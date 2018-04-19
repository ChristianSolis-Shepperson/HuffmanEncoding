
public class InternalNode extends Node implements Comparable<Node> {
	
	private Node left;
	private Node right;

	public InternalNode(int value, Node l, Node r) {
		super(value);
		left = l;
		right = r;
	}

	@Override
	//Calls Node subclass to add a bit to the sequence as the Huffman Tree is being built
	public void addBit(String s) {
		left.addBit(s);
		right.addBit(s);
	}

}
