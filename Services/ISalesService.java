package com.springboot.SalesManager.Services;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.SalesManager.DAO.Sales;

public interface ISalesService {

	Sales findSalesById(Long id);

	List<Sales> findAllSaless();

	Sales saveSales(Sales sales);

	ResponseEntity<Sales> updateSales(Long id, Sales salesDetails);

	ResponseEntity<Map<String, Boolean>> deleteSalesPosition(Long id);


		
	

}
