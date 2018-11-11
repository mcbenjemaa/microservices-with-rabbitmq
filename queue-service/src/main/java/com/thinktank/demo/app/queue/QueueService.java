package com.thinktank.demo.app.queue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class QueueService {

	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	
    
 
    public void sendOrder(Position order) {
        this.amqpTemplate.convertAndSend(EventProducerConfiguration.QUEUE_Control, new Gson().toJson(order));
    }
}
