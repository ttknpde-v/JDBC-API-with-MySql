package myDirectSql;

import java.sql.SQLException; /* using tell somethings error */
import java.sql.Connection; /* using connect database */
import java.sql.Statement; /* using send statement SQL */
import java.sql.ResultSet; /* using same pointer for data from select */
public class SelectTable {
    private void setSelectTable (Connection connection , String directSql) {

        ResultSet resultSet = null;
        Statement statementSQL = null;
        /* create Object from class */
        try {
        statementSQL= connection.createStatement();
        resultSet = statementSQL.executeQuery(directSql); // # ประมวลผลแล้วเก็บผลลัพธ์เป็น set
        /** executeQuery() uses with statement SELECT (ผลลัพธ์จะอยู่ในรูป result set same pointer)
         *  and we can check value by next() method
         *  working same language */
        showTable(resultSet);

        } catch (SQLException events) {
            /* when direct SQL something wrong it works in here */
            System.out.println("Select table Failed. "+events);
        }

    }

    private void showTable (ResultSet resultSet) {
        String nickname , comment , dateandtime;
        int id_comment;
        try {

            while (resultSet.next()) {

                nickname = resultSet.getString("nickname");
                comment = resultSet.getString("comment");
                dateandtime = resultSet.getString("dateandtime");
                id_comment = resultSet.getInt("id_comment");

                System.out.print
                        ("order : "+id_comment+" "+
                         "name : " +nickname+"\n"+
                         "message : " +comment+"\n"+
                         "date and time " +dateandtime+"\n\n");

            }

            } catch (SQLException errors) {

                System.out.println("While loop Failed. "+errors);

            }
    }

    public void getSelect(Connection connection, String directSql) { // method mutator
        this.setSelectTable(connection,directSql);
    }

}
