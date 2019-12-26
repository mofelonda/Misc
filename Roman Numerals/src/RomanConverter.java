import java.util.Scanner;
public class RomanConverter {

	public static void main(String[] args) {
		Scanner  scnr      = new Scanner(System.in);
		String   romanNums = "";
		String[] romanSyms = new String[] {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int[]    regNums   = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		int      userNum   = 0;
		int      i         = 0;
		
		System.out.println("Enter a number:");
		userNum = scnr.nextInt();
		
		boolean valid = (userNum > 0);
		
		while (i < 13) {
			if (userNum >= regNums[i]) {
				romanNums += romanSyms[i];
				userNum -= regNums[i];  
			}
			else {
				i++;
			}
	    }
		if (valid) {
			System.out.print("This number in roman numerals is: " + romanNums + "\nGoodbye!");
		}
		else {
			System.out.println("This number is invalid. \nTry again next time!");
		}
		scnr.close();
	}
}
