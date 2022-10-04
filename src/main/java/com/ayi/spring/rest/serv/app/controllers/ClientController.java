package com.ayi.spring.rest.serv.app.controllers;

import com.ayi.spring.rest.serv.app.dto.request.ClientDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;
import com.ayi.spring.rest.serv.app.services.IClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Api(value = "Client API", tags = {"Clients services"})
@Slf4j
@RequestMapping(value = "/clients", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class ClientController {
    private IClientService clientService;

    @GetMapping(
            value = "/getAllClients",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Retrieves data associated to all the clients",
            httpMethod = "GET",
            response = ClientResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Body content with the clients information"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received")
    })
    public ResponseEntity<?> getAllClients() {

        Map<String, Object> response = new HashMap<>();

        List<ClientResponseDTO> clientResponseDTOList;

        try {
            clientResponseDTOList = clientService.findAllClients();
        } catch (ReadAccessException e) {
            response.put("Código de error: ", 1001);
            response.put("Mensaje de error: ", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(clientResponseDTOList);
    }

    @GetMapping(
            value = "/getClientById/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Retrieves data associated to the clients by Id",
            httpMethod = "GET",
            response = ClientResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Body content with the client information"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received")
    })
    public ResponseEntity<?> getClientById(
            @ApiParam(name = "id", required = true, value = "Client Id", example = "1")
            @PathVariable("id") Long id) {

        Map<String, Object> response = new HashMap<>();

        ClientResponseDTO clientResponseDTO;

        try {
            clientResponseDTO = clientService.findClientById(id);
        } catch (ReadAccessException e) {
            response.put("Código de error: ", 1002);
            response.put("Mensaje de error: ", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(clientResponseDTO);
    }

    @PostMapping(value = "/addPerson")
    @ApiOperation(
            value = "Adds a client to the DB table",
            httpMethod = "POST",
            response = ClientResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Body content with the new client"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received"
            )
    })
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.addClient(clientDTO));
    }
}
