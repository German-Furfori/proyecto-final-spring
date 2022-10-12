package com.ayi.spring.rest.serv.app.controllers;

import com.ayi.spring.rest.serv.app.dto.request.invoice.InvoiceWithClientDTO;
import com.ayi.spring.rest.serv.app.dto.request.invoice.InvoiceWithoutClientDTO;
import com.ayi.spring.rest.serv.app.dto.response.invoice.InvoicePagesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.invoice.InvoiceWithFullClientDataResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.invoice.InvoiceWithClientResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.RepositoryAccessException;
import com.ayi.spring.rest.serv.app.services.IInvoiceService;
import io.swagger.annotations.*;
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
@Api(value = "Invoice API", tags = {"Invoices services"})
@Slf4j
@RequestMapping(value = "/invoices", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class InvoiceController {

    private IInvoiceService invoiceService;

    @PostMapping(value = "/createInvoiceWithoutClient/{id}")
    @ApiOperation(
            value = "Adds an invoice to the data base",
            httpMethod = "POST",
            response = InvoiceWithFullClientDataResponseDTO.class
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
    public ResponseEntity<?> createInvoiceWithoutClient(
            @ApiParam(name = "id", required = true, value = "Client Id", example = "1")
            @PathVariable("id") Long id,
            @Valid @RequestBody InvoiceWithoutClientDTO invoiceWithoutClientDTO) {

        Map<String, Object> response = new HashMap<>();

        InvoiceWithClientResponseDTO invoiceWithClientResponseDTO;

        try {
            invoiceWithClientResponseDTO = invoiceService.addInvoiceWithoutClient(id, invoiceWithoutClientDTO);
        } catch (RepositoryAccessException e) {
            response.put(ERROR_CODE, HttpStatus.NOT_ACCEPTABLE.value());
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(invoiceWithClientResponseDTO);
    }

    @PostMapping(value = "/createInvoiceWithClient")
    @ApiOperation(
            value = "Adds an invoice to the data base with a new client",
            httpMethod = "POST",
            response = InvoiceWithFullClientDataResponseDTO.class
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
    public ResponseEntity<?> createInvoiceWithClient(@Valid @RequestBody InvoiceWithClientDTO invoiceWithClientDTO) {

        Map<String, Object> response = new HashMap<>();

        InvoiceWithFullClientDataResponseDTO invoiceWithFullClientDataResponseDTO;

        try {
            invoiceWithFullClientDataResponseDTO = invoiceService.addInvoiceWithClient(invoiceWithClientDTO);
        } catch (RepositoryAccessException e) {
            response.put(ERROR_CODE, HttpStatus.NOT_FOUND.value());
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(invoiceWithFullClientDataResponseDTO);
    }

    @GetMapping(
            value = "/getAllInvoicePages/{page}/{size}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Retrieves data associated to all the invoices paginated",
            httpMethod = "GET",
            response = InvoicePagesResponseDTO.class
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
    public ResponseEntity<?> getAllInvoices(
            @ApiParam(value = "Page to display", required = true, example = "1")
            @PathVariable(name = "page") Integer page,
            @ApiParam(value = "Number of items per request", required = true, example = "1")
            @PathVariable(name = "size") Integer size) {

        Map<String, Object> response = new HashMap<>();

        InvoicePagesResponseDTO invoicePagesResponseDTO;

        try {
            invoicePagesResponseDTO = invoiceService.findAllInvoicePages(page - 1, size);
        } catch (RepositoryAccessException e) {
            response.put(ERROR_CODE, HttpStatus.NOT_FOUND.value());
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(invoicePagesResponseDTO);
    }

    @GetMapping(
            value = "/getInvoiceById/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Retrieves data associated to an invoice",
            httpMethod = "GET",
            response = InvoiceWithClientResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Body content with the invoice information"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received")
    })
    public ResponseEntity<?> getInvoiceById(
            @ApiParam(name = "id", required = true, value = "Invoice Id", example = "1")
            @PathVariable("id") Long id) {

        Map<String, Object> response = new HashMap<>();

        InvoiceWithClientResponseDTO invoiceWithClientResponseDTO;

        try {
            invoiceWithClientResponseDTO = invoiceService.findInvoiceById(id);
        } catch (RepositoryAccessException e) {
            response.put(ERROR_CODE, HttpStatus.NOT_FOUND.value());
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(invoiceWithClientResponseDTO);
    }

    @DeleteMapping(
            value = "/deleteInvoice/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Removes an invoice",
            httpMethod = "DELETE",
            response = InvoiceWithClientResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Body content with the deleted invoice information"
            ),
            @ApiResponse(
                    code = 400,
                    message = "Describes errors on invalid payload received")
    })
    public ResponseEntity<?> deleteInvoice(
            @ApiParam(name = "id", required = true, value = "Invoice Id", example = "1")
            @PathVariable("id") Long id) {

        Map<String, Object> response = new HashMap<>();

        InvoiceWithClientResponseDTO invoiceWithClientResponseDTO;

        try {
            invoiceWithClientResponseDTO = invoiceService.removeInvoice(id);
        } catch (RepositoryAccessException e) {
            response.put(ERROR_CODE, HttpStatus.NOT_FOUND.value());
            response.put(ERROR_MESSAGE, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(invoiceWithClientResponseDTO);
    }

}
