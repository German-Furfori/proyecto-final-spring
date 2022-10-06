package com.ayi.spring.rest.serv.app.dto.response;

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
        value = "Client Response",
        description = "The client only data provided by the server"
)
public class ClientOnlyResponseDTO {
    @ApiModelProperty(position = 1, notes = "Client id")
    private Long clientId;

    @ApiModelProperty(position = 2, notes = "Client DNI")
    private String dni;

    @ApiModelProperty(position = 3, notes = "Client first name")
    private String firstName;

    @ApiModelProperty(position = 4, notes = "Client last name")
    private String lastName;

    @ApiModelProperty(position = 5, notes = "Active client?")
    private Boolean isActive;
}
