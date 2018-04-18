
public class Leaf extends Node implements Comparable<Node> {

	//Class should have two instance variables: the character and its code
	private static int code;
	private String symbol;
	
	public Leaf() {
		super(code);
	}

	@Override
	//Calls Node subclass to add a bit to the sequence as the Huffman Tree is being built
	public void addBit(String s) {
		
	}

}
