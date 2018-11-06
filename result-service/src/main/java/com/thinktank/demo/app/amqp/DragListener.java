package com.thinktank.demo.app.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;

import com.google.gson.Gson;
import com.thinktank.demo.app.SocketHandler;

@Component
public class DragListener {

	
	 static final Logger logger = LoggerFactory.getLogger(DragListener.class);
	 
	    @RabbitListener(queues = EventProducerConfiguration.QUEUE_Control)
	    public void processOrder(Position order) throws Exception {
	        logger.info("Order Received: "+order);
	        if (SocketHandler.session != null ) {
	        	SocketHandler.session.sendMessage(new TextMessage(new Gson().toJson(order)));
	        } else
	        {
	        	logger.debug("session null.."); 
	        }
	    }
}
