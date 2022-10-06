package com.ayi.spring.rest.serv.app.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(
        value = "Invoice Response",
        description = "The invoice data provided by the server"
)
public class InvoiceResponseDTO {

    @ApiModelProperty(position = 1, notes = "Invoice id")
    private Long idInvoice;

    @ApiModelProperty(position = 2, notes = "Invoice description")
    private String description;

    @ApiModelProperty(position = 3, notes = "Total amount")
    private Double totalAmount;

    @ApiModelProperty(position = 4, notes = "Client data")
    @JsonIgnoreProperties(value = "invoiceList")
    private ClientFullResponseDTO client;
}
