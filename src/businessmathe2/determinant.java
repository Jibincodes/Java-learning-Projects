package businessmathe2;

import java.util.*;

public class determinant {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [][] m = new int [3][3];
		System.out.println("Enter the elements of the 3x3 Matrix");
		for (int i =0;i<3;i++)
		{
			for (int j =0;j<3;j++)
			{
				System.out.print(" enter the element in the positions of "+ (i+1)+ "," + (j+1) + "");
				m[i][j] = sc.nextInt();
			}
		}
		
	// printing the original matrix to see
		System.out.println("The original matrix is:");
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
				System.out.print(m[i][j]+ " ");
				System.out.println();
			
		}
		int det;
		det = m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
	            - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
	            + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
		System.out.println("The determinant of the matrix is "+ det);
	}

}
