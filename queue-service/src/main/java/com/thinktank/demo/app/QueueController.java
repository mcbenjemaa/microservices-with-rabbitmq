package com.thinktank.demo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.thinktank.demo.app.queue.Position;
import com.thinktank.demo.app.queue.QueueService;
import com.thinktank.demo.app.queue.QueueWService;

@RestController
public class QueueController {
	
	@Autowired
	QueueService queueService;
	
	
	
	@GetMapping("/")
	public String sendMessage() {
		
		queueService.sendOrder(new Position("500px", "250px"));
		return "send Message over AMQP";
	}
	
	@PostMapping("receive")
	public String receive(Position position) {
		queueService.sendOrder(position);
		
		return "Recevied and dilvred.";
	}

}
