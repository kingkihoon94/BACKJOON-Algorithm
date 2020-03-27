

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1939_중량제한_200321 {
   static class LinkNode implements Comparable<LinkNode> {
      int v1;
      int v2;
      int cost;
      LinkNode(int v1, int v2, int cost) {
         this.v1 = v1;
         this.v2 = v2;
         this.cost = cost;
      }
      public int compareTo(LinkNode o) {
         if(o.cost > this.cost) return 1;
         else if (o.cost == this.cost) return 0;
         else return -1;
      }
   }
   static int[] parent;
   static boolean[] visited;
   static List<LinkNode> list;
   static int start, end, ans;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      list = new ArrayList<>();
      parent = new int[n + 1];
      visited = new boolean[n + 1];
      for(int i = 1; i <= n; i++) parent[i] = i;
      
      for(int i = 0; i < m; i++) {
         st = new StringTokenizer(br.readLine(), " ");
         int v1 = Integer.parseInt(st.nextToken());
         int v2 = Integer.parseInt(st.nextToken());
         int cost = Integer.parseInt(st.nextToken());
         list.add(new LinkNode(v1, v2, cost));
      }
      st = new StringTokenizer(br.readLine(), " ");
      start = Integer.parseInt(st.nextToken());
      end = Integer.parseInt(st.nextToken());
      
      Collections.sort(list);
      
      for(int i = 0; i < list.size(); i++) {
         if(visited[start] && visited[end] && find(start) == find(end)) break;
         LinkNode ln = list.get(i);
         if(!isSameParent(ln.v1, ln.v2)) {
            visited[ln.v1] = true;
            visited[ln.v2] = true;
            ans = ln.cost;
            union(ln.v1, ln.v2);
         }
      }
      
      if(parent[start] != parent[end]) ans = 0;
      
      System.out.println(ans);
      
   }
   
   public static int find(int x) {
      if(x == parent[x]) return x;
      else return parent[x] = find(parent[x]);
   }
   
   public static void union(int x, int y) {
      x = find(x);
      y = find(y);
      if(x != y) parent[y] = x;
   }
   
   public static boolean isSameParent(int x, int y) {
      x = find(x);
      y = find(y);
      if(x != y) {
    	  return false;
      }
      else {
    	  return true;
      }
   }
}