package com.daimens.algorithm.may;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author DemonSong
 * 
 *         558. Cheese
 * 
 *         チーズ (Cheese) 問題 今年も JOI 町のチーズ工場がチーズの生産を始め，ねずみが巣から顔を出した．JOI
 *         町は東西南北に区画整理されていて，各区画は巣，チーズ工場，障害物，空き地のいずれかである．ねずみは巣から出発して全てのチーズ工場を訪れチーズを
 *         1 個ずつ食べる．
 * 
 *         この町には，N 個のチーズ工場があり，どの工場も１種類のチーズだけを生産している．チーズの硬さは工場によって異なっており，硬さ 1 から
 *         N までのチーズを生産するチーズ工場がちょうど 1 つずつある．
 * 
 *         ねずみの最初の体力は 1 であり，チーズを 1 個食べるごとに体力が 1
 *         増える．ただし，ねずみは自分の体力よりも硬いチーズを食べることはできない．
 * 
 *         ねずみは，東西南北に隣り合う区画に 1
 *         分で移動することができるが，障害物の区画には入ることができない．チーズ工場をチーズを食べずに通り過ぎることもできる．すべてのチーズを食べ終えるまでにかかる最短時間を求めるプログラムを書け．ただし，ねずみがチーズを食べるのにかかる時間は無視できる．
 * 
 *         入力 入力は H+1 行ある．1 行目には 3 つの整数 H，W，N (1 ≤ H ≤ 1000，1 ≤ W ≤ 1000，1 ≤ N ≤
 *         9) がこの順に空白で区切られて書かれている．2 行目から H+1 行目までの各行には，'S'，'1', '2', ...,
 *         '9'，'X'，'.' からなる W 文字の文字列が書かれており，各々が各区画の状態を表している．北から i 番目，西から j
 *         番目の区画を (i,j) と記述することにすると (1 ≤ i ≤ H, 1 ≤ j ≤ W)，第 i+1 行目の j 番目の文字は，区画
 *         (i,j) が巣である場合は 'S' となり，障害物である場合は 'X' となり，空き地である場合は '.' となり，硬さ 1, 2,
 *         ..., 9 のチーズを生産する工場である場合はそれぞれ '1', '2', ..., '9' となる．入力には巣と硬さ 1, 2,
 *         ..., N のチーズを生産する工場がそれぞれ 1
 *         つずつある．他のマスは障害物または空き地であることが保証されている．ねずみは全てのチーズを食べられることが保証されている．
 * 
 *         出力 すべてのチーズを食べ終えるまでにかかる最短時間（分）を表す整数を 1 行で出力せよ．
 * 
 *         入出力例 入力例 1 3 3 1 S.. ... ..1 出力例 1 4 入力例 2 4 5 2 .X..1 ....X .XX.S
 *         .2.X. 出力例 2 12 入力例 3 10 10 9 .X...X.S.X 6..5X..X1X ...XXXX..X
 *         X..9X...X. 8.X2X..X3X ...XX.X4.. XX....7X.. X..X..XX.. X...X.XX..
 *         ..X....... 出力例 3 91
 *
 */
public class SolutionDay18_A0558 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int H = in.nextInt();
		int W = in.nextInt();
		int N = in.nextInt();
		
		char[][] map = new char[H][W];
		for (int i = 0; i < H; i++) {
			char[] ss = in.next().trim().toCharArray();
			for (int j = 0; j < W; j++) {
				map[i][j] = ss[j];
			}
		}
		System.out.println(solve(map,N));
		in.close();
	}
	
	public static int solve(char[][] map, int N){
		int row = map.length;
		int col = map[0].length;
		int[][] factory = new int[N+1][2];
		for (int i = 0; i < row; i++){
			for (int j = 0; j <col; j++){
				if (map[i][j] == 'S'){
					factory[0][0] = i;
					factory[0][1] = j;
				}
				else if (map[i][j] != '.' && map[i][j] != 'X'){
					factory[map[i][j]-'0'][0] = i;
					factory[map[i][j]-'0'][1] = j;
				}
			}
		}
		int step = 0;
		for (int i = 0; i < N; i++){
			step += bfs(map, factory[i][0], factory[i][1], factory[i+1][0], factory[i+1][1]);
		}
		return step;
	}
	
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int bfs(char[][] map, int sx, int sy, int ex, int ey){
		int row = map.length, col = map[0].length;
		int[][] distance = new int[row][col];
		for (int i = 0; i < row; i++){
			Arrays.fill(distance[i], -1);
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{sx, sy});
		distance[sx][sy] = 0;
		int step = 1;
		while (!queue.isEmpty()){
			int size = queue.size();
			for (int i = 0; i < size; i++){
				int[] cur = queue.poll();
				for (int[] d : dir){
					int nx = cur[0] + d[0];
					int ny = cur[1] + d[1];
					if (nx >= 0 && nx < row && ny >= 0 && ny < col && map[nx][ny] != 'X' && distance[nx][ny] == -1){
						distance[nx][ny] = step;
						queue.offer(new int[]{nx,ny});
					}
				}
			}
			step++;
		}
		return distance[ex][ey];
	}
}
