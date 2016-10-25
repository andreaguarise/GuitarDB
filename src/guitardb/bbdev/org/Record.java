package guitardb.bbdev.org;

import java.sql.Connection;
import java.util.*;

public interface Record {
	
	public abstract void save();
	
	public abstract void update();
	
	public abstract void destroy();
	
	public abstract void load();
	
	public static  Vector<Object> all(){return new Vector<Object>();};
	
	public abstract Object first();
	
	public abstract Object[] find(String key, String value);
}
