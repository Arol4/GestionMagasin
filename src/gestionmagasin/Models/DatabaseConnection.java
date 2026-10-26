/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionmagasin.Models;

import com.moandjiezana.toml.Toml;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author arold
 */
public class DatabaseConnection {
    public static final Logger logger = LoggerFactory.getLogger(DatabaseConnection.class);
    private static HikariDataSource dataSource = null;
    static {
        try {
            logger.info("Initializing the HikariCP connections pool to the MySQL database...");
            File configFile = new File("config.toml");
            Toml toml = new Toml().read(configFile);
            String host = toml.getString("mysql_database.host");
            Long port = toml.getLong("mysql_database.port");
            String user = toml.getString("mysql_database.user");
            String database = toml.getString("mysql_database.database");
            String password = toml.getString("mysql_database.password");
            String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
            
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(url);
            config.setUsername(user);
            config.setPassword(password);
            config.setDriverClassName("com.mysql.cj.jdbc.Driver");
            
            config.setMaximumPoolSize(10);
            config.setMinimumIdle(2);
            config.setConnectionTimeout(30000);
            
            dataSource = new HikariDataSource(config);
            logger.info("Connections Pool successfully initialized!");
        } catch (Exception e){
            logger.error("Critical error: Unable to initialize the connection pool", e);
            throw new RuntimeException("Database initialization and connection failed", e);
        }
    }
    /**
     * Provides a connection borrowed from <b>the connections pool</b>.
     * @return A Connection object connected to the database.
     * @throws SQLException If the config.toml file is not found in the project root directory or if there are an error in the query.
     */ 
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    /**
     * Close the entire connection pool (Only call this when the application will be completely closed). 
     */
    public static void closePool(){
        if(dataSource != null && !dataSource.isClosed()){
            dataSource.close();
            logger.info("Connection pool successfully closed!");
        }
    }
}
