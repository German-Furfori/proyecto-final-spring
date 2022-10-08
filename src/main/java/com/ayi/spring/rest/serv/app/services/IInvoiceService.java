package com.ayi.spring.rest.serv.app.services;

import com.ayi.spring.rest.serv.app.dto.request.invoice.InvoiceWithClientDTO;
import com.ayi.spring.rest.serv.app.dto.request.invoice.InvoiceWithoutClientDTO;
import com.ayi.spring.rest.serv.app.dto.response.invoice.InvoicePagesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.invoice.InvoiceWithFullClientDataResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.invoice.InvoiceWithClientResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.GenericAccessException;

import java.util.List;

public interface IInvoiceService {
    InvoiceWithClientResponseDTO addInvoiceWithoutClient(Long idClient, InvoiceWithoutClientDTO invoiceWithoutClientDTO) throws GenericAccessException;

    InvoiceWithFullClientDataResponseDTO addInvoiceWithClient(InvoiceWithClientDTO invoiceWithClientDTO) throws GenericAccessException;

    InvoicePagesResponseDTO findAllInvoicePages(Integer page, Integer size) throws GenericAccessException;

    InvoiceWithClientResponseDTO findInvoiceById(Long id) throws GenericAccessException;

    InvoiceWithClientResponseDTO removeInvoice(Long id) throws GenericAccessException;
}
