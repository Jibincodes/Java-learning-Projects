package week10.SinglyLinkedList;
//--------------------------------------------------------------
//This has been extended to here as per as the question
//-------------------------------------------------------------


public class ListElement<T> {
	private final T data; // in our current implementation, this is unchangeable
	ListElement<T> next = null; // package-private - used directly by the main list class
	
	/**
	 * Constructor protected; could be needed by a subclass
	 */
	protected ListElement(T data) {
		this.data = data;
	}
	
	/**
	 * Protected; could be needed by a subclass
	 */
	protected T getData() {
		return data;
	}

}
