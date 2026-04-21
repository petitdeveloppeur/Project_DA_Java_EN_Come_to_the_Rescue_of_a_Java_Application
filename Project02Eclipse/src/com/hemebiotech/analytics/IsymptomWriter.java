package com.hemebiotech.analytics;

/**
 * Anything that will write symptom data to a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */     
import java.util.Map;
import java.io.IOException;
public interface ISymptomWriter {
    /**
     * Write the symptoms to a source
     * 
     * @param symptoms a map of symptoms and their counts
     */
    void writeSymptoms(Map<String, Integer> symptoms) throws IOException;