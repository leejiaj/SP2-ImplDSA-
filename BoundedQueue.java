package PXA172130;

import java.util.Scanner;

public class BoundedQueue<T> {
	int rear =0;
	int maxSize = 0;
	Object[] bqueue;
	
	BoundedQueue(int size)
	{
		maxSize = size;
		bqueue = new Object[size];		
	}
	
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
	
	T peek()
	{
		return null;
	}
	
	int size()
	{
		return rear;
	}
	
	boolean isEmpty()
	{
		return rear==0? true : false;
	}
	
	void clear()
	{
		
	}
	
	void toArray(T[] a)
	{
		
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
		
		BoundedQueue<Integer> b1 = new BoundedQueue<>(10);
		for(int i=1; i<=n; i++) {
			b1.offer(Integer.valueOf(i));
		}
		b1.printQueue();
		
		Scanner in = new Scanner(System.in);
		whileloop:
		while(in.hasNext()) {
			int com = in.nextInt();
			switch(com) {
			case 1:  // Add a new element x at the rear of the queue
				int elemAdd = in.nextInt();
				b1.offer(elemAdd);
				b1.printQueue();
				break;
			case 2:  // Remove and return the element at the front of the queue
				System.out.println(b1.poll());
				b1.printQueue();
				break;
			default:  // Exit loop
				break whileloop;
			}
		}
		b1.printQueue();
	}
}
