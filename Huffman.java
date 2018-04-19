public class Huffman {
	private static String name;
	private static int totalChars;
	private static int diffChars;
	private static int maxCodeLen;
	private static double aveCodeLen;
	private static int fileLen;
	private static int byteFileLen;		// totalChars*8
	private static double huffmanReduction;		// fileLen/byteFileLen * 100
	
	

	public static void main(String args[]) {
		//call huffmanEncode on project assignment
		//call huffmanEncode on a book
		//call huffmanEncode on Huffman.java file
		//call huffmanEncode on a file with one line:  A_DEAD_DAD_CEDED_A_BAD_BABE_A_BEADED_ABACA_BED
		HuffmanCoding.huffmanEncode("HuffmanTest.txt");
	}
}