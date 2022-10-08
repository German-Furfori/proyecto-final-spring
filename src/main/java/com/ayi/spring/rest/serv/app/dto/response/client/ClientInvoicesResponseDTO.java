package com.ayi.spring.rest.serv.app.dto.response.client;

import com.ayi.spring.rest.serv.app.dto.response.invoice.InvoiceWithFullClientDataResponseDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(
        value = "Client Invoices Response",
        description = "The invoices data of the client id provided by the server"
)
public class ClientInvoicesResponseDTO {

    @ApiModelProperty(position = 1, notes = "Client id")
    private Long clientId;

    @ApiModelProperty(position = 2, notes = "Client DNI")
    private String dni;

    @ApiModelProperty(position = 3, notes = "Client first name")
    private String firstName;

    @ApiModelProperty(position = 4, notes = "Client last name")
    private String lastName;

    @ApiModelProperty(position = 5, notes = "Client invoices list")
    @JsonIgnoreProperties(value = "client")
    private List<InvoiceWithFullClientDataResponseDTO> invoiceList;
}
