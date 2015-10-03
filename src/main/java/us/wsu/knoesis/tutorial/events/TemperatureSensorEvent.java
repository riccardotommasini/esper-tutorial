package us.wsu.knoesis.tutorial.events;

public class TemperatureSensorEvent {

	private String sensor;
	private double temperature;

	public TemperatureSensorEvent(String sensor, double temperature) {
		this.sensor = sensor;
		this.temperature = temperature;
	}

	public String getSensor() {
		return sensor;
	}

	public void setSensor(String sensor) {
		this.sensor = sensor;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	@Override
	public String toString() {
		return "TemperatureSensorEvent [sensor=" + sensor + ", temperature="
				+ temperature + "]";
	}

}
