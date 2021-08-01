# Builders - TestCase

Simple API(Rest) for password validation following specifications
#### Tecnologias
* Java 11 
* Springboot 2.1.7
* Lombok
* Junit
* Swagger
* Docker
#### Solução
A solução consiste num arquitetura simples de projeto, definidas por camada.
As principais funções da api consistem em salvar ou atualizar um objeto, usei o mesmo endpoint para isso.
Listar baseado em paginação.
Lister usando filtros de todos os campos envolvidos na entidade. Para isso usei alguns recursos como reflection e recursão.

Fiz testes usando restassured, com isso consegui validar minhas chamadas e de também integrar com o banco de dados.

Usei uma classe a ***ApiExceptionHandlerAdvice*** para capturar as exceptions das chamadas ou classes que sejam anotadas com ***@RestController***
Com isso consigo gerar um feedback mais amigável para o consumidor da API.
## Instalação
```bash
git clone https://github.com/Arthur-Diego/builders-test-case.git

cd builders-testcase/

./mvnw clean package -DskipTests && docker-compose up --build
```

## Uso
```bash
http://localhost:8080/swagger-ui.html#
```
