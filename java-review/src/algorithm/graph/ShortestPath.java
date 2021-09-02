package algorithm.graph;

class MyGraph {
	private int count;
	private boolean[] visited;
	private int[][] vertexMatrix;
	private int[] distance;
	private static int unlimit = Integer.MAX_VALUE; 
	
	public MyGraph(int count) {
		this.count = count;
		visited = new boolean[count];
		vertexMatrix = new int[count][count];
		distance = new int[count];
		
	}
	
	public void addEdges(int from, int to, int weight) {
		vertexMatrix[from][to] = weight;
		vertexMatrix[to][from] = weight;
	}
	
	public void calcShotestPath(int from) {
		for (int i = 0; i < count; i++) {
			distance[i] = unlimit;
		}
		
		visited[from] = true;
		distance[from] = 0;
		for (int i = 0; i < count; i++) {
			if(visited[from] && vertexMatrix[from][i] != 0) {
				distance[i] = vertexMatrix[from][i];
			}
		}
		
		for (int i = 0; i < count-1; i++) {
			int min = unlimit;
			int minIndex = -1;
			
			for (int j = 0; j < count; j++) {
				if(!visited[j] && distance[j]!=unlimit) {
					if(distance[j]<min) {
						min = distance[j];
						minIndex = j;
					}
				}
				
			}
			visited[minIndex] = true;
			for (int j = 0; j < count; j++) {
				if(!visited[j] && vertexMatrix[minIndex][j] != 0) {
					if(distance[j]> distance[minIndex] + vertexMatrix[minIndex][j]) {
						distance[j] = distance[minIndex] + vertexMatrix[minIndex][j];
					}
				}
			}
		}
	}
	
	public void showDistance(int from) {
		for(int i = 0; i<count; i++) {
    		System.out.println(from + " 노드로부터 " + i + " 노드의 최단 거리는 : " + distance[i]);
    	}
	}
}

	
public class ShortestPath {

	public static void main(String[] args) {
		MyGraph graph = new MyGraph(6);
		graph.addEdges(0, 1, 1);
		graph.addEdges(0, 2, 4);
		graph.addEdges(1, 2, 2);
		graph.addEdges(2, 3, 1);
		graph.addEdges(3, 4, 8);
		graph.addEdges(3, 5, 3);
		graph.addEdges(4, 5, 4);

		graph.calcShotestPath(0);
		graph.showDistance(0);

	}
}

