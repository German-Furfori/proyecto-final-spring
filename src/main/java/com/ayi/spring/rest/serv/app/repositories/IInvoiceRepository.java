package com.ayi.spring.rest.serv.app.repositories;

import com.ayi.spring.rest.serv.app.entities.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
}
