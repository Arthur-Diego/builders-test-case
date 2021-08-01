package com.builders.testcase.resource;

import com.builders.testcase.dto.ClientResponseDTO;
import com.builders.testcase.dto.ClientFieldRequestDTO;
import com.builders.testcase.dto.ClientRequestDTO;
import com.builders.testcase.dto.PageDTO;
import com.builders.testcase.service.ClientService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/client")
public class ClientController {

    private final ClientService clientService;

    @ApiOperation(value = "Find all clients")
    @GetMapping(path = "/find-all")
    public ResponseEntity<List<ClientResponseDTO>> findAll(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @ApiOperation(value = "Find with Pagination")
    @GetMapping(path = "/pageable")
    public ResponseEntity<PageDTO<ClientResponseDTO>> findPageable(Pageable pageable){
        return ResponseEntity.ok(clientService.findPageable(pageable));
    }

    @ApiOperation(value = "Find all clients with filters")
    @PostMapping(path = "/filters")
    public ResponseEntity<List<ClientResponseDTO>> findAllWithFilters(@RequestBody @Valid ClientFieldRequestDTO dto){
        return ResponseEntity.ok(clientService.findByFields(dto));
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @ApiOperation(value = "Save or update client")
    @PostMapping(path = "/save")
    public void saveClient(@RequestBody ClientRequestDTO dto){
        clientService.save(dto);
    }
}
