package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerRepositoryTest {
	@Autowired 
	CustomerRepository customerRepository;
	
//	@Test
//	@Rollback
//	@Transactional()
	public void insert() {
		// given
		Customer customer = new Customer();
		customer.setName("홍길동");
		customer.setPhone("011-0000-1111");
		
		// when
		Customer result = customerRepository.save(customer);
		
		// then // 테스트는 결과가 boolean으로 나와야함.
		Customer cust = customerRepository.findById(result.getId()).get();
		assertEquals(cust.getName(), "홍길동");
	}
	
//	@Test
	public void update() {
		//given
		Customer cust = customerRepository.findById(102L).get();

		//when
		cust.setName("김유신");
		customerRepository.save(cust);
		
		//then
		assertEquals(customerRepository.findById(102L).get().getName(), "김유신");
	}
	
	@Test
	public void delete() {
		//given
		Customer cust = customerRepository.findById(102L).get();
		
		//when
		customerRepository.delete(cust);
		
		//then
//		assertTrue(customerRepository.findById(102L).isPresent());
	}
}
