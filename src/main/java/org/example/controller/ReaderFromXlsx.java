package org.example.controller;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;

@Component
public class ReaderFromXlsx {
    public int[] read(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            Workbook workbook = new XSSFWorkbook(fis);
            int[] res;
            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getPhysicalNumberOfRows();
            res = new int[rowCount];
            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell cell = row.getCell(0);
                    if (cell != null && cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                        res[i] = (int) cell.getNumericCellValue();
                    }
                }
            }
            return res;
        }
    }
}
