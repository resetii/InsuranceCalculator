public class MemberParser {

	public static Member createMemberFromLine(String desc) {
		int age, height, weight, bpSys, bpDias;
		boolean cancer, diabetes, alz;
		String first, last;
		
		desc = desc.trim();	
		// break line into list based on tab separation
	    String[] splitString = desc.split("\t");
		
	    // fills the variables with the data split out from the line
		first = splitString[0].trim();
		last = splitString[1].trim();
		age = Integer.parseInt(splitString[2].trim());
		height = Integer.parseInt(splitString[3].trim());
		weight = Integer.parseInt(splitString[4].trim());
		bpSys = Integer.parseInt(splitString[5].trim());
		bpDias = Integer.parseInt(splitString[6].trim());
		if ((splitString[7].trim()).equals("y")) {
			cancer = true;
		}
		else { cancer = false; }
		
		if ((splitString[8].trim()).equals("y")) {
			diabetes = true;
		}
		else { diabetes = false; }
		
		if ((splitString[9].trim()).equals("y")) {
			alz = true;
		}
		else { alz = false; }

		return new Member(first, last, age, height, weight, bpSys, bpDias, cancer, diabetes, alz);	
	}
	
}