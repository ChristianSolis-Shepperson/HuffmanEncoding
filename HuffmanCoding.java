import java.io.*;
import java.util.PriorityQueue;
import java.util.Iterator;


import java.util.HashMap;
import java.util.Scanner;

public class HuffmanCoding {

	PriorityQueue<Node> pQueue = new PriorityQueue<>();
	HashMap<String, String> mapWithBitCode = new HashMap<>();
	HashMap<String, Integer> table = new HashMap<>();
    String rawText = "";

    public int getDiffChars(){
        return mapWithBitCode.size();
    }
    public int getTotalChars(){
    	return rawText.length();
	}
	public int getMaxLengthOfCode(){
    	int longestCode = 0;
		Iterator it = mapWithBitCode.entrySet().iterator();
		while(it.hasNext()) {
			HashMap.Entry pair = (HashMap.Entry) it.next();
			String check = (String) pair.getValue();
			if(check.length() > longestCode){
				longestCode = check.length();
			}
		}
		return longestCode;
	}

	public double getAveCodeLen(){
		double original = (double)getFileLength() / (double)getTotalChars();
		double rounded  = Math.round(original * 100.0) / 100.0;
    	return rounded;

	}

	public int getByteFileLen(){
    	return getTotalChars() * 8;
	}

	public int getFileLength(){
		int fileLength = 0;
		Iterator it = mapWithBitCode.entrySet().iterator();
		while(it.hasNext()) {
			HashMap.Entry pair = (HashMap.Entry) it.next();
			String check = (String) pair.getValue();
			int lengthOfCode = check.length();
			int freq = table.get(pair.getKey());
			fileLength += lengthOfCode * freq;
		}
		return fileLength;
	}

	public double getHuffmanReduction(){
    	double i =(double) getFileLength();
    	double j = (double)getByteFileLen();
    	double temp = (i /j) * 100;
		return Math.round(temp * 100.0) / 100.0;
	}


	public void getTextFromFile(String filename) {
		BufferedReader br = null;
		FileReader fr = null;

        Scanner scanner = null;
//        try {
//            scanner = new Scanner(new File(filename));
//            while (scanner.hasNextLine()){
//                rawText += scanner.nextLine();
//            }
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

		try {

			// br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(filename);
			br = new BufferedReader(fr);

			char sCurrentLine;
            int ch;
			while ((ch = br.read())!= -1) {
			    char c = (char) ch;
			    String tmp = Character.toString(c);
			    if(!tmp.equals("\r")){
                    rawText += tmp;
                }

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
		//return textInFile;
	}
	public HashMap<String, String> intiHashMapWithKeys(String s){
		HashMap<String, String> table = new HashMap<>();
		for( char c : s.toCharArray()){
			if (!table.containsKey(Character.toString(c))) {
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
		//lookupTable.put("",lookupTable.get("") + 1);

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
		getTextFromFile(filename);
		table = getLookupTable(rawText);
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
	}
}