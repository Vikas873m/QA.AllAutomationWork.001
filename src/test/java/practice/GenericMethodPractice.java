package practice;

public class GenericMethodPractice {

	public static void main(String[] args) { //caller
		
	 int sum = add(20, 80);
	 System.out.println(sum);
	 
	}
	public static int add(int a ,int b) { //called
		int c=a+b;
		return c;
		
	}
}
