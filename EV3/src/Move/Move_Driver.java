package Move;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.port.*;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.SensorModes;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;


public class Move_Driver {

	public static void main(String[] args) {

		int ReturnDis = 0;
		EV3TouchSensor TSSensor1 = new EV3TouchSensor(SensorPort.S2);
		EV3TouchSensor TSSensor2 = new EV3TouchSensor(SensorPort.S3);
		SampleProvider Touch1= TSSensor1.getTouchMode();
		SampleProvider Touch2= TSSensor2.getTouchMode();
		float[] Touchsample1 = new float[1];
		float[] Touchsample2 = new float[1];
		for(;;)
		{
			TSSensor1.fetchSample(Touchsample1, 0);
			TSSensor2.fetchSample(Touchsample2, 0);
        	System.out.println("Distancia" + String.valueOf(Touchsample1[0]));
        	System.out.println("Distancia" + String.valueOf(Touchsample2[0]));
			Delay.msDelay(10);

		}

	}
}
