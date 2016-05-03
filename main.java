package test;

import java.io.File;

public class main {

	public static void main(String[] args){
		long start = System.currentTimeMillis();
		Graph_Algo ga=new Graph_Algo(new File ("C:\\tinyEWD.txt"));
		ga.blackList(new File ("C:\\test1.txt"));
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
	}
}
