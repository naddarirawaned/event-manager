

# Docker commands: 
+ Start mysql database:

````shell
docker run -d -p 3306:3306 --name mysql --rm  -e MYSQL_ROOT_PASSWORD=password  -e MYSQL_DATABASE=eventmanager  mysql
````