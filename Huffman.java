import java.util.HashMap;
import java.util.Iterator;

/**
 * Class will test the Huffman Encoding algorithm and display summaries.
 * This class took about 2hrs to write and 2hrs test.
 * @author Dillon Sykes Christian Solis-Sheperson Kimberly Jimenez.
 * @date 4.21.18
 */
public class Huffman {
	private static String name;
	private static int totalChars;
	private static int diffChars;
	private static int maxCodeLen;
	private static double aveCodeLen;
	private static int fileLen;
	private static int byteFileLen;		// totalChars*8
	private static double huffmanReduction;		// fileLen/byteFileLen * 100

    /**
     * Method will reset the values after each report is made
     */
	public void reset(){
		totalChars = 0;
		diffChars = 0;
		maxCodeLen = 0;
		aveCodeLen = 0;
		fileLen = 0;
		byteFileLen = 0;
		huffmanReduction = 0.0;
	}

    /**
     * Method will generate a summary report
     * @param filename the name of the file that is being
     * @param totalChars total number of characters that the file contains
     * @param diffChars number of different characters in the file
     * @param maxCodeLen the longest bit code in the file
     * @param aveCodeLen the average length of a bit code
     * @param fileLen the total length of the file
     * @param byteFileLen the number of total characters * 8
     * @param huffmanReduction the size of the reduced file compared to a file with bytes as characters
     * @return summary for each file
     */
	public static String summary(String filename, int totalChars, int diffChars, int maxCodeLen,  double aveCodeLen, int fileLen, int byteFileLen, double huffmanReduction){
		return "Filename: " + filename + "\n" +
				"Total Chars: " + totalChars +
				"\n" + "DiffChars: " + diffChars +
				"\n" + "MacCodeLength: " + maxCodeLen +
				"\n" + "AvgCodeLength: " + aveCodeLen +
				"\n" + "FileLength: " + fileLen +
				"\n" + "ByteFileLength: " + byteFileLen +
				"\n" + "HuffmanReduction: " + huffmanReduction + "%";
	}

    /**
     * Method will generate a detailed report for each file
     * @param freq the frequency of each character
     * @param bitcode the bit code for each character
     * @return detailed report for each bit code, frequency of each character
     */
	public static String bitCodeSummary(HashMap<String,Integer> freq, HashMap<String,String> bitcode){
        String c = "";
        int theFreq = 0;
        String code = "";
	    Iterator it = freq.entrySet().iterator();
        while(it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) it.next();
            c = (String) pair.getKey();
            theFreq = (int) pair.getValue();
            code = bitcode.get(c);
            if(c.equals("\n")){
                c = "{NL}";
            }
            System.out.println(c + "     " + theFreq + "    " +code);
        }
        return null;
    }

    /**
     * Method wil run HuffManEncoding program and call helper methods to generate the reports
     * @param args name of file
     */
	public static void main(String args[]) {
		String filename = "Huffman.java";
		HuffmanCoding HC = new HuffmanCoding();
		HC.huffmanEncode(filename);
		String summary = Huffman.summary(filename,
				HC.getTotalChars(),
				HC.getDiffChars(),
				HC.getMaxLengthOfCode(),
				HC.getAveCodeLen(),
				HC.getFileLength(),
				HC.getByteFileLen(),
				HC.getHuffmanReduction());
		System.out.println(summary);
		System.out.println("--------------------------");
		System.out.println("Char  Freq  Code");
        Huffman.bitCodeSummary(HC.table,HC.mapWithBitCode);
	}
}