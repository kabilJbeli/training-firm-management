package com.don.knn;

public class KNN_Distance {
	
	public double getEuclideanDistance( double[] features1,  double[] features2) {
        double sum = 0;
        for (int i = 0; i < features1.length; i++)
        { 
            sum += Math.pow(features1[i] - features2[i], 2);
        }
        return Math.sqrt(sum);
    }
}
