import java.sql.*;
import com.mysql.cj.protocol.Resultset;
import java.util.InputMismatchException;

public class TerimaGaji extends Gaji
{
    public Integer totalgaji;
    static Connection conn;
	String link = "jdbc:mysql://localhost:3306/dbgajipegawai";  



    @Override
    public void TotalGaji() 
    {
        this.totalgaji = this.gajipokok;
    }

    public void TampilJabatan()
    {
        if (tampilJabatan==1)
        {
            System.out.println("DIREKTUR");
        }
        else if (tampilJabatan==2)
        {
            System.out.println("WAKIL DIREKTUR");
        }
        else if (tampilJabatan==3)
        {
            System.out.println("SEKRETARIS");
        }
        else if (tampilJabatan==4)
        {
            System.out.println("BENDAHARA");
        }
        else if (tampilJabatan==5)
        {
            System.out.println("KEAMANAN");
        }
    }

    public void tampilInfo()
    {
        System.out.println("\n================================");
        System.out.println("     Informasi Gaji Pegawai");
        System.out.println("================================");
        System.out.println("Nama pegawai    : "+this.namaPegawai);
        System.out.println("(Jumlah karakter: " +this.namaPegawai.length() + " Huruf)"); //lenght
        System.out.println("Nomor Pegawai   : "+this.noPegawai);
        System.out.print("Jabatan         : ");
        TampilJabatan();
        System.out.println("Gaji Pokok      : Rp. " + this.gajipokok);
        System.out.println("Total gaji      : Rp. "+this.totalgaji);

    }

    @Override
    public void save() throws SQLException 
    {
        try 
        {
            System.out.println("Masukkan data karyawan"); 
            NamaPegawai();
            NoPegawai();
            Jabatan();
            GajiPokok();
            TotalGaji();

            String sql = "INSERT INTO gajipegawai (namapegawai, nopegawai, jabatan, totalgaji,gajipokok) VALUES ('"+namaPegawai+"','"+noPegawai+"','"+jabatan+"','"+totalgaji+"','"+gajipokok+"')";
            conn = DriverManager.getConnection(link,"root","");
            Statement statement = conn.createStatement();
            statement.execute(sql);
            System.out.println("Berhasil input data!!");
        }
        catch (ArrayIndexOutOfBoundsException e)
        {

            System.err.println("Error masukkan nomor jabatan dengan benar");
        }

        catch (IndexOutOfBoundsException e)
        {

            System.err.println("Masukkan rentang jumlah hadir 1-30");
        }

        catch (InputMismatchException e)
        {
            System.err.println("Input pilihan dengan angka saja");
        }

    }

    @Override
    public void delete() throws SQLException
    {
        view();
        try
        {
            System.out.println("Hapus data karyawan");
            System.out.print("Masukkan nomor pegawai yang akan dihapus : ");
            String noPegawai = input.nextLine();

            String sql = "DELETE FROM gajipegawai WHERE nopegawai = "+ noPegawai;

            conn = DriverManager.getConnection(link,"root","");
	        Statement statement = conn.createStatement();

            if(statement.executeUpdate(sql) > 0)
            {
	            System.out.println("Berhasil menghapus data pegawai (Nomor "+noPegawai+")");
	        }
        }

        catch(SQLException e)
        {
	        System.out.println("Terjadi kesalahan dalam menghapus data");
	    }
        catch(Exception e)
        {
            System.out.println("masukan data yang benar");
        }
    }

    @Override
    public void update() throws SQLException
    {
        view();
        try
        {
            System.out.print("Masukkan nomor pegawai hendak diubah: ");
            String noPegawai = input.nextLine();

            String sql = "SELECT * FROM gajipegawai WHERE nopegawai = " +noPegawai;
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if (result.next())
            {
                System.out.print("Nama baru ["+result.getString("namapegawai")+"]\t: ");
                String namaPegawai = input.nextLine();

                sql = "UPDATE gajipegawai SET namapegawai='"+namaPegawai+"' WHERE nopegawai='"+noPegawai+"'";

                if(statement.executeUpdate(sql) > 0)
                {
                    System.out.println("Berhasil memperbaharui data pegawai (Nomor "+noPegawai+")");
                }
            }
            statement.close();
        }

            catch (SQLException e) 
            {
                System.err.println("Terjadi kesalahan dalam mengedit data");
                System.err.println(e.getMessage());
            }

    }



    @Override
    public void search() throws SQLException
    {
        System.out.print("Masukkan Nama Pegawai yang ingin dilihat : ");    
		String keyword = input.nextLine();

		String sql = "SELECT * FROM gajipegawai WHERE namapegawai LIKE '%"+keyword+"%'";
		conn = DriverManager.getConnection(link,"root","");
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql); 

        while (result.next())
        {
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

}