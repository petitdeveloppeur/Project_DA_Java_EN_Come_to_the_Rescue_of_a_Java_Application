package com.hemebiotech.analytics;
 
import java.util.Map;
import java.io.IOException;

/**
 * Writes aggregated symptom data to a source.
 */  
public interface ISymptomWriter {
    /**
     * Writes each symptom and its occurrence count.
     *
     * @param symptoms map of symptom names to occurrence counts
     */
    void writeSymptoms(Map<String, Integer> symptoms) throws IOException;

}