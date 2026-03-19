package org.example;

import java.util.*;

public class IterativeDFS {
	static class Vertex {
		int id;
		List<Vertex> adjacencyList = new ArrayList<>();

		Vertex(int id) { this.id = id; }
	}

	public static void DFS(Vertex source) {
		Stack<Vertex> open   = new Stack<>();
		HashSet<Vertex> closed = new HashSet<>();
		open.push(source);
		closed.add(source);
		while (!open.empty()) {
			Vertex v = open.pop();
			System.out.print(v.id + " ");
			for (Vertex w : v.adjacencyList) {
				if (!closed.contains(w)) {
					open.push(w);
					closed.add(w);
				}
			}
		}
	}

	public static void main(String[] args) {
		Vertex v0 = new Vertex(0), v1 = new Vertex(1);
		Vertex v2 = new Vertex(2), v3 = new Vertex(3);
		v0.adjacencyList.add(v1); v0.adjacencyList.add(v2);
		v1.adjacencyList.add(v3);
		DFS(v0); // 0 2 1 3  (order depends on stack)
	}
}