package com.ayi.spring.rest.serv.app.repositories;


import com.ayi.spring.rest.serv.app.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<ClientEntity, Long> {
}
