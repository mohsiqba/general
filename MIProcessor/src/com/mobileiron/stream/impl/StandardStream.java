/**
 * 
 */
package com.mobileiron.stream.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.mobileiron.model.Message;
import com.mobileiron.model.MessageStreamEnum;
import com.mobileiron.stream.AbstractMessageStream;
import com.mobileiron.stream.IMessageStream;
import com.mobileiron.stream.MessageStreamFactory;
import com.mobileiron.utils.MessageUtils;

/**
 * Receives input from STDIN and output on STDOUT.
 * @author MohsinIqbal
 *
 */
@Component
public class StandardStream extends AbstractMessageStream implements IMessageStream {

	@PostConstruct
	public void init() {
		MessageStreamFactory.registerStream(MessageStreamEnum.STANDARD, this);
	}
	
	@Override
	protected List<Message> handleInputStream(List<String> strMessages) {
		List<Message> messages=new ArrayList<>();;
		for(String strMsg: strMessages) {
			try {
				Message message=parseMessage(strMsg);
				processMessage(message);
				messages.add(message);
			} catch (Exception e) {
				System.out.println("Exception: "+e);
			}
		}
		return messages;
	}
	
	@Override
	protected void handleOutputStream(List<Message> messages) {
		for(Message message:messages)
			System.out.println(message.getResult());
	}

	@Override
	public void handleMessage(String message) {
		List<String> strMessages=MessageUtils.convertStream(message);
		List<Message> messages=handleInputStream(strMessages);
		handleOutputStream(messages);
	}

}
