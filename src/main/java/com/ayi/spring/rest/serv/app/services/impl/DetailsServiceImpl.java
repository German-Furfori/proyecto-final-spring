package com.ayi.spring.rest.serv.app.services.impl;

import com.ayi.spring.rest.serv.app.dto.request.DetailsDTO;
import com.ayi.spring.rest.serv.app.dto.response.DetailsWithClientResponseDTO;
import com.ayi.spring.rest.serv.app.entities.DetailsEntity;
import com.ayi.spring.rest.serv.app.exceptions.GenericException;
import com.ayi.spring.rest.serv.app.mappers.IDetailsMapper;
import com.ayi.spring.rest.serv.app.repositories.IDetailsRepository;
import com.ayi.spring.rest.serv.app.services.IDetailsService;
import com.ayi.spring.rest.serv.app.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.ayi.spring.rest.serv.app.constants.ExceptionStrings.READ_ACCESS_EXCEPTION_NOT_FOUND;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class DetailsServiceImpl implements IDetailsService {

    @Autowired
    private IDetailsRepository detailsRepository;

    @Autowired
    private IDetailsMapper detailsMapper;

    Utils utils;

    @Override
    public List<DetailsWithClientResponseDTO> findAllDetails() throws GenericException {

        List<DetailsWithClientResponseDTO> detailsWithClientResponseDTOList = new ArrayList<>();
        List<DetailsEntity> detailsEntityList = detailsRepository.findAll();

        if(detailsEntityList == null) {
            throw new GenericException(READ_ACCESS_EXCEPTION_NOT_FOUND);
        }

        detailsEntityList.forEach(detail -> {
            DetailsWithClientResponseDTO detailsWithClientResponseDTO = detailsMapper.entityToDto(detail);
            detailsWithClientResponseDTOList.add(detailsWithClientResponseDTO);
        });

        return detailsWithClientResponseDTOList;

    }

    @Override
    public DetailsWithClientResponseDTO modifyDetails(Long idDetails, DetailsDTO detailsDTO) throws GenericException {

        utils.verifyDetailsId(idDetails);

        DetailsEntity detailsEntity = detailsRepository.findById(idDetails).get();
        detailsEntity.setVipClient(detailsDTO.getVipClient());
        detailsEntity.setAccumulatedPoints(detailsDTO.getAccumulatedPoints());
        detailsRepository.save(detailsEntity);

        return detailsMapper.entityToDto(detailsEntity);

    }

}
