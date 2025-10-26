# Projet de stage — Backend Spring Boot (été 2023)

Ce dépôt contient le backend réalisé durant mon stage d'été 2023. L'objectif principal était de comprendre et d'expérimenter les fonctionnalités de Spring Boot et l'intégration avec MyBatis et autres fonctionnalités avancées.

## Description

Application Spring Boot (Java 17, Spring Boot 3.1.1) fournissant des APIs REST, une couche service/DAO, et l'intégration avec des bases de données via MyBatis (fichiers mapper inclus).

## Fonctionnalités / technologies utilisées

- Spring Boot (starter parent 3.1.1)
- Spring Web (contrôleurs REST)
- Spring Data JPA (présent dans les dépendances)
- MyBatis (mappers XML + starter MyBatis)
- Drivers JDBC : Oracle (ojdbc8) et MySQL (mysql-connector-java)
- Gestion des configurations via `application.properties` et fichiers additionnels (`dbs.properties`, `mybatis-config.xml`)
- Architecture en couches : Controller → Service → DAO → Mapper/DB
- Gestion centralisée des exceptions (package `Excpetionhandler`)
- Tests unitaires / d'intégration (dossier `Spec` / dépendance `spring-boot-starter-test`)
- Documentation API avec SpringDoc / OpenAPI (dépendance `springdoc-openapi-starter-webmvc-ui`)
- Packaging en jar exécutable (plugin `spring-boot-maven-plugin`)
- Frontend statique intégré dans `src/main/resources/static` (build Angular livré)

## Structure du projet (emplacement des éléments clés)

- `src/main/java/com/example/Controller` — classes exposant les endpoints REST
- `src/main/java/com/example/Service` — logique métier
- `src/main/java/com/example/DAO` — accès aux données (sous-dossiers `db1`, `db2` présents)
- `src/main/java/com/example/model` — entités / DTO
- `src/main/java/com/example/config` — classes de configuration (datasources, MyBatis, etc.)
- `src/main/resources` — fichiers de configuration et mappers :
  - `application.properties` — propriétés principales
  - `dbs.properties` — propriétés de connexion aux bases (si présentes)
  - `mybatis-config.xml` — configuration MyBatis
  - `customerMapper.xml` — exemple de mapper MyBatis
  - `static/` — frontend compilé (Angular)


## API / Documentation

Lorsque l'application démarre correctement, la documentation OpenAPI générée par SpringDoc est généralement disponible à :

- Swagger UI : `/swagger-ui.html` ou `/swagger-ui/index.html`
- OpenAPI JSON : `/v3/api-docs`


## Comment builder et lancer

Utilisez le wrapper Maven inclus (recommandé) :

```bash
# Compiler et packager
./mvnw clean package

# Lancer l'application (mode développement)
./mvnw spring-boot:run

# Ou exécuter le jar produit
java -jar target/stage2023-0.0.1-SNAPSHOT.jar
```

Les propriétés de connexion à la base et autres paramètres sont dans `src/main/resources/application.properties` et `dbs.properties`. Adaptez-les selon votre environnement (URL, utilisateur, mot de passe).

## Tests

Le projet contient une dépendance de test (`spring-boot-starter-test`). Cherchez les classes de test dans `src/test` ou le dossier `Spec` pour exemples de tests unitaires/integration.



---

Fait durant le stage été 2023 — objectif pédagogique : comprendre l'écosystème Spring Boot et l'intégration base de données via MyBatis.
