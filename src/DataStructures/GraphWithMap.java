package DataStructures;

import java.util.*;

/**
 * Created by vineet on 7/6/17.
 */
public class GraphWithMap {
    HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
    int root = -1;

    public static void main(String[] args){
        GraphWithMap gr = new GraphWithMap();
        gr.insert(1,2);
        gr.insert(1,3);
        gr.insert(2,4);
        gr.insert(2,5);
        gr.insert(3,6);
        gr.insert(3,7);
        gr.insert(3,5);

        //gr.bfs(gr.root);
        HashSet<Integer> hs = new HashSet<>();
        System.out.println();
        //gr.dfs(gr.root, hs);
        Stack<Integer> stack = new Stack<>();
        gr.topologicalSort(gr.root, stack, hs);

        while(!stack.empty()){
            System.out.print(stack.pop());
        }

    }
    public void insert(int a, int b){
        if(root == -1)
            root = a;
        if(!hm.containsKey(a))
            hm.put(a, new ArrayList<>());
        if(!hm.containsKey(b))
            hm.put(b, new ArrayList<>());
        hm.get(a).add(b);
    }

    public void bfs(int root){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(root);
        while(!q.isEmpty()){
            int temp = q.remove();
            System.out.print(temp+" ");
            Iterator it =hm.get(temp).listIterator();
            while(it.hasNext()){
                int ele = (int)it.next();

                q.add(ele);
            }
           // System.out.println();
        }
    }

    public void dfs(int root, HashSet<Integer> hs){
        System.out.print(root+" ");
        Iterator it =hm.get(root).listIterator();
        hs.add(root);

        while(it.hasNext()){
            int temp = (int)it.next();
            if(!hs.contains(temp)){
                dfs(temp, hs);
            }
        }
        System.out.println();
    }

    public void topologicalSort(int root,Stack<Integer> stack, HashSet<Integer> hs){
        Iterator it =hm.get(root).listIterator();
        hs.add(root);
        while(it.hasNext()){
            int temp = (int)it.next();
            if(!hs.contains(temp)){
                topologicalSort(temp, stack, hs);

            }
        }
        stack.push(root);
    }
}
