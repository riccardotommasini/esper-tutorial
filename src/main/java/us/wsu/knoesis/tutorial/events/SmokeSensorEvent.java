package us.wsu.knoesis.tutorial.events;

public class SmokeSensorEvent {

	private String sensor;
	private boolean smoke;

	public SmokeSensorEvent(String sensor, boolean smoke) {
		this.sensor = sensor;
		this.smoke = smoke;
	}

	// NB naming convention for esper to call the attribute!
	public String getSensor() {
		return sensor;
	}

	public void setSensor(String sensor) {
		this.sensor = sensor;
	}

	public boolean isSmoke() {
		return smoke;
	}

	public void setSmoke(boolean smoke) {
		this.smoke = smoke;
	}

	@Override
	public String toString() {
		return "SmokeSensorEvent [sensor=" + sensor + ", smoke=" + smoke + "]";
	}

}
