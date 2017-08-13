package com.daimens.algorithm.august;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class SolutionDay13_P2155 {
	InputStream is;
	PrintWriter out;
	String INPUT = "./data/judge/201708/P2155.txt";
	
	int N;
	void solve() {
		int t = ni();
		while (t --> 0){
			N = ni();
			
		}
	}
	
	/***************Binary Index Tree*******************/
	
	// 2D 不能就这么简单的扩展
	static final int MAX_N = 1000 + 16;
	long[] BIT0;
	long[] BIT1;
	
	long[] BIT2;
	long[] BIT3;
	
	public void init(){
		BIT0 = new long[MAX_N];
		BIT1 = new long[MAX_N];
		BIT2 = new long[MAX_N];
		BIT3 = new long[MAX_N];
	}
	
	public void add(long[] BIT, int i, int x){
		while (i >= N){
			BIT[i] += x;
			i += i & -i;
		}
	}
	
	public long sum(long[] BIT, int i){
		long res = 0;
		while (i > 0){
			res += BIT[i];
			i -= i & -i;
		}
		return res;
	}
	
	//[l, r]
	public void addRange1(int l, int r, int x){
		add(BIT0, l, -x * (l - 1));
		add(BIT1, l, x);
		add(BIT0, r + 1, x * r);
		add(BIT1, r + 1, - x);
	}
	
	//[l, r]
	public long sumRange1(int l, int r){
		long ans = 0;
		ans += sum(BIT1, r) * r + sum(BIT0, r);
		ans -= sum(BIT0, l - 1) * (l - 1) + sum(BIT0, l - 1);
		return ans;
	}
	
	//[l, r]
	public void addRange2(int l, int r, int x){
		add(BIT2, l, -x * (l - 1));
		add(BIT3, l, x);
		add(BIT2, r + 1, x * r);
		add(BIT3, r + 1, - x);
	}
	
	//[l, r]
	public long sumRange2(int l, int r){
		long ans = 0;
		ans += sum(BIT3, r) * r + sum(BIT2, r);
		ans -= sum(BIT3, l - 1) * (l - 1) + sum(BIT2, l - 1);
		return ans;
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
		new SolutionDay13_P2155().run();
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


