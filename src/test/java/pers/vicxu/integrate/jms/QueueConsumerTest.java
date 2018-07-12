package pers.vicxu.integrate.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;

import javax.jms.*;

/**
 * Create by QueueConsumerTest on 7/12/2018
 */
public class QueueConsumerTest {

    public static void main1(String[] args) throws JMSException, InterruptedException {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Destination queue = new ActiveMQQueue("vic.queue");
        Connection con = factory.createConnection();
        con.start();
        Session session = con.createSession(true, Session.CLIENT_ACKNOWLEDGE); //AUTO_ACKNOWLEDGE 自动应答  CLIENT_ACKNOWLEDGE 手动应答
        MessageConsumer consumer = session.createConsumer(queue);
//        接收会阻塞线程，所以要在子线程消费
        consumer.setMessageListener(new MessageListener() { //异步接收消息，子线程执行接收
            @Override
            public void onMessage(Message message) {
                try {
                    TextMessage msg = (TextMessage) message;
                    System.out.println("消费:" + msg.getText());
                    msg.acknowledge();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("main is here......");
        Thread.sleep(20000);
//        consumer.close();
//        con.close();
    }

    public static void main(String[] args) throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Destination queue = new ActiveMQQueue("vic.queue");
        Connection con = factory.createConnection();
        con.start();
        Session session = con.createSession(true, Session.CLIENT_ACKNOWLEDGE); //AUTO_ACKNOWLEDGE 自动应答  CLIENT_ACKNOWLEDGE 手动应答
        MessageConsumer consumer = session.createConsumer(queue);
        TextMessage msg = (TextMessage) consumer.receive();
        System.out.println("消费:" + msg.getText());
        int m = 10 / 0;
        TextMessage msg1 = (TextMessage) consumer.receive();
        System.out.println("消费:" + msg1.getText());
        session.commit();
        consumer.close();
        con.close();
    }
}
