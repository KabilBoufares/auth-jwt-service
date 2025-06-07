# Auth JWT Service

Projet Spring Boot pour l’authentification sécurisée d’API REST à l’aide de JSON Web Tokens (JWT).

## Description

Ce projet est une API REST de démonstration qui implémente une authentification stateless basée sur JWT avec gestion des rôles (USER, ADMIN).  
Il utilise Spring Boot 3, Spring Security 6, et une base H2 en mémoire pour les tests.

## Fonctionnalités

- Création de compte (registration)
- Authentification avec génération de JWT
- Sécurisation des endpoints par rôles (`USER`, `ADMIN`)
- Validation automatique du JWT à chaque requête
- Console H2 accessible pour le développement

## Technologies

- Java 17
- Spring Boot 3.5.0
- Spring Security 6
- JWT (io.jsonwebtoken)
- Lombok
- H2 Database

## Endpoints principaux

| Méthode | Endpoint                      | Accès         | Description                    |
|---------|-------------------------------|---------------|--------------------------------|
| POST    | `/api/v1/accounts/register`   | Public        | Inscription utilisateur        |
| POST    | `/api/v1/accounts/login`      | Public        | Authentification, retourne JWT |
| GET     | `/api/v1/accounts/hello`      | Public        | Test public                    |
| GET     | `/api/v1/user/hello`          | USER          | Test accès USER                |
| GET     | `/api/v1/admin/hello`         | ADMIN         | Test accès ADMIN               |

## Démarrage rapide

```sh
git clone https://github.com/KabilBoufares/auth-jwt-service.git
cd auth-jwt-service
./mvnw spring-boot:run
```

Accédez à la console H2 sur [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

## Exemple de requête d’authentification

```http
POST /api/v1/accounts/login
Content-Type: application/json

{
  "email": "kabil@test.com",
  "password": "12345678"
}
```

La réponse contient un token JWT à utiliser dans l’en-tête `Authorization` :

```
Authorization: Bearer <votre_token>
```

## Structure du projet

- `entities/` : Entités JPA (User, Role)
- `repositories/` : Accès aux données
- `services/` : Logique métier et sécurité
- `security/` : Filtres et encodeur de mot de passe
- `web/` : Contrôleurs REST

## Auteur

Kabil Boufares

---

N’hésitez pas à contribuer ou à ouvrir une issue !
