package com.ayi.spring.rest.serv.app.dto.response;

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
        value = "Client Response",
        description = "The client data provided by the server"
)
public class ClientResponseDTO {

    @ApiModelProperty(position = 1, notes = "Client id")
    private Long clientId;

    @ApiModelProperty(position = 2, notes = "Client DNI")
    private Integer dni;

    @ApiModelProperty(position = 3, notes = "Client first name")
    private String firstName;

    @ApiModelProperty(position = 4, notes = "Client last name")
    private String lastName;

    @ApiModelProperty(position = 5, notes = "Client account details")
    private DetailsResponseDTO clientDetails;

    @ApiModelProperty(position = 6, notes = "Client invoices list")
    private List<InvoiceResponseDTO> invoiceList;

    @ApiModelProperty(position = 7, notes = "Client addresses list")
    private List<AddressResponseDTO> addressList;
}
