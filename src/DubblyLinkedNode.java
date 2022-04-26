
public class DubblyLinkedNode {
	public DubblyLinkedNode prev;
	public DubblyLinkedNode next;
	public String str;
	
	public DubblyLinkedNode(String str, DubblyLinkedNode prev, DubblyLinkedNode next){
		this.prev = prev;
		this.next = next;
		this.str = str;
	}
	
	public DubblyLinkedNode addHead(String str)
	{
		DubblyLinkedNode headNode = new DubblyLinkedNode(str, this, next);
		next = headNode;
		return headNode;
	}
	
	public DubblyLinkedNode addTail(String str)
	{
		DubblyLinkedNode tailNode = new DubblyLinkedNode(str, prev, this);
		next = tailNode;
		return tailNode;
	}
}
