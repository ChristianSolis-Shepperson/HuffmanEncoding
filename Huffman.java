public class Huffman {
	private static String name;
	private static int totalChars;
	private static int diffChars;
	private static int maxCodeLen;
	private static double aveCodeLen;
	private static int fileLen;
	private static int byteFileLen;		// totalChars*8
	private static double huffmanReduction;		// fileLen/byteFileLen * 100
	
	public void reset(){
		totalChars = 0;
		diffChars = 0;
		maxCodeLen = 0;
		aveCodeLen = 0;
		fileLen = 0;
		byteFileLen = 0;
		huffmanReduction = 0.0;
	}

	public static String summary(String filename, int totalChars, int diffChars, int maxCodeLen,  double aveCodeLen, int fileLen, int byteFileLen, double huffmanReduction){
		return "Filename: " + filename + "\n" +
				"Total Chars: " + totalChars +
				"\n" + "DiffChars: " + diffChars +
				"\n" + "MacCodeLength: " + maxCodeLen +
				"\n" + "AvgCodeLength: " + aveCodeLen +
				"\n" + "FileLength: " + fileLen +
				"\n" + "ByteFileLength: " + byteFileLen +
				"\n" + "HuffmanReduction: " + huffmanReduction + "%";
		//return String.format("%s%d%d%d%d%d%d%d", filename, totalChars, diffChars, maxCodeLen,aveCodeLen, fileLen, byteFileLen, huffmanReduction);

	}

	public static void main(String args[]) {
		//call huffmanEncode on project assignment
		//call huffmanEncode on a book
		//call huffmanEncode on Huffman.java file
		//call huffmanEncode on a file with one line:  A_DEAD_DAD_CEDED_A_BAD_BABE_A_BEADED_ABACA_BED
		String filename = "Alice.txt";
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
		System.out.print(summary);
	}
}