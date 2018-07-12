package pers.vicxu.integrate.util;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

/**
 * Create by JmsUtil on 7/12/2018
 */
public class JmsUtil {

    public static Connection getConnectionJms(String queueName) throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Destination queue = new ActiveMQQueue(queueName);
        Connection con = factory.createConnection();
        con.start();
        return con;
    }


}
