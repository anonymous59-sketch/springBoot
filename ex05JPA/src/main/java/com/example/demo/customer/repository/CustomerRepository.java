package com.example.demo.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	// @Repository 넣고 <클래스, 기본키 타입> 넣기
	
	//나이 범위에 포함되는 회원
    public List<Customer> findByAgeBetween(Integer min, Integer max);	
    
    // 이름 검색 기능
    public List<Customer> findByNameContaining(String name);
    
    //JPQL
    @Query(value = "SELECT c FROM Customer c WHERE c.name = ?1 AND age > :age")
    public List<Customer> findByName(String name, int age);
    
    @Query(value="SELECT c.name FROM Customer c")
    public List<String> getName();
    
    @Query(value="SELECT c.name, c.age FROM Customer c")
    public List<Object[]> getNameAge();
    
}
