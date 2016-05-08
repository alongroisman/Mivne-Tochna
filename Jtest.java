package Ex1;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import test.Graph_Algo;

public class Jtest {
	final static double eps=0.0000001;
	public void test() {
		//Directed graph Test's
		Test1();
		Test2();
		Test3();
    	Test4();
		//UnDirected graph Test's
		Test5();
		Test6();
	}
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(Jtest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}

	@Test
	public void Test1(){
		long start = System.currentTimeMillis();
		System.out.print("Test 1 (mediumEWD) Started - ");
		Graph_Algo ga=new Graph_Algo(new File ("D:\\mediumEWD.txt"));
		assertEquals(0.7147800000000001, ga.BLL("1 100 1 0"),eps);
		assertEquals(0.73099, ga.BLL("1 100 3 14 44 128"),eps);
		assertEquals(0.7147800000000001, ga.BLL("100 1 0"),eps);
		assertEquals(0.7602500000000001, ga.BLL("100 1 5 14 13 129 36 223"),eps);
		long end = System.currentTimeMillis();
		System.out.println("Finished Succesfully ("+(end-start)+"ms).");
	}
	@Test
	public void Test2(){
		long start = System.currentTimeMillis();
		System.out.print("Test 2 (mediumEWD) Started - ");
		Graph_Algo ga=new Graph_Algo(new File ("D:\\mediumEWD.txt"));
		assertEquals(0.7194799999999999, ga.BLL("0 200 1 1"),eps);
		assertEquals(0.5681099999999999, ga.BLL("1 201 3 3 14 128"),eps);
		assertEquals(0.6200600000000001, ga.BLL("2 202 0"),eps);
		assertEquals(0.81525, ga.BLL("100 0 5 14 13 129 36 223"),eps);
		assertEquals(0.5710500000000001, ga.BLL("3 203 0"),eps);
		assertEquals(0.36935999999999997, ga.BLL("4 204 0"),eps);
		assertEquals(0.26372, ga.BLL("5 204 0"),eps);
		assertEquals(0.8169500000000001, ga.BLL("6 204 0"),eps);
		assertEquals(0.38050000000000006, ga.BLL("7 204 0"),eps);
		assertEquals(0.67079, ga.BLL("8 204 0"),eps);
		assertEquals(0.19940001, ga.BLL("9 204 8 1 2 3 4 5 6 7 8"),eps);
		long end = System.currentTimeMillis();
		System.out.println("Finished Succesfully ("+(end-start)+"ms).");

	}
	@Test
	public void Test3(){
		long start = System.currentTimeMillis();
		System.out.print("Test 3 (largeEWD) Started - ");
		Graph_Algo ga=new Graph_Algo(new File ("D:\\largeEWD.txt"));
		assertEquals(0.027943310000000006, ga.BLL("0 200 1 1"),eps);
		assertEquals(0.35244173999999984, ga.BLL("1 201 3 3 14 128"),eps);
		assertEquals(0.27941732000000014, ga.BLL("2 202 0"),eps);
		assertEquals(0.6164415799999996, ga.BLL("100 0 5 14 13 129 36 223"),eps);
		assertEquals(0.29078486000000003, ga.BLL("3 203 0"),eps);
		assertEquals(0.6127715799999993, ga.BLL("4 204 0"),eps);
		assertEquals(0.8389454000000006, ga.BLL("5 204 0"),eps);
		assertEquals(0.3998456700000002, ga.BLL("6 204 0"),eps);
		assertEquals(0.46225164, ga.BLL("7 204 0"),eps);
		assertEquals(0.5500837099999999, ga.BLL("8 204 0"),eps);
		assertEquals(0.7448945699999994, ga.BLL("9 204 8 1 2 3 4 5 6 7 8"),eps);
		long end = System.currentTimeMillis();
		System.out.println("Finished Succesfully ("+(end-start)+"ms).");

	}
	@Test
	public void Test4(){
		long start = System.currentTimeMillis();
		System.out.print("Test 4 (largeEWD) Started - ");
		Graph_Algo ga=new Graph_Algo(new File ("D:\\largeEWD.txt"));
		assertEquals(0.6105256099999996, ga.BLL("1 2 0"),eps);
		assertEquals(0.24701662999999993, ga.BLL("0 7 3 1 2 3"),eps);
		assertEquals(0.7731843099999999, ga.BLL("3 5 0"),eps);
		assertEquals(0.6015857000000002, ga.BLL("2 6 0"),eps);
		assertEquals(0.6015857000000002, ga.BLL("2 6 2 4 5"),eps);
		assertEquals(0.6330433199999997, ga.BLL("1 7 0"),eps);
		long end = System.currentTimeMillis();
		System.out.println("Finished Succesfully ("+(end-start)+"ms).");

	}
	@Test
	public void Test5(){
		long start = System.currentTimeMillis();
		System.out.print("Test 5 (tinyEWG) Started - ");
		Graph_Algo ga=new Graph_Algo(new File ("D:\\tinyEWG.txt"));
		assertEquals(0.35, ga.BLL("4 5 0"),eps);
		assertEquals(0.35, ga.BLL("5 4 0"),eps);
		assertEquals(0.35, ga.BLL("0 1 0"),eps);
		assertEquals(0.35, ga.BLL("1 0 0"),eps);
		assertEquals(0.62, ga.BLL("0 1 1 7"),eps);
		assertEquals(0.62, ga.BLL("1 0 1 7"),eps);
		assertEquals(0.52, ga.BLL("6 3 0"),eps);
		assertEquals(0.52, ga.BLL("3 6 0"),eps);
		assertEquals(0.56, ga.BLL("4 1 0"),eps);
		assertEquals(0.56, ga.BLL("1 4 0"),eps);
		long end = System.currentTimeMillis();
		System.out.println("Finished Succesfully ("+(end-start)+"ms).");
	}
	@Test
	public void Test6(){
		long start = System.currentTimeMillis();
		System.out.print("Test 6 (mediumEWG) Started - ");
		Graph_Algo ga=new Graph_Algo(new File ("D:\\mediumEWG.txt"));
		assertEquals(0.08557, ga.BLL("189 249 0"),eps);
		assertEquals(0.08557, ga.BLL("249 189 0"),eps);
		assertEquals(0.11578, ga.BLL("86 108 0"),eps);
		assertEquals(0.11578, ga.BLL("108 86 0"),eps);
		assertEquals(0.10606, ga.BLL("205 207 0"),eps);
		assertEquals(0.10606, ga.BLL("207 205 0"),eps);
		assertEquals(0.08879, ga.BLL("205 221 0"),eps);
		assertEquals(0.08879, ga.BLL("221 205 0"),eps);
		assertEquals(0.08879, ga.BLL("221 205 0"),eps);
		assertEquals(0.7543, ga.BLL("1 221 0"),eps);
		assertEquals(0.7543, ga.BLL("221 1 0"),eps);
		assertEquals(0.78283, ga.BLL("1 221 1 173"),eps);
		assertEquals(0.78283, ga.BLL("221 1 1 173"),eps);
		assertEquals(0.7968, ga.BLL("1 221 2 107 141"),eps);
		assertEquals(0.7968, ga.BLL("221 1 2 107 141"),eps);
		long end = System.currentTimeMillis();
		System.out.println("Finished Succesfully ("+(end-start)+"ms).");

	}

}