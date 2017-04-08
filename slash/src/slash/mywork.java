package slash;

import java.util.Formatter;
import java.util.Scanner;
import java.util.*;
public class mywork {

static Scanner scn;
static Formatter x ;
int a ;
String  b ,c;
	public static void main(String args[]){
		
		try{
		x = new Formatter("res//1.txt");
		scn = new Scanner(System.in);
		System.out.println("Как вас зовут ?");
		String b = scn.next();
		System.out.println("Сколько вам лет  ?");
		int a = (int) Double.parseDouble(scn.next());
		System.out.println("Где вы живете  ?");
		String c = scn.next();
		x.format("Меня зовут %s, мне %d лет, я живу %s", b , a, c);
		x.close();
		}catch(Exception e){};
		
	}
}


