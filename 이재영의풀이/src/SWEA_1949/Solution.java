package SWEA_1949;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
// 등산로조성
 
public class Solution {
 
    static int N;
    static int K;
    static int cnt = 1;
    static int max = 1;
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            max = 0;
            N = sc.nextInt();
            K = sc.nextInt();
            int[][] arr = new int[N][N];
 
            int highest = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    int num = sc.nextInt();
                    arr[r][c] = num;
                    if (num > highest) {
                        highest = num;
                    }
                }
            }
            List<Integer> listR = new ArrayList<>();
            List<Integer> listC = new ArrayList<>();
 
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (arr[r][c] == highest) {
                        listR.add(r);
                        listC.add(c);
                    }
                }
            }
 
            for (int i = 0; i <= K; i++) {
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        arr[r][c] -= i;
 
//                      for (int nr = 0; nr < N; nr++) {
//                          for (int nc = 0; nc < N; nc++) {
//                              cnt = 1;
//                              func(nr, nc, arr);
//                          }
//                      }
                         
                        for(int j=0;j<listR.size();j++) {
                            cnt = 1;
                            func(listR.get(j),listC.get(j),arr);
                        }
 
                        arr[r][c] += i;
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, max);
        }
    }
 
    static void func(int r, int c, int[][] arr) {
 
//      System.out.println(r+" "+c+" "+cnt);
 
        if (r + 1 < N && arr[r][c] > arr[r + 1][c]) {
            cnt++;
            func(r + 1, c, arr);
        }
        if (r - 1 >= 0 && arr[r][c] > arr[r - 1][c]) {
            cnt++;
            func(r - 1, c, arr);
        }
        if (c + 1 < N && arr[r][c] > arr[r][c + 1]) {
            cnt++;
            func(r, c + 1, arr);
        }
        if (c - 1 >= 0 && arr[r][c] > arr[r][c - 1]) {
            cnt++;
            func(r, c - 1, arr);
        }
        if (cnt > max) {
            max = cnt;
        }
        cnt -= 1;
        return;
    }
}