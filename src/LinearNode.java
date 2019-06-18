/**
 * This is our class LinearNode which contains 2 constructors, one empty one and one pre-defined
 * It also contains 4 methods, one which returns the next node, another method which sets the next node
 * Another method which returns the element and one last method which sets the element
 * 
 * @author Eric Jivraj
 * @author Mohammed Sohiel
 * @author Ruhi Begum
 * @version 14/12/2017
 */

public class LinearNode<T> {
	
	private T element;
	private LinearNode<T> next;
	
	public LinearNode()
	{
		next = null;
		element = null;
	}
		
	public LinearNode(T someElement)
	{
		next = null;
		element = someElement;
	}
	
	/**
	 * This method returns the next node
	 * @return the next node of LinearNode<T>
	 */
	
	public LinearNode<T> getNext()
	{
		return next;
	}
	
	/**
	 * This method allows us to set the next node
	 * @param node which is of type LinearNode<T>
	 */
	
	public void setNext (LinearNode<T> node)
	{
		next = node;
	}
	
	/**
	 * This method returns an element
	 * @return element 
	 */
	
	public T getElement()
	{
		return element;
	}
	
	/**
	 * This method allows us to set the next element
	 * @param someElement which is of type T
	 */
	
	public void setElement (T someElement)
	{
		element = someElement;
	}
		
}