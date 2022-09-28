package com.ayi.spring.rest.serv.app.entities;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "invoices")
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_invoice")
    private Long idInvoice;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    // Client FK
}
