package com.example.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.customer.repository.Address;
import com.example.demo.customer.repository.AddressRepository;
import com.example.demo.customer.repository.Customer;
import com.example.demo.customer.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class CustomerRepositoryTest {
	
	@Autowired 
	CustomerRepository customerRepository;
	@Autowired
	AddressRepository addressRepository;
	
	@BeforeEach
	public void init() {
		customerRepository.deleteAll();
		customerRepository.save(Customer.builder().name("홍길동").phone("010").age(15).build());
		customerRepository.save(Customer.builder().name("김길동").phone("011").age(25).build());
		customerRepository.save(Customer.builder().name("박길동").phone("012").age(35).build());
		customerRepository.save(Customer.builder().name("최길동").phone("013").age(45).build());
	}
	
	
	@Test
	public void onetoOneAddressOwnerTest() {
		Customer customerE = Customer.builder().name("테스트이름").phone("0555").build();
		customerRepository.save(customerE);
		
		Address addressE = Address.builder()
				                 .zipcode("04411")
				                 .address("대구")
				                 .customer(customerE)
				                 .build();
		
		addressRepository.save(addressE);
		
		Address result = addressRepository.findById(1L).get();
		log.info(result.getZipcode() + ":" + result.getCustomer().getName());
		
		assertEquals("테스트이름", result.getCustomer().getName());
		
	}
	
	
//	@Rollback
//	@Transactional
//	@Test
	public void ageBetween() {
		// given
		
		// when
		List<Customer> list = customerRepository.findByAgeBetween(20, 40);
		List<Customer> list2 = customerRepository.findByNameContaining("최길동");
		
		// then
		assertEquals(list.size(), 2);
		assertEquals(list2.size(), 1);
	}
	
//	@Test
	public void findName() {
		List<Customer> list = customerRepository.findByName("최길동", 40);
		
		assertEquals(list.size(), 1);
	}
	
//	@Test
//	@Rollback
//	@Transactional()
	public void insert() {
		// given
		Customer customer = Customer.builder().name("홍길동").phone("010").build();
		
		// when
		Customer result = customerRepository.save(customer);
		
		// then // 테스트는 결과가 boolean으로 나와야함.
		Customer cust = customerRepository.findById(result.getId()).get();
		assertEquals(cust.getName(), "홍길동");
	}
	
//	@Test
	public void update() {
		//given
		Customer cust = Customer.builder().id(1L).name("김기자").build();

		//when
		
		customerRepository.save(cust);
		
		//then
		assertEquals(customerRepository.findById(102L).get().getName(), "김유신");
	}
	
//	@Test
	public void delete() {
		//given
		Customer cust = customerRepository.findById(102L).get();
		
		//when
		customerRepository.delete(cust);
		
		//then
//		assertTrue(customerRepository.findById(102L).isPresent());
	}
	
//	@Test
	public void getName() {
		List<String> list = customerRepository.getName();
		System.out.println(list);
	}
	
//	@Test
	public void getNameAge() {
		List<Object[]> list = customerRepository.getNameAge();
		list.stream()
		    .forEach(e -> System.out.println(e[0] + ": " + e[1] + "살"));
	}
	
	
}
