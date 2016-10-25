package guitardb.bbdev.org;

import java.sql.Connection;

public interface Record {
	
	public abstract void save();
	
	public abstract void update();
	
	public abstract void destroy();
	
	public abstract Object[] all();
	
	public abstract Object first();
	
	public abstract Object[] find(String key, String value);
}
