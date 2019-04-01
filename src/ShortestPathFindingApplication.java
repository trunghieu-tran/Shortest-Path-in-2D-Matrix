import searchAlgorithms.blindSearch.BreadthFirstSearch;
import utils.FileUtils;
import utils.Matrix;

/**
 * @author Harry Tran on 3/30/19.
 * @project ShortestPathFinding
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class ShortestPathFindingApplication {

	private static final String input1 = "./src/input/input1.txt";

	public static void main(String[] args) {
		System.out.println("Hello world");
		Matrix m = FileUtils.read2DMatrixFromFile(input1);
		m.printOutMaxtix();

		BreadthFirstSearch.runSearch(m);
	}
}