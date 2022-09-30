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

    @Column(name = "street_name", nullable = false)
    private String streetName;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "floor_number")
    private Integer floorNumber;

    @Column(name = "zip_code", nullable = false)
    private Integer zipCode;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "province", nullable = false)
    private String province;

    @Column(name = "country", nullable = false)
    private String country;

    @ManyToMany(mappedBy = "addressList")
    private List<ClientEntity> clientList;
}
