package com.thinktank.demo.app.queue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.amqp.core.Queue;

@Configuration
public class EventProducerConfiguration {
	
	 public static final String QUEUE_Control = "control-queue";
	 public static final String QueueExchange = "EXCHANGE_Queue";
	 
	    @Bean
	    Queue ordersQueue() {
	        return QueueBuilder.durable(QUEUE_Control).build();
	    }
	 
//	    @Bean
//	    Queue deadLetterQueue() {
//	        return QueueBuilder.durable(QUEUE_DEAD_ORDERS).build();
//	    }
//	 
	    @Bean
	    org.springframework.amqp.core.Exchange ordersExchange() {
	        return ExchangeBuilder.topicExchange(QueueExchange).build();
	    }
	 
	    @Bean
	    Binding binding(Queue ordersQueue, TopicExchange ordersExchange) {
	        return BindingBuilder.bind(ordersQueue).to(ordersExchange).with(QUEUE_Control);
	    }
	    


}
