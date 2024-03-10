package SWEA_4014;

import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int X = sc.nextInt();
 
            int[][] arr = new int[N][N];
 
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    arr[r][c] = sc.nextInt();
                }
            }
 
            int cnt = 0;
 
            start: for (int r = 0; r < N; r++) {
                int[] tmp = new int[N];
                boolean[] slope = new boolean[N];
                for (int c = 0; c < N; c++) {
                    tmp[c] = arr[r][c];
                }
                for (int i = 0; i < N - 1; i++) { // 정방향
                    if (tmp[i] == tmp[i + 1] || tmp[i] == tmp[i + 1] + 1) {
                        continue;
                    } else if (tmp[i] == tmp[i + 1] - 1) {
 
                        if (i - X + 1 < 0) {
                            continue start;
                        }
                        for (int j = 0; j < X - 1; j++) {
                            if (tmp[i - j - 1] == tmp[i - j] && !slope[i - j - 1] && !slope[i - j]) {
 
                            } else {
                                continue start;
                            }
                        }
                        for (int j = 0; j < X - 1; j++) {
                            slope[i - j - 1] = true;
                            slope[i - j] = true;
 
                        }
                    } else {
                        continue start;
                    }
                }

                for (int i = N - 1; i >= 1; i--) { // 역방향
                    if (tmp[i] == tmp[i - 1] || tmp[i] == tmp[i - 1] + 1) {
                        continue;
                    } else if (tmp[i] == tmp[i - 1] - 1) {
 
                        if (i + X - 1 > N - 1) {
                            continue start;
                        }
 
                        for (int j = 0; j < X - 1; j++) {
                            if (tmp[i + j + 1] == tmp[i + j] && !slope[i + j + 1] && !slope[i + j]) {
 
                            } else {
                                continue start;
                            }
                        }
 
                        for (int j = 0; j < X - 1; j++) {
 
                            slope[i + j + 1] = true;
                            slope[i + j] = true;
 
                        }
                    } else {
                        continue start;
                    }
                }
                cnt++;
            }
 
            start: for (int c = 0; c < N; c++) {
                int[] tmp = new int[N];
                boolean[] slope = new boolean[N];
                for (int r = 0; r < N; r++) {
                    tmp[r] = arr[r][c];
                }
                for (int i = 0; i < N - 1; i++) { // 정방향
                    if (tmp[i] == tmp[i + 1] || tmp[i] == tmp[i + 1] + 1) {
                        continue;
                    } else if (tmp[i] == tmp[i + 1] - 1) {
 
                        if (i - X + 1 < 0) {
                            continue start;
                        }
                        for (int j = 0; j < X - 1; j++) {
                            if (tmp[i - j - 1] == tmp[i - j] && !slope[i - j - 1] && !slope[i - j]) {
 
                            } else {
                                continue start;
                            }
                        }
                        for (int j = 0; j < X - 1; j++) {
 
                            slope[i - j - 1] = true;
                            slope[i - j] = true;
 
                        }
                    } else {
                        continue start;
                    }
                }
                for (int i = N - 1; i >= 1; i--) { // 역방향
                    if (tmp[i] == tmp[i - 1] || tmp[i] == tmp[i - 1] + 1) {
                        continue;
                    } else if (tmp[i] == tmp[i - 1] - 1) {
 
                        if (i + X - 1 > N - 1) {
                            continue start;
                        }
 
                        for (int j = 0; j < X - 1; j++) {
                            if (tmp[i + j + 1] == tmp[i + j] && !slope[i + j + 1] && !slope[i + j]) {
 
                            } else {
                                continue start;
                            }
                        }
 
                        for (int j = 0; j < X - 1; j++) {
 
                            slope[i + j + 1] = true;
                            slope[i + j] = true;
 
                        }
                    } else {
                        continue start;
                    }
                }
                cnt++;
            }
 
            System.out.printf("#%d %d\n", test_case, cnt);
        }
    }
}