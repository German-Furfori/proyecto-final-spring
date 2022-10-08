package com.ayi.spring.rest.serv.app.services;

import com.ayi.spring.rest.serv.app.dto.request.client.ClientFullDTO;
import com.ayi.spring.rest.serv.app.dto.request.client.ClientOnlyDTO;
import com.ayi.spring.rest.serv.app.dto.response.client.ClientFullPagesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.client.ClientInvoicesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.client.ClientFullResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.client.ClientOnlyResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.GenericAccessException;

import java.util.List;

public interface IClientService {
    ClientFullResponseDTO addClient(ClientFullDTO clientFullDTO) throws GenericAccessException;

    ClientFullPagesResponseDTO findAllClients(Integer page, Integer size) throws GenericAccessException;

    ClientFullResponseDTO findClientById(Long idClient) throws GenericAccessException;

    ClientInvoicesResponseDTO findClientInvoices(Long idClient) throws GenericAccessException;

    ClientOnlyResponseDTO modifyClient(Long id, ClientOnlyDTO clientOnlyDTO) throws GenericAccessException;

    ClientFullResponseDTO removeClient(Long id) throws GenericAccessException;
}
