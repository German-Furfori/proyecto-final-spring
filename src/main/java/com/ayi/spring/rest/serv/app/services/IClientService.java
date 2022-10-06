package com.ayi.spring.rest.serv.app.services;

import com.ayi.spring.rest.serv.app.dto.request.ClientFullDTO;
import com.ayi.spring.rest.serv.app.dto.request.ClientOnlyDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientInvoicesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientFullResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientOnlyResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;
import com.ayi.spring.rest.serv.app.exceptions.WriteAccessException;

import java.util.List;

public interface IClientService {
    ClientFullResponseDTO addClient(ClientFullDTO clientFullDTO) throws WriteAccessException;

    List<ClientFullResponseDTO> findAllClients() throws ReadAccessException;

    ClientFullResponseDTO findClientById(Long idClient) throws ReadAccessException;

    ClientInvoicesResponseDTO findClientInvoices(Long idClient) throws ReadAccessException;

    ClientOnlyResponseDTO modifyClient(Long id, ClientOnlyDTO clientOnlyDTO) throws ReadAccessException;

    ClientFullResponseDTO removeClient(Long id) throws ReadAccessException;
}
