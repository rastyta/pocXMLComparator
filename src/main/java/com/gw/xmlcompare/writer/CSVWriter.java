package com.gw.xmlcompare.writer;

import com.gw.xmlcompare.model.XMLDiffResult;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;

public class CSVWriter {
    /*public static void writeResultsToCSV(List<XMLDiffResult> results, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            // Write the header
            writer.append("XML Source,Unique Key,Field/Attribute,Old Value,New Value,Change Type,Change Category\n");

            // Write the data
            for (XMLDiffResult result : results) {
                writer.append(result.xmlSource)
                        .append(',')
                        .append(result.uniqueKey)
                        .append(',')
                        .append(result.field)
                        .append(',')
                        .append(result.oldValue)
                        .append(',')
                        .append(result.newValue)
                        .append(',')
                        .append(result.changeType)
                        .append(',')
                        .append(result.category)
                        .append('\n');
            }

            System.out.println("CSV file created successfully!");

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }*/

    public static void writeResultsToExcel(List<XMLDiffResult> results, String filePath) {
        Workbook workbook = new XSSFWorkbook();

        // Create sheets
        Sheet newSheet = workbook.createSheet("New");
        Sheet removedSheet = workbook.createSheet("Removed");
        Sheet changedSheet = workbook.createSheet("Changed");
        Sheet noChangeSheet = workbook.createSheet("No Change");

        // Categorize results
        List<XMLDiffResult> newItems = new ArrayList<>();
        List<XMLDiffResult> removedItems = new ArrayList<>();
        List<XMLDiffResult> changedItems = new ArrayList<>();
        List<XMLDiffResult> noChangeItems = new ArrayList<>();

        for (XMLDiffResult result : results) {
            switch (result.changeType) {
                case "New":
                    newItems.add(result);
                    break;
                case "Removed":
                    removedItems.add(result);
                    break;
                case "Changed":
                    changedItems.add(result);
                    break;
                case "No Change":
                    noChangeItems.add(result);
                    break;
            }
        }

        // Write data to sheets
        writeSheet(newSheet, newItems);
        writeSheet(removedSheet, removedItems);
        writeSheet(changedSheet, changedItems);
        writeSheet(noChangeSheet, noChangeItems);

        // Write the workbook to a file
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
            System.out.println("Excel file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeSheet(Sheet sheet, List<XMLDiffResult> results) {
        // Create header row
        Row headerRow = sheet.createRow(0);
        String[] headers = {"XML Source", "Unique Key", "Field/Attribute", "Old Value", "New Value", "Change Type", "Change Category"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Write data rows
        int rowNum = 1;
        for (XMLDiffResult result : results) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(result.getXmlSource());
            row.createCell(1).setCellValue(result.getUniqueKey());
            row.createCell(2).setCellValue(result.getField());
            row.createCell(3).setCellValue(result.getOldValue());
            row.createCell(4).setCellValue(result.getNewValue());
            row.createCell(5).setCellValue(result.getChangeType());
            row.createCell(6).setCellValue(result.getCategory());
        }
    }


}
