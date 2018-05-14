package by.tc.epam.model.dao.connection_pool.util;

public class DBProperty {

    private DBProperty() {
    }

    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/bukmaker?useUnicode=true&characterEncoding=UTF-8";

    public static final String DB_USER = "root";
    public static final String DB_PASS = "mischa98";
    public static final int CONNECTIONS_COUNT = 10;

//    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    public static final String DB_URL = "jdbc:mysql://node52919-mmbet.mycloud.by/bukmaker?useUnicode=true&characterEncoding=UTF-8";
//
//    public static final String DB_USER = "root";
//    public static final String DB_PASS = "YKYiog85637";
//    public static final int CONNECTIONS_COUNT = 10;
}
