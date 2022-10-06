package com.ayi.spring.rest.serv.app.controllers;

import com.ayi.spring.rest.serv.app.dto.request.InvoiceWithClientDTO;
import com.ayi.spring.rest.serv.app.dto.request.InvoiceWithoutClientDTO;
import com.ayi.spring.rest.serv.app.dto.response.InvoiceResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;
import com.ayi.spring.rest.serv.app.services.IInvoiceService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.ayi.spring.rest.serv.app.constants.HashMapStrings.ERROR_CODE;
import static com.ayi.spring.rest.serv.app.constants.HashMapStrings.ERROR_MESSAGE;

@AllArgsConstructor
@Api(value = "Invoice API", tags = {"Invoices services"})
@Slf4j
@RequestMapping(value = "/invoices", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class InvoiceController {

    private IInvoiceService invoiceService;

    @PostMapping(value = "/createInvoiceWithClient/{id}")
    @ApiOperation(
            value = "Adds an invoice to the DB table",
            httpMethod = "POST",
            response = InvoiceResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Body content with the new invoice"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received"
            )
    })
    public ResponseEntity<?> createInvoiceWithClient(
            @ApiParam(name = "id", required = true, value = "Client Id", example = "1")
            @PathVariable("id") Long id,
            @RequestBody InvoiceWithoutClientDTO invoiceWithoutClientDTO) {

        Map<String, Object> response = new HashMap<>();

        InvoiceResponseDTO invoiceResponseDTO;

        try {
            invoiceResponseDTO = invoiceService.addInvoiceWithClient(id, invoiceWithoutClientDTO);
        } catch (ReadAccessException e) {
            response.put(ERROR_CODE, 2000);
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(invoiceResponseDTO);
    }

}
