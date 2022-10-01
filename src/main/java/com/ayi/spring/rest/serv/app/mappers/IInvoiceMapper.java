package com.ayi.spring.rest.serv.app.mappers;

import com.ayi.spring.rest.serv.app.dto.request.InvoiceDTO;
import com.ayi.spring.rest.serv.app.dto.response.InvoiceResponseDTO;
import com.ayi.spring.rest.serv.app.entities.InvoiceEntity;

public interface IInvoiceMapper {
    InvoiceResponseDTO entityToDto(InvoiceEntity entity);

    InvoiceEntity dtoToEntity(InvoiceDTO dto);

    InvoiceEntity toEntityByRequest(InvoiceDTO dto);
}
