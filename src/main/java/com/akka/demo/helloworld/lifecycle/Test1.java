package com.akka.demo.helloworld.lifecycle;

import java.util.HashMap;
import java.util.LinkedList;

public class Test1 {

    static int count = 0;

    /**
     * Broadth First Search
     * @param graph 用于存放图中每个结点的邻接表
     *              key：Character value：该结点的邻接表 LinkedList<Character>
     * @param visited 用于存放每个结点与顶点的距离
     *            key：Character value：距离
     * @param start 起始顶点
     */
    public void DFS(HashMap<Character, LinkedList<Character>> graph,
                    HashMap<Character, Boolean> visited,
                    char start) {
        visit(graph, visited, 's');
    }

    private static void visit(HashMap<Character, LinkedList<Character>> graph,
                              HashMap<Character, Boolean> visited,
                              char start) {
        if (!visited.containsKey(start)) {
            count++;
            //记录进入该结点的时间
            System.out.println("The time into element: " + start + ":" + count);
            //将该结点标志为已访问
            visited.put(start, true);

            //访问队首元素结点的邻接表
            for (char c : graph.get(start)) {
                //递归访问其他邻近结点
                if (!visited.containsKey(c)) {
                    visit(graph, visited, c);
                }
            }
            count++;
            System.out.println("The time out element: " + start + ":" + count);
        }
    }



    }
