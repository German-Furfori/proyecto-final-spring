package com.ayi.spring.rest.serv.app.repositories;

import com.ayi.spring.rest.serv.app.entities.DetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetailsRepository extends JpaRepository<DetailsEntity, Long> {
}
