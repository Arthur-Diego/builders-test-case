package com.builders.testcase.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequestDTO {

    private String zipCode;
    private String number;
    private String publicPlace;
    private String district;
    private String city;
    private String state;
}
