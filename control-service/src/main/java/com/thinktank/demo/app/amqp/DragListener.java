package com.thinktank.demo.app.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DragListener {

	
	 static final Logger logger = LoggerFactory.getLogger(DragListener.class);
	 
	    @RabbitListener(queues = EventProducerConfiguration.QUEUE_Control)
	    public void processOrder(Position order) {
	        logger.info("Order Received: "+order);
	    }
}
