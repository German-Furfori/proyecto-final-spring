package com.ayi.spring.rest.serv.app.mappers;

import com.ayi.spring.rest.serv.app.dto.request.InvoiceWithClientDTO;
import com.ayi.spring.rest.serv.app.dto.request.InvoiceWithoutClientDTO;
import com.ayi.spring.rest.serv.app.dto.response.InvoiceResponseDTO;
import com.ayi.spring.rest.serv.app.entities.InvoiceEntity;

public interface IInvoiceMapper {
    InvoiceResponseDTO entityToDto(InvoiceEntity entity);

    InvoiceEntity dtoWithToEntity(InvoiceWithClientDTO dto);

    InvoiceEntity dtoWithoutToEntity(InvoiceWithoutClientDTO dto);

    InvoiceEntity toEntityByRequest(InvoiceWithClientDTO dto);
}
