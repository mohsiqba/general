package com.mobileiron.processor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.mobileiron.model.Message;
import com.mobileiron.model.MessageTypeEnum;

@Component
public class MessageProcessorFactory {
	private static Map<MessageTypeEnum,IMessageProcessor> processorMap=new HashMap<>();
	//private static ApplicationContext context;
	
	/**
	 * method to register concrete implementations with the factory
	 * @param messageTypeEnum
	 * @param messageProcessor
	 */
	public static void registerProcessor(MessageTypeEnum messageTypeEnum, IMessageProcessor messageProcessor) {
		if(!processorMap.containsKey(messageTypeEnum))
			processorMap.put(messageTypeEnum, messageProcessor);
    }
	
	/**
	 * this method uses Reflection API to scan processor's impl and create respective bean. 
	 */
	private static final Object[] packages={"com.mobileiron.processor.impl"};
 	public static void registerProcessor(ApplicationContext context){
		Reflections reflections=new Reflections(packages);
		Set<Class<? extends IMessageProcessor>> classes = reflections.getSubTypesOf(IMessageProcessor.class);
		Iterator<Class<? extends IMessageProcessor>> it=classes.iterator();
		while(it.hasNext()){
			context.getBean(it.next());
		}
	}

 	/**
	 * returns Processor Instance implementation based on message model
	 * @param message
	 * @return
	 */
	public static IMessageProcessor getProcessor(Message message) {
		return processorMap.get(MessageTypeEnum.getEnumFrom(message));
	}
	
}
