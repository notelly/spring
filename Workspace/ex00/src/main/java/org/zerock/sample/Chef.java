package org.zerock.sample;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component  //Spring에서 객체로 만들어서 관리하는 대상임을 명시.
@Data		//get set(lombok) 
public class Chef {
	public Chef() {
		System.out.println("Chef()");
	}

}
