package Util.Read;

import Util.Logger.Log;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

/**
 * Created by chenbo on 2017/10/19.
 */
public class ReadExcel {

     Log log = new Log ( ReadExcel.class );
    //文件类型
     String filetype = null ;
     Workbook wb;
     String filename ;

    /**
     * 读取Excel
     * @return
     */
    public String[][] getLocatorMap( String classname )  {

        filename = "Locator.xlsx";

        //获取文件后缀
        filetype =  filename.substring ( filename.lastIndexOf ( "." ) + 1 );

//        System.out.println ( "文件类型：" + filetype );

        java.io.InputStream inputStream = ReadExcel.class.getClassLoader ().getResourceAsStream ( filename );
        try {
            if (filetype.equalsIgnoreCase ( "xls" )){
                wb = new HSSFWorkbook ( inputStream );
            }else if (filetype.equalsIgnoreCase ( "xlsx" )){
                wb = new XSSFWorkbook ( inputStream );
            }else {
                throw new IOException ( filename + "不是Excel ！" );
            }
        }catch ( IOException e){
            e.printStackTrace ();
        }

        //通过sheet编号加载sheet
//        Sheet sheet = wb.getSheetAt(0);\

        log.info ( "【读取】 ：" + classname );
        //通过sheet名称加载sheet
        Sheet sheet = wb.getSheet ( classname );

        Row header = sheet.getRow(0);

//        System.out.println ( "最大行数  NUM :"+ sheet.getLastRowNum() );
//        System.out.println ( "最大列数  NUM :" + header.getLastCellNum() );

        String[][] locatorMap = new String
                [sheet.getLastRowNum()+1]
                [header.getLastCellNum()];
        for (int rownum = 0; rownum <= sheet.getLastRowNum(); rownum++) {
            // for (Cell cell : row)
            //遍历行
            Row row = sheet.getRow(rownum);
            if (row == null) {
                continue;
            }
            //遍历一行的列
            String value;
            for (int cellnum = 0; cellnum <= row.getLastCellNum(); cellnum++) {
                Cell cell = row.getCell(cellnum);
                if (cell == null) {
                    continue;
                } else {
                    value = "";
                }
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        value = cell.getRichStringCellValue().getString();
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            value = cell.getDateCellValue().toString();

                        } else {
                            value = Integer.toString((int) cell
                                    .getNumericCellValue());

                        }
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        value = Boolean.toString(cell.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_FORMULA:
                        value = cell.getCellFormula().toLowerCase();
                        break;
                    default:
                        value = " ";
//                        System.out.println();
                }
                locatorMap[rownum][cellnum] = value;
            }
        }
        try {
            wb.close();
        } catch (IOException e) {
            log.info ( "【读取excel文件错误】" );
            e.printStackTrace ();
        }
        return locatorMap;
    }
}
