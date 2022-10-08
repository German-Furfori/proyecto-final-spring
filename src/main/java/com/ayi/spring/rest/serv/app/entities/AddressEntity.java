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

    @Column(name = "street_name", nullable = false, length = 50)
    private String streetName;

    @Column(name = "number", nullable = false, length = 5)
    private String number;

    @Column(name = "floor", length = 3)
    private String floor;

    @Column(name = "floor_number", length = 2)
    private String floorNumber;

    @Column(name = "zip_code", nullable = false, length = 6)
    private String zipCode;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "province", nullable = false, length = 50)
    private String province;

    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_fk", referencedColumnName = "id_client")
    private ClientEntity client;
}
