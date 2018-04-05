package com.mobileiron.processor;

import com.mobileiron.model.Message;
/**
 * Message Processor Interface
 * @author MohsinIqbal
 *
 */
public interface IMessageProcessor {

	void handleMessage(Message message);
}
