/**
 * 
 */
package com.mobileiron.main;

import java.util.logging.Logger;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mobileiron.model.MessageStreamEnum;
import com.mobileiron.stream.IMessageStream;
import com.mobileiron.stream.MessageStreamFactory;

/**
 * Starting Main Class
 * Can be different for different Stream types.
 * @author MohsinIqbal
 *
 */
public class MIProcessorMain {
	static Logger logger1 = Logger.getLogger(AnnotationConfigApplicationContext.class.getName());
	static Logger logger2 =Logger.getLogger(DefaultListableBeanFactory.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		logger1.setUseParentHandlers(false);
		logger2.setUseParentHandlers(false);
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		//String message="UPPRCS-0005-abcdeUPPRCS-0001-aREPLCE-0005-abcdeUPPRCS-0010-1234567891TAG001-0005-abcdeREPLCE-0010-1234567891";
		IMessageStream messageStream=MessageStreamFactory.getStream(MessageStreamEnum.STANDARD);
		messageStream.handleMessage(args[0]);

	}

}
