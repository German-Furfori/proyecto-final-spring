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
        description = "Data needed to update the clients"
)
public class ClientOnlyDTO {

    @NotNull(message = "DNI cannot be null")
    @ApiModelProperty(position = 1, required = true)
    private String dni;

    @NotNull(message = "First name cannot be null")
    @ApiModelProperty(position = 2, required = true)
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @ApiModelProperty(position = 3, required = true)
    private String lastName;

    @NotNull(message = "Determines if the client is active or not")
    @ApiModelProperty(position = 4, required = true)
    private Boolean isActive;

}


