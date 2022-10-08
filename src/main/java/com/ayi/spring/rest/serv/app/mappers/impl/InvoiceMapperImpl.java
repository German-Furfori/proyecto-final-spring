package com.ayi.spring.rest.serv.app.mappers.impl;

import com.ayi.spring.rest.serv.app.dto.request.invoice.InvoiceWithClientDTO;
import com.ayi.spring.rest.serv.app.dto.request.invoice.InvoiceWithoutClientDTO;
import com.ayi.spring.rest.serv.app.dto.response.invoice.InvoicePagesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.invoice.InvoiceWithFullClientDataResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.invoice.InvoiceWithClientResponseDTO;
import com.ayi.spring.rest.serv.app.entities.InvoiceEntity;
import com.ayi.spring.rest.serv.app.mappers.IInvoiceMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
    public InvoicePagesResponseDTO entityListToDtoList(List<InvoiceEntity> invoiceEntityList) {
        InvoicePagesResponseDTO invoicePagesResponseDTO = new InvoicePagesResponseDTO();
        List<InvoiceWithClientResponseDTO> invoiceWithClientResponseDTOList = new ArrayList<>();

        invoiceEntityList.forEach(invoiceEntity -> {
            InvoiceWithClientResponseDTO invoiceWithClientResponseDTO = new InvoiceWithClientResponseDTO();
            modelMapper.map(invoiceEntity, invoiceWithClientResponseDTO);
            invoiceWithClientResponseDTOList.add(invoiceWithClientResponseDTO);
        });

        invoicePagesResponseDTO.setInvoiceWithClientResponseDTOList(invoiceWithClientResponseDTOList);
        return invoicePagesResponseDTO;
    }

    @Override
    public InvoiceEntity toEntityByRequest(InvoiceWithClientDTO dto) {
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        modelMapper.map(dto, invoiceEntity);
        return invoiceEntity;
    }
}
