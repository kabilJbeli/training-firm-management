package com.don.knn;

import java.io.IOException;
import java.util.ArrayList;
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
		testfeatures.add(new double[0]); //info of donation to be classed

	}
}
