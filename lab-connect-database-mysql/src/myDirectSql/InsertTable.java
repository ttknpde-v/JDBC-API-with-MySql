package myDirectSql;

import java.sql.Connection; /* using connect database */
import java.sql.SQLException; /* using tell somethings error */
import java.sql.Statement; /* using send statement SQL */

public class InsertTable {

    private void setInsert (Connection connection , String directSql) {
            /** in java Statement => Insert , Update , Delete we use executeUpdate() (ใช้สำหรับการประมวลผล Statement Sql) */
            int resultInsert = 0;
            Statement stateSQL = null;
            /** create variable type object */
            try {

                stateSQL = connection.createStatement();
                /* this variable object
                *  direct createStatement() is creation a object for send statement SQL
                *  to database */

                resultInsert = stateSQL.executeUpdate(directSql);  // # same Query in php
                /* method executeUpdate() it returns (integer) rows in table (แถวของคำสั่ง)
                *  เช่น return จำนวนแถวที่ทำการลบ
                *  */
                checkSetInsert(resultInsert);

                } catch (SQLException event) {
                    /* when direct SQL wrong this block will work*/
                    System.out.println("Insert Into Table Failed. "+event);

                }
    }

    private void checkSetInsert (int resultInsert) {
        if (resultInsert == 1) System.out.println("Insert Success.");
    }

    public void getInsert (Connection connection , String directSql) { // # mutator method
        this.setInsert(connection,directSql);
    }
}
