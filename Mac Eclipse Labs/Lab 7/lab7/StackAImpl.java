package lab7;

import java.util.ArrayList;

public class StackAImpl <T> implements StackList <T>
{
	private ArrayList <T> list;

	public boolean isEmpty()
	{
		if(list.isEmpty())
			return true;

		else
			return false;
	}

	public int size()
	{
		return list.size();
	}

	/** places item on the top of this Stack
	 *pre: param element - item to be pushed
	 *post: element is on top of this stack if the stack is not full
	 */
	public void push(T element) 
	{
		int index=0;
		list.add(index, element);
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

		else
		{
			T item=list.get(0);
			list.remove(0);
			return item;
		}
	}

	public T peek() 
	{
		T item=list.get(0);
		return item;
	}

	public void clear() 
	{
		list.clear();
	}


	public boolean isFull()
	{
		if(list.size()==5)
		{
			return true;
		}
		else
			return false;
	}

}
