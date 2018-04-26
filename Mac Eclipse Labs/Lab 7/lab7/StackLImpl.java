package lab7;


public class StackLImpl <T> implements StackList <T>
{

	private Node <T> first;
	private int count;

	//public class junk here
	public boolean isEmpty() 
	{
		if(count==0)
		{
			return true;
		}

		else
			return false;

	}

	public int size() 
	{
		return count;
	}

	public void push(T element) 
	{
		if(size()==5)
		{
			return;
		}

		Node<T> node=new Node<T>();
		node.data=element;
		node.link=this.first;
		this.first=node;
		this.count ++;
	}
	/** pre: stack is NOT empty
	   post: removes and returns the top item from this Stack if this Stack is
	 *      not empty. 
	 * @throws - RuntimeException if attempt to pop an empty stack.
	 * @return - the object that was popped from the top of the stack. 
	 */
	public T pop() 
	{
		if(this.isEmpty())
		{
			throw new RuntimeException();
		}

		T item=this.first.data;
		this.first=this.first.link;


		return item;
	}

	public T peek()
	{
		if(this.isEmpty())
		{
			throw new RuntimeException();
		}
		return this.first.data;
	}

	public void clear() 
	{
		this.first=null;
		this.count=0;
	}

	public boolean isFull()
	{
		if(this.count==5)
		{
			return true;
		}
		else
			return false;
	}

}

