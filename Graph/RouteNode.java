package Graph;



import java.util.LinkedList;
public class RouteNode {
	public static void main(String a[])
	{
		Graph g = createNewGraph();
		Node[] n = g.getNodes();
		Node start = n[3];
		Node end = n[5];
		System.out.println(RouteNode.search(g, start, end));
	}

	public static Graph createNewGraph()
	{
		Graph g = new Graph();        
		Node[] temp = new Node[6];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}
	public static boolean search(Graph a,Node start,Node end){
		LinkedList<Node> q=new LinkedList<Node>();
		for(Node n:a.getNodes()){
		n.state=State.Stated.unvisted;
		}
		start.state=State.Stated.visiting;
		q.add(start);
		Node u;
		while(!q.isEmpty()){
			u=q.removeFirst();
			if(u!=null){
				for(Node n:u.getAdjacent()){
					if(n.state==State.Stated.unvisted){
					if(n==end){
						return true;
					}else{
						n.state=State.Stated.visiting;
						q.add(n);
					}
				}
			}
				u.state=State.Stated.visited;
			}
		}
		return false;
	}

}
class State{
	public static enum Stated{visited ,unvisted,visiting;};
}
class Node{
	private Node adjacent[];
	public String vertex;
	public int adjacentcount;
	public State.Stated state;
	//public enum State {visited ,unvisted,visiting;};
	public Node(String vertex,int adjacentlength){
		this.vertex=vertex;
		adjacentcount=0;
		adjacent=new Node[adjacentlength];
	}
	
	public void addAdjacent(Node a){
		if(this.adjacentcount<30){
			this.adjacent[this.adjacentcount]=a;
		    this.adjacentcount++;
		}else{
			System.out.print("can't add");
		}
	}
	public Node[] getAdjacent(){
	
		return this.adjacent;
	}
	public String getVertex(){
		return vertex;
	}
}
class Graph{
	private Node vertices[];
	public int count;
	public Graph() {
		vertices = new Node[6];
		count = 0;
    }

    public void addNode(Node x) {
		if (count < 30) {
			vertices[count] = x;
			count++;
		} else {
			System.out.print("Graph full");
		}
    }
    
    public Node[] getNodes() {
        return vertices;
    }
}