package com.springboot.SalesManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.SalesManager.DAO.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long>{

}
