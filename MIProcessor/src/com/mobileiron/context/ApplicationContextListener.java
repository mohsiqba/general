package com.mobileiron.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mobileiron.processor.MessageProcessorFactory;
import com.mobileiron.stream.MessageStreamFactory;

/**
 * Class for Context Listener which activates our Framework
 * @author MohsinIqbal
 *
 */
@Component
public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        MessageProcessorFactory.registerProcessor(context);
        MessageStreamFactory.registerStream(context);
       
    }
}
