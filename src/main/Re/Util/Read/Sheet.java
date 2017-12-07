package Util.Read;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * Created by chenbo on 2017/12/7.
 */
public class Sheet extends ExcelPOI{

    org.apache.poi.ss.usermodel.Sheet sheet;

    public void setSheet(org.apache.poi.ss.usermodel.Sheet sheet) {
        this.sheet = sheet;
    }

    public String getIndex(String CellValue){
        int y = 0;
        int x = 0;
        int rowEnd = sheet.getPhysicalNumberOfRows();
        for ( int i = 0 ; i< rowEnd ; i++ ){
            Row row = sheet.getRow ( i );
            int cellEnd = row.getPhysicalNumberOfCells ();
            for ( int j = 0  ; j < cellEnd ; j++ ){
                Cell cell = row.getCell ( j );
                String value = stringValue ( cell );
                if ( value != null) {
                    if (value.equals ( CellValue )) {
                        y = i;
                        x = j;
                    }
                }
            }
        }
        Index ind = new Index ();
        return ind.get ( x , y );
    }

    public String getCell( String index ){
        Index ind = new Index ();
        ind.set ( index );
        Row row = sheet.getRow ( ind.y-1 );
        Cell cell = row.getCell ( ind.x );
        return stringValue ( cell );
    }
}
