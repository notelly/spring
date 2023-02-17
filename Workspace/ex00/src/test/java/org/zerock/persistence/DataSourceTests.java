package org.zerock.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
public class DataSourceTests {
	
	//필요한 데이터소스를 주입시켜 달라고
	@Setter(onMethod_ = @Autowired)
	private DataSource dataSource;
	
	@Setter(onMethod_ = @Autowired)
	private SqlSessionFactory sqlSessionFactory;
	
	//@Test
	public void testConn() {
		try {
			Connection conn = dataSource.getConnection();
			log.info("DataSource: " + conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void mybatisTest() {
		SqlSession session =sqlSessionFactory.openSession();
		//SqlSessionFactory sqlSessionFactory 에 있는 openSession
		Connection conn = session.getConnection();
		
		log.info("session........: " +session);
		log.info("connection.......: " + conn);
	}
	
	
}
