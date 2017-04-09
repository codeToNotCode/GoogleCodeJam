package QualificationRound;
import java.io.*;
import java.util.*;

public class Flipper {
    
	public static int findFlips(String input) {
		if(input == null)	return -1;
		String[] str = input.split(" ");
		int flips = 0;
		List<Character> panCakes = new ArrayList<>();
		for(int i = 0; i<str[0].length();i++)
			panCakes.add(str[0].charAt(i));
		int k = Integer.parseInt(str[1]);
		int length = panCakes.size();
		for(int i=0; i<length; i++) {
			if(panCakes.get(i)=='-' && i+k <= length) {
				for(int j=i; j<i+k; j++)
					if(panCakes.get(j)=='-')
						panCakes.set(j, '+');
					else if(panCakes.get(j)=='+')
						panCakes.set(j, '-');
				flips++;
			}
		}
		if(panCakes.contains('-'))
			return -1;
		else
			return flips;
	}
    public static void main(String[] args) throws FileNotFoundException {
    	String inFile = "src/A-large.in";
		String outFile = "src/large_output.txt";
    	
        Scanner in = new Scanner(new File(inFile));
        PrintWriter writer = new PrintWriter(outFile);
       
        
        for (int test=0; in.hasNextLine(); test++) {
        	if(test!=0) {
        	//System.out.println(in.nextLine());
        	int result = findFlips(in.nextLine());
        	if(result == -1)
        		writer.println("Case #" + test + ": IMPOSSIBLE");
        	else
        		writer.println("Case #" + test + ": "+result);
        	}else
        		in.nextLine();
		}		
        in.close();
		writer.close();
    }
}


