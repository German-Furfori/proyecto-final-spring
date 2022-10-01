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
        value = "Address Request",
        description = "Data needed to create the client addresses"
)
public class AddressDTO {

    @NotNull(message = "Street name cannot be null")
    @ApiModelProperty(position = 1, required = true)
    private String streetName;

    @NotNull(message = "Street's number cannot be null")
    @ApiModelProperty(position = 2, required = true)
    private Integer number;

    @ApiModelProperty(position = 3)
    private Integer floor;

    @ApiModelProperty(position = 4)
    private Integer floorNumber;

    @NotNull(message = "ZIP code cannot be null")
    @ApiModelProperty(position = 5, required = true)
    private Integer zipCode;

    @NotNull(message = "City's name cannot be null")
    @ApiModelProperty(position = 6, required = true)
    private String city;

    @NotNull(message = "Province's name cannot be null")
    @ApiModelProperty(position = 7, required = true)
    private String province;

    @NotNull(message = "Country's name cannot be null")
    @ApiModelProperty(position = 8, required = true)
    private String country;

    @NotNull(message = "The clients cannot be null")
    @ApiModelProperty(position = 9, required = true)
    private List<ClientDTO> clientList;
}
