package com.codewithmosh.store.repositories;

import com.codewithmosh.store.entities.Product;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.category.id = :categoryId")
    List<Product> findAllByCategoryId(@PathParam("categoryId") Long categoryId);

    @EntityGraph(attributePaths = "category")
    @Query("select p from Product p")
    List<Product> findAllWithCategory();
}