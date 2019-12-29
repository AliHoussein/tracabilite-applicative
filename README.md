# PoC traçabilité applicative pour le SIPF

Ce Proof of Concept a pour but de démontrer comment débuter avec la traçabilité applicative pour une API crée avec
 Spring Boot. 
 
Ce Proof of Concept s'appuie sur Spring Security, Spring Data JPA et JaVers.
 
## Pré-requis : 

* Une base de données accessible
* Un Identify Provider capable de fournir des tokens (authorization code flow) 
    * Disposant de comptes utilisateurs de tests (par exemple Realm de test dans Keycloak)
    * Un role ROLE_ASSOCIATION_MASTER configuré pour vos utilisateurs tests
    * Un client_id configuré, et son nom configuré dans SecurityConfiguration.java, propriété `RESSOURCE_ID_FOR_ROLE_AUTHORISATIONS`
* Configurer `application.yml` pour vos paramètres
* Postman (https://www.getpostman.com/)

## Pour lancer l'application 

Lancer dans la ligne de commande :

`mvn spring-boot:run -Dspring-boot.run.profiles=dev -Dspring-boot.run.arguments
=--server.port
=9090`

L'API sera accessible sur http://localhost:9090 

## Pour utiliser l'application

Se référer à la collection de requêtes Postman fournie.
La récupération des tokens d'authenficiation/d'authorisation se fait aussi grâce à Postman 

### Avertissements

Attention, à ne pas utiliser en production tel quel car le code n'est pas testé (unit test, integration etc).

Aussi data.sql dans l'environnement de dev, vide les tables liées à JaVers à chaque lancement de l'application pour
 mimiquer la politique create-drop de Hibernate.