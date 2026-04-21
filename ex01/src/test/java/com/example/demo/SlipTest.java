package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.slip.mapper.SlipMapper;
import com.example.demo.slip.service.SlipVO;

@SpringBootTest
public class SlipTest {

	@Autowired
	SlipMapper slipMapper;
	
	@Test
	public void selectAll() {
		SlipVO slip = new SlipVO();
		slip.setSlipNo(10L);
		List<SlipVO> list = slipMapper.selectAll(slip);
		for(SlipVO el : list) {
			System.out.println(el.getSlipNo());
		}
	}
}
