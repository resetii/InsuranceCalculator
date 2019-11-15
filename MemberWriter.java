import java.util.ArrayList;
import java.io.*;
import java.beans.XMLEncoder;

public class MemberWriter {
	// Calls the override toString function to print
	public static void printMembersToScreen(ArrayList<Member> emps) {
		for (Member emp : emps) {
			System.out.println(emp.toString());
			System.out.println("-----------------------");
		}
	}
	
    public static boolean printMembersToTextFile(ArrayList<Member> members, String fname) {
        File f = new File(fname);
        return printMembersToTextFile(members, f);
    }
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
