/**
 * @author Priyanka Awaraddi
 * @author Leejia James
 *
 * Implementing bounded-sized queue using arrays
 *
 * Ver 1.0: 2018/09/04
 */

package PXA172130;

import java.util.Scanner;

public class BoundedQueue<T> {
	int rear =0;
	int maxSize = 0;
	Object[] bqueue;
	
    /**
     * Creates new queue of given size
     */
	BoundedQueue(int size)
	{
		maxSize = size;
		bqueue = new Object[size];		
	}
	
    /**
     * @author Priyanka Awaraddi
     *
     * Inserts a new element x at the rear of the queue
     *
     * @param x element to add
     * 
     * @return true if the element is added, false if the element 
     * is not added because the queue is full
     */
	boolean offer(T x)
	{
		if(rear<maxSize)
		{
			bqueue[rear] = x;
			rear++;
			return true;
		}
		return false;
	}
	
	/**
	 * @author Leejia James
	 * 
	 * Removes the element at the front of the queue
	 * 
	 * @return element at the front of the queue, null if the queue
	 * is empty
	 */
	T poll()
	{
		if(isEmpty()) {
			return null;
		}
		Object temp = bqueue[0];
		for(int i=0; i<rear-1; i++) {
			bqueue[i] = bqueue[i+1];
		}
		rear--;
		return (T) temp;
	}
	
	/**
	 * @author Priyanka Awaraddi
	 * 
	 * Returns the front element without removing it
	 * 
	 * @return element at the front of the queue, null if the queue
	 * is empty
	 */
	T peek()
	{
		if(isEmpty()) {
			return null;
		}
		Object temp = bqueue[0];
		return (T) temp;
	}
	
	/**
	 * @author Priyanka Awaraddi
	 * @author Leejia James
	 * 
	 * Finds the number of elements in the queue
	 * 
	 * @return the number of elements in the queue
	 */
	int size()
	{
		return rear;
	}
	
	/**
	 * @author Priyanka Awaraddi
	 * @author Leejia James
	 * 
	 * Checks if the queue is empty
	 * 
	 * @return true if queue is empty, false otherwise
	 */
	boolean isEmpty()
	{
		return rear == 0? true : false;
	}
	
	/**
	 * @author Leejia James
	 * 
	 * Clears the queue (size=0)
	 * 
	 */
	void clear()
	{
		for (Object obj: bqueue) {
			obj = null;
		}
		rear = 0;
	}
	
	/**
	 * @author Priyanka Awaraddi
	 * 
	 * fill user supplied array with the elements of the queue, in queue order
	 * 
	 */
	//what is the size of user array .? if its less than queue how to fill it.?
	void toArray(T[] a)
	{
		for(int i=0; i<rear; i++) {
			a[i]=(T) bqueue[i];
		}
	}
	
	void printQueue()
	{
		System.out.print(size() + ": ");
		for(int i=0; i<rear; i++) {
			System.out.print(bqueue[i] + " ");
		}

		System.out.println();
	}
	
	public static void main(String args[])
	{
		int n = 5;
		if(args.length > 0) {
			n = Integer.parseInt(args[0]);
		}
		
		BoundedQueue<Integer> bq = new BoundedQueue<>(10);
		for(int i=1; i<=n; i++) {
			bq.offer(Integer.valueOf(i));
		}
		bq.printQueue();
		
		Scanner in = new Scanner(System.in);
		whileloop:
		while(in.hasNext()) {
			int com = in.nextInt();
			switch(com) {
			case 1:  // Add a new element x at the rear of the queue
				int elemAdd = in.nextInt();
				bq.offer(elemAdd);
				bq.printQueue();
				break;
			case 2:  // Remove and return the element at the front of the queue
				System.out.println(bq.poll());
				bq.printQueue();
				break;
			case 3:  // Return front element, without removing it 	
				System.out.println(bq.peek());
				bq.printQueue();
				break;
			case 4:  // Return the number of elements in the queue 
				System.out.println(bq.size());
				bq.printQueue();
				break;
			case 5:  // Check if the queue is empty
				System.out.println(bq.isEmpty());
				bq.printQueue();
				break;
			case 6:  // Clear the queue (size=0)
				bq.clear();
				bq.printQueue();
				break;
			case 7:  // fill user supplied array with the 
					// elements of the queue, in queue order
				Integer[] a = new Integer[bq.size()];
				bq.toArray(a);
				for(Integer i: a)
				{
					System.out.println(i);
				}
				bq.printQueue();
				break;				
			default:  // Exit loop
				break whileloop;
			}
		}
		bq.printQueue();
	}
}