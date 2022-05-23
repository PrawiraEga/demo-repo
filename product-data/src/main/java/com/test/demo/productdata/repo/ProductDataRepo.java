package com.test.demo.productdata.repo;

import com.test.demo.productdata.entity.ProductDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDataRepo extends JpaRepository<ProductDataEntity, Integer> {

    @Query(value = "SELECT p from ProductDataEntity p " +
    "WHERE p.isActive = :i ")
    List<ProductDataEntity> findAllByActive(@Param("i") int i);

    @Query(value = "SELECT p from ProductDataEntity p " +
            "WHERE p.id = :id AND p.isActive = 1 ")
    ProductDataEntity findByIdActive(int id);
}
