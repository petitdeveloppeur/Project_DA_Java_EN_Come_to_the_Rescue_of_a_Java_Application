package com.hemebiotech.analytics;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

public class AnalyticsCounter {

    private ISymptomReader reader;
    private ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }
    public List<String> getSymptoms() {
        return reader.GetSymptoms();
    }
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
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        if (symptoms == null) {
            return new TreeMap<>();
        }
        // TreeMap trie automatiquement les clés par ordre alphabétique
        return new TreeMap<>(symptoms);
    }
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            writer.writeSymptoms(symptoms);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}