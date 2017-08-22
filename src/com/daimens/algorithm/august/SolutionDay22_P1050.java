package com.daimens.algorithm.august;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class SolutionDay22_P1050 {
	InputStream is;
	PrintWriter out;
	String INPUT = "./data/judge/201708/P1050.txt";
	
	static final int INF = 1 << 29;
	void solve() {
		int n = ni();
		int[][] board = new int[n][n];
		for (int i = 0; i < n; ++i){
			for (int j = 0; j < n; ++j){
				board[i][j] = ni();
			}
		}
		
		if (n == 1){
			out.println(board[0][0]);
		}
		else{
			long[][][] dp = new long[n + 16][2][n + 16];
			for (int i = 0; i < n + 16; ++i){
				for (int j = 0; j < 2; ++j){
					for (int k = 0; k < n + 16; ++k){
						dp[i][j][k] = - INF;
					}
				}
			}
			
			long max = -INF;
			for (int i = n - 1; i >= 0; --i){
				long sum = 0;
				for (int j = 0; j < n - i; ++j){
					sum += board[i + j][n - 1];
					dp[i][(n - 1) % 2][j + 1] = sum;
					max = Math.max(max, dp[i][(n - 1) % 2][j + 1]);
				}
			}
			
			for (int j = n - 2; j >= 0; --j){
				for (int i = n - 1; i >= 0; --i){
					long sum = 0;
					for (int k = 0; k < n - i; ++k){
						sum += board[i + k][j];
						dp[i][j % 2][k + 1] = Math.max(sum, dp[i][(j + 1) % 2][k + 1] + sum);
						max = Math.max(max, dp[i][j % 2][k + 1]);
					}
				}
			}
			out.println(max);
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
		new SolutionDay22_P1050().run();
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


