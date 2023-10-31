package meeting15;

/**
 * This class demonstrates how to use DynamicArray objects.
 * 
 * @author Prof. Parker
 * @version October 23, 2023
 */
public class DynamicArrayDemo {

	public static void main(String[] args) {

		// Suppose that students are in the call queue to ask the TA a question.
		DynamicArray taCallQueue = new DynamicArray();
		
		// Three students enter the queue when TA help hours start.
		taCallQueue.append("Bob");
		taCallQueue.append("Susan");
		taCallQueue.append("Rogelio");

		// The TA helps the first student.
		System.out.println("The TA is helping: " + taCallQueue.getElement(0));
		taCallQueue.delete(0);
		System.out.println("There are " + taCallQueue.size() + " students remaining in the queue " + taCallQueue + ".");

		// Two more students enter the queue.
		taCallQueue.append("Min");
		taCallQueue.append("Riley");
		
		// The TA helps the next student.
		System.out.println("The TA is helping: " + taCallQueue.getElement(0));
		taCallQueue.delete(0);
		System.out.println("There are " + taCallQueue.size() + " students remaining in the queue " + taCallQueue + ".");
		
		// Min solves her problem on her own and leaves the queue.
		taCallQueue.delete(1);
		
		// The TA helps the next student.
		System.out.println("The TA is helping: " + taCallQueue.getElement(0));
		taCallQueue.delete(0);
		System.out.println("There are " + taCallQueue.size() + " students remaining in the queue " + taCallQueue + ".");
	}
}