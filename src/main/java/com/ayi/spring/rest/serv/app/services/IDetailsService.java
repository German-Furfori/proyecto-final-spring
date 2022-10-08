package com.ayi.spring.rest.serv.app.services;

import com.ayi.spring.rest.serv.app.dto.request.DetailsDTO;
import com.ayi.spring.rest.serv.app.dto.response.AddressResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.DetailsWithClientResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;
import com.ayi.spring.rest.serv.app.exceptions.WriteAccessException;

import java.util.List;

public interface IDetailsService {

    List<DetailsWithClientResponseDTO> findAllDetails() throws ReadAccessException;

    DetailsWithClientResponseDTO modifyDetails(Long id, DetailsDTO detailsDTO) throws ReadAccessException;
}
