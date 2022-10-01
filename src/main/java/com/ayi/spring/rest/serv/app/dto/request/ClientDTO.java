package com.ayi.spring.rest.serv.app.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(
        value = "Client Request",
        description = "Data needed to create the clients"
)
public class ClientDTO {

    @NotNull(message = "DNI cannot be null")
    @ApiModelProperty(position = 1, required = true)
    private Integer dni;

    @NotNull(message = "First name cannot be null")
    @ApiModelProperty(position = 2, required = true)
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @ApiModelProperty(position = 3, required = true)
    private String lastName;

    @NotNull(message = "Client details cannot be null")
    @ApiModelProperty(position = 4, required = true)
    private DetailsDTO clientDetails;

    @NotNull(message = "Client invoices cannot be null")
    @ApiModelProperty(position = 5, required = true)
    private List<InvoiceDTO> invoiceList;

    @NotNull(message = "Client addresses cannot be null")
    @ApiModelProperty(position = 6, required = true)
    private List<AddressDTO> addressList;
}


