package com.ayi.spring.rest.serv.app.services;

import com.ayi.spring.rest.serv.app.dto.request.DetailsDTO;
import com.ayi.spring.rest.serv.app.dto.response.AddressResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.DetailsResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;
import com.ayi.spring.rest.serv.app.exceptions.WriteAccessException;

import java.util.List;

public interface IDetailsService {
    List<DetailsResponseDTO> findAllDetails() throws ReadAccessException;

    DetailsResponseDTO findDetailById(Long id) throws ReadAccessException;

    DetailsResponseDTO addDetail(DetailsDTO detailsDTO) throws WriteAccessException;

    DetailsResponseDTO removeDetailById(Long id) throws WriteAccessException;

    AddressResponseDTO modifyAddress(Long id, DetailsDTO detailsDTO) throws WriteAccessException;
}
