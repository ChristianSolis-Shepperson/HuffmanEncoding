
public abstract class Node implements Comparable<Node>{
	
	protected int weight;
	
	public Node(int value) {
		weight = value;
	}
	
	//Calls Node subclass to add a bit to the sequence as the Huffman Tree is being built
	public abstract void addBit(String s);
	
	//returns difference between node and parameter given
	public int compareTo(Node that) {
		
		return -1;
	}

}
