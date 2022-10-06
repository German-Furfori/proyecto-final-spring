package com.ayi.spring.rest.serv.app.services.impl;

import com.ayi.spring.rest.serv.app.dto.request.InvoiceWithClientDTO;
import com.ayi.spring.rest.serv.app.dto.request.InvoiceWithoutClientDTO;
import com.ayi.spring.rest.serv.app.dto.response.InvoiceResponseDTO;
import com.ayi.spring.rest.serv.app.entities.ClientEntity;
import com.ayi.spring.rest.serv.app.entities.InvoiceEntity;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;
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
import java.util.List;

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
    public InvoiceResponseDTO addInvoiceWithClient(Long idClient, InvoiceWithoutClientDTO invoiceWithoutClientDTO) throws ReadAccessException {

        utils.verifyClientId(idClient);

        InvoiceEntity invoiceEntity = invoiceMapper.dtoWithoutToEntity(invoiceWithoutClientDTO);
        ClientEntity clientEntity = clientRepository.findById(idClient).get();

        invoiceEntity.setClient(clientEntity);
        invoiceRepository.save(invoiceEntity);

        return invoiceMapper.entityToDto(invoiceEntity);

    }

    @Override
    public InvoiceResponseDTO addInvoiceWithoutClient(InvoiceWithClientDTO invoiceWithClientDTO) throws WriteAccessException {
        return null;
    }

    @Override
    public List<InvoiceResponseDTO> findAllInvoices() throws ReadAccessException {
        return null;
    }

    @Override
    public InvoiceResponseDTO findInvoiceById(Long id) throws ReadAccessException {
        return null;
    }


    @Override
    public InvoiceResponseDTO removeInvoiceById(Long id) throws WriteAccessException {
        return null;
    }

}
