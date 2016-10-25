package guitardb.bbdev.org;

public interface Record {
	public abstract void save();
	
	public abstract void update();
	
	public abstract void destroy();
	
	public abstract Object[] all();
	
	public abstract Object first();
	
	public abstract Object[] find(String key, String value);
}
