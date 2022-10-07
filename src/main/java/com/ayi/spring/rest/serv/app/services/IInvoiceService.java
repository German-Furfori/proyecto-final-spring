package com.ayi.spring.rest.serv.app.services;

import com.ayi.spring.rest.serv.app.dto.request.InvoiceWithClientDTO;
import com.ayi.spring.rest.serv.app.dto.request.InvoiceWithoutClientDTO;
import com.ayi.spring.rest.serv.app.dto.response.InvoiceWithClientDataResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.InvoiceWithClientResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;
import com.ayi.spring.rest.serv.app.exceptions.WriteAccessException;

import java.util.List;

public interface IInvoiceService {
    InvoiceWithClientResponseDTO addInvoiceWithoutClient(Long idClient, InvoiceWithoutClientDTO invoiceWithoutClientDTO) throws ReadAccessException;

    InvoiceWithClientDataResponseDTO addInvoiceWithClient(InvoiceWithClientDTO invoiceWithClientDTO) throws WriteAccessException;

    List<InvoiceWithClientResponseDTO> findAllInvoices() throws ReadAccessException;

    InvoiceWithClientResponseDTO findInvoiceById(Long id) throws ReadAccessException;

    InvoiceWithClientResponseDTO removeInvoice(Long id) throws ReadAccessException;
}
