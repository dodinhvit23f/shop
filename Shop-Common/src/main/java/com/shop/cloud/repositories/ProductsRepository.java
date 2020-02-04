package com.shop.cloud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.shop.cloud.entities.Product;

@Repository
public interface ProductsRepository extends JpaRepository<Product,Long>{
    
}
