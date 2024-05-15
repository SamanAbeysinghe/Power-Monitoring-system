package ent.ousl.connectmngdb;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MqttSubscriberRunner implements ApplicationRunner{
    @Autowired
    private MqttSubscriber mqttSubscriber;

    @Override
    public void run(ApplicationArguments args) throws MqttException {
        String brokerUrl = "tcp://localhost:1883"; // Replace with your Mosquitto broker URL
        String clientId = MqttClient.generateClientId();
        MqttClient mqttClient = new MqttClient(brokerUrl, clientId);

        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);

        mqttClient.setCallback(mqttSubscriber);
        mqttClient.connect(options);

        String topic = "Test"; // Replace with the MQTT topic you want to subscribe to
        mqttClient.subscribe(topic);
    }
}
