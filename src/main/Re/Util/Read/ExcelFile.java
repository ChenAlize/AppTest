package Util.Read;

import Data.Dictionary;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbo on 2017/12/1.
 */
public class ExcelFile {
    /**
     * 字符流读取文件
     * @param filename
     * @return
     */
    private java.io.InputStream excelStream( String filename ){
        return ExcelFile.class.getClassLoader ().getResourceAsStream ( filename );
    }

    /**
     * 创建工作簿
     * @param filename
     * @return
     */
    public Workbook getWorkBook( String filename ){
        return ExcelFactory.readExcel ( filename ,excelStream ( filename ) );
    }

    /**
     * 单元格转换字符串格式
     * @param cell
     * @return
     */
    private String stringValue(Cell cell ){

        String cellValue = null;
        if(cell==null||cell.equals("")||cell.getCellType() ==HSSFCell.CELL_TYPE_BLANK){
            cellValue = null;
        }else {
            switch ( cell.getCellType() ){
                case HSSFCell.CELL_TYPE_STRING:
                    cellValue = cell.getStringCellValue();
                    if ( cellValue.toString().equals("") || cellValue.trim().length() < 0 ){
                        cellValue =null ;
                    }
                    break;
                case HSSFCell.CELL_TYPE_NUMERIC:
                    cellValue = String.valueOf( cell.getNumericCellValue() );
                    break;
                case HSSFCell.CELL_TYPE_FORMULA:
                    if (DateUtil.isCellDateFormatted( cell )){
                        cellValue = cell.getDateCellValue().toString();
                    }else {
                        cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN:
                    cellValue = Boolean.toString( cell.getBooleanCellValue() );
                    break;
                default:
                    cellValue = null;
            }
        }
        return cellValue;
    }

    /**
     * 获取一行内容
     * @param row
     * @return
     */
    public List<String> cellValue(Row row ) {

        List<String> list = new ArrayList<String>();
        int cellStart = row.getFirstCellNum();
        int cellnotnull = row.getPhysicalNumberOfCells();

        for ( int c = cellStart; c < cellnotnull ; c++ ){
            Cell cell = row.getCell( c );
            String value = stringValue( cell );
            list.add( value );
        }
        return list;
    }

    /**
     * 将行中keywrod之后的数据保存至Dictionary类对象，赋值
     * @param list
     * @return
     */
    public Dictionary inputDictionary( List list ){
        try {
            Class dic = Class.forName( "Data.Dictionary");
            Field[] fields = dic.getFields();
            int f = fields.length;
            int l = list.size();
            Object o =  dic.newInstance ();
            if ( l >= f ){
                for ( int i =0 ; i< f ; i++ ){
                    fields[i].set ( o , list.get ( i+1 ));
                }
            }else {
             System.out.println( "输入超载！" );
            }
            return  (Dictionary)o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace ();
        }
        return null;
    }
}
