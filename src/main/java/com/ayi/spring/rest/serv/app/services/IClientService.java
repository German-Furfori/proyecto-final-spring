package com.ayi.spring.rest.serv.app.services;

import com.ayi.spring.rest.serv.app.dto.request.ClientDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;

import java.util.List;

public interface IClientService {
    List<ClientResponseDTO> findAllClients() throws ReadAccessException;

    ClientResponseDTO findClientById(Long idClient) throws ReadAccessException;

    ClientResponseDTO addClient(ClientDTO clientDTO);

    ClientResponseDTO removeClient(ClientDTO clientDTO);

    ClientResponseDTO modifyClient(ClientDTO clientDTO);
}
