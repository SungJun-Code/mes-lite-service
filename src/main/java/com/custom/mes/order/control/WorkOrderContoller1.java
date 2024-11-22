package com.custom.mes.order.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
@RequestMapping("/api")
public class WorkOrderContoller1 {
	
	@GetMapping("/hello")
	public String test() {
		System.out.println("WorkOrderContoller 실행");
		return "index";
	}

}
