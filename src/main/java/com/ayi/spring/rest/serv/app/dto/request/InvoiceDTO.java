package com.ayi.spring.rest.serv.app.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(
        value = "Invoice Request",
        description = "Data needed to create the invoice"
)
public class InvoiceDTO {

    @NotNull(message = "The description cannot be null")
    @ApiModelProperty(position = 1, required = true)
    private String description;

    @NotNull(message = "The total amount cannot be null")
    @ApiModelProperty(position = 2, required = true)
    private Double totalAmount;

    @NotNull(message = "The client cannot be null")
    @ApiModelProperty(position = 3, required = true)
    private ClientDTO client;
}
