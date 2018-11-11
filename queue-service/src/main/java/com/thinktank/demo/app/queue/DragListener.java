package com.thinktank.demo.app.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class DragListener {

	
	 static final Logger logger = LoggerFactory.getLogger(DragListener.class);
	 
	    @RabbitListener(queues = EventProducerConfiguration.QUEUE_Control)
	    public void processOrder(String order) {
	        logger.info("Order Received: "+order);
	    }
}
