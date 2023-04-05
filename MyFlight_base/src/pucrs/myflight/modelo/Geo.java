package pucrs.myflight.modelo;

public class Geo {
	private double latitude;
	private double longitude;
	
	public Geo(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	@Override
	public String toString() {
		return "Geo : latitude = " + latitude + ", longitude = " + longitude;
	}

	public double getLongitude() {
		return longitude;
	}
}
