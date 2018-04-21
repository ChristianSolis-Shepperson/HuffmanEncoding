import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Iterator;


import java.util.HashMap;

public class HuffmanCoding {

	PriorityQueue<Node> pQueue = new PriorityQueue<>();
	HashMap<String, String> mapWithBitCode = new HashMap<>();
	public String getTextFromFile(String filename) {
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
	public HashMap<String, String> intiHashMapWithKeys(String s){
		HashMap<String, String> table = new HashMap<>();
		for( char c : s.toCharArray()){
			if(!table.containsKey(Character.toString(c))){
				table.put(Character.toString(c), "");
			}
		}
		return table;
	}
	public HashMap<String, Integer> getLookupTable(String s) {
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
	public void populateHashMapwWithBits(String letters, String encoding){
		for(char c : letters.toCharArray()){
			Iterator it = mapWithBitCode.entrySet().iterator();
			while(it.hasNext()) {
				HashMap.Entry pair = (HashMap.Entry) it.next();
				if(pair.getKey().equals(Character.toString(c))){
					String bit = encoding + pair.getValue();
					mapWithBitCode.put((String)pair.getKey(), bit);
				}

			}
		}
	}
	public void huffmanEncode(String filename) {
		// TODO Auto-generated method stub
		String rawText = getTextFromFile(filename);
		HashMap<String, Integer> table = getLookupTable(rawText);
		mapWithBitCode = intiHashMapWithKeys(rawText);
		Iterator it = table.entrySet().iterator();
		while(it.hasNext()) {
			HashMap.Entry pair = (HashMap.Entry) it.next();
			int w = (int) pair.getValue();
			String letter = (String) pair.getKey();
			Leaf temp = new Leaf(letter, "", w);
			pQueue.add(temp);
		}

		int pQLength = pQueue.size();
		for(int i = 0; i < pQLength - 1; i++){
			Node n1 = pQueue.remove();
			Node n2 = pQueue.remove();
			populateHashMapwWithBits(n1.letter,"0");
			populateHashMapwWithBits(n2.letter, "1");
			int value  = n1.weight + n2.weight;
			InternalNode internalNode = new InternalNode(value,n1,n2);
			internalNode.setLetter(n1.letter + n2.letter);
			internalNode.getLeft().addBit("0");
			internalNode.getRight().addBit("1");
			pQueue.add(internalNode);
		}
        Node lastNode = pQueue.peek();
	}
    String endingBitcode = "";


}