package week10.SinglyLinkedList;

import week10.SinglyLinkedList.ListException.ListErrorCode;

public class SinglyLinkedList<T> {
	private ListElement<T> head = null;

	public boolean isEmpty() {
		return (head == null);
	}

	public void add(int position, T o) throws ListException {
		// TODO: Add code from lecture here
	}

	public T get(int position) throws ListException {
		if (position < 0) throw new ListException(ListErrorCode.PositionTooSmall);
		ListElement<T> cursor = head;
		for (int pos = 0; pos < position; pos++) {
			if (cursor == null) throw new ListException(ListErrorCode.PositionTooLarge);
			cursor = cursor.next;
		}
		if (cursor == null) throw new ListException(ListErrorCode.PositionTooLarge);
		return cursor.getData();
	}

	public T remove(int position) throws ListException {
		// TODO: Exercise
		return null;
	}
	
	public int size() {
		// TODO: Exercise
		return 0;
	}
	
	public boolean contains(T elt) {
		// TODO: Exercise
		return false;
	}
}
