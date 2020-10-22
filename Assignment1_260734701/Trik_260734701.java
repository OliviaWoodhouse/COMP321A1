package kattis;
import java.util.*;

public class Trik_260734701 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String movesString = sc.next();
        char[] moves = movesString.toCharArray();
        int location = 1;
        for (int i=0; i<moves.length; i++) {
        	//Checks the location and the current move before making the appropriate changes
            if (moves[i] == 'A'&& location == 1) {
                location = 2;
            } else if (moves[i] == 'A' && location == 2) {
                location = 1;
            } else if (moves[i] == 'A' && location == 3) {
                location = 3;
            } else if (moves[i] == 'B' && location == 1) {
                location = 1;
            } else if (moves[i] == 'B' && location == 2) {
                location = 3;
            } else if (moves[i] == 'B' && location == 3) {
                location = 2;
            } else if (moves[i] == 'C' && location == 1) {
                location = 3;
            } else if (moves[i] == 'C' && location == 2) {
                location = 2;
            } else if (moves[i] == 'C' && location == 3) {
                location = 1;
            }
        }
        sc.close();
        System.out.println(location);
    }
}
