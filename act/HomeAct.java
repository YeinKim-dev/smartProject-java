package com.smart.project.web.home.act;

import com.smart.project.web.home.biz.HomeServices;
import com.smart.project.web.home.vo.SchVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class HomeAct {

	@Autowired
	HomeServices homeServices;

	@RequestMapping("/hi")
	public String home(Model model){
		homeServices.test(10);
		model.addAttribute("user", "나야나");
		return "index";
	}

	@GetMapping ("/hi")
	public String test(Model model){
		return "/HTML/test";
	}

	@GetMapping ("/testload")
	public String testload(Model model){
		return "/HTML/testload";
	}


}
