// James Campion
// This is the file reader that will do a try statement to read through the 
//   text files or throw exceptions if there is a problem

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class MemberReader {
	public static ArrayList<Member> readMembersFromFile(String fname) {
		try {
			ArrayList<Member> results = new ArrayList<Member>();
			Scanner fsc = new Scanner(new File(fname));
			String line;

			while (fsc.hasNextLine()) {
				line = fsc.nextLine().trim();
				results.add(MemberParser.createMemberFromLine(line));
			}
			fsc.close();
			return results;
		} catch (Exception ex) {
			return null;
		}
	}
}