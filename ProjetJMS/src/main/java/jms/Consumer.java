// Importation des classes nécessaires pour la communication JMS
package jms;
import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;
import sun.plugin2.message.Message;

// Classe représentant un consommateur JMS
public class Consumer {
    // Méthode principale
    public static void main(String[] args) {
        try {
            // Établissement d'une connexion au broker ActiveMQ
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Création d'une session JMS
            Session session = ((Connection) connection).createSession(true, Session.AUTO_ACKNOWLEDGE);

            // Création d'une destination (topic)
            Destination destination = session.createTopic("myTopic.topic");

            // Création d'un consommateur de messages pour la destination spécifiée
            MessageConsumer consumer = session.createConsumer(destination);

            // Définition d'un écouteur de messages pour le consommateur
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(javax.jms.Message message) {


                    if (message instanceof TextMessage) {
                        TextMessage textMessage = (TextMessage) message;
                        try {
                            // Affichage du contenu du message texte
                            System.out.println(textMessage.getText());
                        } catch (JMSException e) {
                            // Gestion des exceptions liées à JMS
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (Exception e) {
            // Gestion des exceptions générales
            e.printStackTrace();
        }
    }
}