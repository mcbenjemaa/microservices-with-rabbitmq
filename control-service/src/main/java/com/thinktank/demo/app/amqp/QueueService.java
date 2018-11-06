package com.thinktank.demo.app.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueService {

	@Autowired
	private final RabbitTemplate rabbitTemplate;
	 
    
    public QueueService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
 
    public void sendOrder(Position order) {
    	System.out.println("send Order --- "+ order);
        this.rabbitTemplate.convertAndSend(EventProducerConfiguration.QUEUE_Control, order);
    }
}
