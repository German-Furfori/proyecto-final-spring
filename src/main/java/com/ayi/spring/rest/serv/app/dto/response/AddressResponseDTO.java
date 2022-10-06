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
        value = "Address Response",
        description = "The address data provided by the server"
)
public class AddressResponseDTO {

    @ApiModelProperty(position = 1, notes = "Address id")
    private Long idAddress;

    @ApiModelProperty(position = 2, notes = "Street name")
    private String streetName;

    @ApiModelProperty(position = 3, notes = "Street number")
    private String number;

    @ApiModelProperty(position = 4, notes = "Floor number")
    private String floor;

    @ApiModelProperty(position = 5, notes = "Number of the apartment")
    private String floorNumber;

    @ApiModelProperty(position = 6, notes = "ZIP code")
    private String zipCode;

    @ApiModelProperty(position = 7, notes = "City name")
    private String city;

    @ApiModelProperty(position = 8, notes = "Province name")
    private String province;

    @ApiModelProperty(position = 9, notes = "Country name")
    private String country;

    @ApiModelProperty(position = 10, notes = "Client data list")
    @JsonIgnoreProperties(value = "addressList")
    private ClientFullResponseDTO client;
}
