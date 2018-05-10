package unit10;

public class MyInteger {
	int value;
	
	public MyInteger(int x) {
		value = x;
	}
	
	public int getMyInt() {
		return value;
	}
	
	public boolean isEven() {
		if (value%2==0)
			return true;
		return false;
	}
	
	public boolean isOdd() {
		if (value%2==1)
			return true;
		return false;
	}
	
	public boolean isPrime() {
		for (int x=2; x<value; x++)
		{
			if (value%x==0)
				return true;
		}
		return false;
	}
	
	public static boolean isEven(int n) {
		if (n%2==0)
			return true;
		return false;
	}
	
	public static boolean isOdd(int n) {
		if (n%2==1)
			return true;
		return false;
	}
	
	public static boolean isPrime(int n) {
		for (int x=2; x<n; x++)
		{
			if (n%x==0)
				return true;
		}
		return false;
	}
	
	public static boolean isEven(MyInteger i) {
		if (i.getMyInt()%2==0)
			return true;
		return false;
	}
	
	public static boolean isOdd(MyInteger i) {
		if (i.getMyInt()%2==1)
			return true;
		return false;
	}
	
	public static boolean isPrime(MyInteger i) {
		for (int x=2; x<i.getMyInt(); x++)
		{
			if (i.getMyInt()%x==0)
				return true;
		}
		return false;
	}
	
	public boolean equals(int n) {
		if (n==value)
			return true;
		return false;
	}
	
	public boolean equals(MyInteger i) {
		if (i.getMyInt()==value)
			return true;
		return false;
	}
	
	public static int parseInt(char[] arr) {
		int num=0;
		for (int i=0; i<arr.length; i++)
		{
			num = (num*10) + Character.getNumericValue(arr[i]);
		}
		return num;
	}
	
	public static int parseInt(String s) {
		int num=0;
		for (int i=0; i<s.length(); i++)
		{
			char c = s.charAt(i);
			int x = c-48;
			num = (num*10) + x;
		}
		return num;
	}
}
