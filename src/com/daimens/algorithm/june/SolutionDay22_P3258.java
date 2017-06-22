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
 *         3258.River Hopscotch
 * 
 *         Description
 * 
 *         Every year the cows hold an event featuring a peculiar version of
 *         hopscotch that involves carefully jumping from rock to rock in a
 *         river. The excitement takes place on a long, straight river with a
 *         rock at the start and another rock at the end, L units away from the
 *         start (1 ≤ L ≤ 1,000,000,000). Along the river between the starting
 *         and ending rocks, N (0 ≤ N ≤ 50,000) more rocks appear, each at an
 *         integral distance Di from the start (0 < Di < L).
 * 
 *         To play the game, each cow in turn starts at the starting rock and
 *         tries to reach the finish at the ending rock, jumping only from rock
 *         to rock. Of course, less agile cows never make it to the final rock,
 *         ending up instead in the river.
 * 
 *         Farmer John is proud of his cows and watches this event each year.
 *         But as time goes by, he tires of watching the timid cows of the other
 *         farmers limp across the short distances between rocks placed too
 *         closely together. He plans to remove several rocks in order to
 *         increase the shortest distance a cow will have to jump to reach the
 *         end. He knows he cannot remove the starting and ending rocks, but he
 *         calculates that he has enough resources to remove up to M rocks (0 ≤
 *         M ≤ N).
 * 
 *         FJ wants to know exactly how much he can increase the shortest
 *         distance *before* he starts removing the rocks. Help Farmer John
 *         determine the greatest possible shortest distance a cow has to jump
 *         after removing the optimal set of M rocks.
 * 
 *         Input
 * 
 *         Line 1: Three space-separated integers: L, N, and M Lines 2..N+1:
 *         Each line contains a single integer indicating how far some rock is
 *         away from the starting rock. No two rocks share the same position.
 *         Output
 * 
 *         Line 1: A single integer that is the maximum of the shortest distance
 *         a cow has to jump after removing M rocks Sample Input
 * 
 *         25 5 2 2 14 11 21 17 Sample Output
 * 
 *         4
 *
 */
public class SolutionDay22_P3258 {
	
	static int[] rocks;
	static int N;
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int L = in.nextInt();
		N = in.nextInt();
		int M = in.nextInt();
		rocks = new int[N + 2];
		rocks[0] = 0;
		for (int i = 1; i <= N; ++i){
			rocks[i] = in.nextInt();
		}
		rocks[N+1] = L;
		Arrays.sort(rocks);
		lf = 0;
		rt = L;
		System.out.println(binarySearch(M));
	}
	
	static int lf;
	static int rt;
	public static int binarySearch(int M){
		while (lf < rt){
			int mid = lf + (rt - lf + 1) / 2;
			if (remove(mid) > M) rt = mid - 1;
			else lf = mid;
		}
		if (remove(lf) <= M) return lf;
		return 0;
	}
	
	public static int remove(int d){
		int cnt = 0;
		for (int i = 1, j = 0; i <= N + 1; ++i){
			if (rocks[i] - rocks[j] < d){
				cnt++;
			}else{
				j = i;
			}
		}
		return cnt;
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
