
public class InternalNode extends Node implements Comparable<Node> {
	
	private Node left;
	private Node right;
	private String bitCode;

	public InternalNode(int value, Node l, Node r) {
		super(value);
		left = l;
		right = r;
	}

	@Override
	//Calls Node subclass to add a bit to the sequence as the Huffman Tree is being built
	public void addBit(String s) {
		this.bitCode = s;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public void setLetter(String s){
		this.letter = s;
	}
	public String getLetter(Node node){
		return node.letter;
	}




}
