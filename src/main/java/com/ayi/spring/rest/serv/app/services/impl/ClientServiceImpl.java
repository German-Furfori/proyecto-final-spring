package com.ayi.spring.rest.serv.app.services.impl;

import com.ayi.spring.rest.serv.app.dto.request.ClientDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientResponseDTO;
import com.ayi.spring.rest.serv.app.entities.ClientEntity;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;
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
    public List<ClientResponseDTO> findAllClients() throws ReadAccessException {
        List<ClientResponseDTO> clientResponseDTOList = new ArrayList<>();
        List<ClientEntity> clientEntityList = clientRepository.findAll();

        if(clientEntityList == null) {
            throw new ReadAccessException("No existen registros en el sistema");
        }

        clientEntityList.forEach(client -> {
            ClientResponseDTO clientResponseDTO = clientMapper.entityToDto(client);
            clientResponseDTOList.add(clientResponseDTO);
        });

        return clientResponseDTOList;
    }

    @Override
    public ClientResponseDTO findClientById(Long idClient) throws ReadAccessException {
        if(idClient == null || idClient <= 0) {
            throw new ReadAccessException("Error, el valor del id es incorrecto");
        }

        Optional<ClientEntity> entity = clientRepository.findById(idClient);

        if(!entity.isPresent()) {
            throw new ReadAccessException("No se encuentra el id solicitado");
        }

        return clientMapper.entityToDto(entity.get());
    }

    @Override
    public ClientResponseDTO addClient(ClientDTO clientDTO) {
        ClientEntity entity = clientMapper.dtoToEntity(clientDTO);

        clientRepository.save(entity);

        return clientMapper.entityToDto(entity);
    }

    @Override
    public ClientResponseDTO removeClient(ClientDTO clientDTO) {
        return null;
    }

    @Override
    public ClientResponseDTO modifyClient(ClientDTO clientDTO) {
        return null;
    }
}
