package com.ayi.spring.rest.serv.app.services.impl;

import com.ayi.spring.rest.serv.app.dto.request.ClientFullDTO;
import com.ayi.spring.rest.serv.app.dto.request.ClientOnlyDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientInvoicesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientFullResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientOnlyResponseDTO;
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
    public ClientFullResponseDTO addClient(ClientFullDTO clientFullDTO) throws WriteAccessException {

        verifyDni(clientFullDTO.getDni());

        ClientEntity entity = clientMapper.fullDtoToEntity(clientFullDTO); // Corregir, no está guardando la FK en el registro de la dirección
        entity.setIsActive(true);

        clientRepository.save(entity);

        return clientMapper.entityToFullDto(entity);

    }

    @Override
    public List<ClientFullResponseDTO> findAllClients() throws ReadAccessException {

        List<ClientFullResponseDTO> clientFullResponseDTOList = new ArrayList<>();
        List<ClientEntity> clientEntityList = clientRepository.findAll();

        if(clientEntityList == null) {
            throw new ReadAccessException(READ_ACCESS_EXCEPTION_NOT_FOUND);
        }

        clientEntityList.forEach(client -> {
            ClientFullResponseDTO clientFullResponseDTO = clientMapper.entityToFullDto(client);
            clientFullResponseDTOList.add(clientFullResponseDTO);
        });

        return clientFullResponseDTOList;

    }

    @Override
    public ClientFullResponseDTO findClientById(Long idClient) throws ReadAccessException {

        verifyId(idClient);

        ClientEntity clientEntity = clientRepository.findById(idClient).get();

        return clientMapper.entityToFullDto(clientEntity);

    }

    @Override
    public ClientInvoicesResponseDTO findClientInvoices(Long idClient) throws ReadAccessException {

        verifyId(idClient);

        ClientEntity clientEntity = clientRepository.findById(idClient).get();
        ClientFullResponseDTO clientFullResponseDTO = clientMapper.entityToFullDto(clientEntity);

        ClientInvoicesResponseDTO clientInvoicesResponseDTO = new ClientInvoicesResponseDTO(
                idClient,
                clientFullResponseDTO.getInvoiceList()
        );

        return clientInvoicesResponseDTO;

    }

    @Override
    public ClientOnlyResponseDTO modifyClient(Long idClient, ClientOnlyDTO clientOnlyDTO) throws ReadAccessException {

        verifyId(idClient);
        verifyDni(clientOnlyDTO.getDni());

        ClientEntity clientEntity = clientRepository.findById(idClient).get();

        clientEntity.setDni(clientOnlyDTO.getDni());
        clientEntity.setFirstName(clientOnlyDTO.getFirstName());
        clientEntity.setLastName(clientOnlyDTO.getLastName());

        clientRepository.save(clientEntity);

        return clientMapper.entityToOnlyDto(clientEntity);

    }

    @Override
    public ClientFullResponseDTO removeClient(Long idClient) throws ReadAccessException {

        verifyId(idClient);

        ClientEntity clientEntity = clientRepository.findById(idClient).get();

        clientEntity.setIsActive(false);
        clientRepository.save(clientEntity);
        ClientFullResponseDTO clientFullResponseDTO = clientMapper.entityToFullDto(clientEntity);

        return clientFullResponseDTO;
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
