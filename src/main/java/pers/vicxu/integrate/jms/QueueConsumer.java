package pers.vicxu.integrate.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

/**
 * Create by QueueConsumer on 7/12/2018
 */
public class QueueConsumer extends JmsQueue implements Consumer {

    @Override
    public void receiveMsg(String queueName) {
        initJms();
        MessageConsumer consumer = null;
        try {
            Destination queue = new ActiveMQQueue(queueName);
            consumer = session.createConsumer(queue);
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        TextMessage msg = (TextMessage) message;
                        //插入数据库操作
                        msg.acknowledge();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
