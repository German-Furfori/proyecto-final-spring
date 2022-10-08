package com.ayi.spring.rest.serv.app.mappers.impl;

import com.ayi.spring.rest.serv.app.dto.request.InvoiceWithClientDTO;
import com.ayi.spring.rest.serv.app.dto.request.InvoiceWithoutClientDTO;
import com.ayi.spring.rest.serv.app.dto.response.InvoiceWithFullClientDataResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.InvoiceWithClientResponseDTO;
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
    public InvoiceWithFullClientDataResponseDTO entityToDto(InvoiceEntity entity) {
        InvoiceWithFullClientDataResponseDTO invoiceWithFullClientDataResponseDTO = new InvoiceWithFullClientDataResponseDTO();
        modelMapper.map(entity, invoiceWithFullClientDataResponseDTO);
        return invoiceWithFullClientDataResponseDTO;
    }

    @Override
    public InvoiceWithClientResponseDTO entityToDtoSimple(InvoiceEntity entity) {
        InvoiceWithClientResponseDTO invoiceWithClientResponseDTO = new InvoiceWithClientResponseDTO();
        modelMapper.map(entity, invoiceWithClientResponseDTO);
        return invoiceWithClientResponseDTO;
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
