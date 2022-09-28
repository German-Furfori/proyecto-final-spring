package com.ayi.spring.rest.serv.app.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "addresses")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private Long idAddress;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "number")
    private Integer number;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "zip_code")
    private Integer zipCode;

    @Column(name = "city")
    private String city;

    @Column(name = "province")
    private String province;

    @Column(name = "country")
    private String country;

    /*@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "tbl_clientes_direcciones",
            joinColumns = @JoinColumn(name = "id_cliente"),
            inverseJoinColumns = @JoinColumn(name = "id_direccion"),
            uniqueConstraints = @UniqueConstraint(columnNames={"id_direccion"}))
    private List<ClientEntity> clientList;*/
}
