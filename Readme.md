# Itaú - TestCase

Simple API(Rest) for password validation following specifications
#### Tecnologias
* Java 11 
* Springboot 2.1.7
* Lombok
* Junit
* Swagger
* Docker
#### Solução

## Instalação
```bash
git clone https://github.com/Arthur-Diego/builders--case.git

cd builders-testcase/

mvnw package && java -jar target/builders-testcase-docker.jar or ./mvnw package && java -jar target/builders-testcase-docker.jar

docker build -t builders-testcase/builders-testcase-docker .
```

## Uso
```bash
docker run -p 8080:8080 builders-testcase/builders-testcase-docker .

http://localhost:8080/swagger-ui.html#
```