
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.TreeMap;

//Kelas anak dari Program
public class datestring implements Program {
    // Method yang diwariskan kelas induk
    @Override
    // Date (String & Date)
    public void date() {
        Date date = new Date();
        // SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyy");
        String dateToStr = DateFormat.getInstance().format(date);
        System.out.print("Tanggal         : " + dateToStr);
    }

    // Collection Framework (Set)
    public void set() {
        // LinkedHashSet
        LinkedHashSet<String> x = new LinkedHashSet<String>();
        x.add("Senin");
        x.add("Selasa");
        x.add("Rabu");
        x.add("Kamis");
        x.add("Jumat");
        x.add("Sabtu");
        x.add("Minggu");

        System.out.println("Jadwal Buka Warnet          : " + x);

        x.remove("Senin");

        x.remove("Sabtu");

        x.remove("Jumat");

        x.remove("Selasa");

        System.out.println("Jadwal Buka Warnet Yang Baru  : " + x);
        System.out.println();

    }

    // String (String & Date)
    public void string() {
        // StringTrim()
        System.out.println();
        String Namawarnet = "     Warnet Gimang Unand";

        // System.out.println(Namawarnet.trim());

        // System.out.println();

    }

    // Collestion Framework (Map)
    public void map() {
        // TreeMap
        TreeMap<String, String> x = new TreeMap<String, String>();

        x.put("08.00 - 18.00", "Senin - Jumat");
        x.put("08.00 - 20.00", "Sabtu - Minggu");

        // System.out.println("Jadwal : " + x.entrySet());

    }

}
