package com.test.demo.productdata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_data")
public class ProductDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", unique = true)
    private int id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "qty")
    private int qty;

    @Column(name = "picture")
    private String picture;

    @Column(name = "invalid_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date expiredAt;

    @Column(name = "has_active")
    private int isActive;
}
