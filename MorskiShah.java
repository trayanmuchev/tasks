import java.util.Scanner;

public class MorskiShah {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char[][] mShah = new char[3][3];
		int row, col;
		boolean player1 = false;
		boolean player2 = false;
		for (int hod = 1; hod < 10; hod++) {
			do {
				do {
					System.out.println("Enter row");
					row = sc.nextInt();
					System.out.println("Enter col");
					col = sc.nextInt();
					if (hod % 2 == 0) {
						System.out.println("2:" + row + " " + col);
					} else {
						System.out.println("1:" + row + " " + col);
					}
				} while (row < 0 || row >= mShah.length || col < 0 || col >= mShah[0].length);
			} while (mShah[row][col] == 'x' || mShah[row][col] == 'o');
			if (hod % 2 == 0) {
				mShah[row][col] = 'x';
			} else {
				mShah[row][col] = 'o';
			}
			print(mShah);
			if (hod >= 5) {
				player1 = check1(mShah);
				player2 = check2(mShah);
				if (player1 == true) {
					System.out.println("Player 1 is the winner");
					break;
				}
				if (player2 == true) {
					System.out.println("Player 2 is the winner");
					break;
				}
			}
			if (hod == 9 && player1 == false && player2 == false) {
				System.out.println("The game is tigth");
			}
		}
		sc.close();

	}

	public static void print(char[][] mShah) {
		for (int row = 0; row < 3; row++) {
			System.out.println();
			for (int col = 0; col < 3; col++) {
				System.out.print(mShah[row][col]);
			}
		}
		System.out.println();
	}

	public static boolean check1(char[][] mShah) {
		for (int row = 0; row < 3; row++) {
			boolean check = false;
			for (int col = 0; col < 3; col++) {
				if (mShah[row][col] == 'x') {
					check = true;
				} else {
					check = false;
					break;
				}
			}
			if (check == true)
				return true;
		}
		for (int col = 0; col < 3; col++) {
			boolean check = false;
			for (int row = 0; row < 3; row++) {
				if (mShah[row][col] == 'x') {
					check = true;
				} else {
					check = false;
					break;
				}
			}
			if (check == true)
				return true;
		}
		if (mShah[0][0] == 'x' && mShah[1][1] == 'x' && mShah[2][2] == 'x') {
			return true;
		}
		if (mShah[0][2] == 'x' && mShah[1][1] == 'x' && mShah[2][0] == 'x') {
			return true;
		} else {
			return false;
		}
	}

	public static boolean check2(char[][] mShah) {
		for (int row = 0; row < 3; row++) {
			boolean check = false;
			for (int col = 0; col < 3; col++) {
				if (mShah[row][col] == 'o') {
					check = true;
				} else {
					check = false;
					break;
				}
			}
			if (check == true)
				return true;
		}
		for (int col = 0; col < 3; col++) {
			boolean check = false;
			for (int row = 0; row < 3; row++) {
				if (mShah[row][col] == 'o') {
					check = true;
				} else {
					check = false;
					break;
				}
			}
			if (check == true)
				return true;
		}
		if (mShah[0][0] == 'o' && mShah[1][1] == 'o' && mShah[2][2] == 'o') {
			return true;
		}
		if (mShah[0][2] == 'o' && mShah[1][1] == 'o' && mShah[2][0] == 'o') {
			return true;
		} else {
			return false;
		}

	}
}
