package SWEA_7465_창용마을무리의개수_10w;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {
	 
    static int n,m;
    static int[] p;

    static int getParent(int x) {
    	if (p[x]==x) return x;
    	else return p[x] = getParent(p[x]);
    }
    
    static void unionParent(int x, int y) {
      x = getParent(x);
      y = getParent(y);
      
      if(x<y) 
    	  p[y]=x;
      else 
    	  p[x]=y;
    }
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

     
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {

            int answer=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            p = new int[n+1];
            for(int i=1; i<=n; i++) {
            	p[i] = i;
            }
            

            for(int i=0; i<m; i++) {    
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                unionParent(x,y);
            }
             System.out.println(Arrays.toString(p));
            //부모 값이 자기 자신과 같은 것의 개수가 그룹의 개수
            for(int i=1; i<=n;i++) {
            	if(p[i]==i) {
            		answer++;
            	}
            }
            System.out.println("#"+t+" "+answer);
        }

    }
}
