package aliceinnets.python.jyplot;

import java.io.IOException;

import aliceinnets.python.PythonScript;
import aliceinnets.util.OneLiners;
import junit.framework.TestCase;

public class TestJyPlot extends TestCase {
	
	public void testJyPlot() throws IOException {
		double[] x = OneLiners.linspace(0, 10, 1000);
		double[] y = new double[x.length];
		for (int i = 0; i < y.length; i++) {
			y[i] = Math.sin(x[i]);
		}
		
		y[y.length/2] = Double.POSITIVE_INFINITY;
		y[y.length/3] = Double.NEGATIVE_INFINITY;
		y[y.length*2/3] = Double.NaN;
		
		double[] z = new double[x.length];
		for (int i = 0; i < y.length; i++) {
			z[i] = Math.cos(x[i]);
		}
		
		double[][] f = new double[x.length][x.length];
		for (int i = 0; i < f.length; i++) {
			for (int j = 0; j < f[0].length; j++) {
				f[i][j] = Math.sin(x[i])+Math.sin(x[j]);
			}
		}
		
		new JyPlot()
		.write("from matplotlib import cm\n")
		.figure()
		.subplot(2,2,1)
		.hist(z, 30)
		.grid()
//		.figure()
		.subplot(2,2,2)
		.scatter(y, z)
		.grid()
//		.figure()
		.subplot(2,2,3)
		.plot(x, y, "o")
		.plot(x, z, "label='a'")
		.grid()
		.xlabel("'$f$'")
		.ylabel("'$A$'")
		.ylim(-2.0, 2.0)
		.legend("loc='lower left'")
//		.savefig("r'"+PythonScript.DEFAULT_PATH+System.nanoTime()+".pdf'")
//		.figure()
		.subplot(2,2,4)
//		.contourf(f, "cmap = cm.jet")
		.contourf(x, x, f, 50, "cmap = cm.jet")
		.colorbar()
		.grid()
		.xlabel("'$T_e$ [keV]'")
		.ylabel("'$n_e$ [$10^{19} m^{-3}$]'")
		.savefig("r'"+PythonScript.DEFAULT_PATH+System.nanoTime()+".pdf'")
		.tight_layout()
//		.show()
		.exec();
	}

}
