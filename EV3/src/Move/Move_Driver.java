package Move;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.port.*;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorModes;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;


public class Move_Driver {

	public static void main(String[] args) {

		int ReturnDis = 0;
		EV3UltrasonicSensor USSensor = new EV3UltrasonicSensor(SensorPort.S1);
		SampleProvider distance= USSensor.getDistanceMode();
		float[] sample = new float[1];
		
		for(;;)
		{
			distance.fetchSample(sample, 0);
        	System.out.println("Distancia" + String.valueOf(sample[0]));
			Delay.msDelay(500);

		}

	}
}
