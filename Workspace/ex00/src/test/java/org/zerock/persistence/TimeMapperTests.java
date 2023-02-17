package org.zerock.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class TimeMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		log.info("타임맵퍼1...." + timeMapper.getTime());
		
		//mapper를 사용함
		log.info("타임맵퍼2...." + timeMapper.getTime2());
		
		//사용하는 방식은 다르지만 1과 2 로그 결과는 동일하다.
		// log4j2 jdbc >> 로그 방식을 바꾸는 것 쿼리나 상세 정보를 확인할 수 잇다.
	}
}
