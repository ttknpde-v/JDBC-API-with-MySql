package myApp;
/* import file Java (difference package) */

import myDirectSql.DeleteTable;
import myDirectSql.InsertTable;
import myDirectSql.SelectTable;
import myDirectSql.UpdateTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConnectDatabase {

    /* Style declare variable for configure database
    *  same php it must be String type */
    private String dateNow = getFormatDate();
    final private String host = "127.0.0.1";
    final private String password = "Architecture.890.098";
    final private String port = "3307";
    final private String databaseName ="web-blog";
    final private String url = "jdbc:mysql://"+host+":"+port+"/"+databaseName; /* Format for setting URL [jdbc:<ระบบฐานข้อมูล>://<host>:<port>/<name database>] */
    private String directSql = "update comments set nickname = 'Alfred Schmidt' , comment = 'am a programmer in thailand and am very rich!!!!' " +
            "where id_comment = '25';";

    public static void main(String[] args) {
        /* start project */
        new ConnectDatabase().open();

    }

    private void open() {

        InsertTable obj_insert = new InsertTable();
        SelectTable obj_select = new SelectTable();
        UpdateTable obj_update = new UpdateTable();
        DeleteTable obj_delete = new DeleteTable();

        Connection connect = null;
        Class loadDriver = null;

        try {  // use exception for tell me some errors


            loadDriver = Class.forName("com.mysql.cj.jdbc.Driver"); // # Load Driver after set path in folder root
            loadDriver.getClasses(); // # calls Load Driver


            /* Format for load driver
            *  Class.forName("ชื่อของ JDBC Driver ที่ต้องการ");
            *  this is name class MySql Driver "com.mysql.cj.jdbc.Driver" // new version
            *  file library (.jar) */


            String user = "thitikorn_db";
            connect = DriverManager.getConnection(this.url , user,this.password); // # Create Connection
            /* Connect Database must call,use Class DriverManager
            *  and must call a method <getConnection()> for connect database
            *  Format for connect database
            *  DriverManager.getConnection(<URL> , <USER NAME> , <PASSWORD> );
            *  + port we actually set in URL  + */
            checkConnect(connect);

            /* Insert Into table */
            /* obj_insert.getInsert(connect, this.directSql); // # Process in Package myDirectSql */

            /* Select table */
            /* obj_select.getSelect(connect,directSql); */

            /* Update table */
            /* obj_update.getUpdate(connect,directSql); */

            /*Delete table */
            /* obj_delete.getDelete(connect,"delete from comments where id_comment = '15'; "); */



            connect.close(); // # Close connection

            } catch (SQLException | ClassNotFoundException error) {
            /* ClassNotFoundException for tell me when not found JDBC Driver
            *  SQLException for tell me when something is wrong from getConnect() */
                System.out.println("Connect failed. check somethings "+error);
            } finally {



            }

    }


    private void checkConnect (Connection connect) {
        /* check object is empty or no*/
        if(connect != null) System.out.println("Database Connect Successful");
    }


    private String getFormatDate () {
        LocalDateTime myDateTime = LocalDateTime.now(); /* library about time (local) at now */
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss"); /*  library about clear format date time */
        String formatDate = myDateTime.format(myFormat);
        return formatDate;
    }

}
