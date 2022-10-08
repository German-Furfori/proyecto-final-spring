package com.ayi.spring.rest.serv.app.mappers;

import com.ayi.spring.rest.serv.app.dto.request.invoice.InvoiceWithClientDTO;
import com.ayi.spring.rest.serv.app.dto.request.invoice.InvoiceWithoutClientDTO;
import com.ayi.spring.rest.serv.app.dto.response.invoice.InvoicePagesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.invoice.InvoiceWithFullClientDataResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.invoice.InvoiceWithClientResponseDTO;
import com.ayi.spring.rest.serv.app.entities.InvoiceEntity;

import java.util.List;

public interface IInvoiceMapper {
    InvoiceWithFullClientDataResponseDTO entityToDto(InvoiceEntity entity);

    InvoiceWithClientResponseDTO entityToDtoSimple(InvoiceEntity entity);

    InvoiceEntity dtoWithToEntity(InvoiceWithClientDTO dto);

    InvoiceEntity dtoWithoutToEntity(InvoiceWithoutClientDTO dto);

    InvoicePagesResponseDTO entityListToDtoList(List<InvoiceEntity> invoiceEntityList);

    InvoiceEntity toEntityByRequest(InvoiceWithClientDTO dto);
}
