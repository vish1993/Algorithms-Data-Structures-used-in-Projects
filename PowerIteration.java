//This function is used to provide an eigenvalue to a matrix

public class PowerIteration {

    public static void main(String[] args) {
        double[] temp = new double[8];
        double[] b = {0.125, 0.125, 0.125, 0.125, 0.125, 0.125, 0.125, 0.125};
        double[][] A = {{0.0157727273,	0.2001447876,	0.0125,	0.1925,	0.1218117409,	0.1052835052,	0.1616712707,	0.1621163683},
                {0.1892272727,	0.0159749035,	0.0125,	0.0955769231,	0.2311234818,	0.1238402062,	0.1616712707,	0.1229859335},
                {0.0125,	0.0125,	0.0817307692,	0.0291153846,	0.0125,	0.031056701,	0.0125,	0.0125},
                {0.2252272727,	0.1167471042,	0.4278846154,	0.0152692308,	0.1218117409,	0.2011597938,	0.1616712707,	0.2472826087},
                {0.1106818182,	0.2209942085,	0.0125,	0.0955769231,	0.0161437247,	0.1331185567,	0.1616712707,	0.143702046},
                {0.1106818182,	0.1375965251,	0.4278846154,	0.1814230769,	0.1546052632,	0.0155927835,	0.1616712707,	0.2150575448},
                {0.1106818182,	0.1167471042,	0.0125,	0.0955769231,	0.1218117409,	0.1052835052,	0.0174723757,	0.0815537084},
                {0.2252272727,	0.1792953668,	0.0125,	0.2949615385,	0.2201923077,	0.2846649485,	0.1616712707,	0.0148017903}};

        for (int i = 0; i < 30; i++) {
			//calculate matrix A* vector b
            for (int j = 0; j < 8; j++) {
                temp[j] = 0;
                for (int k = 0; k < 8; k++) {
                    temp[j] += A[j][k] * b[k];
                }
            }
			
			//calculate length of the resulting vector
            double norm_sq = 0;
            for (int m = 0; m < 8; m++) {
                norm_sq += temp[m] * temp[m];
            }
            double norm = Math.sqrt(norm_sq);
			
			//normalize for next iteration
            b[n] = temp[n]/norm;
        }
    }
}









