package com.builders.testcase.service;

import com.builders.testcase.dto.PageDTO;
import com.builders.testcase.model.Address;
import com.builders.testcase.model.Client;
import com.builders.testcase.repository.ClientRepository;
import com.builders.testcase.util.DatabaseCleaner;
import com.builders.testcase.util.ResourceUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lombok.RequiredArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class ClientServiceTest {

    @LocalServerPort
    private int port;

    @Autowired
    private DatabaseCleaner databaseCleaner;

    @Autowired
    private ClientRepository clientRepository;

    private String jsonClient;

    private String jsonClientField;

    @Before
    public void setUp() {
        enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = port;
        basePath = "/api/client";

        databaseCleaner.clearTables();

        jsonClient = ResourceUtils.getContentFromResource(
                "/json/client.json");

        jsonClientField = ResourceUtils.getContentFromResource(
                "/json/clientField.json");

        prepareData();
    }

    @Test
    public void shouldReturnStatus201_WhenSaveClient() {
        given()
            .body(jsonClient)
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
        .when()
            .post("/save")
        .then()
            .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void shouldReturnStatus201AndBody_WhenRetrieveQueryWithFilters() {
        given()
            .body(jsonClientField)
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
        .when()
            .post("/filters")
        .then()
            .statusCode(HttpStatus.OK.value())
            .body("", hasSize(1))
            .body("get(0).address.city", is("Natal"))
            .body("get(0).age", is(34))
            .body("get(0).id", is(2));
    }

    @Test
    public void shouldReturnStatus200AndBody_WhenRetrievePageable1PageAnd2Size() {
        given()
            .accept(ContentType.JSON)
        .when()
            .get("/pageable?page=1&size=2")
        .then()
            .statusCode(HttpStatus.OK.value())
            .body("pageNum", is(1))
            .body("totalItems", is(2))
            .body("pageItemsNum", is(2))
            .body("data", hasSize(2));
    }

    void prepareData() {
        Address address = Address.builder()
                .publicPlace("Santos dumont")
                .zipCode("032121-654")
                .state("Ceara")
                .city("Fortaleza")
                .number("4789")
                .build();

        Client client = Client.builder()
                .documentNumber("12456789877")
                .name("Arthur")
                .age(30)
                .address(address)
                .build();

        clientRepository.save(client);

        Address address2 = Address.builder()
                .publicPlace("Salgado filho")
                .zipCode("013010-20")
                .state("Rio Grande do Norte")
                .city("Natal")
                .number("7255")
                .build();

        Client client2 = Client.builder()
                .documentNumber("98765432112")
                .name("Diego")
                .age(34)
                .address(address2)
                .build();

        clientRepository.save(client2);
    }

}
