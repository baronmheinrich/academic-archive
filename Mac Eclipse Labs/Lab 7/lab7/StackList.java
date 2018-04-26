package lab7;

public interface StackList <T> 
{
	// max number of allowable elements on a Stack
	 public static final int MAX_ELEMENTS=5;
	/** pre: none, tests to see if the Stack has 0 elements
	 *  post: return true if the Stack is empty (has 0 elements) false otherwise;
	 */
	  public boolean isEmpty();
	/**pre: none, tests to see if this stack is full, 
	        full is true if size has reached MAX_ELEMENTS(you define this constant) 
	   post: returns true if size has reached MAX_ELEMENTS, false if not
	   **/
	  
	  public boolean isFull();

	/** pre: none, returns number of elements currently on this Stack
	 * post: returns  number of elements on this Stack
	 */
	  public int size();

	/** places item on the top of this Stack
	 *pre: param element - item to be pushed
	 *post: element is on top of this stack if the stack is not full
	 */
	  public void push(T element);

	/** pre: stack is NOT empty
	   post: removes and returns the top item from this Stack if this Stack is
	 *      not empty. 
	 * @throws - RuntimeException if attempt to pop an empty stack.
	 * @return - the object that was popped from the top of the stack. 
	 */
	  public T pop();

	/** pre: stack is not empty
	  *returns the top item from this Stack if this Stack is
	 * not empty.  DOES NOT POP IT.
	 * @throws - RuntimeException if attempt to peek at an empty stack.
	 * @return - object that is currently on the top of the stack
	 */
	  public T peek();

	/** pre: none
	    post: removes all items from this Stack, making it empty.
	 */
	  public void clear();

}
