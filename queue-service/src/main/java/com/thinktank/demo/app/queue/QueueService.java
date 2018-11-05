package com.thinktank.demo.app.queue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class QueueService {

	
	private final RabbitTemplate rabbitTemplate;
	 
    @Autowired
    public QueueService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
 
    public void sendOrder(DragBean order) {
        this.rabbitTemplate.convertAndSend(EventProducerConfiguration.QUEUE_Control, order);
    }
}
