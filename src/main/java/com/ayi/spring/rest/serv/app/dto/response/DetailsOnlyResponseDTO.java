package com.ayi.spring.rest.serv.app.dto.response;

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
        value = "Details Response",
        description = "The account details data provided by the server"
)
public class DetailsOnlyResponseDTO {

    @ApiModelProperty(position = 1, notes = "Account details id")
    private Long idDetails;

    @ApiModelProperty(position = 2, notes = "VIP information")
    private Boolean vipClient;

    @ApiModelProperty(position = 3, notes = "Accumulated points")
    private Long accumulatedPoints;

}
