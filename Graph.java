package Ex1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.util.StringTokenizer;

public class Graph {
	static Vertex[] Vertices;
	DijkstraSP SP;
	int Nodes;
	int Edges;

	private String checkType(String str) {
		if (str.contains("EWG"))
			return "UDG";
		else
			return "DG";
	}
	private void createUnDirectionalGraph(BufferedReader R) {
		try {
			String CurrentLoc = R.readLine();
			while(CurrentLoc!=null) {
				StringTokenizer st= new StringTokenizer(CurrentLoc," ");
				int from=Integer.parseInt(st.nextToken());
				int to=Integer.parseInt(st.nextToken());
				float cost=Float.parseFloat(st.nextToken());
				Vertices[from].adjacencies.addElement(new Edge(Vertices[to], cost));
				Vertices[to].adjacencies.addElement(new Edge(Vertices[from], cost));
				CurrentLoc = R.readLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void createDirectionalGraph(BufferedReader R) {
		try {
			String CurrentLoc = R.readLine();
			while(CurrentLoc!=null) {
				int i=0;
				StringTokenizer st= new StringTokenizer(CurrentLoc," ");
				int from=Integer.parseInt(st.nextToken());
				int to=Integer.parseInt(st.nextToken());
				float cost=Float.parseFloat(st.nextToken());
				Vertices[from].adjacencies.addElement(new Edge(Vertices[to], cost));
				CurrentLoc = R.readLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public DijkstraSP getSP() {
		return this.SP;
	}
	public void CreateGraph(File dir) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(dir));
			this.Nodes=Integer.parseInt(reader.readLine());
			this.Edges=Integer.parseInt(reader.readLine());
			Vertices = new Vertex[Nodes];
			for (int i = 0; i < Vertices.length; i++) {
				Vertices[i] = new Vertex(""+i);
				Vertices[i].adjacencies=new Vector<Edge>();
			}
			if (checkType(dir.getName()).compareTo("UDG")==0)
				createUnDirectionalGraph(reader);
			else
				createDirectionalGraph(reader);
			reader.close();
			this.SP = new DijkstraSP(Vertices);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}

