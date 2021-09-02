package algorithm.graph;

import java.util.Stack;

public class Dfs {
	
	int count;
	boolean[] visited;
	Stack<Integer> stack;
	int[][] matrix;
	
	public Dfs(int count) {
		this.count = count;
		visited = new boolean[count];
		stack = new Stack<Integer>(); 
	}
	
	public void dfsTraversal() {
		
		stack.push(0);
		visited[0] = true;
		
		while(stack.isEmpty() == false) {
			int node = stack.pop();
			System.out.print(node+"\t");
			
			for (int i = 0; i < count; i++) {
				if(matrix[node][i] != 0 && !visited[i]) {
					stack.push(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		int count = 8;

		UndirectedGraph graph = new UndirectedGraph(count);
		
		graph.addEdges(0, 1, 1);
		graph.addEdges(0, 2, 1);
		graph.addEdges(1, 3, 1);
		graph.addEdges(1, 4, 1);
		graph.addEdges(2, 5, 1);
		graph.addEdges(2, 6, 1);
		graph.addEdges(4, 5, 1);
		graph.addEdges(3, 7, 1);

		Dfs dfs = new Dfs(count);
		
		dfs.matrix = graph.getMatrix();
		dfs.dfsTraversal();
		
	}

}
