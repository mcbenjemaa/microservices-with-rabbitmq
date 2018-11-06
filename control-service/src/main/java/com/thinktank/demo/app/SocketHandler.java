package com.thinktank.demo.app;

import java.io.Console;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.thinktank.demo.app.amqp.EventProducerConfiguration;
import com.thinktank.demo.app.amqp.Position;
import com.thinktank.demo.app.amqp.QueueControlService;

public class SocketHandler extends TextWebSocketHandler {

	@Autowired
	QueueControlService queueService;
	
	@Autowired	private RabbitTemplate rabbitTemplate;
 
	
	Logger logger = LoggerFactory.getLogger(SocketHandler.class);
	
	List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
	
	WebSocketSession session;

	
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws InterruptedException, IOException {
		

		  if (this.session!=null && this.session.isOpen()) {
			  //Map value = new Gson().fromJson(message.getPayload(), Map.class);
			   System.out.println("message: "+message.getPayload());
				Gson gson = new Gson();
				Position position = gson.fromJson(message.getPayload(), Position.class);
				   System.out.println("position: "+position);

				if(position !=null && queueService!=null) {
					queueService.sendOrder(position);
					session.sendMessage(new TextMessage("message received"));
				} else if(queueService == null) {
					System.out.println("queueService is Null!!");
					sendOrder(position);
//					queueService= new QueueControlService(rabbitTemplate);
//					queueService.sendOrder(position);
//					session.sendMessage(new TextMessage("message received"));
				}
			
		  }
//			Map value = new Gson().fromJson(message.getPayload(), Map.class);
//			webSocketSession.sendMessage(new TextMessage("Hello " + value.get("name") + " !"));
//			
			/*
			 *   send Message
			 */
		
		

	}
	
	public void sendOrder(Position order) {
	    	System.out.println("send Order --- "+ order);
	        this.rabbitTemplate.convertAndSend(EventProducerConfiguration.QUEUE_Control, order);
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//the messages will be broadcasted to all users.
		this.session=session;
		//sessions.add(session);
	}
}
