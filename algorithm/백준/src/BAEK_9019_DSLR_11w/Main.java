package BAEK_9019_DSLR_11w;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Register {
        int num;
        String command;
        
        Register(int num, String command) {
            this.num = num;
            this.command = command;
        }
        
        int D() {
            return (num * 2) % 10000;
        }
        int S() {
        	if(num == 0) {
        		return 9999;
        	}else {
        		return num - 1;
        	}
        }
        int L() {
            return num % 1000 * 10 + num / 1000;
        }
        int R() {
            return num % 10 * 1000 + num / 10;
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int A = sc.nextInt();
            int	B = sc.nextInt();
            
            boolean[] visit = new boolean[10000]; //0~9999
            visit[A] = true;
            
            Queue<Register> q = new LinkedList<>();
            q.add(new Register(A, ""));

//            String ans = "";
            while (!q.isEmpty()) {
                Register curr = q.poll();

                if (curr.num == B) {
                    System.out.println(curr.command);
                    break;
                }

                if (!visit[curr.D()]) {
                    q.add(new Register(curr.D(), curr.command + "D"));
                    visit[curr.D()] = true;
                }
                if (!visit[curr.S()]) {
                    q.add(new Register(curr.S(), curr.command + "S"));
                    visit[curr.S()] = true;
                }
                if (!visit[curr.L()]) {
                    q.add(new Register(curr.L(), curr.command + "L"));
                    visit[curr.L()] = true;
                }
                if (!visit[curr.R()]) {
                    q.add(new Register(curr.R(), curr.command + "R"));
                    visit[curr.R()] = true;
                }

            }
        }

    }


}
