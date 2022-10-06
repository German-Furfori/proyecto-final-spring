package com.ayi.spring.rest.serv.app.mappers.impl;

import com.ayi.spring.rest.serv.app.dto.request.InvoiceWithClientDTO;
import com.ayi.spring.rest.serv.app.dto.request.InvoiceWithoutClientDTO;
import com.ayi.spring.rest.serv.app.dto.response.InvoiceResponseDTO;
import com.ayi.spring.rest.serv.app.entities.InvoiceEntity;
import com.ayi.spring.rest.serv.app.mappers.IInvoiceMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InvoiceMapperImpl implements IInvoiceMapper {
    private final ModelMapper modelMapper;

    @Override
    public InvoiceResponseDTO entityToDto(InvoiceEntity entity) {
        InvoiceResponseDTO invoiceResponseDTO = new InvoiceResponseDTO();
        modelMapper.map(entity, invoiceResponseDTO);
        return invoiceResponseDTO;
    }

    @Override
    public InvoiceEntity dtoWithToEntity(InvoiceWithClientDTO dto) {
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        modelMapper.map(dto, invoiceEntity);
        return invoiceEntity;
    }

    @Override
    public InvoiceEntity dtoWithoutToEntity(InvoiceWithoutClientDTO dto) {
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        modelMapper.map(dto, invoiceEntity);
        return invoiceEntity;
    }

    @Override
    public InvoiceEntity toEntityByRequest(InvoiceWithClientDTO dto) {
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        modelMapper.map(dto, invoiceEntity);
        return invoiceEntity;
    }
}
