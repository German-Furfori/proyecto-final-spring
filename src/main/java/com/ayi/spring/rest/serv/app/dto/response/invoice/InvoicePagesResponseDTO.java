package com.ayi.spring.rest.serv.app.dto.response.invoice;

import com.ayi.spring.rest.serv.app.dto.response.address.AddressResponseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(
        value = "Invoice Pages Response DTO",
        description = "Represents the pagination of the invoice list"
)
public class InvoicePagesResponseDTO {

    @ApiModelProperty(position = 1, notes = "Address list")
    private List<InvoiceWithClientResponseDTO> invoiceWithClientResponseDTOList;

    @ApiModelProperty(position = 2, notes = "Total pages")
    private Integer totalPages;

    @ApiModelProperty(position = 3, notes = "Current pages")
    private Integer currentPage;

    @ApiModelProperty(position = 4, notes = "Size")
    private Integer size;

    @ApiModelProperty(position = 5, notes = "Total number of page elements")
    private Integer totalElements;

}
