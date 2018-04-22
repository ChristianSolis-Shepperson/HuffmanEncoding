/**
 * Class will create an internal node
 * This class took 1hr to write and test
 * @author Dillon Sykes Christian Solis-Sheperson Kimberly Jimenez
 * @date 4.21.18
 */
public class InternalNode extends Node implements Comparable<Node> {
	
	public Node left;
	public Node right;
	private String code="";


	/**
	 * Constructor for Internal Node
	 * @param value - weight of InternalNode
	 * @param l left node
	 * @param r left node
	 */
	public InternalNode(int value, Node l, Node r) {
		super(value);
		left = l;
		right = r;
	}

	/**
	 * Method will add a bit to the bit code for the InternalNode
	 * @param s - Bit code value being added to node
	 */
	@Override
	//Calls Node subclass to add a bit to the sequence as the Huffman Tree is being built
	public void addBit(String s) {
		this.code= s;
	}

	/**
	 * Method will return the left Node of the InternalNode
	 * @return returns the left Node
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * Method will set the left Node
	 * @param left a Node that will be set to the left node
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * Method will return the right Node of the InternalNode
	 * @return returns the right node
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * Method will set the right Node
	 * @param right a Node that will be set to the right node
	 */
	public void setRight(Node right) {
		this.right = right;
	}

	/**
	 * Method will set the letter of the InternalNode
	 * @param s is the letter you will be setting for the node
	 */
	public void setLetter(String s){
		this.letter = s;
	}

	/**
	 * Method return the letter that the Node contains
	 * @param node node that you want to get the letter from
	 * @return returns the letter of the node
	 */
	public String getLetter(Node node){
		return node.letter;
	}




}
