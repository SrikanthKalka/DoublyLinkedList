package srikanth.doublyLinkedList;

public class DLLNode {

	private int data;
	private DLLNode previous;
	private DLLNode next;

	public DLLNode(int data) {
		this.data = data;
		this.previous = null;
		this.next = null;
	}


	/**
	 * whenever we are inserting a new node, it can be easy to assign next/previous node value
	 * 
	 * case 1: whenever we are creating node at front side i.e before head node.
	 * we know that, new node next element should be head,
	 * so we can pass easily next element as head by using this constructor
	 * 
	 * case 2: whenever we are creating node at rare side i.e end of Tail node.
	 * we know that, new node previous element should be old tail node,
	 * so we can pass easily old tail node as new node previous node by using this constructor
	 * 
	 * @param data
	 * @param previous
	 * @param next
	 */
	public DLLNode(int data, DLLNode previous, DLLNode next) {
		this.data = data;
		this.previous = previous;
		this.next = next;

	}

	/*
	 * Need a pointer to the particular node,So, we have to create another node
	 * inside the particular node or pointer to next node
	 */

	public int getData() {

		if(data==0){
			return 0;
		}
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DLLNode getPrevious() {
		return previous;
	}

	public void setPrevious(DLLNode previous) {
		this.previous = previous;
	}

	public DLLNode getNext() {
		return next;
	}

	public void setNext(DLLNode next) {
		this.next = next;
	}

}
