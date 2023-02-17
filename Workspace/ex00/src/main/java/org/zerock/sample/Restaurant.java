package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;



@Component
@Data
public class Restaurant {
	
	//파일창에서 앞에 아이콘에 s가 붙어있는 파일은 다 spring에서 관리하는 객체라는 뜻.
	
	public Restaurant() { // Restaurant()는 chef에 의존적인 객체
		System.out.println("Restaurant()");
	}
	
	@Setter(onMethod_ = @Autowired)
	//@Autowired chef라는 인스턴스를 주입해달라는 어노테이션
	private Chef chef; //chef의 인스턴스를 주입시켜달라
	//chef라는 인스턴스를 만들어서 어느시점(restaurant가 쓰이는 시점)에 사용
	
	/*@setter 대신에 기존에는 set을 직접 만들어주어야했다.
	 * public void setChef(Chef chef)
	 * */
	
	/* 기존 instance만드는 작업
	 * public void stest() {
	 * 	chef = new Chef();
	 * 라고 선언해 주어야했다. 하지만 spring에서는 피요 없음
	 * }
	 */
}
