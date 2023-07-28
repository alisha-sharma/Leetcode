package queue;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    public static void main(String[] args) {
        String senate = "RRDD";
        System.out.println("Winner: " + predictPartyVictoryUsingDoubleQueue(senate));
    }

    public static String predictPartyVictoryUsingDoubleQueue(String senate){
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();

        int i = 0;
        for(char ch : senate.toCharArray()){
            if(ch == 'R') rQueue.add(i);
            else dQueue.add(i);
            i++;
        }

        while(!rQueue.isEmpty() && !dQueue.isEmpty()){
            int rIndex = rQueue.poll();
            int dIndex = dQueue.poll();
            if(rIndex < dIndex) rQueue.add(i);
            else dQueue.add(i);
            i++;
        }

        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}
