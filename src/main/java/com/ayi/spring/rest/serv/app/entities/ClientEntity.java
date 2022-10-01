package com.ayi.spring.rest.serv.app.entities;

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
    private Integer dni;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_fk", referencedColumnName = "id_details")
    private DetailsEntity clientDetails;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL) // Lo mapea el atributo client de la clase InvoiceEntity
    private List<InvoiceEntity> invoiceList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tbl_client_address",
            joinColumns = @JoinColumn(name="client_fk"),
            inverseJoinColumns = @JoinColumn(name = "address_fk"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"client_fk", "address_fk"})
    )
    private List<AddressEntity> addressList;
}
