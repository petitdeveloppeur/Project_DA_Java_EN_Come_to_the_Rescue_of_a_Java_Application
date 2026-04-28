package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    /**
     * Runs the full symptom analytics pipeline.
     *
     * @param args CLI arguments (unused)
     */
    public static void main(String[] args) {

     

        ISymptomReader reader = new ReadSymptomDataFromFile("../symptoms.txt"); 
        ISymptomWriter writer = new WriteSymptomDataToFile("../result.out");
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = analyticsCounter.getSymptoms();
        Map<String, Integer> countedSymptoms = analyticsCounter.countSymptoms(symptoms);
        Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(countedSymptoms);
        analyticsCounter.writeSymptoms(sortedSymptoms);
    }
}