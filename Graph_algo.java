package Ex1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

public class Graph_algo {
	DijkstraSP SP;

	public Graph_algo(File dir) {
		Graph g=new Graph();
		g.CreateGraph(dir);
		this.SP = g.getSP();
	}
	public String getShortestPath(int from, int to){
		this.SP.computePaths(this.SP.getVertex(from));
		String ans = this.SP.getShortestPathTo(to);
		this.SP.unComputePaths();
		return ans;
	}
	public double getShortestDistance(int from, int to){
		this.SP.computePaths(this.SP.getVertex(from));
		double ans = this.SP.getShortestDistanceTo(to);
		this.SP.unComputePaths();
		return ans;
	}
	private double BlackListLabeling(String Loc) {

		StringTokenizer st= new StringTokenizer(Loc, " ");
		int from=Integer.parseInt(st.nextToken());
		int to=Integer.parseInt(st.nextToken());
		int numOfBLNodes=Integer.parseInt(st.nextToken());
		Vector <Integer>B=new Vector<>();

		//Making the incoming black vertices to be forbidden to pass.
		for (int i = 0; i < numOfBLNodes; i++) {
			int BL=Integer.parseInt(st.nextToken());
			this.SP.vertices[BL].BlackList=true;
			B.add(BL);
		}
		getShortestPath(from,to);	
		double ans=getShortestDistance(from,to);

		for (int i = 0; i < numOfBLNodes; i++) {
			int BL=B.get(i);
			this.SP.vertices[BL].BlackList=false;
		}
		return ans;
	}
	public void BlackList(File dir) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(dir));
			int numOfBL=Integer.parseInt(reader.readLine());
			
			String CurrentLoc=reader.readLine();
			while(CurrentLoc!=null){
				BlackListLabeling(CurrentLoc);
				CurrentLoc=reader.readLine();
			}
			reader.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
