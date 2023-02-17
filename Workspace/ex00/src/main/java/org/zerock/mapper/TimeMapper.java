package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	//mapper 파일이 mybatis에서 사용하는 파일이러는 것을 정의해주어야한다.
	
	
	//추상 메소드에 대한 정의만.
	//간단한 건 이렇게 적어도 되지만. 복잡하면 힘듦 mapper파일을 쓸꺼임
	@Select("select sysdate from dual")
	public String getTime();
	
	public String getTime2();
	//getTime2에 있는 추상메소드를 구현하는 것
}
