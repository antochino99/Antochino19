
public class Mobiles {
	static int number;
	static String name;
	
	public Mobiles(int number, String name){
		this.name= name;
		this.number= number;
	}
	
	public static int getNumber() {
		return number;
	}
	public static void setNumber(int number) {
		Mobiles.number = number;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Mobiles.name = name;
	}
	
	
	
}
