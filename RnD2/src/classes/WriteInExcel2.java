package classes;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteInExcel2 {
	    @SuppressWarnings("resource")
		public static void main(String[] args)
	    {
	    	ExcelFile.initialize();
	        //Blank workbook
	        XSSFWorkbook workbook = new XSSFWorkbook();
	         
	        //Create a blank sheet
	        XSSFSheet sheet = workbook.createSheet("Result");
	          
	        //Write data into our XLSX file (Object[])
	        Map<String, Object[]> data = new TreeMap<String, Object[]>();
	        data.put("1", new Object[] {ExcelFile.FRAMEWORK_INPUT.getTestCycleList()});
	        data.put("2", new Object[] {1, "Amit", "Shukla"});
	        data.put("3", new Object[] {2, "Lokesh", "Gupta"});
	        data.put("4", new Object[] {3, "John", "Adwards"});
	        data.put("5", new Object[] {4, "Brian", "Schultz"});
	          
	        //Iterate over data and write to sheet
	        Set<String> keyset = data.keySet();
	        int rownum = 0;
	        for (String key : keyset)
	        {
	            XSSFRow row = sheet.createRow(rownum++);
	            Object [] objArr = data.get(key);
	            int cellnum = 0;
	            for (Object obj : objArr)
	            {
	               XSSFCell cell = row.createCell(cellnum++);
	               if(obj instanceof String)
	                    cell.setCellValue((String)obj);
	                else if(obj instanceof Integer)
	                    cell.setCellValue((Integer)obj);
	            }
	        }
	        try
	        {
	            //Write the workbook in file system
	            FileOutputStream out = new FileOutputStream(new File("Sample.xlsx"));
	            workbook.write(out);
	            out.close();
	            System.out.println("Sample.xlsx written successfully.");
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
}
