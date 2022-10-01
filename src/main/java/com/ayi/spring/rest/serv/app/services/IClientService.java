package com.ayi.spring.rest.serv.app.services;

import com.ayi.spring.rest.serv.app.dto.response.ClientResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;

public interface IClientService {
    ClientResponseDTO findClientById(Long idClient) throws ReadAccessException;
}
