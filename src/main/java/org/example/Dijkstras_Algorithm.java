package org.example;

import java.util.*;

public class Dijkstras_Algorithm {
	static class Vertex {
		int id;
		HashMap<Vertex, Integer> adjacencyList = new HashMap<>();

		Vertex(int id) { this.id = id; }
	}

	static class WrappedVertex {
		Vertex vertex;
		int distance;

		WrappedVertex(Vertex v, int d) {
			vertex = v;
			distance = d;
		}
	}

	static class MinHeap {
		ArrayList<WrappedVertex> items = new ArrayList<>();

		public void insert(Vertex v, int d) {
			WrappedVertex newItem = new WrappedVertex(v, d);
			int index = items.size();
			items.add(newItem);
			while (index > 0) {
				int parent = (index - 1) / 2;
				if (items.get(parent).distance > newItem.distance) {
					items.set(index, items.get(parent));
					index = parent;
				} else break;
			}
			items.set(index, newItem);
		}

		public WrappedVertex extractMinimum() {
			WrappedVertex min = items.get(0);
			WrappedVertex last = items.remove(items.size() - 1);
			if (!items.isEmpty()) {
				items.set(0, last);
				int index = 0;
				while (true) {
					int left = 2 * index + 1, right = 2 * index + 2;
					int smallest = index;
					if (left  < items.size() && items.get(left).distance  < items.get(smallest).distance) smallest = left;
					if (right < items.size() && items.get(right).distance < items.get(smallest).distance) smallest = right;
					if (smallest == index) break;
					WrappedVertex tmp = items.get(index);
					items.set(index, items.get(smallest));
					items.set(smallest, tmp);
					index = smallest;
				}
			}
			return min;
		}

		public boolean empty() { return items.isEmpty(); }
	}

	public static void dijkstra(Vertex source) {
		MinHeap open = new MinHeap();
		HashMap<Vertex, Integer> closed      = new HashMap<>();
		HashMap<Vertex, Vertex>  predecessor = new HashMap<>();

		open.insert(source, 0);
		closed.put(source, 0);
		predecessor.put(source, null);

		while (!open.empty()) {
			WrappedVertex w = open.extractMinimum();

			// Skip outdated heap entries (lazy deletion)
			if (!Objects.equals(w.distance, closed.get(w.vertex)))
				continue;

			// Print shortest distance to this vertex
			System.out.println("Vertex " + w.vertex.id
					+ " | distance: " + w.distance
					+ " | path: " + getPath(w.vertex, predecessor));

			// Explore all outgoing edges
			for (Map.Entry<Vertex, Integer> edge : w.vertex.adjacencyList.entrySet()) {
				Vertex neighbour = edge.getKey();
				int    newDist   = w.distance + edge.getValue();

				if (!closed.containsKey(neighbour) || newDist < closed.get(neighbour)) {
					closed.put(neighbour, newDist);
					predecessor.put(neighbour, w.vertex);
					open.insert(neighbour, newDist);
				}
			}
		}
	}

	private static String getPath(Vertex v, HashMap<Vertex, Vertex> predecessor) {
		LinkedList<Integer> path = new LinkedList<>();
		while (v != null) {
			path.addFirst(v.id);
			v = predecessor.get(v);
		}
		return path.toString();
	}

	public static void main(String[] args) {
		Vertex v0 = new Vertex(0), v1 = new Vertex(1);
		Vertex v2 = new Vertex(2), v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);

		v0.adjacencyList.put(v1, 1);
		v0.adjacencyList.put(v2, 4);
		v1.adjacencyList.put(v2, 2);
		v1.adjacencyList.put(v3, 6);
		v2.adjacencyList.put(v3, 3);
		v2.adjacencyList.put(v4, 5);
		v3.adjacencyList.put(v4, 1);

		dijkstra(v0);
		// v0: 0,  v1: 1,  v2: 3,  v3: 6,  v4: 7
	}
}
