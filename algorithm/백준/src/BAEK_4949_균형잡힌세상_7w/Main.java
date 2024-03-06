package BAEK_4949_균형잡힌세상_7w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


import java.io.*;
import java.util.Stack;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;

            Stack<String> stack = new Stack<>();

            String[] sentence = str.split("");
            for(String word : sentence){
                switch (word) {
                    case ("("):
                    case ("["):
                        stack.push(word);
                        break;
                    case (")"):
                        if(!stack.isEmpty() && stack.peek().equals("("))
                            stack.pop();
                        else stack.push(")");
                        break;
                    case ("]"):
                        if(!stack.isEmpty() && stack.peek().equals("["))
                            stack.pop();
                        else stack.push("]");
                        break;
                }
            }

            if (stack.empty())
                bw.write("yes\n");
            else
                bw.write("no\n");

            bw.flush();
        }

    }
}