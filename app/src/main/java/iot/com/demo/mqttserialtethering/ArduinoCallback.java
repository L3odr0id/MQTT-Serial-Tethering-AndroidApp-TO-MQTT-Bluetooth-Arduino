package iot.com.demo.mqttserialtethering;

import android.util.Log;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class ArduinoCallback implements MqttCallback {

	@Override
	public void connectionLost(Throwable arg0) {
		// TODO Auto-generated method stub
		Log.d("AAAAAA", "Connection lost");

	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub
		try {
			Log.d("AAAAAA", "deliveryComplete"+arg0.getMessage().toString());
		} catch (MqttException e) {
			e.printStackTrace();
			Log.d("AAAAAA", "deliveryComplete, but failed to get message");
		}

	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		BluetoothService.arrivedMessage.put(topic, message);
		Log.d("AAAAAA", "messageArrived"+message.toString());
	}

}
