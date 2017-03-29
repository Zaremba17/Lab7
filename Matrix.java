import java.lang.Math;

public class Matrix {
	private int n;
	private double[][] mdata = new double[10][10];
	public void Matrix(int _n, String row)
	{
		n = _n;
		double[] list = new double[n*n];
		boolean filled = false;
		int current =0;
		for (int z = 0;z< n*n;z++)
		{
			while (!filled)
			{
				if (row.charAt(0) == 'f')
				{
					list[z] = 0;
					current++;
					filled = true;
				}
				else if (row.charAt(current) == '-')
				{
					list[z] = -(Character.getNumericValue(row.charAt(current+1)));
					current+= 2;
					filled = true;
				}
				else if (row.charAt(current) == ' ')
				{
					current++;
				}
				else
				{
					list[z] = Character.getNumericValue(row.charAt(current));
					current++;
					filled = true;
				}
			}
			filled = false;
		}
		current = 0;
		for (int x = 0;x<n;x++)
		{
			for (int y = 0;y<n;y++)
			{
				mdata[x][y] = list[current];
				current++;
			}
		}
	}

	public double determinant()
	{
		
		double det = 0.0;
		
		if (n == 1)
		{
			det = mdata[0][0];
		}
		else if (n == 2)
		{
			det = mdata[0][0] * mdata[1][1] - mdata[0][1] * mdata[1][0];
		}
		else
		{
			for (int i = 0; i < n; i++)
			{
				det += Math.pow(-1.0,(double)i) * mdata[0][i] * subMatrix(0, i).determinant();
			}
		}
		
		return det;
	}
	
	public Matrix inverse()
	{
		Matrix inv = new Matrix();
		inv.Matrix(n,"f");
		double det = determinant();
		
		for (int i = 0; i < n; ++i)
		{
			for (int j = 0; j < n; ++j)
			{
				inv.mdata[i][j] = Math.pow(-1.0, (double)i + j) * subMatrix(j, i).determinant() / det + + 0.0;
			}
		}
		
		return inv;
	}
	
	public Matrix subMatrix(int r, int c)
	{
		Matrix sub = new Matrix();
		sub.Matrix(n-1, "f");
		
		int row = 0; 
		for (int i = 0; i < n; i++)
		{
			if (i == r) continue;
			
			int col = 0;
			for (int j = 0; j < n; j++)
			{
				if (j == c) continue;
				
				sub.mdata[row][col] = mdata[i][j];
				col++;
			}
			
			row++;
		}
		
		return sub;
	}
	
	public String printMatrix()
	{
		String m1 = "";
		for (int x = 0;x<n;x++)
		{
			for (int y = 0;y<n;y++)
			{
				if (mdata[x][y] % 1 == 0)
				{
					m1 = m1 + (int)mdata[x][y] + " ";
				}
				else 
				{
					m1 = m1 + mdata[x][y] + " ";
				}

			}
				m1 = m1 + "\n";
		}

		return m1;
	}
	
	public double[][] getArray(){
		
		return mdata;
	}
	
}
