import java.util.Scanner;

public class Kriptirane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char[][] leters = new char[][] { { 'Q', 'W', 'E', 'R', 'T' }, { 'Y', 'U', 'I', 'O', 'P' },
				{ 'A', 'S', 'D', 'F', 'G' }, { 'H', 'J', 'K', 'L', 'X' }, { 'C', 'V', 'B', 'N', 'M' } };
		System.out.println("Enter text you want to cript");
		String text = sc.nextLine();
		int length = text.length();
		if (text.length() % 2 != 0) {
			text += "p";
		}
		text = text.toUpperCase();
		String text1;
		text1 = cript(leters, text);
		System.out.println(text1);
		String text2;
		text2 = decript(leters, text1, length);
		System.out.println(text2);
		sc.close();
	}

	public static String cript(char[][] leters, String text) {
		int poz1 = 0;
		int poz2 = 1;
		char letter1, letter2;
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < text.length() / 2; i++) {
			int r1 = 0, c1 = 0;
			int r2 = 0, c2 = 0;
			letter1 = text.charAt(poz1);
			letter2 = text.charAt(poz2);
			for (int row = 0; row < leters.length; row++) {
				for (int col = 0; col < leters[0].length; col++) {
					if (letter1 == leters[row][col]) {
						r1 = row;
						c1 = col;
					}
					if (letter2 == leters[row][col]) {
						r2 = row;
						c2 = col;
					}
				}
			}
			if (r1 != r2 && c1 != c2) {
				letter1 = leters[r1][c2];
				letter2 = leters[r2][c1];
			}
			if (r1 == r2) {
				if (c1 == leters[0].length - 1) {
					c1 = 0;
					letter1 = leters[r1][c1];

				} else {
					letter1 = leters[r1][++c1];
				}
				if (c2 == leters[0].length - 1) {
					c2 = 0;
					letter2 = leters[r2][c2];

				} else {
					letter2 = leters[r2][++c2];
				}
			}
			if (c1 == c2) {
				if (r1 == leters.length - 1) {
					r1=0;
					letter1 = leters[r1][c1];
				} else {
					letter1 = leters[++r1][c1];
				}
				if (r2 == leters.length - 1) {
					r2=0;
					letter2 = leters[r2][c2];
				} else {
					letter2 = leters[++r2][c2];
				}
			}
			str.append(letter1);
			str.append(letter2);
			poz1 += 2;
			poz2 += 2;

		}
		return str.toString();

	}

	public static String decript(char[][] leters, String text, int length) {
		int poz1 = 0;
		int poz2 = 1;
		char letter1, letter2;
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < text.length() / 2; i++) {
			int r1 = 0, c1 = 0;
			int r2 = 0, c2 = 0;
			letter1 = text.charAt(poz1);
			letter2 = text.charAt(poz2);
			for (int row = 0; row < leters.length; row++) {
				for (int col = 0; col < leters[0].length; col++) {
					if (letter1 == leters[row][col]) {
						r1 = row;
						c1 = col;
					}
					if (letter2 == leters[row][col]) {
						r2 = row;
						c2 = col;
					}
				}
			}
			if (r1 != r2 && c1 != c2) {
				letter1 = leters[r1][c2];
				letter2 = leters[r2][c1];
			}
			if (r1 == r2) {
				if (c1 == 0) {
					c1 = 4;
					letter1 = leters[r1][c1];

				} else {
					letter1 = leters[r1][--c1];
				}
				if (c2 == 0) {
					c2 = 4;
					letter2 = leters[r2][c2];
				} else {
					letter2 = leters[r2][--c2];
				}
			}
			if (c1 == c2) {
				if (r1 == 0) {
					r1=4;
					letter1 = leters[r1][c1];
				} else {
					letter1 = leters[--r1][c1];
				}
				if (r2 == 0) {
					r2=4;
					letter2 = leters[r2][c2];
				} else {
					letter2 = leters[--r2][c2];
				}
			}
			str.append(letter1);
			str.append(letter2);
			poz1 += 2;
			poz2 += 2;

		}
		if (str.length() != length) {
			str.deleteCharAt(str.length() - 1);
		}
		return str.toString();

	}
}
