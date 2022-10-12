package com.ayi.spring.rest.serv.app.services;

import com.ayi.spring.rest.serv.app.dto.request.invoice.InvoiceWithClientDTO;
import com.ayi.spring.rest.serv.app.dto.request.invoice.InvoiceWithoutClientDTO;
import com.ayi.spring.rest.serv.app.dto.response.invoice.InvoicePagesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.invoice.InvoiceWithFullClientDataResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.invoice.InvoiceWithClientResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.RepositoryAccessException;

public interface IInvoiceService {
    InvoiceWithClientResponseDTO addInvoiceWithoutClient(Long idClient, InvoiceWithoutClientDTO invoiceWithoutClientDTO) throws RepositoryAccessException;

    InvoiceWithFullClientDataResponseDTO addInvoiceWithClient(InvoiceWithClientDTO invoiceWithClientDTO) throws RepositoryAccessException;

    InvoicePagesResponseDTO findAllInvoicePages(Integer page, Integer size) throws RepositoryAccessException;

    InvoiceWithClientResponseDTO findInvoiceById(Long id) throws RepositoryAccessException;

    InvoiceWithClientResponseDTO removeInvoice(Long id) throws RepositoryAccessException;
}
