package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.customer.repository.Customer;
import com.example.demo.member.repository.Member;
import com.example.demo.member.repository.Team;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EntityManagerTest {
	
	@Autowired EntityManager em;
	
	@Transactional
//	@Test
	public void insert() {
		em.persist(Customer.builder().name("테스트").phone("0000").build());
	}
	
    @Rollback
    @Transactional
    @Test
    void 회원_팀_저장_조회() {
	    Team team = Team.builder().name("개발팀").build();
	    em.persist(team);

	    Member member = Member.builder().name("홍길동").team(team).build();
	    em.persist(member);

	    //조회
	    Member found = em.find(Member.class, member.getId());
	    System.out.println("회원 이름: " + found.getName());
	    System.out.println("팀 이름: " + found.getTeam().getName());
	    
	    log.info("회원 이름: " + found.getName());
	    log.info("팀 이름: " + found.getTeam().getName());
	    
    }
}
