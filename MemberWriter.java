import java.util.ArrayList;
import java.io.*;
import java.beans.XMLEncoder;

/**
 * Writes member data to screen or to files. 
 * @author James
 *
 */
public class MemberWriter {
	/**
	 * Calls the override toString function to print to screen
	 * @param mems An array list of member objects
	 */
	public static void printMembersToScreen(ArrayList<Member> mems) {
		for (Member mem : mems) {
			System.out.println(mem.toString());
			System.out.println("-----------------------");
		}
	}
	/**
	 * Prints to text file
	 * @param members Array list of members
	 * @param fname file name
	 * @return creates text file
	 */
    public static boolean printMembersToTextFile(ArrayList<Member> members, String fname) {
        File f = new File(fname);
        return printMembersToTextFile(members, f);
    }
    /**
     * Prints to text file
     * @param members Array list of members
     * @param file a file object
     * @return creates text file
     */
    public static boolean printMembersToTextFile(ArrayList<Member> members, File file) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            for (Member mem : members) {
                String a, b, c;
            	if (mem.getCancer()) {
                	a = "y";
                }
                else {a = "n";}
            	if (mem.getDiabetes()) {
                	b = "y";
                }
                else {b = "n";}
            	if (mem.getAlz()) {
                	c = "y";
                }
                else {c = "n";}
            	pw.printf("%s\t%s\t%d\t%d\t%d\t%d\t%d\t%s\t%s\t%s\n", 
                		mem.getFirst(),mem.getLast(), mem.getAge(), mem.getHeight(), mem.getWeight(),mem.getSys(),mem.getDias(),a,b,c);
            }
            pw.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    /**
     * Prints to binary file
     * @param members Array list of members
     * @param fname file name
     * @return creates bin file
     */
    public static boolean writeMembersToBinary(ArrayList<Member> members, String fname) {
            try {
            	FileOutputStream fos = new FileOutputStream(fname);
            	ObjectOutputStream oos = new ObjectOutputStream(fos);
            	oos.writeObject(members);
            	oos.close();
                return true;
            } catch(Exception ex) {
                return false;
            }
    }
    /**
     * Prints to xml file
     * @param members Array list of members
     * @param fname file name
     * @return creates xml file
     */
    public static boolean writeMembersToXML(ArrayList<Member> members, String fname) {
            try {
                XMLEncoder xml = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fname)));
                xml.writeObject(members);
                xml.close();
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
}
