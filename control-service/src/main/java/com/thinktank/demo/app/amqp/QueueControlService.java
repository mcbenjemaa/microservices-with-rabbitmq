package com.thinktank.demo.app.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class QueueControlService {

	
	private final RabbitTemplate rabbitTemplate;
	 
	@Autowired
    public QueueControlService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
 
    public void sendOrder(Position order) {
    	System.out.println("send Order --- "+ order);
        this.rabbitTemplate.convertAndSend(EventProducerConfiguration.QUEUE_Control, order);
    }
}
