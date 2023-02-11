package ru.project.messaging;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.jms.*;

@Stateless
@LocalBean
public class Producer {

    @Resource(name = "java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(name = "java:/jms/queue/DLQ")
    private Destination destination;

//    @Schedule(hour = "*", minute = "*", second = "*/5", persistent = false)
    public void produceMessage() throws JMSException {
        try (Connection connection = connectionFactory.createConnection()) {
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination);
            System.out.println("----------------------------------**** Create Message ---------------------");
            TextMessage textMessage = session.createTextMessage("---------------**Hellow JMS!***--------------");
            producer.send(textMessage);
            System.out.println("--------------------------------------**** Send Message ---------------------");
            session.close();
        }
    }
}
