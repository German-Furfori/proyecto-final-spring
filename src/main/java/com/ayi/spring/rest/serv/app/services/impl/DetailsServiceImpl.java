package com.ayi.spring.rest.serv.app.services.impl;

import com.ayi.spring.rest.serv.app.dto.request.DetailsDTO;
import com.ayi.spring.rest.serv.app.dto.response.AddressResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.DetailsResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;
import com.ayi.spring.rest.serv.app.exceptions.WriteAccessException;
import com.ayi.spring.rest.serv.app.mappers.IDetailsMapper;
import com.ayi.spring.rest.serv.app.repositories.IDetailsRepository;
import com.ayi.spring.rest.serv.app.services.IDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class DetailsServiceImpl implements IDetailsService {

    @Autowired
    private IDetailsRepository detailsRepository;

    @Autowired
    private IDetailsMapper detailsMapper;

    @Override
    public List<DetailsResponseDTO> findAllDetails() throws ReadAccessException {
        return null;
    }

    @Override
    public DetailsResponseDTO findDetailById(Long id) throws ReadAccessException {
        return null;
    }

    @Override
    public DetailsResponseDTO addDetail(DetailsDTO detailsDTO) throws WriteAccessException {
        return null;
    }

    @Override
    public DetailsResponseDTO removeDetailById(Long id) throws WriteAccessException {
        return null;
    }

    @Override
    public AddressResponseDTO modifyAddress(Long id, DetailsDTO detailsDTO) throws WriteAccessException {
        return null;
    }

}
