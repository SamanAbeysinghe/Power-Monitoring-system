package ent.ousl.connectmngdb;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

@Component
public class MqttSubscriber implements MqttCallback{
    @Override
    public void connectionLost(Throwable cause) {
        
    }
    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        
        String payload = new String(message.getPayload());
        System.out.println("Received message from topic: " + topic);
        System.out.println("Payload: " + payload);
        
    }

    @Override
    public void deliveryComplete(org.eclipse.paho.client.mqttv3.IMqttDeliveryToken token) {
       
    }
}
