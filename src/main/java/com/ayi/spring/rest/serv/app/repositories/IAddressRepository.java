package com.ayi.spring.rest.serv.app.repositories;

import com.ayi.spring.rest.serv.app.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<AddressEntity, Long> {
}
