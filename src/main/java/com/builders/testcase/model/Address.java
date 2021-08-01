package com.builders.testcase.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Embeddable
public class Address {

    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "number")
    private String number;
    @Column(name = "public_place")
    private String publicPlace;
    @Column(name = "district")
    private String district;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;

}
