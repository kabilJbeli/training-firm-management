package com.don.knn;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
 * Knn algorithm implementation
 */
public class KNN_Implementation {

	// created lists for storing training and testing datasets label and features.

	private List<double[]> trainfeatures = new ArrayList<>();
	private List<String> trainlabel = new ArrayList<>();

	private List<double[]> testfeatures = new ArrayList<>();
	int knn_value = 1;
	int DistanceMetricsSelction = 0;
	int totalNumberOfLabel = 0;

	/*
	 * loading training data and extracting features and label for training dataset
	 */
	void loadtrainData() throws NumberFormatException, IOException {

		trainfeatures.add(new double[0]); // add values to be calculated like conf of benificier
		trainlabel.add("benificier"); // benificier atttribuated
	}

	/*
	 * loading testing data and extracting features and label for training dataset
	 * 
	 */
	void loadtestData() {
		testfeatures.add(new double[0]); // info of donation to be classed

	}

	/*
	 * Based on user input, calling algorithm to calculate distance
	 */
	void distanceCalcualte() throws IOException {
		euclideanDistance();
	}

	/*
	 * EuclideanDistance Calling euclidean method to calculate distance and writing
	 * output to file.
	 * 
	 */

	@SuppressWarnings("unchecked")
	void euclideanDistance() throws FileNotFoundException {
		KNN_Distance euclidean = new KNN_Distance();
		Iterator<double[]> testITR = testfeatures.iterator();
		while (testITR.hasNext()) {
			double testF[] = testITR.next();
			Iterator<double[]> trainITR = trainfeatures.iterator();
			int noOfobject = 0;
			ArrayList<DistanceAndFeatures> ts = new ArrayList<>();
			while (trainITR.hasNext()) {
				double trainF[] = trainITR.next();
				double dist = 0;
				dist = euclidean.getEuclideanDistance(trainF, testF);

				String trainFeat = trainlabel.get(noOfobject);
				DistanceAndFeatures DfObject = new DistanceAndFeatures(dist, trainFeat);
				ts.add(DfObject);
				Collections.sort(ts);
				noOfobject++;
			}
			
			//TODO Iskander class finding

		}
	}
}
