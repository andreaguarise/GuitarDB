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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Instrument.dbconnect();
		Guitar sg = new Guitar("Gibson", 2012, "None","SG");
		System.out.println("Insert:" + sg.brand + sg.model);
		sg.save();
		
		
		Guitars result = Guitar.all();
		for (Guitar g : result)
		{
			System.out.println("In DB:"+ g.id + "Model:" + g.model);
		}
		Instrument.dbclose();
	}

}
