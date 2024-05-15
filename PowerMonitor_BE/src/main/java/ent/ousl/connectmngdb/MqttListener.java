package ent.ousl.connectmngdb;
import com.fasterxml.jackson.core.JsonProcessingException;
import ent.ousl.connectmngdb.DataDTO.DataDTO;
import ent.ousl.connectmngdb.service.UserService;
import org.eclipse.paho.client.mqttv3.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class MqttListener implements MqttCallback {
    private final UserService userService;

    private final String brokerUrl = "tcp://localhost:1883"; 
    private final String topic = "Test"; 


    public MqttListener(UserService userService) {
        this.userService = userService;
        startListening();
    }

    public void startListening() {
        try {
            MqttClient mqttClient = new MqttClient(brokerUrl, MqttClient.generateClientId());
            mqttClient.setCallback(this);
            mqttClient.connect();
            mqttClient.subscribe(topic);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT broker lost!");
    }

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) {
        String jsonMessage = new String(mqttMessage.getPayload());
        System.out.println("Received JSON message: " + jsonMessage);

        
        DataDTO dataDTO = parseJsonToDataDTO(jsonMessage);
        userService.SaveData(dataDTO);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        
    }

    private DataDTO parseJsonToDataDTO(String jsonString) {
        try {
            
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonString, DataDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            
            return null;
        }
    }
}
