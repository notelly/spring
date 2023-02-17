package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {

	@Setter(onMethod_ = @Autowired) //setter 주입 (권장)
	//@Autowired 					//생성자 주입.
	private Restaurant restaurant;
	
	@Test
	public void testExists() {
		assertNotNull(restaurant); //()값이 null이 아닐때 하위 코드를 실행하겠다.
		log.info(restaurant);
		log.info("------------");
		log.info(restaurant.getChef());
	}
}
