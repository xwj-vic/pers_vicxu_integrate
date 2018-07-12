package pers.vicxu.integrate.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;

import javax.jms.*;

/**
 * Create by QueueProducerTest on 7/12/2018
 */
public class QueueProducerTest {

//    @Test
//    public void queueProducerTest() throws JMSException {
//        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
//        Destination queue = new ActiveMQQueue("vic.queue");
//        Connection con = factory.createConnection();
//        con.start();
//        Session session = con.createSession(true, Session.CLIENT_ACKNOWLEDGE); //AUTO_ACKNOWLEDGE 自动应答  CLIENT_ACKNOWLEDGE 手动应答
//        MessageProducer producer = session.createProducer(queue);
//        TextMessage msg = session.createTextMessage("I am Vic Xu");
//        producer.send(msg);
//        msg.acknowledge();
//        producer.close();
//        con.close();
//    }

    public static void main(String[] args) throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Destination queue = new ActiveMQQueue("vic.queue");
        Connection con = factory.createConnection();
        con.start();
        Session session = con.createSession(false, Session.CLIENT_ACKNOWLEDGE); //AUTO_ACKNOWLEDGE 自动应答  CLIENT_ACKNOWLEDGE 手动应答
        MessageProducer producer = session.createProducer(queue);
        TextMessage msg = session.createTextMessage("I am Vic Xu");
        producer.send(msg);
        msg.acknowledge();
//        session.commit();
        producer.close();
        con.close();
    }


}
