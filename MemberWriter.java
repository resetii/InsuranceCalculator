import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class MemberWriter {
	// Calls the override toString function to print all rooms
	public static void printMembersToScreen(ArrayList<Member> emps) {
		for (Member emp : emps) {
			System.out.println(emp.toString());
			System.out.println("-----------------------");
		}
	}
	
    public static boolean printMembersToTextFile(ArrayList<Member> emps, String fname) {
        File f = new File(fname);
        return printMembersToTextFile(emps, f);
    }
    public static boolean printMembersToTextFile(ArrayList<Member> emps, File file) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            for (Member emp : emps) {
                String a, b, c;
            	if (emp.getCancer()) {
                	a = "y";
                }
                else {a = "n";}
            	if (emp.getDiabetes()) {
                	b = "y";
                }
                else {b = "n";}
            	if (emp.getAlz()) {
                	c = "y";
                }
                else {c = "n";}
            	pw.printf("%s\t%s\t%d\t%d\t%d\t%d\t%d\t%s\t%s\t%s\n", 
                		emp.getFirst(),emp.getLast(), emp.getAge(), emp.getHeight(), emp.getWeight(),emp.getSys(),emp.getDias(),a,b,c);
            }
            pw.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
