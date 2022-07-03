import java.sql.*;

public class P1_ReadData {

    //MySql de day3 de..

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "1234");

        Statement st = con.createStatement();
        System.out.println("Soru 1*********************");
        // SORU1: Talebeler tablosundan tum kayitları listeleyiniz.
        ResultSet kayitlar = st.executeQuery("select * from talebeler");
        while (kayitlar.next()) {
            System.out.printf("%-6d %-15.15s %-8s %-5d\n", kayitlar.getInt(1),
                    kayitlar.getString(2), kayitlar.getString(3), kayitlar.getInt(4));
        }
        System.out.println("Soru 2*********************");
        // SORU2: Talebeler tablosunda notları 90 uzeri olan kayitları listeleyiniz.
        kayitlar = st.executeQuery("select * from talebeler where yazili_notu>90");
        while (kayitlar.next()) {
            System.out.printf("%-6d %-15.15s %-8s %-5d\n", kayitlar.getInt(1),
                    kayitlar.getString(2), kayitlar.getString(3), kayitlar.getInt(4));
        }
        System.out.println("Soru 3*********************");
        // SORU3: Talebeler tablosunda id'si 124 olan öğrencilerin tüm bilgilerini listeleyiniz.
        kayitlar = st.executeQuery("select * from talebeler where id=124");
        while (kayitlar.next()) {
            System.out.printf("%-6d %-15.15s %-8s %-5d\n", kayitlar.getInt(1),
                    kayitlar.getString(2), kayitlar.getString(3), kayitlar.getInt(4));
        }
        System.out.println("Soru 4*********************");
        // SORU4: Talebeler tablosunda notu 70 ile 90 arasindaki kisilerin isimlerini listeleyiniz.
        kayitlar = st.executeQuery("select isim, yazili_notu from talebeler where yazili_notu between '70' And '90'");
        while (kayitlar.next()) {
            System.out.printf("%-16s %-16s\n",
                    kayitlar.getObject(1), kayitlar.getObject(2));
        }
        System.out.println("Soru 5*********************");
        // SORU5: Talebeler tablosunda isminin 2. harfi e olan kisilerin veli_isimleri ile birlikte listeleyiniz.
        kayitlar = st.executeQuery("select isim, veli_isim from talebeler where isim like '_e%'");
        while (kayitlar.next()) {
            System.out.printf("%-16s %-16s\n",
                    kayitlar.getObject(1), kayitlar.getObject(2));
        }

    }
}


