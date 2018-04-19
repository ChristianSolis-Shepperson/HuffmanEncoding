import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class HuffmanCoding {
	
	PriorityQueue<String> pQueue;
	public static String getTextFromFile(String filename){
		BufferedReader br = null;
		FileReader fr = null;
		String textInFile = "";

		try {

			//br = new BufferedReader(new FileReader(FILENAME));
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
	public static void huffmanEncode(String filename) {
		// TODO Auto-generated method stub
		String rawText = getTextFromFile(filename);
		

		
	}




}
