# UserServiceApi
#FROM eclipse-temurin:17
LABEL mentainer="siddharth.singh0701@gmail.com"
WORKDIR /app
COPY target/springboot-docker-demo-0.0.1-SNAPSHOT.jar /app/springboot-docker-demo.jar
ENTRYPOINT ["java", "-jar", "springboot-docker-demo.jar"]



docker build -t springboot-docker-demo .

with tag

docker build -t springboot-docker-demo:0.1.RELEASE .

SEE ALL THE IMAGES
docker images

run the docker image in docker container
docker run -p 8080:8080 springboot-docker-demo

-------------see docker image on running
docker ps

run spring boot application in detached mode 
docker run -p 8080:8080 -d springboot-docker-demo

docker log----
docker log -f first four digit of id

--to stop the docker image from detached mode
docker stop first four digit of id

create repository in docker hub
docker tag springboot-docker-demo siddharth0701/springboot-docker-demo:0.1.RELEASE
push docker image
docker push siddharth0701/springboot-docker-demo

-----------------launch amazon ec2 instance
sudo su
sudo yum install docker -yum

sudo service docker start

----------------------------------install mysql in docker

docker pull mysql
docker network create springboot-mysql-net  
docker network ls
docker run --name mysqldb --network springboot-mysql-net -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=employeedb -d mysql
docker ps
docker logs -f CONTAINER ID

docker exec -it  fout digit CONTAINER ID bash
mysql -u root -p

---build command then run 

docker run --network springboot-mysql-net --name springboot-mysql-container -p 8080:8080 userservice



-----------docker compose

--------------install docker and docker compose on linux aws ec2
sudo yum update -y 

sudo amazon-linux-extras install docker 

sudo yum install docker 

sudo service docker start 

sudo usermod -a -G docker ec2-user
--------------docker compose installation-----


docker-compose up -d --build

sudo curl -L https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose

sudo chmod +x /usr/local/bin/docker-compose

docker-compose version




