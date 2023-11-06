/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

/**
 *
 * @author ASUS
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;

public class koneksi {

    public static PreparedStatement prepareStatement(String sql) throws SQLException {
    Connection connection = getConnection(); // Gantilah ini dengan cara mendapatkan koneksi ke database Anda
    return connection.prepareStatement(sql);    
    }

    private static Connection getConnection() {
        Object connection = null;
    if (connection != null) {
            return (Connection) connection;
        } else {
            try {
                String url = "jdbc:mysql://localhost:3306/inventory"; // Ganti dengan URL database Anda
                String username = "root"; // Ganti dengan nama pengguna database Anda
                String password = ""; // Ganti dengan kata sandi database Anda
                
                connection = DriverManager.getConnection(url, username, password);
                return (Connection) connection;
            } catch (SQLException e) {
                e.printStackTrace();
                return null; // Atau Anda bisa melakukan penanganan kesalahan lain sesuai kebutuhan Anda
            }  
    }
    }
    private Connection koneksi;

        public static Statement createStatement() throws SQLException, ClassNotFoundException {
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/inventory";
            String username = "root";
            String password = "";

            // Membuat koneksi
            Connection connection = DriverManager.getConnection(url, username, password);

            // Membuat objek Statement dari koneksi
            Statement statement = connection.createStatement();

            return statement;
        }    catch (SQLException e){
                System.out.println("Gagal Koneksi Database"+e);
            }

        return null;
    }
  
    
    
    public Connection koneksi(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Berhasil Koneksi");
        }   catch (ClassNotFoundException ex){
            System.out.println ("Gagal Koneksi"+ex);
        }
        
        String url ="jdbc:mysql://localhost:3306/inventory";
        try {
            koneksi = DriverManager.getConnection(url,"root","");
            System.out.println("Berhasil Koneksi Database");
        }   catch (SQLException ex){
            System.out.println("Gagal Koneksi Database"+ex);
        }
        return koneksi;
    }
}