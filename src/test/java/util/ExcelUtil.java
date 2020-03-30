package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	private static File file = null;
	public static OutputStream os = null;
	public static InputStream is = null;
	//Workbook
	public static Workbook wb = null;
	//excel 2007版本sheet
	public static XSSFSheet xsh = null;
	//excel 2003版本sheet
	public static HSSFSheet hsh = null;
	
	public static ArrayList<String> getCaseSheets(String filePath) throws Exception{
		file = new File(filePath);
		ArrayList<String> sheets = new ArrayList<String>();
		is = new FileInputStream(file);
		String excelType = filePath.substring(filePath.lastIndexOf("."));
		if(".xlsx".equals(excelType)) {
			wb=new XSSFWorkbook(is);
		}else if(".xls".equals(excelType)) {
			wb=new HSSFWorkbook(is);
		}else {
			throw new Exception("读取的不是excel文件");
		}
		for(int i = 0;i<wb.getNumberOfSheets();i++) {//获取每个sheet表
			String name = wb.getSheetAt(i).getSheetName();
			sheets.add(name);
		}
		return sheets;
	}	
	/**
	 * 
	 * @param filePath 
	 * 				文件路径
	 * @param sheetName 
	 * 				制定sheet名字 第一行写死了 为map的键
	 * @param rowIndex 
	 * 				循环开始的行 缺省为0
	 * @param rowLast 
	 * 				循环结束的行 缺省读取excel有值的最大的行数
	 * @param colIndex 
	 * 				循环开始的列 缺省为0
	 * @param colLast 
	 * 				循环结束的列 缺省为读取excel有效的列数
	 * @return Object[][] 存入的是HashMap<String,Object>单元格存的是String 存入的行号是int
	 * @throws Exception
	 */
	@SuppressWarnings({})
	public static Object[][] readExcel(String filePath,String sheetName,Object rowIndex,Object rowLast,
			Object colIndex,Object colLast)throws Exception{
		int rowf = 0,rowl,colf=0,coll;
		//判断是否有传入指定的开始的行和列
		if(rowIndex!=null) {
			rowf=Integer.parseInt(rowIndex.toString());
		}
		if(colIndex!=null) {
			colf=Integer.parseInt(colIndex.toString());
		}
		Object[][] object = null;
		Map<String,String>map=null;
		try {
			file=new File(filePath);
			is=new FileInputStream(file);
			String excelType = filePath.substring(filePath.lastIndexOf("."));
			if(".xlsx".equals(excelType)) {
				wb=new XSSFWorkbook(is);
				xsh=(XSSFSheet)wb.getSheet(sheetName);
				XSSFRow row = null;
				int rowAll = xsh.getPhysicalNumberOfRows();
				//判断是否需要制定特殊的行数循环
				if(rowLast!=null) {
					rowl = Integer.parseInt(rowLast.toString());
					if(rowAll<rowl) {
						rowl=rowAll;
					}
				}else {
					rowl=rowAll;
				}
				object =new Object[rowl-rowf][1];
				//将第一行的数据取出来作为键值
				List<String> list = new ArrayList<String>();
				//
		}
	}
		
		
		
		
		
		
			}catch(FileNotFoundException e) {
			throw new Exception("未找到文件");
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
			if(wb!=null) {
				wb.close();
			}
			if(is!=null) {
				is.close();
			}
			if(os!=null) {
				os.close();
			}	
		}	
	}
	/**
	 * 删除源文件的人员信息，新增参数列表的人员信息
	 * @param filePath
	 * @param sheetName
	 * @param rowIndex删除的行号的第一行
	 * @param rowLast 删除的行号的最后一行
	 * @param move要插入的行
	 * @throws Exception
	 * */
	public static void insertRow(String filepath,String sheetName,Object rowIndex,int move)throws Exception{
		int rowf = 0;
		//判断是否有传入指定的开始的行和列
		if(rowIndex!=null) {
			rowf=Integer.parseInt(rowIndex.toString());
		}
		try {
			file=new File(filePath);
			is = new FileInputStream(file);
			String excelType = filePath.subTring(filePath.lastIndexOf("."));
			if(".xls".equals(excelType)) {
				wb=new HSSFWorkbook(is);
				hsh= (HSSFSheet)wb.getSheet(sheetName);
				int rowAll = hsh.getPhysicalNumberOfRows();
				hsh.shiftRows(rowf,rowAll,move);
				FileOutputStream os = new FileOutputStream(file);
				wb.write(os);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(wb!=null) {
				wb.close();
			}
			if(is!=null) {
				is.close();
			}
		}
	}
}
}
