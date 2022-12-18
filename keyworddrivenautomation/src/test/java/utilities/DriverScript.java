package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

public class DriverScript {
	
	KeywordActions keywordActions;
	public DriverScript() {
		keywordActions=new KeywordActions();
	}
	
	public void runScript(String excelPath,String sheetName,String testCaseId) throws Exception {
		
		try {
			XSSFWorkbook workbook=new XSSFWorkbook(excelPath);
			XSSFSheet sheet=workbook.getSheet(sheetName);
			int lastRowIndex=sheet.getLastRowNum();
			System.out.println("No.of rows present in the excel sheet:="+(lastRowIndex+1));
			
			for(int i=1;i<=lastRowIndex;i++) {
				XSSFRow row=sheet.getRow(i);
				String testId=getCellValue(row,0);
				
				if(!testId.equalsIgnoreCase(testCaseId)) {
					continue;
				}
				String stepDescription=getCellValue(row,1);
				String locatorType=getCellValue(row,2);
				String locatorValue=getCellValue(row,3);
				String testData=getCellValue(row,4);
				String action=getCellValue(row,5);
				Reporter.log(testId+"-"+stepDescription+"-"+locatorType+"-"+locatorValue+"-"+testData+"-"+action,true);
				keywordActions.performAction(action,locatorType,locatorValue,testData);
			}
			workbook.close();
		}
		catch(Exception e) {
			throw e;
		}
		
	}
	
	private String getCellValue(XSSFRow row,int columnIndex) {
		XSSFCell cellValue=row.getCell(columnIndex);
		if(cellValue==null) {
			return "";
		}
		else {
			return cellValue.getStringCellValue();
		}
	}

}
