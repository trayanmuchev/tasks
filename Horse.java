import java.util.Scanner;

public class Horse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
	System.out.println("Enter number of rows");
	int r=sc.nextInt();
	System.out.println("Enter number of colums");
	int c=sc.nextInt();
	char[][] horse=new char[r][c];
	System.out.println("Enter a row you want to start");
	int red=sc.nextInt();
	System.out.println("Enter a colum you want to start");
	int col=sc.nextInt();
	horse(horse,red,col);
	print(horse);
	sc.close();
	}
public static void horse(char[][] horse,int row,int col){
	if(row<0||row>=horse.length)return;
	if(col<0||col>=horse[0].length)return;
	if(horse[row][col]=='.')return;
	horse[row][col]='.';
	horse(horse,row-1,col-2);
	horse(horse,row-2,col-1);
	horse(horse,row-2,col+1);
	horse(horse,row-1,col+2);
	horse(horse,row+1,col+2);
	horse(horse,row+2,col+1);
	horse(horse,row+2,col-1);
	horse(horse,row+1,col-2);
}
public static void print(char[][] horse){
	for(int r=0;r<horse.length;r++){
		System.out.println();
		for(int c=0;c<horse[0].length;c++){
			System.out.print(horse[r][c]);
		}
	}
}
}
