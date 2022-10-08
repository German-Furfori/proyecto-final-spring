package com.ayi.spring.rest.serv.app.services.impl;

import com.ayi.spring.rest.serv.app.dto.request.invoice.InvoiceWithClientDTO;
import com.ayi.spring.rest.serv.app.dto.request.invoice.InvoiceWithoutClientDTO;
import com.ayi.spring.rest.serv.app.dto.response.address.AddressPagesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.invoice.InvoicePagesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.invoice.InvoiceWithFullClientDataResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.invoice.InvoiceWithClientResponseDTO;
import com.ayi.spring.rest.serv.app.entities.AddressEntity;
import com.ayi.spring.rest.serv.app.entities.ClientEntity;
import com.ayi.spring.rest.serv.app.entities.InvoiceEntity;
import com.ayi.spring.rest.serv.app.exceptions.GenericAccessException;
import com.ayi.spring.rest.serv.app.mappers.IInvoiceMapper;
import com.ayi.spring.rest.serv.app.repositories.IClientRepository;
import com.ayi.spring.rest.serv.app.repositories.IInvoiceRepository;
import com.ayi.spring.rest.serv.app.services.IInvoiceService;
import com.ayi.spring.rest.serv.app.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public InvoiceWithClientResponseDTO addInvoiceWithoutClient(Long idClient, InvoiceWithoutClientDTO invoiceWithoutClientDTO) throws GenericAccessException {

        utils.verifyClientId(idClient);

        InvoiceEntity invoiceEntity = invoiceMapper.dtoWithoutToEntity(invoiceWithoutClientDTO);
        ClientEntity clientEntity = clientRepository.findById(idClient).get();

        invoiceEntity.setClient(clientEntity);
        invoiceRepository.save(invoiceEntity);

        return invoiceMapper.entityToDtoSimple(invoiceEntity);

    }

    @Override
    public InvoiceWithFullClientDataResponseDTO addInvoiceWithClient(InvoiceWithClientDTO invoiceWithClientDTO) throws GenericAccessException {

        utils.verifyClientDni(invoiceWithClientDTO.getClient().getDni());

        InvoiceEntity invoiceEntity = invoiceMapper.dtoWithToEntity(invoiceWithClientDTO);
        invoiceEntity.getClient().setIsActive(true);

        invoiceRepository.save(invoiceEntity);

        return invoiceMapper.entityToDto(invoiceEntity);

    }

    @Override
    public InvoicePagesResponseDTO findAllInvoicePages(Integer page, Integer size) throws GenericAccessException {

        /*List<InvoiceWithClientResponseDTO> invoiceWithClientResponseDTOList = new ArrayList<>();
        List<InvoiceEntity> invoiceEntityList = invoiceRepository.findAll();

        if(invoiceEntityList == null) {
            throw new GenericAccessException(READ_ACCESS_EXCEPTION_NOT_FOUND);
        }

        invoiceEntityList.forEach(invoice -> {
            InvoiceWithClientResponseDTO invoiceWithClientResponseDTO = invoiceMapper.entityToDtoSimple(invoice);
            invoiceWithClientResponseDTOList.add(invoiceWithClientResponseDTO);
        });

        return invoiceWithClientResponseDTOList;*/

        InvoicePagesResponseDTO invoicePagesResponseDTO;
        Pageable pageable = PageRequest.of(page, size);

        Page<InvoiceEntity> invoiceEntityPages = invoiceRepository.findAll(pageable);

        if(invoiceEntityPages != null && !invoiceEntityPages.isEmpty()) {
            invoicePagesResponseDTO = invoiceMapper.entityListToDtoList(invoiceEntityPages.getContent());
            invoicePagesResponseDTO.setSize(invoiceEntityPages.getSize());
            invoicePagesResponseDTO.setCurrentPage(invoiceEntityPages.getNumber() + 1);
            invoicePagesResponseDTO.setTotalPages(invoiceEntityPages.getTotalPages());
            invoicePagesResponseDTO.setTotalElements((int) invoiceEntityPages.getTotalElements());
            return invoicePagesResponseDTO;
        } else {
            throw new GenericAccessException(READ_ACCESS_EXCEPTION_NOT_FOUND);
        }

    }

    @Override
    public InvoiceWithClientResponseDTO findInvoiceById(Long idInvoice) throws GenericAccessException {

        utils.verifyInvoiceId(idInvoice);

        InvoiceEntity invoiceEntity = invoiceRepository.findById(idInvoice).get();

        return invoiceMapper.entityToDtoSimple(invoiceEntity);

    }


    @Override
    public InvoiceWithClientResponseDTO removeInvoice(Long idInvoice) throws GenericAccessException {

        utils.verifyInvoiceId(idInvoice);

        InvoiceEntity invoiceEntity = invoiceRepository.findById(idInvoice).get();
        InvoiceWithClientResponseDTO invoiceWithClientResponseDTO = invoiceMapper.entityToDtoSimple(invoiceEntity);

        invoiceRepository.deleteById(idInvoice);

        return invoiceWithClientResponseDTO;

    }

}
