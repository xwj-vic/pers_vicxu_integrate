package pers.vicxu.integrate.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

/**
 * Create by JmsQueue on 7/12/2018
 */
abstract class BaseJmsQueue {

    Connection con;

    Session session;

    void initJms() {
        try {
            ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            con = factory.createConnection();
            con.start();
            session = con.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
