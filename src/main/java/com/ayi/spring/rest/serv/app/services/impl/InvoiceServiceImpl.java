package com.ayi.spring.rest.serv.app.services.impl;

import com.ayi.spring.rest.serv.app.dto.request.InvoiceDTO;
import com.ayi.spring.rest.serv.app.dto.response.InvoiceResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;
import com.ayi.spring.rest.serv.app.exceptions.WriteAccessException;
import com.ayi.spring.rest.serv.app.mappers.IInvoiceMapper;
import com.ayi.spring.rest.serv.app.repositories.IInvoiceRepository;
import com.ayi.spring.rest.serv.app.services.IInvoiceService;
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
    IInvoiceRepository invoiceRepository;

    @Autowired
    IInvoiceMapper invoiceMapper;

    @Override
    public InvoiceResponseDTO addInvoiceWithClient(Long idClient, InvoiceDTO invoiceDTO) throws WriteAccessException {
        return null;
    }

    @Override
    public InvoiceResponseDTO addInvoiceWithoutClient(InvoiceDTO invoiceDTO) throws WriteAccessException {
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
