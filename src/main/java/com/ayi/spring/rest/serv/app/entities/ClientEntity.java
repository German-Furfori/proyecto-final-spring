package com.ayi.spring.rest.serv.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "clients")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long idClient;

    @Column(name = "dni", nullable = false, length = 8)
    private String dni;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "is_active", nullable = false, columnDefinition = "boolean default true")
    private Boolean isActive;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_fk", referencedColumnName = "id_details")
    private DetailsEntity clientDetails;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<InvoiceEntity> invoiceList;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<AddressEntity> addressList;
}
