package com.ayi.spring.rest.serv.app.services.impl;

import com.ayi.spring.rest.serv.app.dto.request.ClientFullDTO;
import com.ayi.spring.rest.serv.app.dto.request.ClientOnlyDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientInvoicesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientFullResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientOnlyResponseDTO;
import com.ayi.spring.rest.serv.app.entities.ClientEntity;
import com.ayi.spring.rest.serv.app.exceptions.GenericException;
import com.ayi.spring.rest.serv.app.exceptions.WriteAccessException;
import com.ayi.spring.rest.serv.app.mappers.IClientMapper;
import com.ayi.spring.rest.serv.app.repositories.IClientRepository;
import com.ayi.spring.rest.serv.app.services.IClientService;
import com.ayi.spring.rest.serv.app.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

import static com.ayi.spring.rest.serv.app.constants.ExceptionStrings.*;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class ClientServiceImpl implements IClientService {

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private IClientMapper clientMapper;

    private Utils utils;

    @Override
    public ClientFullResponseDTO addClient(ClientFullDTO clientFullDTO) throws GenericException {

        utils.verifyClientDni(clientFullDTO.getDni());

        ClientEntity clientEntity = clientMapper.fullDtoToEntity(clientFullDTO); // Corregir, no está guardando la FK en el registro de la dirección
        clientEntity.setIsActive(true);

        clientRepository.save(clientEntity);

        return clientMapper.entityToFullDto(clientEntity);

    }

    @Override
    public List<ClientFullResponseDTO> findAllClients() throws GenericException {

        List<ClientFullResponseDTO> clientFullResponseDTOList = new ArrayList<>();
        List<ClientEntity> clientEntityList = clientRepository.findAll();

        if(clientEntityList == null) {
            throw new GenericException(READ_ACCESS_EXCEPTION_NOT_FOUND);
        }

        clientEntityList.forEach(client -> {
            ClientFullResponseDTO clientFullResponseDTO = clientMapper.entityToFullDto(client);
            clientFullResponseDTOList.add(clientFullResponseDTO);
        });

        return clientFullResponseDTOList;

    }

    @Override
    public ClientFullResponseDTO findClientById(Long idClient) throws GenericException {

        utils.verifyClientId(idClient);

        ClientEntity clientEntity = clientRepository.findById(idClient).get();

        return clientMapper.entityToFullDto(clientEntity);

    }

    @Override
    public ClientInvoicesResponseDTO findClientInvoices(Long idClient) throws GenericException {

        utils.verifyClientId(idClient);

        ClientEntity clientEntity = clientRepository.findById(idClient).get();
        ClientFullResponseDTO clientFullResponseDTO = clientMapper.entityToFullDto(clientEntity);

        ClientInvoicesResponseDTO clientInvoicesResponseDTO = new ClientInvoicesResponseDTO(
                idClient,
                clientFullResponseDTO.getInvoiceList()
        );

        return clientInvoicesResponseDTO;

    }

    @Override
    public ClientOnlyResponseDTO modifyClient(Long idClient, ClientOnlyDTO clientOnlyDTO) throws GenericException {

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
    public ClientFullResponseDTO removeClient(Long idClient) throws GenericException {

        utils.verifyClientId(idClient);

        ClientEntity clientEntity = clientRepository.findById(idClient).get();

        clientEntity.setIsActive(false);
        clientRepository.save(clientEntity);
        ClientFullResponseDTO clientFullResponseDTO = clientMapper.entityToFullDto(clientEntity);

        return clientFullResponseDTO;
    }

}
