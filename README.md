# spring-boot-barter-app

## Introduction

During this ‘shelter in place’ days, that is imposed to control covid-19 spread, I came across many neighbors posting for essentials in the NextDoor application. For example, one of them posted asking if anyone has yeast at home that she could take to bake for the medical professionals working tirelessly at this time. All neighborhood stores ran out of yeast. And she was willing to give a few bread rolls or muffins in exchange to the yeast. I then thought a barter application could be helpful for a small neighborhood to do these exchanges.

Here is the barter-app which with an attractive UI and a few validations could serve the very same purpose.

## Requirements

For building and running this application you need:

•	JDK 11

•	Maven 3

•	MySQL Ver 8

## URLs

|  URL |  Method | Remarks |
|----------|--------------|--------------|
|`http://localhost:8080/printAllUsers`                           | GET | Print all users in the system|
|`http://localhost:8080/printAllItems`                       | GET |Print all items available to barter |
|`http://localhost:8080 /printAllOfferRequest `                 | GET |Print all barter offers and requests |
|`http://localhost:8080/addUser` | POST | Add a new user into the system|
|`http://localhost:8080/addItem`                             | POST | Add a new item in the application|
|`http://localhost:8080 /addOfferRequest`                             | POST |Create a new offer record or request record into the application |
|`http://localhost:8080/ updateOfferRequest`                             | POST |Update an offer or request record |

## Deploying the application to AWS

