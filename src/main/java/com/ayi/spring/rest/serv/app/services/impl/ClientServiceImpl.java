package com.ayi.spring.rest.serv.app.services.impl;

import ch.qos.logback.core.net.server.Client;
import com.ayi.spring.rest.serv.app.dto.request.ClientFullDTO;
import com.ayi.spring.rest.serv.app.dto.request.ClientOnlyDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientInvoicesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientResponseDTO;
import com.ayi.spring.rest.serv.app.entities.ClientEntity;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;
import com.ayi.spring.rest.serv.app.exceptions.WriteAccessException;
import com.ayi.spring.rest.serv.app.mappers.IClientMapper;
import com.ayi.spring.rest.serv.app.repositories.IClientRepository;
import com.ayi.spring.rest.serv.app.services.IClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public ClientResponseDTO addClient(ClientFullDTO clientFullDTO) throws WriteAccessException {

        verifyDni(clientFullDTO.getDni());

        ClientEntity entity = clientMapper.fullDtoToEntity(clientFullDTO); // Corregir, no está guardando la FK en el registro de la dirección

        clientRepository.save(entity);

        return clientMapper.entityToDto(entity);

    }

    @Override
    public List<ClientResponseDTO> findAllClients() throws ReadAccessException {

        List<ClientResponseDTO> clientResponseDTOList = new ArrayList<>();
        List<ClientEntity> clientEntityList = clientRepository.findAll();

        if(clientEntityList == null) {
            throw new ReadAccessException(READ_ACCESS_EXCEPTION_NOT_FOUND);
        }

        clientEntityList.forEach(client -> {
            ClientResponseDTO clientResponseDTO = clientMapper.entityToDto(client);
            clientResponseDTOList.add(clientResponseDTO);
        });

        return clientResponseDTOList;

    }

    @Override
    public ClientResponseDTO findClientById(Long idClient) throws ReadAccessException {

        verifyId(idClient);

        ClientEntity clientEntity = clientRepository.findById(idClient).get();

        return clientMapper.entityToDto(clientEntity);

    }

    @Override
    public ClientInvoicesResponseDTO findClientInvoices(Long idClient) throws ReadAccessException {

        verifyId(idClient);

        ClientEntity clientEntity = clientRepository.findById(idClient).get();
        ClientResponseDTO clientResponseDTO = clientMapper.entityToDto(clientEntity);

        ClientInvoicesResponseDTO clientInvoicesResponseDTO = new ClientInvoicesResponseDTO(
                idClient,
                clientResponseDTO.getInvoiceList()
        );

        return clientInvoicesResponseDTO;

    }

    @Override
    public ClientResponseDTO modifyClient(Long idClient, ClientOnlyDTO clientOnlyDTO) throws ReadAccessException {

        verifyId(idClient);
        verifyDni(clientOnlyDTO.getDni());

        ClientEntity clientEntity = clientRepository.findById(idClient).get();

        clientEntity.setDni(clientOnlyDTO.getDni());
        clientEntity.setFirstName(clientOnlyDTO.getFirstName());
        clientEntity.setLastName(clientOnlyDTO.getLastName());

        clientRepository.save(clientEntity);

        return clientMapper.entityToDto(clientEntity);

    }

    @Override
    public ClientResponseDTO removeClient(Long idClient) throws ReadAccessException {

        verifyId(idClient);

        ClientEntity clientEntity = clientRepository.findById(idClient).get();

        clientEntity.setIsActive(false);
        clientRepository.save(clientEntity);
        ClientResponseDTO clientResponseDTO = clientMapper.entityToDto(clientEntity);

        return clientResponseDTO;
    }

    /**
     *
     * Function to verify the integrity or existence of the ID provided
     *
     * */
    public void verifyId(Long idClient) throws ReadAccessException {
        if(idClient == null || idClient <= 0) {
            throw new ReadAccessException(READ_ACCESS_EXCEPTION_INCORRECT_INPUT);
        }

        Optional<ClientEntity> entity = clientRepository.findById(idClient);

        if(!entity.isPresent()) {
            throw new ReadAccessException(READ_ACCESS_EXCEPTION_ID_NOT_FOUND);
        }
    }

    /**
     *
     * Function to verify existence of the DNI provided
     *
     * */
    public void verifyDni(String dni) throws WriteAccessException {
        Optional<ClientEntity> clientOptional = clientRepository.findByDni(dni);

        if(clientOptional.isPresent()) {
            throw new WriteAccessException(WRITE_ACCESS_EXCEPTION_DNI);
        }
    }
}
