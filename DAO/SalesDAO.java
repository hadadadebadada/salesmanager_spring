package com.springboot.SalesManager.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


@Repository
public class SalesDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public SalesDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Sales> list(){
		String sql = "SELECT * FROM SALES";
		List<Sales> salesList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Sales.class));
		return salesList;
	}
	
	public void save(Sales sales) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("sales").usingColumns("item","quantity","amount");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sales); // sales aus übergebenem parameter ausgelesen
		insertActor.execute(param);
	}
	@SuppressWarnings("deprecation")
	public Sales get(int id) {
		   String sql = "SELECT * FROM SALES WHERE id = ?";
		    Object[] args = {id};
		  Sales sales =  jdbcTemplate.queryForObject(sql, args,BeanPropertyRowMapper.newInstance(Sales.class));
		   // Sales sales = new Sales();
		    return sales;
	}
	
	public void update(Sales sales) {
	    String sql = "UPDATE SALES SET item=:item, quantity=:quantity, amount=:amount WHERE id=:id";
	    BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sales);
	 
	    NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
	    template.update(sql, param);       
	}
	
	public void delete(int id) {
	    String sql = "DELETE FROM SALES WHERE id = ?";
	    jdbcTemplate.update(sql, id);
	}
	
	

}
