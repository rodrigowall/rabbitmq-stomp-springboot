package br.com.parede.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class IndexController {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@GetMapping("/{name}")
	public String home(@PathVariable("name") String name, Model model) {
		model.addAttribute("name",name);
		return "index";
	}

	@GetMapping("/teste/{name}/{message}")
	public String teste(@PathVariable("name") String name, @PathVariable("message") String message) {
		rabbitTemplate.convertAndSend("amq.topic","test-"+name, message);
		return "ok";
	}
}
