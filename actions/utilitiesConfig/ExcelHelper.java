package utilitiesConfig;
import java.io.FileInputStream;
import java.util.*;

import org.apache.poi.ss.usermodel.*;

public class ExcelHelper {
	public static List<Map<String, String>> readExcel(String filePath) {
        List<Map<String, String>> excelData = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            // đọc header (dòng 0)
            Row headerRow = sheet.getRow(0);
            int cellCount = headerRow.getLastCellNum();

            // đọc từng dòng tiếp theo
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);
                if (row == null) continue;

                Map<String, String> rowData = new HashMap<>();

                for (int j = 0; j < cellCount; j++) {
                    String header = headerRow.getCell(j).getStringCellValue();
                    Cell cell = row.getCell(j);

                    String value = (cell == null)
                            ? ""
                            : cell.toString().trim();

                    rowData.put(header, value);
                }

                excelData.add(rowData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return excelData;
    }
}
