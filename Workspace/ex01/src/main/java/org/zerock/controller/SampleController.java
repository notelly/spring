package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;


@Controller
@RequestMapping("/sample/*")
public class SampleController {
	//FrontController -> Main.do, Login.do
	
	@RequestMapping(value="/basic", //
			method = {RequestMethod.GET, RequestMethod.POST })
	public void basicGet() {
			System.out.println("basicGet");
	}
	
	@RequestMapping(value="/basicGet", //
			method = {RequestMethod.GET})
	public String basicGet2 () {
		System.out.println("basicGet2");
		return "basicGet2";
	}
	
	@GetMapping("/basic3") //get방식일떄만 처리하겠다(url로 요청)
	public void basic3() {	
		System.out.println("basic3 get요청");
	}
	
	@PostMapping("/basic3") //from으로 요청 (url로 요청할 수 없다.)
	public String basic4() {//(똑같은) basic.jsp파일을 불러온다.	
		System.out.println("basic3 post요청");
		return "basic4";
	}
	
	@GetMapping("/ex01")
	public String ex01(String p1) { //ex01?p1=test >> 콘솔에 test 출력
		
		//예전에 썼던 request.setta~?그거 쓸필요 없다.
		
		System.out.println(p1);
		return "ex01";
	}
	
	@GetMapping("/ex1")
	public String ex1(SampleDTO dto) {  //매개값으로 어떤 유형이던지 다 받을 수 있다.
		System.out.println("name: "+ dto.getName());
		System.out.println("age: "+ dto.getAge());
		return "ex1";
	}
	
	//안됨
	@GetMapping("/ex02")
	public void ex02(@RequestParam("n") String name,
			@RequestParam("a") int age) {
		System.out.println("name: "+ name);
		System.out.println("age: "+ age);
	}
	
	
	@GetMapping("/ex02List")
	public void ex02List(@RequestParam("ids") ArrayList<String> ids) {
		System.out.println("ids: " + ids);
	}
	
	
	@GetMapping("/ex02Bean")
	public void ex02Bean(SampleDTOList list) {
		System.out.println("list => " +list);
	}
	
	
	@RequestMapping("/aaa")
	public void basic() {	
		System.out.println("basic 요청.");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormate, false));
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		System.out.println("todo: "+ todo);
		return "ex03";
	}
}
