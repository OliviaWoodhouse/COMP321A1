package kattis;
import java.util.*;

public class FlexibleSpaces_260734701 {
	//Returns the distinct widths that can be achieved for a meeting space
	public static int[] width(int[] partitions, int w) {
		int[] widths = new int[w];
		//Partitions can NOT be moved but can be removed/replaced
		Arrays.sort(partitions);
		for (int i = 0; i < partitions.length; i++) {
			int width1 = partitions[i];
			int width2 = w-partitions[i];
			widths[width1-1] = width1;
			widths[width2-1] = width2;
			for (int j = 0; j < partitions.length; j++) {
				if (j != i) {
					int width3 = Math.abs(partitions[j]-partitions[i]);
					widths[width3-1] = width3;
				}
			}
		}
		
		
		
		return widths;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		if (w < 2 || w > 100) {
			System.out.println("The overall width of the room must be greater than or equal to 2 and less than or equal to 100!");
			System.exit(0);
		}
		int p = sc.nextInt();
		if (p < 1 || p >= w) {
			System.out.println("The number of intermediate partitions in the room must be greater than or equal to 1 and less than the room's width!");
			System.exit(0);
		}
		int[] partitions = new int[p];
		for (int i = 0; i < p; i++) {
			partitions[i] = sc.nextInt();
			if (partitions[i] <= 0 || partitions[i] >= w) {
				System.out.println("Each partition's location must be greater than 0 and less than the room's width!");
				System.exit(0);
			}
		}
		int[] widths = width(partitions, w);
		//Need to print out only valid entries in widths output
		for (int i = 0;i < widths.length; i++) {
			if (widths[i] != 0) {
				System.out.print(widths[i]+ " ");
			}
		}
		System.out.println(w+" ");
		sc.close();
	}
}

