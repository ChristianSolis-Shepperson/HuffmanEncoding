
public class Leaf extends Node implements Comparable<Node> {

	//Class should have two instance variables: the character and its code

	public Leaf(int weight) {
		super(weight);
	}
	
	public Leaf(String letter, String bitCode, int weight) {
		super(letter, bitCode, weight);
	}

	@Override
	//Calls Node subclass to add a bit to the sequence as the Huffman Tree is being built
	public void addBit(String s) {
		this.bitCode = s;
		
	}
	public void setLetter(String s){
		this.letter = s;
	}

	public String getLetter(Node node){
		return node.letter;
	}


}
