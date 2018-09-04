package PXA172130;

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
		return null;
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
		for(Object obj: bqueue)
		{
			System.out.println(obj);
		}
	}
	
	public static void main(String args[])
	{
		BoundedQueue<Integer> b1 = new BoundedQueue<>(4);
		b1.offer(1);
		b1.offer(2);
		System.out.println("size:"+b1.size());
		b1.printQueue();
	}
}
