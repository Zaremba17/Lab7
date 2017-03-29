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
		return 0;

	}
	
	public Matrix inverse()
	{
		return null;

	}
	
	public Matrix subMatrix(int r, int c)
	{
		return null;

	}
	
	public String printMatrix()
	{
		return null;

	}
}
