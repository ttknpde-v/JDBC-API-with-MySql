package myDirectSql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/* file update table */
public class UpdateTable {
    private void setUpdate (Connection connection , String directSql) {

        Statement stateSendSQL = null;
        int resultUpdate;
        try {

            stateSendSQL = connection.createStatement();
            /* creation a object for send statement SQL */
            resultUpdate = stateSendSQL.executeUpdate(directSql);
            /* send statement to SQL and
            *  set a result to variable */
            checkUpdateSql(resultUpdate);

            } catch (SQLException errors) {

                System.out.println("Update table is failed "+errors);

            }
    }

    private void checkUpdateSql (int result) {
        if(result!=0) System.out.println("Update Success.");
    }

    public void getUpdate (Connection connection , String directSql) {
        this.setUpdate(connection,directSql);
    }

}
