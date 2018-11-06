package com.thinktank.demo.app.queue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinktank.demo.app.Position;
@Service
public class QueueWService {

	private final RabbitTemplate rabbitTemplate;
	 
    @Autowired
    public QueueWService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
 
    public void sendOrder(Position order) {
        this.rabbitTemplate.convertAndSend(EventProducerConfiguration.QUEUE_Control, order);
    }
}
