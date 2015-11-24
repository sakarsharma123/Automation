package classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteInExcel {
	Logger logger = Logger.getLogger(getClass());
	int sheetNo;
	FileInputStream file = null;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	int resultCellNumber;
	
	public WriteInExcel(int sheetNo) {
		this.sheetNo=sheetNo;
	}
	public int fetchResultCellNumber() {
		Iterator<Cell> cellIterator = sheet.getRow(0).cellIterator();
		while (cellIterator.hasNext()) {
			Cell cell = (Cell) cellIterator.next();
			if (cell.getStringCellValue().equals("Result")) {
				return cell.getColumnIndex();
			}
		}
		return -1;
	}
	public void updateResult(int rowCounter, boolean status) {
		try {
			file = new FileInputStream(new File("./ExcelFiles/DataInput.xlsx"));
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheetAt(sheetNo);
			resultCellNumber = fetchResultCellNumber();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			//	System.out.println("################################## rowCounter X ResultCellNumber="+rowCounter +" , "+resultCellNumber);
			Cell cell = sheet.getRow(rowCounter).getCell(resultCellNumber);
			logger.info("=========================================== Writing Result In DataInput File. =====================================================");
			logger.info("Current DataInput Result = " +cell);
						if (status) {
				cell.setCellValue("Passed");
			} else {
				cell.setCellValue("Failed");
			}
			logger.info("DataInput Result = " +status);
			FileOutputStream outFile = new FileOutputStream(new File("./ExcelFiles/DataInput.xlsx"));
			workbook.write(outFile);
			outFile.flush();
			outFile.close();
			logger.info("=========================================== Result DataInput File Completed. ======================================================");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				workbook.close();
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		
	public void close() {

		
		
	}
}