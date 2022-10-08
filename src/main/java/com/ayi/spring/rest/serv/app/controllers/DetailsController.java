package com.ayi.spring.rest.serv.app.controllers;

import com.ayi.spring.rest.serv.app.dto.request.details.DetailsDTO;
import com.ayi.spring.rest.serv.app.dto.response.details.DetailsPagesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.details.DetailsWithClientResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.GenericAccessException;
import com.ayi.spring.rest.serv.app.services.IDetailsService;
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
@Api(value = "Details API", tags = {"Details services"})
@Slf4j
@RequestMapping(value = "/details", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class DetailsController {

    IDetailsService detailsService;

    @GetMapping(
            value = "/getAllDetailsPages/{page}/{size}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Retrieves data associated to all the clients details paginated",
            httpMethod = "GET",
            response = DetailsWithClientResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Body content with the clients details information"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received")
    })
    public ResponseEntity<?> getAllDetailsPages(
            @ApiParam(value = "Page to display", required = true, example = "1")
            @PathVariable(name = "page") Integer page,
            @ApiParam(value = "Number of items per request", required = true, example = "1")
            @PathVariable(name = "size") Integer size) {

        Map<String, Object> response = new HashMap<>();

        DetailsPagesResponseDTO detailsPagesResponseDTO;

        try {
            detailsPagesResponseDTO = detailsService.findAllDetailsPages(page, size);
        } catch (GenericAccessException e) {
            response.put(ERROR_CODE, 4000);
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(detailsPagesResponseDTO);
    }

    @PatchMapping(
            value = "/updateDetails/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Updates data associated to the client details",
            httpMethod = "PATCH",
            response = DetailsWithClientResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Body content with the updated details information"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received")
    })
    public ResponseEntity<?> updateDetails(
            @ApiParam(name = "id", required = true, value = "Details Id", example = "1")
            @PathVariable("id") Long id,
            @RequestBody DetailsDTO detailsDTO) {

        Map<String, Object> response = new HashMap<>();

        DetailsWithClientResponseDTO detailsWithClientResponseDTO;

        try {
            detailsWithClientResponseDTO = detailsService.modifyDetails(id, detailsDTO);
        } catch (GenericAccessException e) {
            response.put(ERROR_CODE, 2003);
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(detailsWithClientResponseDTO);
    }

}
