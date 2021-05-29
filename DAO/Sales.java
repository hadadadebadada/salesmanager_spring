package com.springboot.SalesManager.DAO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Sales {  /// REST CLASS
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SALES_SEQUENCE")
	@SequenceGenerator(name = "SALES_GENERATOR", sequenceName = "SALES_SEQUENCE", allocationSize = 1)
	private Long id;
	private String item;
	private int quantity;
	private float amount;
	
	
	public Sales() {

	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Sales [id=" + id + ", item=" + item + ", quantity=" + quantity + ", amount=" + amount + "]";
	}
	public Sales(int id, String item, int quantity, float amount) {
		this.item = item;
		this.quantity = quantity;
		this.amount = amount;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}

}
