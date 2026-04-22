package com.hemebiotech.analytics;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;


/**
 * Coordinates reading, counting, sorting, and writing symptom data.
 */

public class AnalyticsCounter {

    private ISymptomReader reader;
    private ISymptomWriter writer;

/**
     * Builds the analytics workflow with pluggable reader/writer.
     *
     * @param reader symptom data source
     * @param writer symptom result target
     */

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

	/**
     * Retrieves raw symptom entries from the configured reader.
     *
     * @return raw symptom list
     */
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

	/**
     * Counts occurrences for each symptom.
     *
     * @param symptoms raw symptom list
     * @return map of symptom names to occurrence counts
     */

    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> counts = new HashMap<>();
        if (symptoms == null) {
            return counts;
        }
        for (String symptom : symptoms) {
            if (symptom == null || symptom.isEmpty()) {
                continue;
            }
            counts.put(symptom, counts.getOrDefault(symptom, 0) + 1);
        }
        return counts;
    }

	/**
     * Sorts symptoms alphabetically by name.
     *
     * @param symptoms unsorted symptom-count map
     * @return alphabetically sorted map
     */

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        if (symptoms == null) {
            return new TreeMap<>();
        }
        // TreeMap trie automatiquement les clés par ordre alphabétique
        return new TreeMap<>(symptoms);
    }

	 /**
     * Writes final symptom counts through the configured writer.
     *
     * @param symptoms sorted symptom-count map
     */

    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            writer.writeSymptoms(symptoms);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}