package com.builders.testcase.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddressResponseDTO {

    private String zipCode;
    private String number;
    private String publicPlace;
    private String district;
    private String city;
    private String state;

}
