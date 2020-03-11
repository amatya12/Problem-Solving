
import java.math.BigInteger;
import java.util.Scanner;
public class Ratio {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		double inputValue = sc.nextDouble();
		int noOfRepeatingDigits = sc.nextInt();
		String decimalToString = inputValue+"";
		String [] separatedValue = decimalToString.split("\\.");
		int track1 = 1;
		int track2 = toBeMultipliedBy(separatedValue[1].length());
		if(separatedValue[1].length() != noOfRepeatingDigits) {
			track1 = toBeMultipliedBy(Math.abs(separatedValue[1].length() -noOfRepeatingDigits));
		}
		
		
		int numerator =  Math.abs((int)(inputValue * track1) - (int)(inputValue * track2));
		int denominator = Math.abs(track1 - track2);
		
		BigInteger num, den, gcd;
		 num = new BigInteger(numerator+"");
		 den = new BigInteger(denominator+"");
		 
		 gcd = num.gcd(den);
		 
		 System.out.print(numerator/(gcd.intValue()) + "/" + (denominator/gcd.intValue()));
	}
	
	public static int toBeMultipliedBy(int noOfDigits) {
		return (int)Math.pow(10, Math.abs(noOfDigits));
	}
}

