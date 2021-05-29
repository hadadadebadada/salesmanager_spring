package com.springboot.SalesManager.Controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.SalesManager.DAO.Sales;
import com.springboot.SalesManager.DAO.SalesDAO;
import com.springboot.SalesManager.Services.ISalesService;



@RestController
@RequestMapping(RestAppController.BASE_URL)
@CrossOrigin(origins = "*")
public class RestAppController {
	
	private final ISalesService salesService;
	public static final String BASE_URL ="/api/v1/sales";
	
	public RestAppController(ISalesService salesService) {
		this.salesService = salesService;
	}

	
	//-------------------------------------------------------------------------------------


    @GetMapping
    List<Sales> getAllSales(){
        return salesService.findAllSaless();
    }

    @GetMapping("/{id}")
    public Sales getSalesById(@PathVariable Long id){
        return salesService.findSalesById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sales saveSale(@RequestBody Sales sales){
        return salesService.saveSales(sales);
    }
    
    //update sales
    
    //@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "application/json")
    //@ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
	public ResponseEntity<Sales> updateSales(@PathVariable Long id, @RequestBody Sales salesDetails){
		
    return salesService.updateSales(id, salesDetails);

		
	}
    
    @DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSalesPosition(@PathVariable Long id){
		return salesService.deleteSalesPosition(id);
		
	}
    
    
    
    

	
}
