package srikanth.doublyLinkedList;

public class DoublyLinkedList {

	// Length of the Linked List class
	private int length;
	DLLNode head; // It holds the head of the class
	DLLNode tail;

	/**
	 * Algorithm
	 * 
	 * step 1: new node is inserted before the head node.
	 * 
	 * step 2: update the new node next pointer (right) to "head".
	 * 
	 * step 3: update the new node previous pointer (left )to "null".
	 * 
	 * step 4: update the head previous pointer (left) to "new node".
	 * 
	 * step 5: Make a new node as a "head".
	 * 
	 * @param newNode
	 */
	public synchronized void insertAtBegin(int newNodeData) {

		System.out.println("\n" + "insertAtBegin Method is Running.." + "\n"
				+ "The element going to added in the list is :" + newNodeData);

		if (head == null) {
			head = new DLLNode(newNodeData, null, null);
		} else {
			DLLNode newNode = new DLLNode(newNodeData, null, head);
			head.setPrevious(newNode);
			head = newNode;
		}
		length++;
		printHeadTailPeviousNextAndLength();
	}

	/**
	 * Algorithm
	 * 
	 * step 1: New node is inserted end of the Tail node.
	 * 
	 * step 2: Update the Tail next node pointer (right) as "new node".
	 * 
	 * step 3: Update new node previous pointer (left )to "tail".
	 * 
	 * step 4: Update the new node next pointer (left) to "null".
	 * 
	 * step 5: Make a new node as a "Tail".
	 * 
	 * @param newNode
	 */
	public synchronized void insertAtEnd(int newNodeData) {

		System.out.println("\n" + "InsertAtEnd Method is Running.." + "\n"
				+ "The element going to added in the list is :" + newNodeData);

		if (head == null) {
			head = new DLLNode(newNodeData, null, null);
		} else {

			DLLNode lastElement = head;

			while (lastElement.getNext() != null) {
				lastElement = lastElement.getNext();
			}

			DLLNode newNode = new DLLNode(newNodeData, lastElement, null);
			lastElement.setNext(newNode);

		}
		length++;
		printHeadTailPeviousNextAndLength();
	}

	/**
	 * Algorithm
	 * 
	 * step 1: position is < 0 or > length return from the method.
	 * 
	 * step 2: If position = 0 then make newNode next node as head first, then
	 * make new node as Head node
	 * 
	 * step 3: Position is more than 0 then iterate head element using the given
	 * position value.
	 * 
	 * step 4: by the end of the for loop, create a new node the assign
	 * prev,next node from the iterator resultant
	 * 
	 * step 5: Make a iterator resultant node next node as a newNode.
	 * 
	 * @param newNode
	 */
	public synchronized void insertbyPosition(int position, int data) {

		if (position < 0 || position > length)
			return;

		if (position == 0) {
			DLLNode newNode = new DLLNode(data, null, head);
			head = newNode;
		} else {
			DLLNode temp = head;

			for (int i = 1; i < position; i++) {
				temp = temp.getNext();
			}

			DLLNode newNode = new DLLNode(data, temp, temp.getNext());
			temp.setNext(newNode);

		}

	}

	/**
	 * Algorithm
	 * 
	 * step 1: Head node is null then return from the method
	 * 
	 * step 2: if head is only one element in the list then make head node as
	 * null
	 * 
	 * step 3: if head node is contains more than one element then make
	 * head.next element as head.
	 * 
	 * @param newNode
	 */
	public synchronized void deleteAtFront() {

		System.out.println("\n" + "InsertAtEnd Method is Running.." + "\n");

		if (head == null) {
			return;
		} else if (head.getNext() == null) {
			head = null;
		} else {
			head = head.getNext();

		}
		length--;

		printHeadTailPeviousNextAndLength();
	}

	/**
	 * Algorithm
	 * 
	 * step 1: Head node is null then return from the method
	 * 
	 * step 2: if head is only one element in the list then make head node as
	 * null
	 * 
	 * step 3: if head node is contains more than one element, then take a temp
	 * node as head, then iterate it until reach to end of the list by the
	 * maintain a previous node to get tail before node. Once coming from the
	 * loop make previous element next node as null
	 * 
	 * @param newNode
	 */
	public synchronized void deleteAtEnd() {

		System.out.println("\n" + "InsertAtEnd Method is Running.." + "\n");

		if (head == null) {
			return;
		} else if (head.getNext() == null) {
			head = null;
		} else {

			DLLNode temp = head;
			DLLNode previousNode = null;

			while (temp.getNext() != null) {

				previousNode = temp;
				temp = temp.getNext();

			}
			previousNode.setNext(null);
		}
		length--;

		printHeadTailPeviousNextAndLength();
	}

	/**
	 * Algorithm
	 * 
	 * step 1: position is < 0 or > length return from the method.
	 * 
	 * step 2: If position = 0 then make newNode next node as head first, then
	 * make new node as Head node
	 * 
	 * step 3: Position is more than 0 then iterate head element using the given
	 * position value.
	 * 
	 * step 4: by the end of the for loop, create a new node the assign
	 * prev,next node from the iterator resultant
	 * 
	 * step 5: Make a iterator resultant node next node as a newNode.
	 * 
	 * @param newNode
	 */
	public synchronized void deletByPosition(int position) {

		if (position < 0 || position > length)
			return;

		System.out.println("\nDelete Process executing on " + position
				+ " position");

		if (position == 0) {
			head = null;
		} else {
			DLLNode temp = head;
			DLLNode prev = null;

			for (int i = 1; i < position; i++) {

				prev = temp;
				temp = temp.getNext();
			}

			prev.setNext(temp.getNext());
			length--;
			System.out.println("\n" + printElements());

		}

	}

	/**
	 * Algorithm
	 * 
	 * step 1: Head node is null then return from the method
	 * 
	 * step 2: if head is equal to remove node then make head as null
	 * 
	 * step 3: Assign one temp node as head node and previous  node as null then Iterate it based on the node data.
	 * in the loop, assign previous node as temp and then make temp as temp next element.
	 * 
	 * step 4: Once node found, loop ends then assign previous node next node as temp.next value.
	 *  
	 * @param removeNode
	 */
	public synchronized void removeNodeMatched(DLLNode removeNode) {

		if (head == null)
			return;

		if (head.equals(removeNode)) {
			head = null;
		} else {

			DLLNode temp = head;
			DLLNode prev = null;

			while (temp.getData()!=removeNode.getData()) {

				prev = temp;
				temp = temp.getNext();

			}
			prev.setNext(temp.getNext());
			length--;
			System.out.println("\n" + printElements());
		}
	}

	/**
	 * Print Doubly Linked List elements as a form of [ 25<====> 20<====>
	 * 15<====> 10<====> 5<====> 30<====> null ]
	 * 
	 * @return
	 */
	public synchronized String printElements() {

		if (head == null) {
			return null;
		}

		String result = "\n" + "[";

		DLLNode temp = head;

		while (temp != null) {

			result = result + " [" + temp.getData() + "]<====>";
			temp = temp.getNext();

		}

		return result + " null ]";

	}

	/**
	 * Return first node (Head)value in the list
	 * 
	 * @return
	 */
	public synchronized int getHead() {
		if (head == null) {
			System.out.println("Sorry, your list was empty..");
			return 0;
		}
		return head.getData();
	}

	/**
	 * Return Last node (Tail)value in the list
	 * 
	 * @return
	 */
	public synchronized DLLNode getTail() {

		if (head == null)
			return null;

		DLLNode temp = head;

		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		tail = temp;

		return tail;
	}

	/**
	 * // Find Length of the Linked List
	 * 
	 * @return length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Remove all elements from the list
	 */
	public void clearList() {
		head = null;
		length = 0;
	}

	/**
	 * To Print Head,Tail,Previous,Next and Length of the List
	 */
	public void printHeadTailPeviousNextAndLength() {

		DLLNode tail = getTail();

		System.out.println("Head Element  value: " + getHead());
		System.out.println("Tail of the List is: " + tail.getData());
		System.out.println("Length of the Linked-List is: " + getLength());
	}
}
