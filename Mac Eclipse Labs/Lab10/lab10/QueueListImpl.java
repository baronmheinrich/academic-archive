package lab10;

public class QueueListImpl<T> implements QueueList<T> 
{
	private int count;
	private Node<T> first;
	private Node<T> last;
	private int MAX_SIZE;

	//pre: n/a
	//post: default constructor
	public QueueListImpl()
	{
		this.count=0;
		this.first=null;
		this.last=null;
		this.MAX_SIZE=5;
	}

	//pre: n/a
	//post: returns boolean value if list is empty or not
	public boolean isEmpty()
	{
		if(this.size()==0)
		{
			return true;
		}
		else
			return false;
	}

	//pre: n/a
	//post: returns boolean if list is full or not
	public boolean isFull() 
	{
		if(this.size()==5)
		{
			return true;
		}
		else
			return false;
	}

	//pre: n/a
	//post: returns count
	public int size() 
	{
		return count;
	}

	//pre:n/a
	//post: returns maximium size of list
	public int getMaxSize() 
	{
		return MAX_SIZE;
	}


	/** sets max allowable elements in this Queue
	 * truncates queue (at tail or rear) if max allowable is
	 *  less than current size of this Queue
	 *  @param - newSize - max allowable elements to set max to.
	 */
	//pre: newSize
	//post: sets Max size
	public void setMaxSize(int newSize) 
	{
	

		if(newSize<count)
		{
			Node <T> previous = null;
			Node <T> current =this.first;
			for(int i=0; i<newSize; i++)
			{
				previous=current;
				current=current.link;
			}
			
			this.last=previous;
			this.last.data=previous.data;
			this.last.link=null;
			current=null;
			
		
			this.count=newSize;
			this.MAX_SIZE=newSize;
		}
		else
		{
			this.MAX_SIZE=newSize;
		}
	}


	/** places item at the end (rear or tail) of this Queue
	 *  inserts item at end of this Queue returns true if room to add
	 *  false if this queue is full.  
	 *@param element - item to be inserted at rear of this Queue
	 *@return - true if add is successful, false otherwise
	 */
	//pre: T elements
	//adds element to queue if queue is not full
	public boolean add(T element)
	{
		if(this.isFull())
		{
			throw new RuntimeException();
		}
		Node<T> node = new Node<T>();
		node.data=element;

		if(this.isEmpty())
		{
			this.first=node;
			this.last=node;
			count ++;
		}

		else
		{
			this.last.link=node;
			this.last=node;
			this.count++;
		}

		return true;
	}

	//pre: n/a
	//post: removes item from queue if it's not full
	public T remove()
	{
		if(this.isEmpty())
		{
			throw new RuntimeException();
		}

		T item=this.first.data;
		this.first=this.first.link;
		if(this.first==null)
		{
			this.last=null;
			this.count --;
		}
		return item;
	}

	//pre: n/a
	//post: returns the first T thing in the queue
	public T front() 
	{
		if(this.isEmpty())
		{
			throw new RuntimeException();
		}
		else
			return this.first.data;
	}

	//pre: n/a
	//post: returns last T thing in the queue
	public T last() 
	{
		if(this.isEmpty())
		{
			throw new RuntimeException();
		}

		else
		{
			return this.last.data;
		}
	}

	//pre: n/a
	//post: clears the list by setting private values to defaults
	public void clear()
	{
		this.first=null;
		this.last=null;
		this.count=0;
		this.MAX_SIZE=5;
	}

	//pre: n/a
	//post: returns a string of the list
	public String toString()
	{
		String empty="";
		String blank="";

		if(this.isEmpty())
		{
			empty="Empty queue...";
			return empty;
		}
		else
		{
			Node <T> current =this.first;
			for(int i=0; i<getMaxSize(); i++)
			{
				blank=blank+current.data +"\n";
				current=current.link;

			}
			return blank;
		}
	}

}
