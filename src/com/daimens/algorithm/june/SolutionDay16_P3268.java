package com.daimens.algorithm.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author DemonSong
 * 
 *         3268.Silver Cow Party
 * 
 *         Description
 * 
 *         One cow from each of N farms (1 ≤ N ≤ 1000) conveniently numbered
 *         1..N is going to attend the big cow party to be held at farm #X (1 ≤
 *         X ≤ N). A total of M (1 ≤ M ≤ 100,000) unidirectional (one-way roads
 *         connects pairs of farms; road i requires Ti (1 ≤ Ti ≤ 100) units of
 *         time to traverse.
 * 
 *         Each cow must walk to the party and, when the party is over, return
 *         to her farm. Each cow is lazy and thus picks an optimal route with
 *         the shortest time. A cow's return route might be different from her
 *         original route to the party since roads are one-way.
 * 
 *         Of all the cows, what is the longest amount of time a cow must spend
 *         walking to the party and back?
 * 
 *         Input
 * 
 *         Line 1: Three space-separated integers, respectively: N, M, and X
 *         Lines 2..M+1: Line i+1 describes road i with three space-separated
 *         integers: Ai, Bi, and Ti. The described road runs from farm Ai to
 *         farm Bi, requiring Ti time units to traverse. Output
 * 
 *         Line 1: One integer: the maximum of time any one cow must walk.
 *         Sample Input
 * 
 *         4 8 2 1 2 4 1 3 2 1 4 7 2 1 1 2 3 5 3 1 2 3 4 4 4 2 3 Sample Output
 * 
 *         10 Hint
 * 
 *         Cow 4 proceeds directly to the party (3 units) and returns via farms
 *         1 and 3 (7 units), for a total of 10 time units.
 *
 */
public class SolutionDay16_P3268 {
	
	static int INF = 1 << 29;
	static int[][] g;
	static int[][] d;
	static int N;
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		
		int M = in.nextInt();
		int X = in.nextInt();
		g = new int[N][N];
		d = new int[N][N];
		for (int i = 0; i < N; ++i) Arrays.fill(g[i], INF);
		for (int i = 0; i < N; ++i) g[i][i] = 0;
		
		for (int i = 0; i < M; ++i){
			int f = in.nextInt();
			int t = in.nextInt();
			f--;
			t--;
			int c = in.nextInt();
			g[f][t] = c;
		}
		
		for (int i = 0; i < N; ++i){
			//initial
			Arrays.fill(d[i], INF);
			d[i][i] = 0;
			dijkstra(i);
		}
		
		int max = 0;
		for (int i = 0; i < N; ++i){
			if (i == X) continue;
			max = Math.max(max, d[i][X] + d[X][i]);
		}
		System.out.println(max);
	}
	
	private static void dijkstra(int s){
		int V = N;
		boolean[] used = new boolean[V];

		while (true){
			int v = -1;
			for (int i = 0; i < V; ++i){
				if (!used[i] && (v == -1 || d[s][i] < d[s][v])) v = i;
			}
			if (v == -1) break;
			used[v] = true;
			for (int i = 0; i < V; ++i){
				d[s][i] = Math.min(d[s][i],d[s][v] + g[v][i]);
			}
		}
	}
	
	private static void warshallFlyod(){
		for (int i = 0; i < N; ++i){
			for (int j = 0; j < N; ++j){
				for (int k = 0; k < N; ++k){
					g[j][k] = Math.min(g[j][k], g[j][i] + g[i][k]);
				}
			}
		}
	}
	
	static class Scanner {

		private BufferedReader br;
		private StringTokenizer tok;

		public Scanner(InputStream is) throws IOException {
			br = new BufferedReader(new InputStreamReader(is));
			getLine();
		}

		private void getLine() throws IOException {
			while (tok == null || !tok.hasMoreTokens()) {
				tok = new StringTokenizer(br.readLine());
			}
		}

		private boolean hasNext() {
			return tok.hasMoreTokens();
		}

		public String next() throws IOException {
			if (hasNext()) {
				return tok.nextToken();
			} else {
				getLine();
				return tok.nextToken();
			}
		}

		public int nextInt() throws IOException {
			if (hasNext()) {
				return Integer.parseInt(tok.nextToken());
			} else {
				getLine();
				return Integer.parseInt(tok.nextToken());
			}
		}

		public long nextLong() throws IOException {
			if (hasNext()) {
				return Long.parseLong(tok.nextToken());
			} else {
				getLine();
				return Long.parseLong(tok.nextToken());
			}
		}

		public double nextDouble() throws IOException {
			if (hasNext()) {
				return Double.parseDouble(tok.nextToken());
			} else {
				getLine();
				return Double.parseDouble(tok.nextToken());
			}
		}
	}

}
