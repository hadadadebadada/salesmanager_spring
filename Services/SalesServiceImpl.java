package com.springboot.SalesManager.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.SalesManager.DAO.Sales;
import com.springboot.SalesManager.repositories.SalesRepository;


@Service
public class SalesServiceImpl implements ISalesService{
	
	private final SalesRepository salesRepository;

	public SalesServiceImpl(SalesRepository salesRepository) {
		this.salesRepository = salesRepository;
	}
	
	
    @Override
    public Sales findSalesById(Long id) {
        return salesRepository.findById(id).get();
    }

    
	@Override
    public List<Sales> findAllSaless() {
        return salesRepository.findAll();
    }

    
	@Override
    public Sales saveSales(Sales sales) {
        return salesRepository.save(sales);
    }
	
	
	
	
	@Override
	public ResponseEntity<Sales> updateSales( Long id, Sales salesDetails){
		
		Sales sales = salesRepository.findById(id).get();
    	
    	sales.setItem(salesDetails.getItem());
    	sales.setQuantity(salesDetails.getQuantity());
    	sales.setAmount(salesDetails.getAmount());
    	
    	Sales updatedSales = salesRepository.save(sales);
    	return ResponseEntity.ok(updatedSales);
		
	}
	
	
	
	@Override
	public ResponseEntity<Map<String, Boolean>> deleteSalesPosition(Long id){
		Sales sales = salesRepository.findById(id).get();
		
		salesRepository.delete(sales);
		Map<String, Boolean> resp = new HashMap<>();
		resp.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(resp);
		
	}
	
	
//	@Override
//	public Sales deleteSales(Long id) {
//		return salesRepository.deleteById(id);
//	}
	

	
	
}
