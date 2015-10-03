package us.wsu.knoesis.tutorial.events;

public class FireEvent {

	private String sensor;
	private boolean smoke;

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

	public double getTemperture() {
		return temperture;
	}

	public void setTemperture(double temperture) {
		this.temperture = temperture;
	}

	public FireEvent(String sensor, boolean smoke, double temperture) {
		this.sensor = sensor;
		this.smoke = smoke;
		this.temperture = temperture;
	}

	private double temperture;

	@Override
	public String toString() {
		return "FireEvent [sensor=" + sensor + ", smoke=" + smoke
				+ ", temperture=" + temperture + "]";
	}
}
