
package jobportal;

import java.sql.*;
import java.util.Scanner;

public class Jobportal {

    static Connection con;

    public static void connect() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/job_portal",
            "root",
            "srikesav9@"
        );

        System.out.println("Connected to MySQL Workbench!");
    }

    // INSERT JOB
    public static void insertJob() throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Job Title:");
        String t = sc.nextLine();

        System.out.println("Company:");
        String c = sc.nextLine();

        System.out.println("Salary:");
        int s = sc.nextInt();

        String q = "insert into jobs(title,company,salary) values(?,?,?)";

        PreparedStatement ps = con.prepareStatement(q);

        ps.setString(1, t);
        ps.setString(2, c);
        ps.setInt(3, s);

        ps.executeUpdate();

        System.out.println("Inserted → Check MySQL Workbench");
    }

    // VIEW JOBS
    public static void viewJobs() throws Exception {

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("select * from jobs");

        System.out.println("\nJOB_ID | TITLE | COMPANY | SALARY");

        while(rs.next()) {

            System.out.println(
                rs.getInt(1) + " | " +
                rs.getString(2) + " | " +
                rs.getString(3) + " | " +
                rs.getInt(4)
            );
        }
    }

    // UPDATE SALARY
    public static void updateJob() throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Job ID to Update:");
        int id = sc.nextInt();

        System.out.println("New Salary:");
        int sal = sc.nextInt();

        String q = "update jobs set salary=? where job_id=?";

        PreparedStatement ps = con.prepareStatement(q);

        ps.setInt(1, sal);
        ps.setInt(2, id);

        ps.executeUpdate();

        System.out.println("Updated → Check MySQL Workbench");
    }

    // DELETE JOB
    public static void deleteJob() throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Job ID to Delete:");
        int id = sc.nextInt();

        String q = "delete from jobs where job_id=?";

        PreparedStatement ps = con.prepareStatement(q);

        ps.setInt(1, id);

        ps.executeUpdate();

        System.out.println("Deleted → Check MySQL Workbench");
    }

    public static void main(String[] args) throws Exception {

        connect();

        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("\n1. Insert Job");
            System.out.println("2. View Jobs");
            System.out.println("3. Update Salary");
            System.out.println("4. Delete Job");
            System.out.println("5. Exit");

            int ch = sc.nextInt();

            switch(ch) {

                case 1: insertJob(); break;

                case 2: viewJobs(); break;

                case 3: updateJob(); break;

                case 4: deleteJob(); break;

                case 5: System.exit(0);
            }
        }
    }
}

