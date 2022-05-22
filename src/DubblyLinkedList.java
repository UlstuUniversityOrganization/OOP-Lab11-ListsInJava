
public class DubblyLinkedList {

	public DubblyLinkedNode tail = null;
	public DubblyLinkedNode head = null;
	public int size;
	
	
	public DubblyLinkedList(){
		
	}
	
	public void addHead(String str){
		
		if(size <= 0)
		{
			DubblyLinkedNode firstNode = new DubblyLinkedNode(str, null, null);
			tail = firstNode;
			head = firstNode;
		}
		else
		{
			DubblyLinkedNode node = new DubblyLinkedNode(str, head, null);
			head.next = node;
			head = node;
		}
		size++;
	}
	
	public void addTail(String str){
		
		if(size <= 0)
		{
			DubblyLinkedNode firstNode = new DubblyLinkedNode(str, null, null);
			tail = firstNode;
			head = firstNode;
		}
		else
		{
			DubblyLinkedNode node = new DubblyLinkedNode(str, null, tail);
			tail.prev = node;
			tail = node;
		}
		size++;
	}
	
	public void insert(int id, String str)
	{
		if(id > 0 && id < size)
		{
			DubblyLinkedNode node = getNode(id);
			node.addTail(str);
			size++;
		}
		else if(id >= size) {
			addHead(str);
		}
		else if(id <= 0) {
			addTail(str);
		}
	}
	
	public DubblyLinkedNode getNode(int id)
	{
		if(id > size / 2)
		{
			int i = size - 1;
			DubblyLinkedNode currentNode = head;
			while(i >= 0)
			{
				if(i == id)
					return currentNode;
				currentNode = currentNode.prev;
				i--;
			}
		}
		else
		{
			int i = 0;
			DubblyLinkedNode currentNode = tail;
			while(i < size)
			{
				if(i == id)
					return currentNode;
				currentNode = currentNode.next;
				i++;
			}
		}
		return null;
	}
	
	public String getData(int id)
	{
		DubblyLinkedNode node = getNode(id);
		if(node != null)
			return node.str;
		else
			return null;
	}
	
	public String getListElementsString(boolean reversed)
	{
		String outputStr = "";
		
		if(reversed)
		{
			for(int i = size - 1; i >= 0; i--) {
				outputStr = outputStr + getData(i);
				if(i != 0)
					outputStr = outputStr + ", ";
			}	
		}
		else
		{
			for(int i = 0; i < size; i++) {
				outputStr = outputStr + getData(i);
				if(i != size - 1)
					outputStr = outputStr + ", ";
			}		
		}
		return outputStr;
	}
	
	public void remove(int id)
	{
		if(size > 0)
		{
			if(tail != null && head != null)
			{
				if(id <= 0)
				{
					id = 0;
					tail = tail.getNext(1);
				}
				else if(id >= size)
				{
					id = size - 1;
					head = head.getPrev(1);
				}	
				else
				{
					DubblyLinkedNode node = getNode(id - 1);
					DubblyLinkedNode nextNode = node.getNext(2);
					if(nextNode != null) {
						node.next = nextNode;
						nextNode.prev = node;
					}
				}
				size--;
			}
		}			
	}
	
	public void removeFirstOccurrence(String str)
	{
		int i = 0;
		DubblyLinkedNode currentNode = tail;
		while(i < size)
		{
			if(str.equals(currentNode.str))
			{
				remove(i);
				/*
				size--;
				if(size > 0)
				{
					if(i == size - 1)
						head = currentNode.prev;
					if(i == 0)
						tail = currentNode.next;
				}else
				{
					head = null;
					tail = null;
				}
				remove(i);
				*/
				break;
			}
			currentNode = currentNode.next;
			i++;
		}
	}
}
