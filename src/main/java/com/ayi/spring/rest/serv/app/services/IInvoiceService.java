package com.ayi.spring.rest.serv.app.services;

import com.ayi.spring.rest.serv.app.dto.request.InvoiceWithClientDTO;
import com.ayi.spring.rest.serv.app.dto.request.InvoiceWithoutClientDTO;
import com.ayi.spring.rest.serv.app.dto.response.InvoiceWithFullClientDataResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.InvoiceWithClientResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.GenericException;
import com.ayi.spring.rest.serv.app.exceptions.WriteAccessException;

import java.util.List;

public interface IInvoiceService {
    InvoiceWithClientResponseDTO addInvoiceWithoutClient(Long idClient, InvoiceWithoutClientDTO invoiceWithoutClientDTO) throws GenericException;

    InvoiceWithFullClientDataResponseDTO addInvoiceWithClient(InvoiceWithClientDTO invoiceWithClientDTO) throws GenericException;

    List<InvoiceWithClientResponseDTO> findAllInvoices() throws GenericException;

    InvoiceWithClientResponseDTO findInvoiceById(Long id) throws GenericException;

    InvoiceWithClientResponseDTO removeInvoice(Long id) throws GenericException;
}
