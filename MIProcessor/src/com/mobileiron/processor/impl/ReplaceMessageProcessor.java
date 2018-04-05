/**
 * 
 */
package com.mobileiron.processor.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.mobileiron.model.Message;
import com.mobileiron.model.MessageTypeEnum;
import com.mobileiron.processor.IMessageProcessor;
import com.mobileiron.processor.MessageProcessorFactory;

/**
 * @author MohsinIqbal
 *
 */
@Component
public class ReplaceMessageProcessor implements IMessageProcessor {

	@PostConstruct
	public void init() {
		MessageProcessorFactory.registerProcessor(MessageTypeEnum.REPLCE, this);
	}
	
	/* (non-Javadoc)
	 * @see com.mobileiron.processor.IMessageProcessor#handleMessage(com.mobileiron.model.Message)
	 */
	@Override
	public void handleMessage(Message message) {
		message.setResult(message.getType().concat("-").concat("THIS STRING"));
	}

}
