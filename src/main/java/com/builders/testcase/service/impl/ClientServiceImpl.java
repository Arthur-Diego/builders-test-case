package com.builders.testcase.service.impl;

import com.builders.testcase.builder.ClientRequestBuilder;
import com.builders.testcase.builder.ClientResponseBuilder;
import com.builders.testcase.builder.PageBuilder;
import com.builders.testcase.dto.ClientResponseDTO;
import com.builders.testcase.dto.ClientFieldRequestDTO;
import com.builders.testcase.dto.ClientRequestDTO;
import com.builders.testcase.dto.PageDTO;
import com.builders.testcase.exception.EntityNotFoundException;
import com.builders.testcase.model.Client;
import com.builders.testcase.repository.ClientRepository;
import com.builders.testcase.service.ClientService;
import com.builders.testcase.specification.ClientSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientRequestBuilder requestBuilder;
    private final ClientResponseBuilder responseBuilder;

    @Override
    public List<ClientResponseDTO> findAll() {
        return getListResponseDTO(clientRepository.findAll());
    }

    @Override
    public void save(ClientRequestDTO dto) {

        if(dto.getId() != null){
            clientRepository.findById(dto.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Client not found"));
        }

        Client client = requestBuilder.fromDto(dto);
        clientRepository.save(client);
    }

    @Override
    public List<ClientResponseDTO> findByFields(ClientFieldRequestDTO dto) {
        return getListResponseDTO(clientRepository.findAll(ClientSpecification.clientSpecification(dto)));
    }

    @Override
    public PageDTO<ClientResponseDTO> findPageable(Pageable pageable) {

        Pageable pageableAux = PageBuilder.from(pageable.getPageNumber(), pageable.getPageSize());
        Page<Client> page = clientRepository.findAll(pageableAux);
        List<ClientResponseDTO> pageContentDto = getListResponseDTO(page.getContent());

        PageDTO<ClientResponseDTO> pageDTO = PageDTO.buildPageDTO((long) pageable.getPageNumber(), page, pageContentDto);

        return pageDTO;
    }

    private List<ClientResponseDTO> getListResponseDTO(List<Client> clients) {
        return clients.stream()
                .map(c -> responseBuilder.fromEntity(c))
                .collect(Collectors.toList());
    }
}
