
public abstract class Node implements Comparable<Node>{
	
	protected int weight;
	protected String letter;
	protected String bitCode;
	
	public Node(int value) {
		weight = value;
	}
	
	public Node(String letter, String bitCode, int weight) {
		this.letter = letter;
		this.bitCode = bitCode;
		this.weight = weight;
	}
	
	//Calls Node subclass to add a bit to the sequence as the Huffman Tree is being built
	public abstract void addBit(String s);
	
	//returns difference between node and parameter given
	public int compareTo(Node that) {
		
		return this.weight - that.weight;
	}

}
