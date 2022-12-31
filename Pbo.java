import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;

//Subkelas Dari Kelas Warnet
public class Pbo extends Warnet

{
    // Deklarasi Scanner
    static Scanner input = new Scanner(System.in);
    static Connection conn;

    public static void main(String[] args) throws Exception {

        String pilihan;
        boolean next = true;

        // Koneksi Database
        String url = "jdbc:mysql://localhost:3306/warnett";

        // Exception
        try {

            // Koneksi Database
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "");

            datestring d = new datestring();

            // Perulangan
            while (next) {
                d.string();
                d.set();
                d.map();
                d.date();
                System.out.println("\n\n       ===============  ");
                System.out.println("            Warnet Gimang      ");
                System.out.println("           ===============  ");
                System.out.println("1. Lihat Data Member ");
                System.out.println("2. Tambah Member ");
                System.out.println("3. Ubah Member ");
                System.out.println("4. Hapus Member ");

                System.out.print("Inputkan Pilihan : ");
                pilihan = input.next();

                // Percabangan
                switch (pilihan) {
                    case "1":
                        lihatdata();
                        break;

                    case "2":
                        tambahdata();
                        break;

                    case "3":
                        updatedata();
                        break;

                    case "4":
                        hapusdata();
                        break;

                    default:
                        System.out.println("Input tidak sesuai");
                }

            }
            System.out.println("Program Selesai");

        } catch (SQLException ex) {
            System.err.println("Tidak berhasil terkoneksi");
        } catch (InputMismatchException n) {
            System.out.println("Inputan Salah!!!");
        }

    }

    // Method yang di extend
    public static void lihatdata() throws SQLException {
        // Syntax untuk lihatdata() dari database
        String sql = "SELECT * FROM data_warnet";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        // Perulangan
        while (result.next()) {
            System.out.println();
            System.out.println("ID Member           : " + result.getInt("id_member"));
            System.out.println("Nama Member         : " + result.getString("nama_member"));
            System.out.println("Durasi Bermain      : " + result.getInt("durasi") + " jam");
            System.out.print("Total Harga         : " + "Rp" + result.getInt("total_harga"));
            System.out.println();
        }

    }

    // Method yang di extend
    public static void tambahdata() throws SQLException {
        System.out.println("--------------");
        System.out.println("  Input Data  ");
        System.out.println("--------------");

        // Exception
        try {
            System.out.print("ID Member         : ");
            idmember = input.nextInt();
            System.out.print("\nNama Member          : ");
            nama = input.next();

            System.out.print("Durasi Bermain         : ");
            durasi = input.nextInt();

            // Proses Matematika
            totalharga = durasi * 5000;
            System.out.print("Total Harga   : " + totalharga);
            System.out.println();

            // Syntax untuk tambahdata() pada database
            String sql = "INSERT INTO data_warnet (id_member, nama_member, durasi, total_harga) VALUES ('" + idmember
                    + "','" + nama + "','" + durasi + "','" + totalharga + "')";
            Statement statement = conn.createStatement();
            statement.execute(sql);
            System.out.println("Data Ditambahkan");

        } catch (SQLException e) {
            System.out.println("Data Tidak Berhasil Ditambahkan!!!");
        } catch (InputMismatchException ex) {
            System.out.println("Error!!!");
        } catch (NullPointerException n) {
            System.out.println("Data Tidak Berhasil Ditambahkan!!!");
        }

    }

    // Method yang di extend
    public static void updatedata() throws SQLException {
        Scanner input = new Scanner(System.in);
        // Exception
        try {
            lihatdata();
            System.out.println("\n\nPilih ID Member  : ");
            Integer idmember = Integer.parseInt(input.nextLine());

            // Syntax untuk memilih data yang akan diubah
            String sql = "SELECT * FROM data_warnet WHERE id_member = " + idmember;

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            // Percabangan
            if (result.next()) {

                System.out.print("\nNama [" + result.getString("nama_member") + "]\t : ");
                String nama = input.next();

                System.out.print("\nDurasi[" + result.getDouble("durasi") + "]\t : ");
                Double durasi = input.nextDouble();

                System.out.print("\nTotal Harga[" + result.getInt("total_harga") + "]\t :");
                Double totalharga = input.nextDouble();

                // Syntax untuk menyimpan update data
                sql = "UPDATE data_warnet SET nama_member ='" + nama + "', durasi='" + durasi
                        + "', total_harga='" + totalharga + "' WHERE id_member='" + idmember + "'";
                if (statement.executeUpdate(sql) > 0) {
                    System.out.println("\n\nData Diperbarui (ID Member " + idmember + ")");
                }
            }

        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan dalam mengedit data");
            System.err.println(e.getMessage());

        }

    }

    // Method yang di extend
    public static void hapusdata() throws SQLException {
        Scanner input = new Scanner(System.in);

        // Exception
        try {
            lihatdata();
            System.out.println("\n\nID Member   :");
            Integer idmember = Integer.parseInt(input.nextLine());

            // Syntax untuk menghapus data
            String sql = "DELETE FROM data_warnet WHERE id_member = " + idmember;

            Statement statement = conn.createStatement();
            if (statement.executeUpdate(sql) > 0) {
                System.out.println("\nData Terhapus(id_member" + idmember + ")");
            }
        } catch (InputMismatchException e) {
            System.out.println("Terjadi Kesalahan!!!");
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan dalam menghapus data barang");
        }

    }

}
