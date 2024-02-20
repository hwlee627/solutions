package BAEK_2775_부녀회장이될테야_5w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case = 1; test_case<=T; test_case++){
            int floor = sc.nextInt();
            int roomNum = sc.nextInt();
            int[] peopleZeroFloor = new int[15];
            int[] peopleOtherFloor = new int[15];
            for(int i = 1; i<15; i++){
                peopleZeroFloor[i] = i;
            }
            for(int t = 0; t<floor; t++){
                int peopleCnt = 0;
                if(t == 0){
                    for(int i = 1; i<=roomNum; i++){
                        
                        peopleCnt += peopleZeroFloor[i];
                        peopleOtherFloor[i] = peopleCnt;
                    }
                    
                }else{
                    for(int i = 1; i<=roomNum; i++){
                        peopleCnt += peopleOtherFloor[i];
                        peopleOtherFloor[i] = peopleCnt;
                    }
                }
                // System.out.println(Arrays.toString(peopleOtherFloor));
                
            }
            
            System.out.println(peopleOtherFloor[roomNum]);
        }
        
    }
}
