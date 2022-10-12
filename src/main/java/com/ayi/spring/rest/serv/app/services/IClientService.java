package com.ayi.spring.rest.serv.app.services;

import com.ayi.spring.rest.serv.app.dto.request.client.ClientFullDTO;
import com.ayi.spring.rest.serv.app.dto.request.client.ClientOnlyDTO;
import com.ayi.spring.rest.serv.app.dto.response.client.ClientFullPagesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.client.ClientInvoicesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.client.ClientFullResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.client.ClientOnlyResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.RepositoryAccessException;

public interface IClientService {
    ClientFullResponseDTO addClient(ClientFullDTO clientFullDTO) throws RepositoryAccessException;

    ClientFullPagesResponseDTO findAllClients(Integer page, Integer size) throws RepositoryAccessException;

    ClientFullResponseDTO findClientById(Long idClient) throws RepositoryAccessException;

    ClientInvoicesResponseDTO findClientInvoices(Long idClient) throws RepositoryAccessException;

    ClientOnlyResponseDTO modifyClient(Long id, ClientOnlyDTO clientOnlyDTO) throws RepositoryAccessException;

    ClientFullResponseDTO removeClient(Long id) throws RepositoryAccessException;
}
