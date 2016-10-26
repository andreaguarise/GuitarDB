package guitardb.bbdev.org;
import java.util.*;

public class Guitars implements Iterable<Guitar>{
	
	Vector<Guitar> list;
	public Guitars() {
		list = new Vector<Guitar>();
		// TODO Auto-generated constructor stub
	}
	
	public Guitars(Vector<Guitar> v){
		this.list = v;
	}
	
	void add(Guitar g){
		if (!list.contains(g)) {
			list.add(g);
		}
	}
	
	public Iterator<Guitar> iterator(){
		return list.iterator();
	}

}
