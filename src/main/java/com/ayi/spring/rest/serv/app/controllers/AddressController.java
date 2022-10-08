package com.ayi.spring.rest.serv.app.controllers;

import com.ayi.spring.rest.serv.app.dto.request.AddressDTO;
import com.ayi.spring.rest.serv.app.dto.response.AddressResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;
import com.ayi.spring.rest.serv.app.services.IAddressService;
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
@Api(value = "Address API", tags = {"Addresses services"})
@Slf4j
@RequestMapping(value = "/addresses", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class AddressController {

    IAddressService addressService;

    @PostMapping(value = "/createAddressWithClientId/{id}")
    @ApiOperation(
            value = "Adds an address associated with a client to the DB table",
            httpMethod = "POST",
            response = AddressResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Body content with the new address"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received"
            )
    })
    public ResponseEntity<?> createAddress(
            @ApiParam(name = "id", required = true, value = "Client Id", example = "1")
            @PathVariable("id") Long id,
            @RequestBody AddressDTO addressDTO) {

        Map<String, Object> response = new HashMap<>();

        AddressResponseDTO addressResponseDTO;

        try {
            addressResponseDTO = addressService.addAddress(id, addressDTO);
        } catch (ReadAccessException e) {
            response.put(ERROR_CODE, 3000);
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(addressResponseDTO);
    }

    @GetMapping(
            value = "/getAllAddresses",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Retrieves data associated to all the addresses",
            httpMethod = "GET",
            response = AddressResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Body content with the addresses information"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received")
    })
    public ResponseEntity<?> getAllAddresses() {

        Map<String, Object> response = new HashMap<>();

        List<AddressResponseDTO> addressResponseDTOList;

        try {
            addressResponseDTOList = addressService.findAllAddresses();
        } catch (ReadAccessException e) {
            response.put(ERROR_CODE, 3001);
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(addressResponseDTOList);
    }

    @GetMapping(
            value = "/getAddressById/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Retrieves data associated to the address by Id",
            httpMethod = "GET",
            response = AddressResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Body content with the address information"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received")
    })
    public ResponseEntity<?> getClientById(
            @ApiParam(name = "id", required = true, value = "Address Id", example = "1")
            @PathVariable("id") Long id) {

        Map<String, Object> response = new HashMap<>();

        AddressResponseDTO addressResponseDTO;

        try {
            addressResponseDTO = addressService.findAddressById(id);
        } catch (ReadAccessException e) {
            response.put(ERROR_CODE, 3002);
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(addressResponseDTO);
    }

    @PatchMapping(
            value = "/updateAddress/{idClient}/{idAddress}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Retrieves data associated to the client address updated",
            httpMethod = "PATCH",
            response = AddressResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Body content with the client address updated"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received")
    })
    public ResponseEntity<?> updateAddress(
            @ApiParam(name = "idClient", required = true, value = "Client Id", example = "1")
            @PathVariable("idClient") Long idClient,
            @ApiParam(name = "idAddress", required = true, value = "Address Id", example = "1")
            @PathVariable("idAddress") Long idAddress,
            @RequestBody AddressDTO addressDTO) {

        Map<String, Object> response = new HashMap<>();

        AddressResponseDTO addressResponseDTO;

        try {
            addressResponseDTO = addressService.modifyAddress(idClient, idAddress, addressDTO);
        } catch (ReadAccessException e) {
            response.put(ERROR_CODE, 3004);
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(addressResponseDTO);
    }

    @DeleteMapping(
            value = "/deleteClientAddress/{idClient}/{idAddress}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Removes a client address",
            httpMethod = "DELETE",
            response = AddressResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Body content with the deleted address information"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received")
    })
    public ResponseEntity<?> deleteClientAddress(
            @ApiParam(name = "idClient", required = true, value = "Client Id", example = "1")
            @PathVariable("idClient") Long idClient,
            @ApiParam(name = "idAddress", required = true, value = "Address Id", example = "1")
            @PathVariable("idAddress") Long idAddress) {

        Map<String, Object> response = new HashMap<>();

        AddressResponseDTO addressResponseDTO;

        try {
            addressResponseDTO = addressService.removeAddress(idClient, idAddress);
        } catch (ReadAccessException e) {
            response.put(ERROR_CODE, 3004);
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(addressResponseDTO);
    }

}
