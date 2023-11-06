import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
public class shiva {
    public static void main(String[] args) {     
        Scanner sc=new Scanner(System.in);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sidd","root","root");
            if(!con.isClosed()){
                //System.out.println("Connection is created.........");
                System.out.println("Enter the name of Student : ");
                String name=sc.nextLine();
                System.out.println("Enter the roll number : ");
                String roll=sc.next();
                String q="insert into student(name,rollnum) values(?,?)";
                PreparedStatement pstmt=con.prepareStatement(q);
                pstmt.setString(1, name);
                pstmt.setString(2, roll);
                pstmt.executeUpdate();
                con.close();
                System.out.println("insert successful........");
                
            }
            else{
                System.out.println("Connection faild......");
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
