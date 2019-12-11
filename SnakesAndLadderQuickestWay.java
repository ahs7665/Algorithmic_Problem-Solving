import java.util.ArrayList;
import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            int numberOfLadders = Integer.parseInt(sc.nextLine());

            ArrayList <Integer> ladderStartingPoints = new ArrayList <Integer> ();
            ArrayList <Integer> ladderEndingPoints = new ArrayList <Integer> ();
            ArrayList <Integer> snakeStartingPoints = new ArrayList <Integer> ();
            ArrayList <Integer> snakeEndingPoints = new ArrayList <Integer> ();

            for (int j = 0; j < numberOfLadders; j++) {

        String[] temp = sc.nextLine().split(" ");
        int src = Integer.parseInt(temp[0]);
        int dest = Integer.parseInt(temp[1]);

        ladderStartingPoints.add(src);
        ladderEndingPoints.add(dest);

            }

      int numberOfSnakes = Integer.parseInt(sc.nextLine());

            for (int j = 0; j < numberOfSnakes; j++) {
        String[] temp = sc.nextLine().split(" ");
        int src = Integer.parseInt(temp[0]);
        int dest = Integer.parseInt(temp[1]);

        snakeStartingPoints.add(src);
        snakeEndingPoints.add(dest);
            }

            State initialState = new State(1, 0);
            ArrayList <Integer> visited = new ArrayList <Integer> ();
            ArrayList <State> list = new ArrayList <State> ();
            list.add(initialState);
            visited.add(1);

            boolean isReached = false;
            while (!list.isEmpty()) {
                State top = list.get(0);
                list.remove(0);

                if (top.currentCell == 100) {
                    System.out.println(top.moves);
                    isReached = true;
                    break;
                }

                for (int j = 1; j <= 6; j++) {
                    int temp = top.currentCell + j;
                    int ladderIndex = ladderStartingPoints.indexOf(temp);
                    int snakeIndex = snakeStartingPoints.indexOf(temp);
                    if (ladderIndex != -1) {
                        temp = ladderEndingPoints.get(ladderIndex);
                    }
                    else if (snakeIndex != -1) {
                        temp = snakeEndingPoints.get(snakeIndex);
                    }
                    if (!visited.contains(temp)) {
                        list.add(new State(temp, top.moves + 1));
                        visited.add(temp);
                    }
                }
            }

            if(!isReached) {
                System.out.println(-1);
            }
        }

        sc.close();
    }

    public static class State {
        public int currentCell;
        public int moves;

        public State(int currentCell, int moves) {
            this.currentCell = currentCell;
            this.moves = moves;
        }

        public String toString() {
            return currentCell + " " + moves;
        }
    }

}
