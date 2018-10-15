# Projet description
This is a simple Demo of Restful CRUD service.This project depends on `Spring Boot` and `MongoDB`, deployed by `docker`. We retrive the init data from [Hacker News API](https://github.com/HackerNews/API) by using python file.

# Install prerequisites
The project is deployed by docker, we need to install 
 - [Docker](https://docs.docker.com/install/) 
 - [Docker Compose](https://docs.docker.com/compose/install/)

If you want to retirve data from Hacker News API with python file, we can install the dependencies ues following command.
If you haven't install pip, run command
```bash
sudo apt install pip
```
After that, we can install requests and pymongo 
```bash
pip install requests
```
```bash
pip install pymongo
```
# How to run our project in docker
1. make a folder and clone the project into where you want 
```bash 
git clone git@github.com:CornPrincess/springboot-mongodb-docker.git
```
2. run `hackernews_item.py` and `hackernews_user.py` to init mongodb
```bash
cd springboot-mongodb-docker
python hackernews_item.py
python hackernews_user.py
```
3.start the application by docker compose(crtl + c to exit)
```bash
docker-compose up 
```
or add the `-d` key to start container in the background and leave them running.
```bash
docker-compose up -d
```

So far, we have started the application, and we can use
```bash
docker-compose ps
```
to check the contianers related with the project

# How to work with the application
The application provides three source REST API:
users:
```bash
GET: http://localhost:8080/rest/users/all
GET: http://localhost:8080/rest/users/userId
POST: http://localhost:8080/rest/users
PUT: http://localhost:8080/rest/users/userId
DELETE : http://localhost:8080/rest/users/userId
```
items:
```bash
GET: http://localhost:8080/rest/items/all
GET: http://localhost:8080/rest/items/itemId
POST: http://localhost:8080/rest/items
PUT: http://localhost:8080/rest/items/itemId
DELETE : http://localhost:8080/rest/items/itemId
```

hotels:
```bash
GET: http://localhost:8080/rest/hotels/all
GET: http://localhost:8080/rest/hotels/hotelId
POST: http://localhost:8080/rest/hotels
PUT: http://localhost:8080/rest/hotels/hotelId
DELETE : http://localhost:8080/rest/hotels/hotelId
```


