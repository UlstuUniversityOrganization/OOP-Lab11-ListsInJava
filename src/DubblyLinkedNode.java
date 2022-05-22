
public class DubblyLinkedNode {
	public DubblyLinkedNode prev;
	public DubblyLinkedNode next;
	public String str;
	
	public DubblyLinkedNode(){
	}
	
	public DubblyLinkedNode(String str, DubblyLinkedNode prev, DubblyLinkedNode next){
		this.prev = prev;
		this.next = next;
		this.str = str;
		
	}
	
	public DubblyLinkedNode addHead(String str)
	{
		DubblyLinkedNode headNode = new DubblyLinkedNode(str, this, next);
		next.prev = headNode;
		next = headNode;
		return headNode;
	}
	
	public DubblyLinkedNode addTail(String str)
	{
	
		DubblyLinkedNode tailNode = new DubblyLinkedNode(str, prev, this);
		if(prev != null) {
			prev.next = tailNode;
		}
		prev = tailNode;
		return tailNode;
	}
	
	public DubblyLinkedNode getNext(int offset)
	{
		int i = 0;
		DubblyLinkedNode currentNode = this;
		while(i < offset)
		{
			if(currentNode.next == null)
				return null;
			currentNode = currentNode.next;
			i++;
		}
		return currentNode;
	}
	
	public DubblyLinkedNode getPrev(int offset)
	{
		int i = 0;
		DubblyLinkedNode currentNode = this;
		while(i < offset)
		{
			if(currentNode.prev == null)
				return null;
			currentNode = currentNode.prev;
			i++;
		}
		return currentNode;
	}
}
