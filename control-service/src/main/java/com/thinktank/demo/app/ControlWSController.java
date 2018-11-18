package com.thinktank.demo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControlWSController {


	@Autowired
	private Source source;
	
	//@GetMapping('send')
	
	@GetMapping("/config")
	public Source getConfig() {
		
		
		return this.source;
	}
	
	
	
	
	@Component
	class Source {
		
		@Value("${spring.rabbitmq.host}")
		public String springrabbitmqhost;
		@Value("${spring.rabbitmq.port}")
		public String springrabbitmqport;
		
		}
}
