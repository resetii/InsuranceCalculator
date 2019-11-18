import java.io.*;
import java.util.ArrayList;
import org.json.simple.*;

public class InsuranceScoreWriter {
	/**
	 * Writes scores of members to screen
	 * @param members Array list of members
	 */
	public static void writeScoresToScreen(ArrayList<Member> members) {
		for (Member mem : members) {
				mem.assessment();
				System.out.println(mem.getMyScore().toString());
				System.out.print("\n");
		}
	}
	/**
	 * Writes the scores of members to JSON file
	 * @param members Array list of members
	 * @param fname desired file name
	 * @return create JSON file
	 */
	public static boolean writeScoresToJSON(ArrayList<Member> members, String fname) {
		        try {
		            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
		            JSONArray array = new JSONArray();
		            JSONObject obj;
		            for (Member mem : members) {
		                obj = new JSONObject();
		                obj.put("FirstName", mem.getFirst());
		                obj.put("LastName", mem.getLast());
		                obj.put("Score",mem.getMyScore());	                
		                array.add(obj);
		            }
		            JSONObject scoreList = new JSONObject();
		            scoreList.put("Scores",array);
		            pw.println(scoreList.toJSONString());
		            pw.close();
		            return true;
		        } catch (Exception ex) {
		            return false;
		        }
	}
}
