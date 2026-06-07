# Guidelines to execute this project and contribute in the development
To implement this project on your local computer, you should follow rigorously the followings steps.

## Prerequisites
- You should have **Apache NetBeans IDE** and **JDK** installed in your computer.(_if you don't have none of both can download and install **Apache NetBeans IDE** with **JDK** integrated [here](https://www.codelerity.com/netbeans) ._)
- You should have **MySQL Server**(8.0 or higher versions) installed in your computer with the **admin access**.
- You should have **Git** installed and accessible through the **cmd**.

## Principal guidelines
1. Open **MySQL Command Line Client** and enter your root password the connect to **MySQL Server** with **admin access**.
2. Create a database with some tables with the following SQL code:
```SQL
    CREATE DATABASE gestion_magasin;

    USE gestion_magasin;

    CREATE TABLE marchandise(
            id_marchandise INT NOT NULL,
            designation VARCHAR(500) NOT NULL UNIQUE,
            prix_unitaire INT NOT NULL,
            qte_en_stock INT NOT NULL,
            nom VARCHAR(45) NOT NULL UNIQUE,

            PRIMARY KEY(id_marchandise),
            CHECK(prix_unitaire > 0 AND qte_en_stock > 0)
    );

    CREATE TABLE responsable(
            id_responsable INT NOT NULL,
            nom_responsable VARCHAR(45) NOT NULL,
            prenom_responsable VARCHAR(45) NOT NULL,
            telephone_responsable CHAR(9) NOT NULL,
            date_naissance DATE NOT NULL,
            date_enregistrement DATE NOT NULL DEFAULT (CURRENT_DATE)

            PRIMARY KEY(id_responsable),
            UNIQUE(nom_responsable, prenom_responsable)
    );

    CREATE TABLE entree(
            id_entree INT NOT NULL,
            date_entree DATE NOT NULL DEFAULT (CURRENT_DATE),
            id_responsable INT NOT NULL,

            PRIMARY KEY(id_entree),
            FOREIGN KEY(id_responsable) REFERENCES responsable(id_responsable)
    );

    CREATE TABLE sortie(
            id_sortie INT NOT NULL,
            date_sortie DATE NOT NULL DEFAULT (CURRENT_DATE),
            id_responsable INT NOT NULL,

            PRIMARY KEY(id_sortie),
            FOREIGN KEY(id_responsable) REFERENCES responsable(id_responsable)
    );

    CREATE TABLE entree_marchandise(
            id_entree INT NOT NULL,
            id_marchandise INT NOT NULL,
            qte_entree INT NOT NULL,

            FOREIGN KEY(id_entree) REFERENCES entree(id_entree),
            FOREIGN KEY(id_marchandise) REFERENCES marchandise(id_marchandise),
            PRIMARY KEY(id_entree, id_marchandise),
            CHECK(qte_entree > 0)

    );

    CREATE TABLE sortie_marchandise(
            id_sortie INT NOT NULL,
            id_marchandise INT NOT NULL,
            qte_sortie INT NOT NULL,

            FOREIGN KEY(id_sortie) REFERENCES sortie(id_sortie),
            FOREIGN KEY(id_marchandise) REFERENCES marchandise(id_marchandise),
            PRIMARY KEY(id_sortie, id_marchandise),
            CHECK(qte_sortie > 0)
    );
```
3. Create a user called *user_gestion_magasin* with password *bT2aA%!5* with suitable privileges(**INSERT**, **SELECT**, **UPDATE** and **DELETE** data in *gestion_magasin*) with the following SQL code:
```SQL
    CREATE USER 'user_gestion_magasin'@'localhost' IDENTIFIED BY 'bT2aA%!5';
    GRANT SELECT, INSERT, UPDATE, DELETE ON gestion_magasin.* TO 'user_gestion_magasin'@'localhost';
    FLUSH PRIVILEGES;
    SHOW GRANTS FOR 'user_gestion_magasin'@'localhost';
```
4. Clone this repository with the git command ``git clone https://github.com/Arol4/gestion-magasin.git``;
5. Create a TOML file in the root of the directory of the cloned repository with the following content:
```TOML
    [mysql_database]
    host = "localhost"
    port = 3306
    user = "user_gestion_magasin"
    password = "bT2aA%!5"
    database = "gestion_magasin"
```
6. Open the project(cloned directory) with **Apache NetBeans IDE** and then you can run the project;
## Authors and contributors
- **Arol4**
- **Simo**
