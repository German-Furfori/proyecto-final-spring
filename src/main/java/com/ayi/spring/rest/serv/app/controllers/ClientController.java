package com.ayi.spring.rest.serv.app.controllers;

import com.ayi.spring.rest.serv.app.dto.request.client.ClientFullDTO;
import com.ayi.spring.rest.serv.app.dto.request.client.ClientOnlyDTO;
import com.ayi.spring.rest.serv.app.dto.response.client.ClientFullPagesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.client.ClientInvoicesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.client.ClientFullResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.client.ClientOnlyResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.RepositoryAccessException;
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

import javax.validation.Valid;
import java.util.HashMap;
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
                    code = 201,
                    message = "Body content with the new client"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received"
            )
    })
    public ResponseEntity<?> createClient(@Valid @RequestBody ClientFullDTO clientFullDTO) {

        Map<String, Object> response = new HashMap<>();

        ClientFullResponseDTO clientFullResponseDTO;

        try {
            clientFullResponseDTO = clientService.addClient(clientFullDTO);
        } catch (RepositoryAccessException e) {
            response.put(ERROR_CODE, HttpStatus.NOT_ACCEPTABLE.value());
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(clientFullResponseDTO);
    }

    @GetMapping(
            value = "/getAllClientPages/{page}/{size}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Retrieves data associated to all the clients paginated",
            httpMethod = "GET",
            response = ClientFullPagesResponseDTO.class
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
    public ResponseEntity<?> getAllClientPages(
            @ApiParam(value = "Page to display", required = true, example = "1")
            @PathVariable(name = "page") Integer page,
            @ApiParam(value = "Number of items per request", required = true, example = "1")
            @PathVariable(name = "size") Integer size) {

        Map<String, Object> response = new HashMap<>();

        ClientFullPagesResponseDTO clientFullPagesResponseDTO;

        try {
            clientFullPagesResponseDTO = clientService.findAllClients(page - 1, size);
        } catch (RepositoryAccessException e) {
            response.put(ERROR_CODE, HttpStatus.NOT_FOUND.value());
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(clientFullPagesResponseDTO);
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
        } catch (RepositoryAccessException e) {
            response.put(ERROR_CODE, HttpStatus.NOT_FOUND.value());
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
        } catch (RepositoryAccessException e) {
            response.put(ERROR_CODE, HttpStatus.NOT_FOUND.value());
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
                    code = 201,
                    message = "Body content with the client updated"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received")
    })
    public ResponseEntity<?> updateClient(
            @ApiParam(name = "id", required = true, value = "Client Id", example = "1")
            @PathVariable("id") Long id,
            @Valid @RequestBody ClientOnlyDTO clientOnlyDTO) {

        Map<String, Object> response = new HashMap<>();

        ClientOnlyResponseDTO clientOnlyResponseDTO;

        try {
            clientOnlyResponseDTO = clientService.modifyClient(id, clientOnlyDTO);
        } catch (RepositoryAccessException e) {
            response.put(ERROR_CODE, HttpStatus.NOT_FOUND.value());
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
            value = "Retrieves data associated to the unsubscribed client",
            httpMethod = "PATCH",
            response = ClientFullResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Body content with the unsubscribed client"
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
        } catch (RepositoryAccessException e) {
            response.put(ERROR_CODE, HttpStatus.NOT_FOUND.value());
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(clientFullResponseDTO);

    }
}
