package com.ayi.spring.rest.serv.app.utils;

import com.ayi.spring.rest.serv.app.entities.ClientEntity;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;
import com.ayi.spring.rest.serv.app.exceptions.WriteAccessException;
import com.ayi.spring.rest.serv.app.repositories.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.ayi.spring.rest.serv.app.constants.ExceptionStrings.*;

@Service
public class Utils {

    @Autowired
    IClientRepository clientRepository;

    /**
     *
     * Function to verify the integrity or existence of the ID provided
     *
     * */
    public void verifyClientId(Long idClient) throws ReadAccessException {
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
    public void verifyClientDni(String dni) throws WriteAccessException {
        Optional<ClientEntity> clientOptional = clientRepository.findByDni(dni);

        if(clientOptional.isPresent()) {
            throw new WriteAccessException(WRITE_ACCESS_EXCEPTION_DNI);
        }
    }

}
