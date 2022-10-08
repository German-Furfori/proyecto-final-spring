package com.ayi.spring.rest.serv.app.services.impl;

import com.ayi.spring.rest.serv.app.dto.request.InvoiceWithClientDTO;
import com.ayi.spring.rest.serv.app.dto.request.InvoiceWithoutClientDTO;
import com.ayi.spring.rest.serv.app.dto.response.InvoiceWithFullClientDataResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.InvoiceWithClientResponseDTO;
import com.ayi.spring.rest.serv.app.entities.ClientEntity;
import com.ayi.spring.rest.serv.app.entities.InvoiceEntity;
import com.ayi.spring.rest.serv.app.exceptions.GenericException;
import com.ayi.spring.rest.serv.app.exceptions.WriteAccessException;
import com.ayi.spring.rest.serv.app.mappers.IInvoiceMapper;
import com.ayi.spring.rest.serv.app.repositories.IClientRepository;
import com.ayi.spring.rest.serv.app.repositories.IInvoiceRepository;
import com.ayi.spring.rest.serv.app.services.IInvoiceService;
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
public class InvoiceServiceImpl implements IInvoiceService {

    @Autowired
    private IInvoiceRepository invoiceRepository;

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private IInvoiceMapper invoiceMapper;

    private Utils utils;

    @Override
    public InvoiceWithClientResponseDTO addInvoiceWithoutClient(Long idClient, InvoiceWithoutClientDTO invoiceWithoutClientDTO) throws GenericException {

        utils.verifyClientId(idClient);

        InvoiceEntity invoiceEntity = invoiceMapper.dtoWithoutToEntity(invoiceWithoutClientDTO);
        ClientEntity clientEntity = clientRepository.findById(idClient).get();

        invoiceEntity.setClient(clientEntity);
        invoiceRepository.save(invoiceEntity);

        return invoiceMapper.entityToDtoSimple(invoiceEntity);

    }

    @Override
    public InvoiceWithFullClientDataResponseDTO addInvoiceWithClient(InvoiceWithClientDTO invoiceWithClientDTO) throws GenericException {

        utils.verifyClientDni(invoiceWithClientDTO.getClient().getDni());

        InvoiceEntity invoiceEntity = invoiceMapper.dtoWithToEntity(invoiceWithClientDTO);
        invoiceEntity.getClient().setIsActive(true);

        invoiceRepository.save(invoiceEntity);

        return invoiceMapper.entityToDto(invoiceEntity);

    }

    @Override
    public List<InvoiceWithClientResponseDTO> findAllInvoices() throws GenericException {

        List<InvoiceWithClientResponseDTO> invoiceWithClientResponseDTOList = new ArrayList<>();
        List<InvoiceEntity> invoiceEntityList = invoiceRepository.findAll();

        if(invoiceEntityList == null) {
            throw new GenericException(READ_ACCESS_EXCEPTION_NOT_FOUND);
        }

        invoiceEntityList.forEach(invoice -> {
            InvoiceWithClientResponseDTO invoiceWithClientResponseDTO = invoiceMapper.entityToDtoSimple(invoice);
            invoiceWithClientResponseDTOList.add(invoiceWithClientResponseDTO);
        });

        return invoiceWithClientResponseDTOList;

    }

    @Override
    public InvoiceWithClientResponseDTO findInvoiceById(Long idInvoice) throws GenericException {

        utils.verifyInvoiceId(idInvoice);

        InvoiceEntity invoiceEntity = invoiceRepository.findById(idInvoice).get();

        return invoiceMapper.entityToDtoSimple(invoiceEntity);

    }


    @Override
    public InvoiceWithClientResponseDTO removeInvoice(Long idInvoice) throws GenericException {

        utils.verifyInvoiceId(idInvoice);

        InvoiceEntity invoiceEntity = invoiceRepository.findById(idInvoice).get();
        InvoiceWithClientResponseDTO invoiceWithClientResponseDTO = invoiceMapper.entityToDtoSimple(invoiceEntity);

        invoiceRepository.deleteById(idInvoice);

        return invoiceWithClientResponseDTO;

    }

}
