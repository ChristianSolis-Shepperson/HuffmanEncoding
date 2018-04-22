import java.io.*;
import java.util.PriorityQueue;
import java.util.Iterator;


import java.util.HashMap;

/**
 * This call runs the Huffman encoding algorithm.
 * This class took 9hrs to write and 2hrs to test.
 * @author Dillon Sykes Christian Solis-Sheperson Kimberly Jimenez
 * @date 4.21.18
 */
public class HuffmanCoding {

	PriorityQueue<Node> pQueue = new PriorityQueue<>();
	HashMap<String, String> mapWithBitCode = new HashMap<>();
	HashMap<String, Integer> table = new HashMap<>();
    String rawText = "";

	/**
	 * Method will return the number of different characters
	 * @return the total number of different characters
	 */
	public int getDiffChars(){
        return mapWithBitCode.size();
    }

	/**
	 * Method will return the number of total characters
	 * @return the total number of characters
	 */
	public int getTotalChars(){
    	return rawText.length();
	}

	/**
	 * Method will calculate the longest bit code that is in the tree
	 * @return the longest bit code from the tree
	 */
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

	/**
	 * Method will calculate the total length of the file / total number of characters
	 * @return the total length of the file / total number of characters
	 */
	public double getAveCodeLen(){
		double original = (double)getFileLength() / (double)getTotalChars();
		double rounded  = Math.round(original * 100.0) / 100.0;
    	return rounded;

	}

	/**
	 * Method will calculate the number of characters * 8
	 * @return number of characters * 8
	 */
	public int getByteFileLen(){
    	return getTotalChars() * 8;
	}

	/**
	 * Method will calculate the length of the file
	 * @return the length of the file
	 */
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

	/**
	 * Method will calculate the size of the reduced file compared to a file with the bytes for characters
	 * @return size of the reduced file
	 */
	public double getHuffmanReduction(){
    	double i =(double) getFileLength();
    	double j = (double)getByteFileLen();
    	double temp = (i /j) * 100;
		return Math.round(temp * 100.0) / 100.0;
	}


	/**
	 * Method will read the file and put everything in a string
	 * @param filename the name of the file
	 */
	public void getTextFromFile(String filename) {
		BufferedReader br = null;
		FileReader fr = null;

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

	/**
	 * Initiates a hashmap with all unique characters with blank values of the bitcode
	 * @param s contains everything that is read from the file
	 * @return hashmap with all unique characters with blank values of the bitcode
	 */
	public HashMap<String, String> intiHashMapWithKeys(String s){
		HashMap<String, String> table = new HashMap<>();
		for( char c : s.toCharArray()){
			if (!table.containsKey(Character.toString(c))) {
				table.put(Character.toString(c), "");
			}
		}
		return table;
	}

	/**
	 * Initiates a hashmap with each unique character and their frequencies
	 * @param s contains everything that is read from the file
	 * @return hashmap with each unique character and their frequencies
	 */
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

	/**
	 * Adds the bitcodes for each character in the hashmap
	 * @param letters the character that we are looking for from the tree
	 * @param encoding 1 or 0 added to its bitcode
	 */
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

	/**
	 * Method will calculate the bitcode using the Huffman Encoding Algorithm
	 * @param filename name of file
	 */
	public void huffmanEncode(String filename) {
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