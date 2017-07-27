package com.daimens.algorithm.july;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class SolutionDay26_P1795 {
	InputStream is;
	PrintWriter out;
	String INPUT = "./data/judge/201707/1795.txt";
	
	void solve() {
		int t = ni();
		for (int i = 0; i < t; ++i){
			int len = ni();
			String[] str = new String[len];
			for (int j = 0; j < len; ++j){
				str[j] = ns();
			}
			
			
			out.println("Scenario #"+(i + 1)+":");
			out.println();
		}
	}
	
//	Map<Integer, String> mem;
//	String cmp = "";
//	public void dfs(String[] str, int pos, String ans){
//		if (pos == str.length){
//			if (cmp.isEmpty()){
//				cmp = ans;
//				return;
//			}
//			else{
//				if (cmp.length() >= ans.length()){ 
//					if (cmp.length() > ans.length()){ 
//						cmp = ans;
//					}
//					else{
//						if (cmp.compareTo(ans) > 0) cmp = ans;
//					}
//					return;
//				}
//			}
//		}
//		else{
//			if (ans.contains(str[pos])){
//				dfs(str, pos + 1, ans);
//			}
//			else{
//				char[] c1 = str[pos].toCharArray();
//				char[] c2 = ans.toCharArray();
//				int i = c1.length - 1;
//				int j = 0;
//				while (i >= 0 && j < c2.length && c1[i] == c2[j]){
//					i--;
//					j++;
//				}
//				dfs(str, pos + 1, str[pos] + ans.substring(j));
//				
//				int index = 0;
//				for (; index < c2.length; ++index){
//					if (str[pos].contains(ans.substring(index))) break;
//				}
//				dfs(str, pos + 1, ans.substring(0, index) + str[pos]);
//				
//				
//			}
//		}
//	}
	
//	public String dfs(String[] str, int pos, String ans){
//		if (mem.containsKey(pos)) return mem.get(pos);
//		if (pos == str.length){
//			return ans;
//		}
//		else{
//			if (ans.contains(str[pos])){
//				String key = dfs(str, pos + 1, ans);
//				mem.put(pos, key);
//				return key;
//			}
//			else{
//				char[] c1 = str[pos].toCharArray();
//				char[] c2 = ans.toCharArray();
//				int i = c1.length - 1;
//				int j = 0;
//				while (i >= 0 && j < c2.length && c1[i] == c2[j]){
//					i--;
//					j++;
//				}
//				String key1 = dfs(str, pos + 1, str[pos] + ans.substring(j));
//				
//				int index = 0;
//				for (; index < c2.length; ++index){
//					if (str[pos].contains(ans.substring(index))) break;
//				}
//				String key2 = dfs(str, pos + 1, ans.substring(0, index) + str[pos]);
//				if (key1.length() < key2.length()){
//					mem.put(pos, key1);
//					return key1;
//				}
//				else if (key1.length() > key2.length()){
//					mem.put(pos, key2);
//					return key2;
//				}
//				else{
//					if (key1.compareTo(key2) > 0){
//						mem.put(pos, key2);
//						return key2;
//					}
//					else{
//						mem.put(pos, key1);
//						return key1;
//					}
//				}
//			}
//		}
//	}
	
	void run() throws Exception {
		is = oj ? System.in : new FileInputStream(new File(INPUT));
		out = new PrintWriter(System.out);

		long s = System.currentTimeMillis();
		solve();
		out.flush();
		tr(System.currentTimeMillis() - s + "ms");
	}

	public static void main(String[] args) throws Exception {
		new SolutionDay26_P1795().run();
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


