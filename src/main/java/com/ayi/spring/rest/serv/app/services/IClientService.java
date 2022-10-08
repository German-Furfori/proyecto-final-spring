package com.ayi.spring.rest.serv.app.services;

import com.ayi.spring.rest.serv.app.dto.request.ClientFullDTO;
import com.ayi.spring.rest.serv.app.dto.request.ClientOnlyDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientInvoicesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientFullResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientOnlyResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.GenericException;
import com.ayi.spring.rest.serv.app.exceptions.WriteAccessException;

import java.util.List;

public interface IClientService {
    ClientFullResponseDTO addClient(ClientFullDTO clientFullDTO) throws GenericException;

    List<ClientFullResponseDTO> findAllClients() throws GenericException;

    ClientFullResponseDTO findClientById(Long idClient) throws GenericException;

    ClientInvoicesResponseDTO findClientInvoices(Long idClient) throws GenericException;

    ClientOnlyResponseDTO modifyClient(Long id, ClientOnlyDTO clientOnlyDTO) throws GenericException;

    ClientFullResponseDTO removeClient(Long id) throws GenericException;
}
