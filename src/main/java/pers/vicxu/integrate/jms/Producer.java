package pers.vicxu.integrate.jms;

/**
 * Create by Producer on 7/12/2018
 */
public interface Producer {

    /**
     *
     * @param str :JSON
     * @param queueName :Queue Name
     */
    public void producer(String str, String queueName);
}
