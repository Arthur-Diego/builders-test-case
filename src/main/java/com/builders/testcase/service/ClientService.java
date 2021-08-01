package com.builders.testcase.service;


import com.builders.testcase.dto.ClientResponseDTO;
import com.builders.testcase.dto.ClientFieldRequestDTO;
import com.builders.testcase.dto.ClientRequestDTO;
import com.builders.testcase.dto.PageDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {

    List<ClientResponseDTO> findAll();

    void save(ClientRequestDTO dto);

    List<ClientResponseDTO> findByFields(ClientFieldRequestDTO dto);

    PageDTO<ClientResponseDTO> findPageable(Pageable pageable);

}
