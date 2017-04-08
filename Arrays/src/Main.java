import java.util.ArrayList;
import java.util.Random;

public class Main {
	private static ArrayList<Mobiles> mobiles = new ArrayList<Mobiles>();
	private static Random r = new Random ();
	public static void main(String args[]){
	 for( int u=0;  u<1000000; u++){
		mobiles.add(new Mobiles(r.nextInt(99995479), "ABC")); 
	 }
		for(Mobiles m:mobiles){
			System.out.println(m.getNumber()+"  "+m.getName());
		}
	 
	 }
	
}
