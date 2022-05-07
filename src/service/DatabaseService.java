package service;



import entity.AuthorEntity;
import entity.TypeEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/pao";

    static final String USER = "sa";
    static final String PASS = "sa";

    public static List<AuthorEntity> readAuthorsQuery(){
        Connection conn = null;
        Statement stmt = null;
        List<AuthorEntity> result = new ArrayList<AuthorEntity>();
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // STEP 3: Execute a query
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            String sql = "SELECT * from author";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 4: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String country = rs.getString("country");

                // Display values
                AuthorEntity author = new AuthorEntity(id, name, country);
                result.add(author);
            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        System.out.println("Goodbye!");
        return result;
    }

    public static List<TypeEntity> readTypesQuery(){
        Connection conn = null;
        Statement stmt = null;
        List<TypeEntity> result = new ArrayList<TypeEntity>();
        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            String sql = "SELECT * from author_type";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                int id_a  = rs.getInt("author_id");
                int id_t = rs.getInt("type_id");

                TypeEntity type = new TypeEntity(id_a, id_t);
                result.add(type);
            }
            rs.close();
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            }
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
        return result;
    }
}
