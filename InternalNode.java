
public class InternalNode extends Node implements Comparable<Node> {

	public InternalNode(int value, Node l, Node r) {
		super(value);
		l = null;
		r = null;
	}

	@Override
	//Calls Node subclass to add a bit to the sequence as the Huffman Tree is being built
	public void addBit(String s) {
		
	}

}
