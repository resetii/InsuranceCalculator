import java.util.ArrayList;
import java.util.Scanner;
import java.beans.XMLDecoder;
import java.io.*;

/**
 * This class can read information from various formats and create members. 
 * @author James
 *
 */
public class MemberReader {
	/**
	 * Reading from text file.
	 * @param fname File name
	 * @return List of members
	 */
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
	/**
	 * Reading from binary file.
	 * @param fname File name
	 * @return List of members
	 */
	public static ArrayList<Member> readMembersFromBinary(String fname) {
        try {
        	FileInputStream fis = new FileInputStream(fname);
        	ObjectInputStream ois = new ObjectInputStream(fis);
        	ArrayList<Member> results = (ArrayList<Member>) ois.readObject();
        	ois.close();
            return results;
        } catch (Exception ex) {
            return null;
        }
    }
	/**
	 * Reading from XML file.
	 * @param fname File name
	 * @return List of members
	 */
	public static ArrayList<Member> readMembersFromXML(String fname) {
        try {
            XMLDecoder xml = new XMLDecoder(new BufferedInputStream(new FileInputStream(fname)));
            ArrayList<Member> results = (ArrayList<Member>)xml.readObject();
            xml.close();
            return results;
        } catch (Exception ex) {
            return null;
        }
    }
}