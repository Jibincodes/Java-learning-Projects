package businessmathe2;

import java.util.*;
public class SortMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i,j,k,m,n,l= 0;
		System.out.println("Enter the number of rows and columns as wished");
		// first entered number would be taken as row and 2nd as number of columns
		m=sc.nextInt();
		n=sc.nextInt();
		// personal call not to have array bigger than sizee, plus a check to make sure they are numbers entered
		if (m<=2 && m>=15 || n<=2 && n>=15 )
			System.out.println("Out of range");
		else
		{
	int num[][] = new int[m][n];
	System.out.println("Enter the elements");
	for (i=0;i<m;i++)
	{
		for(j=0;j<n;j++)
			num[i][j]= sc.nextInt();
		
	}
	//To display the original Matrix
	System.out.println("The current Matrix:");
	for (i=0;i<m;i++)
	{
		for(j=0;j<n;j++)
			System.out.print(num[i][j]+ " ");
		System.out.println();
		
	}
	// now sorting logic
	for (i=0;i<m;i++)
	{
		for(j=0;j<(n-1);j++)
		{
			for (k=0;k<(n-1-j);k++)
			{
				if (num[i][k]>num[i][k+1])
				{
					l = num[i][k];
				num[i][k]= num[i][k+1];
				num[i][k+1]= l;
				}
						}
		}
	}
	System.out.println("Matrix sorted by rows");
	for(i=0;i<m;i++)
	{
		for(j=0;j<n;j++)
			System.out.print(num[i][j]+ " ");
		System.out.println();
		
	}
	
	}
		
	}
}
