package guitardb.bbdev.org;

public abstract class Instrument implements Record {
	Integer id;
	String brand;
	Integer pricePaid;
	Integer year;
	String serial;
	
	public Instrument(String brand, Integer year, String serial) {
		this.brand = brand;
		this.serial = serial;
		this.year = year;
	}

	
}
