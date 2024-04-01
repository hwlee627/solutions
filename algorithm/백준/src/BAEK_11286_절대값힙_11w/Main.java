package BAEK_11286_절대값힙_11w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class  Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if(abs1 == abs2) {
            	if(o1>o2) {
            		return 1;
            	}else {
            		return -1;
            	}
            }
            return abs1 - abs2;
        });

        for(int i = 0 ; i < n; i++){
            int value = Integer.parseInt(br.readLine());
            if(value == 0){
                if(queue.isEmpty()) System.out.println("0");
                else System.out.println(queue.poll());
            }else{
                queue.add(value);
            }
        }
    }
}