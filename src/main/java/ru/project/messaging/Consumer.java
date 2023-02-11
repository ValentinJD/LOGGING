package ru.project.messaging;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "Consumer",
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/DLQ")
        }
)
public class Consumer implements MessageListener {
        @Override
        public void onMessage(Message message) {
                TextMessage message1 = (TextMessage) message;

                try {
                        System.out.println("**** ------------------Given Message ---------------------");
                        System.out.println("------------------*************************---------------");
                        System.out.println("-----------" + message1.getText() + this.getClass() + "--------------------");
                        System.out.println("------------------*************************---------------");
                } catch (JMSException e) {
                        e.printStackTrace();
                }
        }
}
