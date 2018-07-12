package pers.vicxu.integrate.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import pers.vicxu.integrate.util.JmsUtil;

import javax.jms.*;

/**
 * Create by QueueProducer on 7/12/2018
 */
public class QueueProducer extends JmsQueue implements Producer {
    @Override
    public void producer(String str, String queueName) {
        initJms();
        MessageProducer producer = null;
        try {
            Destination queue = new ActiveMQQueue(queueName);
            producer = session.createProducer(queue);
            TextMessage msg = session.createTextMessage(str);
            producer.send(msg);
            msg.acknowledge();
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                producer.close();
                con.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
