package com.thinktank.demo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinktank.demo.app.queue.DragBean;
import com.thinktank.demo.app.queue.QueueService;

@RestController
public class QueueController {
	
	@Autowired
	QueueService queueService;
	
	
	@GetMapping("/")
	public String sendMessage() {
		
		queueService.sendOrder(new DragBean(500, 250));
		return "send Message over AMQP";
	}

}
