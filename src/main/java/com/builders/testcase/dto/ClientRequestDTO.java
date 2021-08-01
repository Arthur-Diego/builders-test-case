package com.builders.testcase.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequestDTO {

    private Long id;
    private String name;
    private Integer age;
    private String documentNumber;
    private AddressRequestDTO address;

}
