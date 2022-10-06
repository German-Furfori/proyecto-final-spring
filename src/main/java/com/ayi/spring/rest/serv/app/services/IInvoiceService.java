package com.ayi.spring.rest.serv.app.services;

import com.ayi.spring.rest.serv.app.dto.request.InvoiceWithClientDTO;
import com.ayi.spring.rest.serv.app.dto.request.InvoiceWithoutClientDTO;
import com.ayi.spring.rest.serv.app.dto.response.InvoiceResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;
import com.ayi.spring.rest.serv.app.exceptions.WriteAccessException;

import java.util.List;

public interface IInvoiceService {
    InvoiceResponseDTO addInvoiceWithClient(Long idClient, InvoiceWithoutClientDTO invoiceWithoutClientDTO) throws ReadAccessException;

    InvoiceResponseDTO addInvoiceWithoutClient(InvoiceWithClientDTO invoiceWithClientDTO) throws WriteAccessException;

    List<InvoiceResponseDTO> findAllInvoices() throws ReadAccessException;

    InvoiceResponseDTO findInvoiceById(Long id) throws ReadAccessException;

    InvoiceResponseDTO removeInvoiceById(Long id) throws WriteAccessException;
}
