package com.ayi.spring.rest.serv.app.utils;

import com.ayi.spring.rest.serv.app.entities.AddressEntity;
import com.ayi.spring.rest.serv.app.entities.ClientEntity;
import com.ayi.spring.rest.serv.app.entities.DetailsEntity;
import com.ayi.spring.rest.serv.app.entities.InvoiceEntity;
import com.ayi.spring.rest.serv.app.exceptions.GenericException;
import com.ayi.spring.rest.serv.app.exceptions.WriteAccessException;
import com.ayi.spring.rest.serv.app.repositories.IAddressRepository;
import com.ayi.spring.rest.serv.app.repositories.IClientRepository;
import com.ayi.spring.rest.serv.app.repositories.IDetailsRepository;
import com.ayi.spring.rest.serv.app.repositories.IInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static com.ayi.spring.rest.serv.app.constants.ExceptionStrings.*;

@Service
public class Utils {

    @Autowired
    IClientRepository clientRepository;

    @Autowired
    IInvoiceRepository invoiceRepository;

    @Autowired
    IAddressRepository addressRepository;

    @Autowired
    IDetailsRepository detailsRepository;

    /**
     *
     * Function to verify the integrity or existence of the client ID provided
     *
     * */
    public void verifyClientId(Long idClient) throws GenericException {
        if(idClient == null || idClient <= 0) {
            throw new GenericException(READ_ACCESS_EXCEPTION_INCORRECT_INPUT);
        }

        Optional<ClientEntity> entity = clientRepository.findById(idClient);

        if(!entity.isPresent()) {
            throw new GenericException(READ_ACCESS_EXCEPTION_ID_NOT_FOUND);
        }
    }

    /**
     *
     * Function to verify the integrity or existence of the invoice ID provided
     *
     * */
    public void verifyInvoiceId(Long idInvoice) throws GenericException {
        if(idInvoice == null || idInvoice <= 0) {
            throw new GenericException(READ_ACCESS_EXCEPTION_INCORRECT_INPUT);
        }

        Optional<InvoiceEntity> entity = invoiceRepository.findById(idInvoice);

        if(!entity.isPresent()) {
            throw new GenericException(READ_ACCESS_EXCEPTION_ID_NOT_FOUND);
        }
    }

    /**
     *
     * Function to verify the integrity or existence of the address ID provided
     *
     * */
    public void verifyAddressId(Long idAddress) throws GenericException {
        if(idAddress == null || idAddress <= 0) {
            throw new GenericException(READ_ACCESS_EXCEPTION_INCORRECT_INPUT);
        }

        Optional<AddressEntity> entity = addressRepository.findById(idAddress);

        if(!entity.isPresent()) {
            throw new GenericException(READ_ACCESS_EXCEPTION_ID_NOT_FOUND);
        }
    }

    /**
     *
     * Function to verify the integrity or existence of the details ID provided
     *
     * */
    public void verifyDetailsId(Long idDetails) throws GenericException {
        if(idDetails == null || idDetails <= 0) {
            throw new GenericException(READ_ACCESS_EXCEPTION_INCORRECT_INPUT);
        }

        Optional<DetailsEntity> entity = detailsRepository.findById(idDetails);

        if(!entity.isPresent()) {
            throw new GenericException(READ_ACCESS_EXCEPTION_ID_NOT_FOUND);
        }
    }

    /**
     *
     * Function to verify the integrity or existence of the client address ID provided.
     * The ID Client must be verified before using this method
     *
     * */
    public void verifyClientAddressId(Long idClient, Long idAddress) throws GenericException {
        AtomicReference<Boolean> addressExistence = new AtomicReference<>(false);

        if(idAddress == null || idClient == null || idAddress <= 0 || idClient <= 0) {
            throw new GenericException(READ_ACCESS_EXCEPTION_INCORRECT_INPUT);
        }

        ClientEntity clientEntity = clientRepository.findById(idClient).get();

        clientEntity.getAddressList().forEach(addressEntity -> {
            if(addressEntity.getIdAddress() == idAddress) addressExistence.set(true);
        });

        if(!addressExistence.get()) {
            throw new GenericException(READ_ACCESS_EXCEPTION_CLIENT_ADDRESS_NOT_FOUND);
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
