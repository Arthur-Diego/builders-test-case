package com.builders.testcase.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClientResponseDTO {
    private Long id;
    private String name;
    private Integer age;
    private String documentNumber;
    private AddressResponseDTO address;

}
