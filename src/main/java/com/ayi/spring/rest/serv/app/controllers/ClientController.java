package com.ayi.spring.rest.serv.app.controllers;

import com.ayi.spring.rest.serv.app.dto.request.ClientFullDTO;
import com.ayi.spring.rest.serv.app.dto.request.ClientOnlyDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientInvoicesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientFullResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientOnlyResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;
import com.ayi.spring.rest.serv.app.exceptions.WriteAccessException;
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

import static com.ayi.spring.rest.serv.app.constants.HashMapStrings.ERROR_CODE;
import static com.ayi.spring.rest.serv.app.constants.HashMapStrings.ERROR_MESSAGE;

@AllArgsConstructor
@Api(value = "Client API", tags = {"Clients services"})
@Slf4j
@RequestMapping(value = "/clients", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class ClientController {
    private IClientService clientService;

    @PostMapping(value = "/createClient")
    @ApiOperation(
            value = "Adds a client to the DB table",
            httpMethod = "POST",
            response = ClientFullResponseDTO.class
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
    public ResponseEntity<?> createClient(@RequestBody ClientFullDTO clientFullDTO) {

        Map<String, Object> response = new HashMap<>();

        ClientFullResponseDTO clientFullResponseDTO;

        try {
            clientFullResponseDTO = clientService.addClient(clientFullDTO);
        } catch (WriteAccessException e) {
            response.put(ERROR_CODE, 1000);
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(clientFullResponseDTO);
    }

    @GetMapping(
            value = "/getAllClients",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Retrieves data associated to all the clients",
            httpMethod = "GET",
            response = ClientFullResponseDTO.class
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

        List<ClientFullResponseDTO> clientFullResponseDTOList;

        try {
            clientFullResponseDTOList = clientService.findAllClients();
        } catch (ReadAccessException e) {
            response.put(ERROR_CODE, 1001);
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(clientFullResponseDTOList);
    }

    @GetMapping(
            value = "/getClientById/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Retrieves data associated to the clients by Id",
            httpMethod = "GET",
            response = ClientFullResponseDTO.class
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

        ClientFullResponseDTO clientFullResponseDTO;

        try {
            clientFullResponseDTO = clientService.findClientById(id);
        } catch (ReadAccessException e) {
            response.put(ERROR_CODE, 1002);
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(clientFullResponseDTO);
    }

    @GetMapping(
            value = "/getClientInvoices/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Retrieves data associated to the client invoices",
            httpMethod = "GET",
            response = ClientFullResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Body content with the invoices information"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received")
    })
    public ResponseEntity<?> getClientInvoices(
            @ApiParam(name = "id", required = true, value = "Client Id", example = "1")
            @PathVariable("id") Long id) {

        Map<String, Object> response = new HashMap<>();

        ClientInvoicesResponseDTO clientInvoicesResponseDTO;

        try {
            clientInvoicesResponseDTO = clientService.findClientInvoices(id);
        } catch (ReadAccessException e) {
            response.put(ERROR_CODE, 1003);
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(clientInvoicesResponseDTO);
    }

    @PatchMapping(
            value = "/updateClient/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Retrieves data associated to the client updated",
            httpMethod = "PATCH",
            response = ClientFullResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Body content with the client updated"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received")
    })
    public ResponseEntity<?> updateClient(
            @ApiParam(name = "id", required = true, value = "Client Id", example = "1")
            @PathVariable("id") Long id,
            @RequestBody ClientOnlyDTO clientOnlyDTO) {

        Map<String, Object> response = new HashMap<>();

        ClientOnlyResponseDTO clientOnlyResponseDTO;

        try {
            clientOnlyResponseDTO = clientService.modifyClient(id, clientOnlyDTO);
        } catch (ReadAccessException e) {
            response.put(ERROR_CODE, 1004);
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(clientOnlyResponseDTO);
    }

    @PatchMapping(
            value = "/deleteClient/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Retrieves data associated to the removed client",
            httpMethod = "PATCH",
            response = ClientFullResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Body content with the removed client"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received")
    })
    public ResponseEntity<?> deleteClient(
            @ApiParam(name = "id", required = true, value = "Client Id", example = "1")
            @PathVariable("id") Long id) {

        Map<String, Object> response = new HashMap<>();

        ClientFullResponseDTO clientFullResponseDTO;

        try {
            clientFullResponseDTO = clientService.removeClient(id);
        } catch (ReadAccessException e) {
            response.put(ERROR_CODE, 1005);
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(clientFullResponseDTO);

    }
}
