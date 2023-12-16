// Importing the necessary class for the ActiveMQ broker
package jms;
import org.apache.activemq.broker.BrokerService;

// The class that sets up and starts the ActiveMQ broker
public class ActiveMQBroker {
    // The main method where the execution of the program starts
    public static void main(String[] args)  {
        // Creating an instance of the ActiveMQ BrokerService
        BrokerService brokerService = new BrokerService();

        // brokerService.setPersistent(false);
        try {
            // Adding a connector to the broker with the specified connection URI
            brokerService.addConnector("tcp://0.0.0.0:61616");

            // Starting the ActiveMQ broker
            brokerService.start();
        } catch (Exception e) {
            // Handling any exceptions that might occur during the broker setup
            throw new RuntimeException(e);
        }
    }
}