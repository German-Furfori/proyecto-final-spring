package com.ayi.spring.rest.serv.app.mappers;

import com.ayi.spring.rest.serv.app.dto.request.InvoiceWithClientDTO;
import com.ayi.spring.rest.serv.app.dto.request.InvoiceWithoutClientDTO;
import com.ayi.spring.rest.serv.app.dto.response.InvoiceWithFullClientDataResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.InvoiceWithClientResponseDTO;
import com.ayi.spring.rest.serv.app.entities.InvoiceEntity;

public interface IInvoiceMapper {
    InvoiceWithFullClientDataResponseDTO entityToDto(InvoiceEntity entity);

    InvoiceWithClientResponseDTO entityToDtoSimple(InvoiceEntity entity);

    InvoiceEntity dtoWithToEntity(InvoiceWithClientDTO dto);

    InvoiceEntity dtoWithoutToEntity(InvoiceWithoutClientDTO dto);

    InvoiceEntity toEntityByRequest(InvoiceWithClientDTO dto);
}
