package com.mobileiron.stream;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.mobileiron.model.Message;
import com.mobileiron.model.MessageStreamEnum;

/**
 * Stream Factory Implementations
 * @author MohsinIqbal
 *
 */
@Component
public class MessageStreamFactory {
	private static Map<MessageStreamEnum,IMessageStream> streamMap=new HashMap<>();
	//private static ApplicationContext context;
	
	/**
	 * method to register concrete implementations with the factory
	 * @param messageStreamEnum
	 * @param messageStream
	 */
	public static void registerStream(MessageStreamEnum messageStreamEnum, IMessageStream messageStream) {
		if(!streamMap.containsKey(messageStreamEnum))
			streamMap.put(messageStreamEnum, messageStream);
    }
	
	/**
	 * this method uses Reflection API to scan stream's impl and create respective bean. 
	 */
	private static final Object[] packages={"com.mobileiron.stream.impl"};
 	public static void registerStream(ApplicationContext context){
		Reflections reflections=new Reflections(packages);
		Set<Class<? extends IMessageStream>> classes = reflections.getSubTypesOf(IMessageStream.class);
		Iterator<Class<? extends IMessageStream>> it=classes.iterator();
		while(it.hasNext()){
			context.getBean(it.next());
		}
	}

 	/**
	 * returns Stream Instance implementation based on message model
	 * @param message
	 * @return
	 */
	public static IMessageStream getStream(Message message) {
		return streamMap.get(MessageStreamEnum.getEnumFrom(message));
	}
	
 	/**
	 * returns Stream Instance implementation based on MessageStreamEnum enum
	 * @param message
	 * @return
	 */
	public static IMessageStream getStream(MessageStreamEnum messageStreamEnum) {
		return streamMap.get(messageStreamEnum);
	}
	
}
