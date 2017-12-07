package Util.Read;

/**
 * Created by chenbo on 2017/12/7.
 */
public class Index {

    public int x;
    public int y;

    public Index(){}

    public String get( int x , int y ){
        this.x = x;
        this.y = y;
        String index = new StringBuffer ( ).append ( (char) (x+65) ).append ( y+1 ).toString ();
       return index;
    }

    public void set( String index){

        if ( index.length () == 2 ){
                char cell_1 = index.charAt ( 0 );
                if ( Character.isUpperCase ( cell_1 )){
                    x = cell_1-65;
                    char cell_2 = index.charAt ( 1 );
                    if ( Character.isDigit ( cell_2 )){
                        if ( cell_2-48 > 0) {
                            y = cell_2 - 48;
                        }else {
                            System.out.println ( "不符合限定规则，必须是数字大于0：" + index );
                        }
                    }else {
                        System.out.println ( "不符合限定规则，必须是数字结束：" + index );
                    }
                }else {
                    System.out.println ( "不符合限定规则，必须是大写开头：" + index );
                }

        } else {
            System.out.println ( "不符合限定规则，必须是两个字符：" + index );
        }
    }

    public void set( int x , int y ){
        this.x = x;
        this.y = y;
    }

}
