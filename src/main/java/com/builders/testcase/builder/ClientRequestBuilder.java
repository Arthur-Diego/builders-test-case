package com.builders.testcase.builder;

import com.builders.testcase.dto.ClientRequestDTO;
import com.builders.testcase.model.Address;
import com.builders.testcase.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientRequestBuilder {

    public Client fromDto(ClientRequestDTO dto){

        Address address = Address.builder()
                .city(dto.getAddress().getCity())
                .district(dto.getAddress().getDistrict())
                .number(dto.getAddress().getNumber())
                .state(dto.getAddress().getState())
                .zipCode(dto.getAddress().getZipCode())
                .publicPlace(dto.getAddress().getPublicPlace())
                .build();

        return Client.builder()
                .id(dto.getId())
                .age(dto.getAge())
                .address(address)
                .name(dto.getName())
                .documentNumber(dto.getDocumentNumber())
                .build();
    }
}
