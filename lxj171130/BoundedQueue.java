/**
 * @author Priyanka Awaraddi
 * @author Leejia James
 *
 * Implementing bounded-sized queue using arrays
 *
 * Ver 1.0: 2018/09/04
 */

package lxj171130;

import java.util.Scanner;

public class BoundedQueue<T> {
	int front, rear, size;
	int maxSize = 0;
	Object[] bqueue;
	
    /**
     * Creates new queue of given size
     */
	BoundedQueue(int size)
	{
		front = 0; rear = 0; this.size = 0;
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
		if(size() != maxSize)
		{
			bqueue[rear] = x;
			rear = (rear + 1 ) % maxSize;
			size++;
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
		Object temp = bqueue[front];
		bqueue[front] = null;
		front = (front + 1) % maxSize;
		size--;
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
		Object temp = bqueue[front];
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
		return size;
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
		return size == 0? true : false;
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
		size = 0; front = 0; rear = 0;
	}
	
	/**
	 * @author Priyanka Awaraddi
	 * 
	 * fill user supplied array with the elements of the queue, in queue order
	 * 
	 */
	void toArray(T[] a)
	{
		if (a.length < size())
			throw new ArrayIndexOutOfBoundsException();
		if (size() > 0) {
			int j = 0;
			if (front < rear) {
				for(int i=front; i<rear; i++) {
					a[j]=(T) bqueue[i];
					j++;
				}
			}
			else {
				for(int i=front; i<maxSize; i++) {
					a[j]=(T) bqueue[i];
					j++;
				}
				for(int i=0; i<rear; i++) {
					a[j]=(T) bqueue[i];
					j++;
				}
			}
		}	
		
		//Printing elements of user supplied array
		System.out.print("Array elements: ");
		for(T elem: a)
		{
			System.out.print(elem + " ");
		}
		System.out.println();
	}
	
	void printQueue()
	{
		System.out.print(size() + ": ");
		
		if(size() > 0) {
			if (front < rear) {
				for(int i=front; i<rear; i++) {
					System.out.print(bqueue[i] + " ");
				}
			}
			else {
				for(int i=front; i<maxSize; i++) {
					System.out.print(bqueue[i] + " ");
				}
				for(int i=0; i<rear; i++) {
					System.out.print(bqueue[i] + " ");
				}
			}
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
				System.out.println(bq.offer(elemAdd));
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
				bq.printQueue();
				break;				
			default:  // Exit loop
				break whileloop;
			}
		}
		bq.printQueue();
	}
}