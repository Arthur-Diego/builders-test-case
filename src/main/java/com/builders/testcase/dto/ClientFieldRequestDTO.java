package com.builders.testcase.dto;

import com.builders.testcase.annotation.FieldEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientFieldRequestDTO {
    @FieldEntity(isString = false)
    private Long id;
    private String name;
    @FieldEntity(isString = false)
    private Integer age;
    private String documentNumber;
    @FieldEntity(isEmbbedable = true)
    private AddressRequestDTO address;
}
