/**
 * Class will create Leaf Nodes
 * This class took 1hr to write and test
 * @author Dillon Sykes Christian Solis-Sheperson Kimberly Jimenez
 * @date 4.21.18
 */
public class Leaf extends Node implements Comparable<Node> {

	//Class should have two instance variables: the character and its code

    /**
     * Creates a Leaf Node with the specified weight
     * @param weight the weight of the Leaf
     */
	public Leaf(int weight) {
		super(weight);
	}

    /**
     * Creates a Leaf Node with a letter, weight, and bit code
     * @param letter - Letter that will set for the Leaf
     * @param bitCode - bitcode that will set for the Leaf
     * @param weight - weight that will set for the Leaf
     */
	public Leaf(String letter, String bitCode, int weight) {
		super(letter, bitCode, weight);
	}

    /**
     * Adds a bit to the current bit code of the Node
     * @param s Bit code value being added to node
     */
	@Override
	//Calls Node subclass to add a bit to the sequence as the Huffman Tree is being built
	public void addBit(String s) {
		this.bitCode = s;
		
	}

    /**
     * Method will set the letter for the Leaf Node
     * @param s is the letter you will be setting for the node
     */
	public void setLetter(String s){
		this.letter = s;
	}

    /**
     * Method will return the letter that the leaf Node contains
     * @param node node that you want to get the letter from
     * @return returns the letter of the node
     */
	public String getLetter(Node node){
		return node.letter;
	}

}
