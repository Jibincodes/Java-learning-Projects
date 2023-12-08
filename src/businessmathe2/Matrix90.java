package businessmathe2;
import java.util.*;
public class Matrix90 {

	public static void main(String[] args) {
		int i ,j,m;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the matrix wished");
		m = sc.nextInt();
		if (m>2 && m<10)
		{
			int a[][]= new int [m][m];
			System.out.println("enter the elements");
			for(i=0;i<m;i++)
			{
				for(j=0;j<m;j++)
				{
					a[i][j] = sc.nextInt();
					}
			}
			System.out.println("Orginial one");
			for(i=0;i<m;i++)
			{
				for(j=0;j<m;j++)
					System.out.print(a[i][j]+ " ");
					System.out.println();
				
			}
			System.out.println("The matrix after 90 degrees rotation clockwise");
			for (i =0;i<m;i++)
			{
				for (j=m-1;j>=0;j--)
				{
					System.out.print(a[j][i]+ " ");
				}
				System.out.println();
			}
			
		}
		else {
			System.out.println("Invalid Size");
		}

	}

}
