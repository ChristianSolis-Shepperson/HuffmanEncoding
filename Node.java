/**
 * Abstract class for a Node
 * This class took 1hr to write and test
 * @author Dillon Sykes Christian Solis-Sheperson Kimberly Jimenez
 * @date 4.21.18
 */
public abstract class Node implements Comparable<Node>{
	
	protected int weight;
	protected String letter;
	protected String bitCode;

	/**
	 *	Creates a new Node with the specified weight
	 * @param value the weight of the node
	 */
	public Node(int value) {
		weight = value;
	}

	/**
	 * Creates a new Node that contains a weight, letter, and bit code
	 * @param weight - weight of Node
	 * @param letter - letter that will be set to the Node
	 * @param bitCode bitcode that will be set to the Node
	 */
	public Node(String letter, String bitCode, int weight) {
		this.letter = letter;
		this.bitCode = bitCode;
		this.weight = weight;
	}

	/**
	 * Calls Node subclass to add a bit to the sequence as the Huffman Tree is being built
	 * @param s adds a bit to the bit code for each Node
	 */
	public abstract void addBit(String s);

	/**
	 * returns difference between node and parameter given
	 * @param that A Node that will be used for comparing
	 * @return the difference of the weights of the two nodes that are being compared
	 */
	public int compareTo(Node that) {
		
		return this.weight - that.weight;
	}

}
