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
		System.out.println("��� ��� ����� ?");
		String b = scn.next();
		System.out.println("������� ��� ���  ?");
		int a = (int) Double.parseDouble(scn.next());
		System.out.println("��� �� ������  ?");
		String c = scn.next();
		x.format("���� ����� %s, ��� %d ���, � ���� %s", b , a, c);
		x.close();
		}catch(Exception e){};
		
	}
}


