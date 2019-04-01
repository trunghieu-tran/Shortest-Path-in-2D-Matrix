package searchAlgorithms.blindSearch;

import utils.Matrix;
import utils.utils;

/**
 * @author Harry Tran on 3/30/19.
 * @project ShortestPathFinding
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class DepthLimited {

	static private void DL(Matrix data, int[][] mark, int currX, int currY, int limited) {
		if (data.isDestination(currX, currY)) {
			return;
		}
		if (mark[currX][currY] >= limited) return;

		for (int i = 0; i < 4; ++i) {
			int newX = currX + utils.rr[i];
			int newY = currY + utils.cc[i];
			if (!data.isValidToGo(newX, newY)) continue;

			if (data.isDestination(newX, newY)){
				if (mark[newX][newY] == 0 || mark[currX][currY] + 1 < mark[newX][newY]) {
					mark[newX][newY] = mark[currX][currY] + 1;
				}
				continue;
			}

			if (mark[newX][newY] != 0) continue;

			mark[newX][newY] = mark[currX][currY] + 1;
			DL(data, mark, newX, newY, limited);
			mark[newX][newY] = 0;
		}
	}

	static public void runSearch(Matrix data) {
		System.out.println("\n=== Depth Limited Search ===");
		long startTime = System.nanoTime();
		int[][] mark = new int[data.getN()][data.getM()];

		mark[data.getiSource()][data.getjSource()] = 1;
		int limited = Math.max(data.getN(), data.getM());
		System.out.println("Depth Limit = " + Integer.toString(limited));

		DL(data, mark, data.getiSource(), data.getjSource(), limited);

		if (mark[data.getiDes()][data.getjDes()] == 0) {
			System.out.println("Can not find path to the destination!!!");
		} else {
			System.out.println("Distance = " + Integer.toString(mark[data.getiDes()][data.getjDes()] - 1));
		}
		long endTime   = System.nanoTime();
		System.out.println(Double.toString((double)(endTime - startTime)/1000000) + " miliseconds");
		System.out.println("=== Finished ===");
	}
}
