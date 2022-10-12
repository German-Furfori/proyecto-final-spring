package com.ayi.spring.rest.serv.app.services.impl;

import com.ayi.spring.rest.serv.app.dto.request.client.ClientFullDTO;
import com.ayi.spring.rest.serv.app.dto.request.client.ClientOnlyDTO;
import com.ayi.spring.rest.serv.app.dto.response.client.*;
import com.ayi.spring.rest.serv.app.entities.ClientEntity;
import com.ayi.spring.rest.serv.app.exceptions.RepositoryAccessException;
import com.ayi.spring.rest.serv.app.mappers.IClientMapper;
import com.ayi.spring.rest.serv.app.repositories.IClientRepository;
import com.ayi.spring.rest.serv.app.repositories.IInvoiceRepository;
import com.ayi.spring.rest.serv.app.services.IClientService;
import com.ayi.spring.rest.serv.app.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.ayi.spring.rest.serv.app.constants.ExceptionStrings.*;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class ClientServiceImpl implements IClientService {

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private IInvoiceRepository invoiceRepository;

    @Autowired
    private IClientMapper clientMapper;

    private Utils utils;

    @Override
    public ClientFullResponseDTO addClient(ClientFullDTO clientFullDTO) throws RepositoryAccessException {

        utils.verifyClientDni(clientFullDTO.getDni());

        ClientEntity clientEntity = clientMapper.fullDtoToEntity(clientFullDTO);
        clientEntity.setIsActive(true);

        clientRepository.save(clientEntity);

        return clientMapper.entityToFullDto(clientEntity);

    }

    @Override
    public ClientFullPagesResponseDTO findAllClients(Integer page, Integer size) throws RepositoryAccessException {

        ClientFullPagesResponseDTO clientFullPagesResponseDTO;
        Pageable pageable = PageRequest.of(page, size);

        Page<ClientEntity> clientEntityPages = clientRepository.findAll(pageable);

        if(clientEntityPages != null && !clientEntityPages.isEmpty()) {
            clientFullPagesResponseDTO = clientMapper.entityListToDtoList(clientEntityPages.getContent());
            clientFullPagesResponseDTO.setSize(clientEntityPages.getSize());
            clientFullPagesResponseDTO.setCurrentPage(clientEntityPages.getNumber() + 1);
            clientFullPagesResponseDTO.setTotalPages(clientEntityPages.getTotalPages());
            clientFullPagesResponseDTO.setTotalElements((int) clientEntityPages.getTotalElements());
            return clientFullPagesResponseDTO;
        } else {
            throw new RepositoryAccessException(READ_ACCESS_EXCEPTION_NOT_FOUND);
        }

    }

    @Override
    public ClientFullResponseDTO findClientById(Long idClient) throws RepositoryAccessException {

        utils.verifyClientId(idClient);

        ClientEntity clientEntity = clientRepository.findById(idClient).get();

        return clientMapper.entityToFullDto(clientEntity);

    }

    @Override
    public ClientInvoicesResponseDTO findClientInvoices(Long idClient) throws RepositoryAccessException {

        utils.verifyClientId(idClient);

        ClientEntity clientEntity = clientRepository.findById(idClient).get();
        ClientFullResponseDTO clientFullResponseDTO = clientMapper.entityToFullDto(clientEntity);

        ClientInvoicesResponseDTO clientInvoicesResponseDTO = new ClientInvoicesResponseDTO(
                idClient,
                clientFullResponseDTO.getDni(),
                clientFullResponseDTO.getFirstName(),
                clientFullResponseDTO.getLastName(),
                clientFullResponseDTO.getInvoiceList()
        );

        return clientInvoicesResponseDTO;

    }

    @Override
    public ClientOnlyResponseDTO modifyClient(Long idClient, ClientOnlyDTO clientOnlyDTO) throws RepositoryAccessException {

        utils.verifyClientId(idClient);
        utils.verifyClientDni(clientOnlyDTO.getDni());

        ClientEntity clientEntity = clientRepository.findById(idClient).get();

        clientEntity.setDni(clientOnlyDTO.getDni());
        clientEntity.setFirstName(clientOnlyDTO.getFirstName());
        clientEntity.setLastName(clientOnlyDTO.getLastName());

        clientRepository.save(clientEntity);

        return clientMapper.entityToOnlyDto(clientEntity);

    }

    @Override
    public ClientFullResponseDTO removeClient(Long idClient) throws RepositoryAccessException {

        utils.verifyClientId(idClient);

        ClientEntity clientEntity = clientRepository.findById(idClient).get();

        clientEntity.setIsActive(false);
        clientRepository.save(clientEntity);
        ClientFullResponseDTO clientFullResponseDTO = clientMapper.entityToFullDto(clientEntity);

        return clientFullResponseDTO;
    }

}
