import java.io.*;


public class Main {

	public static void main(String[] args) {
		Matrix m = new Matrix();
		String line;
        String matrixLine = "";
        int mSize = 0;
        int count = 0;
		if (args.length < 2)
		{
			System.out.println("argument is less than two, expected src/input.txt : src/output.txt");
		}
		else
		{
	        String input = args[0];
	        String output = args[1];
	        try 
	        {
	            FileReader fileReader = new FileReader(input);
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            FileWriter fileWriter = new FileWriter(output);
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	            
	            while((line = bufferedReader.readLine()) != null) 
	            {
	            	if (line.length() == 1)
	            	{
	            		if (Integer.parseInt(line) !=0)
	            		{
	            			mSize = Integer.parseInt(line);
	            			count = 0;
	            			matrixLine = "";
	            			bufferedWriter.write("M = ");
	            			bufferedWriter.newLine();
	            		}
	            	}
	            	else if(count < mSize)
	            	{
	            		matrixLine = matrixLine + " " + line;
	            		if (count  + 1 == mSize)
	            		{
	            			m.Matrix(mSize, matrixLine);
				            bufferedWriter.write(m.printMatrix());	  
				            bufferedWriter.write("det(M) = " + m.determinant());
				            bufferedWriter.newLine();
				            bufferedWriter.write("Minv = ");
				            bufferedWriter.newLine();
				            bufferedWriter.write(m.inverse().printMatrix());
	            		}
	            		count++;
	            	}
	            }
	            bufferedReader.close();       
	            bufferedWriter.close();
	        }
	        catch(FileNotFoundException ex) 
	        {
	            System.out.println(
	                "Unable to open file '" + input + "'");                
	        }
	        catch(IOException ex) 
	        {
	            System.out.println("Error reading file '" + input + "'");                  
	        }

	        
		}
	}
}
