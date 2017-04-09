package QualificationRound;

import java.io.*;
import java.util.*;

public class TidyNumber {
    

	public static String findTidy(String s) {
		List<Character> list = new ArrayList<>();
		for(int i = 0; i < s.length(); i++)
			list.add(s.charAt(i));
		for(int i = 1 ; i<list.size(); i++) {
			int first = list.get(i-1) - '0';
			int second = list.get(i) - '0';
			if(second<first) {
				list.set(i-1, (char)(first-1+ '0'));
				for(int j = i; j<list.size(); j++)
					list.set(j, '9');
				i=0;
			}
		}
		for(int i = 0 ; list.get(i)=='0';i++)
			list.remove(0);
		String result = "";
		for(Character c :list) {
			result+=c;
		}
		return result;
	}
    public static void main(String[] args) throws FileNotFoundException {
    	String inFile = "src/QualificationRound/B-large.in";
		String outFile = "src/QualificationRound/large_output.txt";
    	
        Scanner in = new Scanner(new File(inFile));
        PrintWriter writer = new PrintWriter(outFile);
       
        
        for (int test=0; in.hasNextLine(); test++) {
        	if(test!=0) {
        	//System.out.println(in.nextLine());
        	String result = findTidy(in.nextLine());
        	writer.println("Case #" + test + ": "+result);
        	}else
        		in.nextLine();
		}		
        in.close();
		writer.close();
    }
}


