package round1A;
import java.io.*;
import java.util.*;

public class AlphabetCake {
    
	public static List<List<Character>> fillCake(List<List<Character>> inputList) {
		
		List<List<Character>> updatedCake = new ArrayList<>();
		if(inputList == null)	return updatedCake;
		int count = 0;
		List<Character> initials = new ArrayList<>();
		
		for(int i = 0; i<inputList.size();i++) {
			for(int j = 0; j<inputList.get(i).size(); j++) {
				if( inputList.get(i).get(j) != '?' )
					initials.add(inputList.get(i).get(j));
			}
		}
	
		for(int i = 0; i<inputList.size();i++) {
			List<Character> lineOfInitials = inputList.get(i);
			for(int j = 0; j<inputList.get(i).size(); j++) {
				if( lineOfInitials.get(j) == '?' )
					lineOfInitials.set(j,initials.get((count++)%initials.size()));
			}
			updatedCake.add(lineOfInitials);
		}
		
		return updatedCake;
	}
    public static void main(String[] args) throws FileNotFoundException {
    	String inFile = "src/round1A/A-small-attempt0.in";
		String outFile = "src/round1A/smallOutput.txt";
    	
        Scanner in = new Scanner(new File(inFile));
        PrintWriter writer = new PrintWriter(outFile);
       
    	
        for (int test=0; in.hasNextLine(); test++) {
        	if(test!=0) {
        	List<List<Character>> inputList = new ArrayList<>();
        	String[] str = in.nextLine().split(" ");
        
        	for(int i = 0; i<Integer.parseInt(str[0]); i++) {
        		String line = in.nextLine();
        		List<Character> lineList = new ArrayList<>();
        			for(int j = 0; j<Integer.parseInt(str[1]); j++) {
        				lineList.add(line.charAt(j));
        			}
        		inputList.add(lineList);
        	}
        	List<List<Character>> result = fillCake(inputList);
       		writer.println("Case #" + test + ":");
       		for(int i = 0; i <result.size(); i++) {
            	for(int j = 0; j<result.get(i).size();j++)
            		writer.print(result.get(i).get(j));
            	writer.println();
       		}
        	}else
        		in.nextLine();
		}	
        
        
        in.close();
		writer.close();
    }
}


