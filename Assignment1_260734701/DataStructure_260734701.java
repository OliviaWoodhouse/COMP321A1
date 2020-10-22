package kattis;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;


public class DataStructure_260734701 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String parser;
		
		
		ArrayList<Integer> operations = new ArrayList<>();
		
		
		while((parser = in.readLine()) != null) {
			int n = Integer.parseInt(parser);
			if (n < 1 || n > 1000) {
				System.out.println("The number of commands must be greater than or equal to 1 and less than or equal to 1000!");
				System.exit(0);
			}
			
			//Creates each data structure to compare with our input commands
			PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(n, Collections.reverseOrder());
			Stack<Integer> stack = new Stack<Integer>();
			Queue<Integer> queue = new LinkedList<Integer>();
			
			boolean stackCheck = true;
			boolean queueCheck = true;
			boolean pQueueCheck = true;
			
			for (int i = 0; i < n; i++) {
				//Stores each line of input in operations arraylist
				String[] input = in.readLine().split(" ");
				for (String s : input) {
					if (!s.isEmpty()) {
						operations.add(Integer.parseInt(s));
					}
				}
				
				int x = operations.get(1);
				if (x < 0 || x > 100) {
					System.out.println("Each integer value must be positive and not larger than 100!");
					System.exit(0);
				}
				//if command is type 1, simply add the element to each data structure
				if (operations.get(0) == 1) {
					stack.add(x);
					queue.add(x);
					pQueue.add(x);
				//if command is type 2, check if each data structure performs the same as the command
				} else if (operations.get(0) == 2) {
					if (stackCheck) {
						if (stack.isEmpty()) {
							stackCheck = false;
						} else {
							if (stack.peek() != x) {
								stackCheck = false;
							} else {
								stack.pop();
							}
						}
					}
					if (queueCheck) {
						if (queue.isEmpty()) {
							queueCheck = false;
						} else {
							if (queue.peek() != x) {
								queueCheck = false;
							} else {
								queue.poll();
							}
						}
					}
					if (pQueueCheck) {
						if (pQueue.isEmpty()) {
							pQueueCheck = false;
						} else {
							if (pQueue.peek() != x) {
								pQueueCheck = false;
							} else {
								pQueue.poll();
							}
						}
					}
				} else {
					System.out.println("Must enter a valid command type!");
					System.exit(0);
				}
				operations.clear();
			}
			//use our booleans to see if any of the data structures have been "discounted"
			if (!stackCheck && !queueCheck && !pQueueCheck) {
				out.append("impossible\n");
			} else if (stackCheck && !queueCheck && !pQueueCheck) {
				out.append("stack\n");
			} else if (queueCheck && !stackCheck && !pQueueCheck) {
				out.append("queue\n");
			} else if (pQueueCheck && !stackCheck && !queueCheck) {
				out.append("priority queue\n");
			} else {
				out.append("not sure\n");
			}
			out.flush();
			
		}
	}
}

