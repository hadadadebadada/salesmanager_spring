package com.springboot.SalesManager.BootstrapData;

import org.springframework.boot.CommandLineRunner;

import com.springboot.SalesManager.DAO.Sales;
import com.springboot.SalesManager.repositories.SalesRepository;

public class BootstrapData implements CommandLineRunner{
	
	private final SalesRepository salesRepository;

	public BootstrapData(SalesRepository salesRepository) {
		this.salesRepository = salesRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Sales s1 = new Sales();
		s1.setAmount(312);
		s1.setItem("asdasd");
		s1.setQuantity(123);
		
		salesRepository.save(s1);
        System.out.println("count:"+ salesRepository.count());

		
	}
	
	

}
