package guitardb.bbdev.org;

public class Guitar extends Instrument {

	String type;
	String model;
	String currentGauge;
	String changeDate;
	public Guitar(String brand, Integer year, String serial, String model) {
		super(brand, year, serial);
		this.model = model;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void save() {
		String sql = "INSERT INTO Guitars ";
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object[] all() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] find(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
