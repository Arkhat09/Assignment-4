package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MyGraph<Vertex> {
    private Map<Vertex, List<Vertex>> list;

    public MyGraph(){
        list = new HashMap<Vertex, List<Vertex>>();
    }

    public void addVertex(Vertex vertex){
        list.put(vertex, new LinkedList<Vertex>());
    }

    public void addEdge(Vertex source, Vertex destination){
        validateVertex(source);
        validateVertex(destination);
        list.get(source).add(destination);
        list.get(destination).add(source);
    }

    private void validateVertex(Vertex index){
        if(!list.containsKey(index)){
            throw new IllegalArgumentException("Vertex " + index + " is out of range");
        }
    }

    public void removeEdge(Vertex source, Vertex destination){
        if(!hasEdge(source, destination)) {
            System.out.println("These two vertices do not have an edge");
            return;
        }
        list.get(source).remove(destination);
        list.get(destination).remove(source);
    }

    public boolean hasEdge(Vertex source, Vertex destination){
        validateVertex(source);
        validateVertex(destination);
        List<Vertex> neighbors = list.get(source);
        return neighbors != null && neighbors.contains(destination);
    }

    public List<Vertex> getNeighbors(Vertex vertex){
        validateVertex(vertex);
        return list.getOrDefault(vertex, new LinkedList<>());
    }

    public void DFS(Vertex startVertex){
        validateVertex(startVertex);

        Map<Vertex, Boolean> visited= new HashMap<Vertex, Boolean>();
        for(Vertex vertex : list.keySet()){
            visited.put(vertex, false);
        }
        DFS(startVertex, visited);
    }

    private void DFS(Vertex vertex, Map<Vertex, Boolean> visited){
        visited.put(vertex,true);
        System.out.print(vertex + " ");
        for(Vertex neighbor : list.get(vertex)){
            if(!visited.get(neighbor)){
                DFS(neighbor, visited);
            }
        }
    }

    public void BFS(Vertex startVertex){
        validateVertex(startVertex);

        Map<Vertex, Boolean> visited = new HashMap<Vertex, Boolean>();
        for(Vertex vertex : list.keySet()){
            visited.put(vertex, false);
        }

        Queue<Vertex> queue = new LinkedList<>();
        visited.put(startVertex, true);
        queue.add(startVertex);

        while(!queue.isEmpty()){
            Vertex currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for(Vertex neighbor : list.get(currentVertex)){
                if(!visited.get(neighbor)){
                    visited.put(neighbor, true);
                    queue.add(neighbor);
                }
            }
        }
    }
    public void printGraph(){
        for(Map.Entry<Vertex, List<Vertex>> entry : list.entrySet()){
            Vertex vertex = entry.getKey();
            System.out.print("Vertex " + vertex + " connected to: ");
            List<Vertex> neighbors = entry.getValue();
            for(Vertex neighbor : neighbors){
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}