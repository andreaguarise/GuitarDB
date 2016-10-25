package guitardb.bbdev.org;
import java.util.*;

public class Guitars {
	
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Instrument.dbconnect();
		Guitar sg = new Guitar("Gibson", 2012, "None","SG");
		System.out.println("Insert:" + sg.brand + sg.model);
		Guitars guitars = new Guitars();
		guitars.add(sg);
		guitars.add(sg);
		sg.save();
		
		for (Guitar g : guitars.list) {
			System.out.println("Found:" + g.brand + g.model + g.serial +g.year);
			
		}
		
		//FIXME should get directly a Guitars instance somehow.
		Vector<Object> result = null; 
		result = Guitar.all();
		for (Object o : result)
		{
			Guitar g = (Guitar)o;
			System.out.println("In DB:"+ g.id + "Model:" + g.model);
		}
		Instrument.dbclose();
	}

}
