package com.hemebiotech.analytics;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Writes aggregated symptom counts to a text file.
 */

public class WriteSymptomDataToFile implements ISymptomWriter {
    private String filepath;
   
   /**
     * Builds a writer bound to an output file path.
     *
     * @param filepath path to the output file
     */

    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

	/**
     * Writes symptoms as "name: count" lines.
     *
     * @param symptoms map of symptom names to occurrence counts
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException 		{
        if (filepath != null && symptoms != null) {
            try (FileWriter writer = new FileWriter(filepath)) {
                for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                    writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}