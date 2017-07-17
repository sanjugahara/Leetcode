package com.daimens.algorithm.july;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Stack;

public class SolutionDay09_H1269 {
	InputStream is;
	PrintWriter out;
	String INPUT = "./data/judge/201707/1269.txt";
	
	class Edge{
		int from;
		int to;
		
		public Edge(int from, int to){
			this.from = from;
			this.to = to;
		}
	}
	
	List<Edge>[] g;
	boolean[] marked;
	void solve() {
		while (true){
			int N = ni();
			int M = ni();
			if (N == 0 && M == 0) break;
			g = new ArrayList[N];
			for (int i = 0; i < N; ++i) g[i] = new ArrayList<>();
			
			for (int i = 0; i < M; ++i){
				int from = ni();
				int to = ni();
				from--;
				to--;
				g[from].add(new Edge(from, to));
			}
			marked = new boolean[N];	
			DepthFirstOrder order = new DepthFirstOrder(reverseG(g));
			Stack<Integer> reverseOrder = order.reverseOrder();
			int cnt = 0;
			while (!reverseOrder.isEmpty()){
				int v = reverseOrder.pop();
				if (!marked[v]){
					dfs(g, v);
					cnt++;
				}
			}
			String ans = cnt >= 2 ? "NO" : "YES";
			System.out.println(ans);
		}
	}
		
	private void dfs(List<Edge>[] g, int v){
		marked[v] = true;
		for (Edge e : g[v]){
			int to = e.to;
			if (!marked[to]) dfs(g, to);
		}
	}
	
	
	public List<Edge>[] reverseG(List<Edge>[] g){
		int n = g.length;
		List<Edge>[] rg = new ArrayList[n];
		for (int i = 0; i < n; ++i){
			rg[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < n; ++i){
			for (Edge e : g[i]){
				int from = e.from;
				int to = e.to;
				rg[to].add(new Edge(to, from));
			}
		}
		return rg;
	}
	
	class DepthFirstOrder{
		
		boolean[] marked;
		Stack<Integer> reverse;
		List<Edge>[] graph;
		
		public DepthFirstOrder(List<Edge>[] graph){
			this.graph = graph;
			int n = graph.length;
			marked = new boolean[n];
			reverse = new Stack<>();
			for (int i = 0; i < n; ++i){
				if (!marked[i]) dfs(graph, i);
			}
		}
		
		public void dfs(List<Edge>[] graph, int v){
			marked[v] = true;
			for (Edge e : graph[v]){
				int to = e.to;
				if (!marked[to]) dfs(graph, to);
			}
			reverse.push(v);
		}
		
		public Stack<Integer> reverseOrder(){
			return this.reverse;
		}
	}
	
	void run() throws Exception {
		is = oj ? System.in : new FileInputStream(new File(INPUT));
		out = new PrintWriter(System.out);

		long s = System.currentTimeMillis();
		solve();
		out.flush();
		tr(System.currentTimeMillis() - s + "ms");
	}

	public static void main(String[] args) throws Exception {
		new SolutionDay09_H1269().run();
	}

	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;

	private int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	private boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	private int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	private double nd() {
		return Double.parseDouble(ns());
	}

	private char nc() {
		return (char) skip();
	}

	private String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != '
									// ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	private char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	private char[][] nm(int n, int m) {
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = ns(m);
		return map;
	}

	private int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}

	private int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	private long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	private boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	private void tr(Object... o) {
		if (!oj)
			System.out.println(Arrays.deepToString(o));
	}
}