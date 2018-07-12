package pers.vicxu.integrate.jms;

/**
 * Create by Consumer on 7/12/2018
 */
public interface Consumer {

    /**
     *
     * @param queueName :QueueName
     */
    public void receiveMsg(String queueName);
}
