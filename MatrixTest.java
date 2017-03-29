import static org.junit.Assert.*;

import org.junit.Test;


public class MatrixTest {

	@Test
	public void testDeterminant() {
		Matrix m = new Matrix();
		m.Matrix(3,"1 2 3 2 1 3 3 1 2");
		
		assertEquals(6.0, m.determinant(),0.001);
	}

	@Test
	public void testInverse() {
		Matrix m = new Matrix();
		m.Matrix(2,"2 0 0 2");
		m = m.inverse();
		System.out.println(m.printMatrix());

		double[][] testArr = new double[10][10];
		testArr[0][0] = .5;
		testArr[0][1] = 0;
		testArr[1][0] = 0;
		testArr[1][1] = .5;

		assertEquals(m.getArray(), testArr);
	}

	@Test
	public void testSubMatrix() {
		
		Matrix m = new Matrix();
		m.Matrix(3,"1 2 3 2 1 3 3 1 2");
		m = m.subMatrix(0, 0);
		
		Matrix test = new Matrix();
		test.Matrix(2,"1 3 1 2");
		
		assertEquals(m.getArray(), test.getArray());
	}


	@Test
	public void testPrintMatrix() {
		
		Matrix m = new Matrix();
		m.Matrix(2,"1 2 3 4");
		
		String test = "1 2 \n3 4 \n";
		
		assertEquals(test, m.printMatrix());
	}

}
