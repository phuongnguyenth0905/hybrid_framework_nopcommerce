package utilitiesConfig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {
	 public static List<String[]> readCSV(String filePath) {
	        List<String[]> data = new ArrayList<>();
	        String line;

	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            while ((line = br.readLine()) != null) {
	                if (!line.trim().isEmpty()) {
	                    data.add(line.split(","));
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return data;
	    }
}
