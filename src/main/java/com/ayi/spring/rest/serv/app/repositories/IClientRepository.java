package com.ayi.spring.rest.serv.app.repositories;


import com.ayi.spring.rest.serv.app.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClientRepository extends JpaRepository<ClientEntity, Long> {

    @Query("Select CE from ClientEntity CE where CE.dni = :dni")
    Optional<ClientEntity> findByDni(@Param("dni") String dni);

}
