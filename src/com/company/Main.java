package com.company;

public class Main {

    public static void main(String[] args) {
        MyGraph<Integer> myGraph = new MyGraph<>();

        myGraph.addVertex(0);
        myGraph.addVertex(1);
        myGraph.addVertex(2);
        myGraph.addVertex(3);
        myGraph.addVertex(4);

        myGraph.addEdge(0,1);
        myGraph.addEdge(0,2);
        myGraph.addEdge(0,3);
        myGraph.addEdge(0,4);
        myGraph.addEdge(1,2);
        myGraph.addEdge(2,3);
        myGraph.addEdge(3,4);
        myGraph.addEdge(1,4);

        System.out.println("____________Before removing________________");
        myGraph.printGraph();

        myGraph.removeEdge(0,3);
        System.out.println("____________After removing________________");
        myGraph.printGraph();
        myGraph.removeEdge(0,3);
        System.out.println("Vertex 0 has next neighbors: " + myGraph.getNeighbors(0));
        System.out.println();

        System.out.println("DFS Traversal:");
        myGraph.DFS(0);
        System.out.println();

        System.out.println("BFS Traversal:");
        myGraph.BFS(0);
    }
}
