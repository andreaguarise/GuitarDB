package guitardb.bbdev.org;
import java.util.*;

public class Guitars {
	
	Vector<Guitar> list;
	public Guitars() {
		list = new Vector<Guitar>();
		// TODO Auto-generated constructor stub
	}
	
	void add(Guitar g){
		if (!list.contains(g)) {
			list.add(g);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Guitar sg = new Guitar("Gibson", 2012, "None","SG");
		System.out.println("Insert:" + sg.brand + sg.model);
		Guitars guitars = new Guitars();
		guitars.add(sg);
		guitars.add(sg);
		Instrument.dbconnect();
		for (Guitar g : guitars.list) {
			System.out.println("Found:" + g.brand + g.model + g.serial +g.year);
			g.save();
		}
		
		Instrument.dbclose();
	}

}
