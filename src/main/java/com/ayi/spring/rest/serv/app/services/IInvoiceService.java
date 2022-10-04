package com.ayi.spring.rest.serv.app.services;

import com.ayi.spring.rest.serv.app.dto.request.InvoiceDTO;
import com.ayi.spring.rest.serv.app.dto.response.InvoiceResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;
import com.ayi.spring.rest.serv.app.exceptions.WriteAccessException;

import java.util.List;

public interface IInvoiceService {
    List<InvoiceResponseDTO> findAllInvoices() throws ReadAccessException;

    InvoiceResponseDTO findInvoiceById(Long id) throws ReadAccessException;

    InvoiceResponseDTO addInvoice(InvoiceDTO invoiceDTO) throws WriteAccessException;

    InvoiceResponseDTO removeInvoiceById(Long id) throws WriteAccessException;

    InvoiceResponseDTO modifyInvoice(Long id, InvoiceDTO invoiceDTO) throws WriteAccessException;
}
