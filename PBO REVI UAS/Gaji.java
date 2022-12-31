import java.util.Scanner;
import java.sql.*;
import com.mysql.cj.protocol.Resultset;

public class Gaji implements CVREPI, Database {
    public Integer noPegawai;
    public Integer jumlahhadir;
    public Integer tampilJabatan;
    public Integer gajipokok;
    public Integer jabatan;
    public Integer[] nojabatan = { 1, 2, 3, 4, 5 };
    public String namaPegawai;
    // variable

    static Connection conn;
    String link = "jdbc:mysql://localhost:3306/dbgajipegawai";

    Scanner input = new Scanner(System.in);
    // scan

    @Override
    public void NoPegawai() {
        System.out.print("Masukkan Nomor Pegawai : ");
        this.noPegawai = input.nextInt();
        System.out.println("================================");
    }
    // override method NoPegawai

    @Override
    public void NamaPegawai() {
        System.out.print("Masukkan Nama Pegawai  : ");
        this.namaPegawai = input.nextLine();
    }
    // override method NamaPegawai

    public void Jabatan() {
        System.out.println("\n================================");
        System.out.println("          Daftar Jabatan ");
        System.out.println("================================");
        System.out.println("1. DIREKTUR");
        System.out.println("2. WAKIL DIREKTUR");
        System.out.println("3. SEKRETARIS");
        System.out.println("4. BENDAHARA");
        System.out.println("5. KEAMANAN");
        System.out.print("Masukkan No jabatan anda : ");
        this.jabatan = input.nextInt();
        // this.jabatan = input.nextLine();
        if (this.jabatan == 1) {
            tampilJabatan = 1;
        } else if (this.jabatan == 2) {
            tampilJabatan = 2;
        } else if (this.jabatan == 3) {
            tampilJabatan = 3;
        } else if (this.jabatan == 4) {
            tampilJabatan = 4;
        } else if (this.jabatan == 5) {
            tampilJabatan = 5;
            nojabatan[6] = 6;
        }
    }

    @Override
    public void GajiPokok() {
        System.out.println();
        if (this.jabatan == 1) {
            this.gajipokok = 20000000;
        } else if (jabatan == 2) {
            this.gajipokok = 10000000;
        } else if (jabatan == 3) {
            this.gajipokok = 8000000;
        } else if (jabatan == 4) {
            this.gajipokok = 6000000;
        } else if (jabatan == 5) {
            this.gajipokok = 2000000;
        }
    }

    public void Potongan() {

    }

    public void TotalGaji() {

    }

    @Override
    public void view() throws SQLException {
        System.out.println("Daftar seluruh pegawai");
        String sql = "SELECT * FROM gajipegawai";
        conn = DriverManager.getConnection(link, "root", "");
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            System.out.print("\nNo pegawai\t\t: ");
            System.out.print(result.getString("nopegawai"));
            System.out.print("\nNama pegawai\t\t: ");
            System.out.print(result.getString("namapegawai"));
            System.out.print("\nJabatan\t\t\t: ");
            System.out.print(result.getString("jabatan"));
            System.out.print("\nTotal gaji\t\t: ");
            System.out.println(result.getInt("totalgaji"));
            System.out.print("\nTotal gajipokok\t\t: ");
            System.out.println(result.getInt("gajipokok"));
        }
    }

    public void update() throws SQLException {

    }

    public void delete() throws SQLException {

    }

    public void save() throws SQLException {

    }

    public void search() throws SQLException {

    }

}