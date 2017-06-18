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
 *         2220.Mr.Rito Post Office
 * 
 *         Problem D: Mr. Rito Post Office
 *         あなたは離島の郵便局に勤めるプログラマである．あなたの住んでいる地域は，複数の島々からなる．各島には一つ以上の港町がある．それらに加えて他の町や村があるかもしない．ある島から別の島に向かうためには船を使わなければならない．一つの島の中を回るには陸路が使えるが，海路を利用した方が速いこともある．
 * 
 *         近年行われた郵便局の民営化をきっかけに，経費削減に向けて郵便配達員の人員整理が全国的に行われた．離島の郵便局もその例外ではなく，結果として郵便配達員は利藤さんただ一人となってしまった．その郵便局が集配を担当する地域は非常に広いため，一人で集配するのは大変な作業である．なので，どのようにすれば効率的に集配を行えるのか，利藤さんがあなたに助けを求めてきた．
 * 
 *         あなたの仕事は，利藤さんがたどるべき町や村の集配順序が与えられたときに，最短巡回経路を求めるプログラムを書くことである．
 * 
 *         利藤さんは，決して指定された順序以外で集配業務を行うことができない．しかし，ある町や村から別の町や村へ移動する際に，他の町や村を経由して移動することは許可されている．また，利藤さんは島々を巡るための一隻の船を持っている．
 * 
 *         例えば，町A，町B，村Cという集配順序が与えられた場合，町Aから町Bへ向かう際にどの町や村を経由してもかまわない．このとき，村Cを経由しても構わないが，集配順序を守るためには，一度町Bに行って集配をおこなってから，改めて村Cを訪れて集配をおこなわなければならない．また，町Aから海路を用いて町Bに向かい，町Bから陸路を用いて村Cに向かった場合，船を町Bに置いたままになる．したがって，次に海路を使いたい場合は町Bに戻る必要がある．
 * 
 *         一つの町や村において複数回集配をしなければならない場合もある．たとえば，町A，村B，町C，村Bという集配順序が与えられるかもしれない．このとき，町Aから村Bをたどらずに町Cに向かった場合は，町Cでいきなり集配をおこなうことはできない．最初の村Bでの集配が終わっていないからである．町Cで集配を済ませた後で村Bを訪れて集配しても，一回目の村Bの集配を終わらせたことにはならない．
 * 
 *         利藤さんは，はじめに必ずある港町に船とともにいる．利藤さんはベテランであるため，移動時間以外の集配作業にかかる時間は無視してよい．また，最後の町または村での集配業務が完了するまでの時間だけが問題であり，船をもとの位置に戻して郵便局に帰るまでの時間は考慮しなくてよい．
 * 
 *         Input 入力は複数のデータセットから構成される．各データセットの形式は次に示すとおりである．
 * 
 *         N M x1 y1 t1 sl1 x2 y2 t2 sl2 ... xM yM tM slM R z1 z2 ... zR
 *         データセットの中の入力項目は，すべて非負の整数である．行中の入力項目の区切りは空白 1 個である．
 * 
 *         最初の行は，陸路及び海路網の大きさを規定する．
 * 
 *         N (2 ≤ N ≤ 200) は，町または村の数である． それぞれの町または村には，1 から N までの固有の番号を割り当てる． M
 *         (1 ≤ M ≤ 10000) は，陸路と海路の合計本数である．
 * 
 *         2 行目から 1 + M 行目は，陸路または海路の記述である． xi と yi (1 ≤ xi, yi ≤ N)
 *         は両端の町または村の番号を表す． ti (1 ≤ ti ≤ 1000) はその陸路または海路の移動時間を表す． sli は ‘L’ または
 *         ‘S’ のいずれかであり，Lは陸路を，Sは海路をそれぞれ表す．
 * 
 *         ある2つの町や村を直接結ぶ陸路または海路が2本以上存在することがある．
 *         それぞれの陸路または海路は双方向であり，すなわちどちらの向きにも移動できる．
 * 
 *         M + 2 行目の R (1 ≤ R ≤ 1000)は，利藤さんが担当する集配先の数を表す． M + 3 行目には，集配先の町や村の番号
 *         zi (1 ≤ zi ≤ N) が集配順に R 個並んでいる．
 * 
 *         初期状態では利藤さんと船はともに港町 z1 に存在する． 初期状態から集配先の町や村へは，必ず何らかの方法で移動することができる．
 * 
 *         入力の終わりは，空白で区切られた2つの0を含む1行で示される．
 * 
 *         Output 入力の各データセットに対して，与えられた集配順序で利藤さんが町と村を巡回するために必要な最短移動時間を求め，1行に出力せよ．
 * 
 *         Sample Input 3 3 1 2 5 L 1 2 7 S 2 3 11 S 3 1 2 3 5 5 1 2 15 L 2 3 10
 *         L 4 5 7 L 1 3 30 S 3 4 100 S 5 1 3 5 4 1 0 0 Output for the Sample
 *         Input 18 269
 *
 */
public class SolutionDay16_A2200 {
	
	static int[][] water;
	static int[][] land;
	static int N;
	static int INF = 1 << 28;
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		while (true){
			N = in.nextInt();
			int M = in.nextInt();
			if (N == 0 && M == 0) break;
			
			water = new int[N][N];
			land = new int[N][N];
			
			for (int i = 0; i < N; ++i){
				Arrays.fill(water[i], INF);
				Arrays.fill(land[i],INF);
				water[i][i] = 0;
				land[i][i] = 0;
			}
			
			for (int i = 0; i < M; ++i){
				int from = in.nextInt();
				int to = in.nextInt();
				from--;
				to--;
				
				int cost = in.nextInt();
				String mark = in.next();
				if (mark.equals("S")){
					water[from][to] = water[to][from] = cost;
				}
				else{
					land[from][to] = land[to][from] = cost;
				}
			}
			
			int C = in.nextInt();
			int[] city = new int[C];
			for (int i = 0; i < C; ++i){
				city[i] = in.nextInt() - 1;
			}
			
			warshallFloyd();
			
			int[][] dp = new int[C][N];
			for (int i = 0; i < C; ++i) Arrays.fill(dp[i], INF);
			for (int i = 0; i < N; ++i){
				dp[0][i] = land[city[0]][i] + water[i][city[0]];
			}
			
			for (int i = 1; i < C; ++i){
				for (int j = 0; j < N; ++j){
					for (int k = 0; k < N; ++k){
						if (j != k){
							dp[i][k] = Math.min(dp[i][k], dp[i-1][j] + land[city[i-1]][j] + water[j][k] + land[k][city[i]]);
						}
						else{
							dp[i][k] = Math.min(dp[i][k], dp[i-1][j] + land[city[i-1]][city[i]]);
						}
					}
				}
			}
			
			int min = INF;
			for (int i = 0; i < N; ++i){
				min = Math.min(min, dp[C-1][i]);
			}
			
			System.out.println(min);
		}
	}
	
	private static void warshallFloyd(){ 
		for (int i = 0; i < N; ++i){
			for (int j = 0; j < N; ++j){
				for (int k = 0; k < N; ++k){
					water[j][k] = Math.min(water[j][k], water[j][i] + water[i][k]);
					land[j][k] = Math.min(land[j][k], land[j][i] + land[i][k]);
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
