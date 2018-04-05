/**
 * 
 */
package com.mobileiron.stream;

import java.util.List;

import com.mobileiron.model.Message;
import com.mobileiron.processor.IMessageProcessor;
import com.mobileiron.processor.MessageProcessorFactory;
import com.mobileiron.utils.MessageUtils;

/**
 * @author MohsinIqbal
 *
 */
public abstract class AbstractMessageStream {

	/**
	 * handle input Stream
	 * @param strMessages
	 * @return
	 */
	protected abstract List<Message> handleInputStream(List<String> strMessages);
	
	/**
	 * handle output Stream
	 * @param messages
	 */
	protected abstract void handleOutputStream(List<Message> messages);
	
	/**
	 * parse String message into Message Model
	 * @param message
	 * @return
	 */
	protected Message parseMessage(String message) {
		return MessageUtils.parseMessage(message);
	}
	
	/**
	 * process the Message based on Message-Type
	 * @param message
	 */
	protected void processMessage(Message message) {
		IMessageProcessor messageProcessor=MessageProcessorFactory.getProcessor(message);
		messageProcessor.handleMessage(message);
	}
	
}
