package myDirectSql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTable {
    private void setDelete(Connection connection , String directSql) {
        Statement stateSendSql = null;
        int resultDelete;
            try {

                stateSendSql = connection.createStatement();
                resultDelete = stateSendSql.executeUpdate(directSql);
                checkDelete(resultDelete);

            } catch (SQLException errors) {
                System.out.println("Delete Table Failed "+errors);
            }
    }
    private void checkDelete(int resultDelete) {
        if (resultDelete != 0) System.out.println("Delete Success.");
    }
    public void getDelete(Connection connection , String directSql) {
        this.setDelete(connection , directSql);
    }

}
