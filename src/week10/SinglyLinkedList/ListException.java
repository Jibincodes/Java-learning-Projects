package week10.SinglyLinkedList;

// extended as per as the question

public class ListException extends Exception {
	enum ListErrorCode { PositionTooSmall, PositionTooLarge; }

	public ListException(ListErrorCode error) {
		super(error.toString());
	}
} 
