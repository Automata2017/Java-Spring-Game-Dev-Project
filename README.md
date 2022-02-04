# Java-Spring-Game-Dev-Project

## **And this is my second project, the Java Spring Boot Project**

The basica behind this projects was to take what I've learned about Java, OOP, and 
Spring and put it into practice. This incolved building what's called a 
monolithic back-end using Spring Boot and the modules available as well as Postgres
and Tomcat to run the application. I mainly used it as a learning expierience to
review the lessons on Spring and OOP while experimenting here and there with new
modules. Unfortunately, all the modules I tried to implement broke at the last
second so I was forced to go back to basics. Woops...

In any case, this application will allow users to view and post games they've 
developped, creating a sort of catalogue with all the relavent information of
their games like title, description, genre, releasedate, etc. To do this, they'll 
have the ability to log in and edit information as they see fit. Adding, deleting, 
updating, and deleting both genres and videogames are all available for the users.

## Entity Relationship Diagram (ERD):

The ERD diagram contains a one to many relationship between the genres and videogames, 
a one to many relationship between developers and videogames, and a one to one 
relationsip between profiles and developers. there is no relationship between devs 
and genres however. Here's a link to view the diagram:
https://cdn.discordapp.com/attachments/596324585885007892/938979261040197642/Project_2_Diagram.png

## Model View Controller System Design (MVC):

This model, much like our class lesson, consists of:
1. 4 model classes
2. 2 subclasses, Request and Response, within model
3. 3 repository classes
4. 5 security classes
5. 2 service classes
6. 2 exceptions models
7. 2 controller models

## Planning
I mostly followed along with the lessons from General Assembly as provided by Dhrubo, but 
sped up to two times the normal pace and skipping through all of the parts not about 
java spring.

## Unsolved Problems and hurdles

1. The only unsolved problem was the fact that I wasn't able to completely remove
the relationship between UserID and Genres without the code breaking in time. The 
issue stemmed from needing an entirely new role to create and edit Genres.

2. Other than that, it was just general issues of debugging and polishing the code
at the last minute.

## User Stories

| |
| --- |
|1. A user log in and have full access to the apps available
|2. As a user, I am able to login.
|3. As a user, I can create genres.
|4. As a user, I can view all of the genres.
|5. As a user, I can view videogames.
|6. As a user, I can view all of the games i submitted.
|7. As a user, I can update my submission entries (isReleased)(dlc)(criticScore).


