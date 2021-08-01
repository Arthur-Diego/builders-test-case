package com.builders.testcase.builder;

import com.builders.testcase.dto.AddressResponseDTO;
import com.builders.testcase.dto.ClientResponseDTO;
import com.builders.testcase.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientResponseBuilder {

    public ClientResponseDTO fromEntity(Client dto){

        AddressResponseDTO addressResponseDTO = AddressResponseDTO.builder()
                .city(dto.getAddress().getCity())
                .district(dto.getAddress().getDistrict())
                .number(dto.getAddress().getNumber())
                .state(dto.getAddress().getState())
                .zipCode(dto.getAddress().getZipCode())
                .publicPlace(dto.getAddress().getPublicPlace())
                .build();

        return ClientResponseDTO.builder()
                .id(dto.getId())
                .age(dto.getAge())
                .address(addressResponseDTO)
                .documentNumber(dto.getDocumentNumber())
                .name(dto.getName())
                .build();
    }

}
