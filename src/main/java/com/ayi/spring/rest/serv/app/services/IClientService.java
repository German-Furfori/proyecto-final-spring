package com.ayi.spring.rest.serv.app.services;

import com.ayi.spring.rest.serv.app.dto.request.ClientFullDTO;
import com.ayi.spring.rest.serv.app.dto.request.ClientOnlyDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientInvoicesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;
import com.ayi.spring.rest.serv.app.exceptions.WriteAccessException;

import java.util.List;

public interface IClientService {
    ClientResponseDTO addClient(ClientFullDTO clientFullDTO) throws WriteAccessException;

    List<ClientResponseDTO> findAllClients() throws ReadAccessException;

    ClientResponseDTO findClientById(Long idClient) throws ReadAccessException;

    ClientInvoicesResponseDTO findClientInvoices(Long idClient) throws ReadAccessException;

    ClientResponseDTO modifyClientById(Long id, ClientOnlyDTO clientOnlyDTO) throws ReadAccessException;

    ClientResponseDTO removeClient(Long id) throws ReadAccessException;
}
