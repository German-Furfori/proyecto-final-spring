package com.ayi.spring.rest.serv.app.entities;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "details")
public class DetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_details")
    private Long idDetails;

    @Column(name = "vip_client", nullable = false)
    private Boolean vipClient;

    @Column(name = "accumulated_points", nullable = false)
    private Long accumulatedPoints;
}
