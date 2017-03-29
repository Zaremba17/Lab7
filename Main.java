import java.io.*;


public class Main {

	public static void main(String[] args) {
		String line;

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
