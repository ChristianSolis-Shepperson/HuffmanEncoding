import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.HashMap;

public class HuffmanCoding {

	PriorityQueue<Node> pQueue;

	public static String getTextFromFile(String filename) {
		BufferedReader br = null;
		FileReader fr = null;
		String textInFile = "";

		try {

			// br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(filename);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				textInFile += sCurrentLine;
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		return textInFile;
	}

	public static HashMap<String, Integer> getLookupTable(String s) {
		HashMap<String, Integer> lookupTable = new HashMap<String, Integer>();

		for (char c : s.toCharArray()) {

			if (lookupTable.containsKey(Character.toString(c))) {
				// Check to make sure this increments Integer value of existing key
				//Call should update existing key and increment value
				lookupTable.put(Character.toString(c), lookupTable.get(Character.toString(c)) + 1);
			} else {
				lookupTable.put(Character.toString(c), 1);
			}

		}

		return lookupTable;
	}

	public static void huffmanEncode(String filename) {
		// TODO Auto-generated method stub
		String rawText = getTextFromFile(filename);
		HashMap<String, Integer> table = getLookupTable(rawText);
		
		//create nodes using the hashmap? weight will be the value in hashmap
		for(int i = 0; i < table.size();i++) {
			//store nodes created in priority queue
			//PriorityQueue instance variable should be initalized to contain a Leaf Node for each different character
		}
		
		
		

	}

}