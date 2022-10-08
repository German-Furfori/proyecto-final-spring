package com.ayi.spring.rest.serv.app.dto.request.details;

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
        value = "Details Request",
        description = "Data needed to create the client details"
)
public class DetailsDTO {

    @NotNull(message = "VIP information cannot be null")
    @ApiModelProperty(position = 1, required = true)
    private Boolean vipClient;

    @NotNull(message = "The accumulated points cannot be null")
    @ApiModelProperty(position = 2, required = true)
    private Long accumulatedPoints;
}
