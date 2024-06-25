import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainCuboid {

    public static void main(String[] args) {
        String namaFile = "C:\\Users\\user\\AppData\\Local\\Temp\\cuboid.txt";

        List<Cuboid> cuboid = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(namaFile))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Cuboid c = new Cuboid();
                c.panjang = Double.parseDouble(row[0]);
                c.lebar = Double.parseDouble(row[1]);
                c.tinggi = Double.parseDouble(row[2]);
                cuboid.add(c);

            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        for (Cuboid balok : cuboid) {
            double volume = balok.hitungVolume();
            double luasPermukaan = balok.hitungLuasPermukaan();
            System.out.println("Volume balok adalah: " + volume);
            System.out.println("Luas permukaan balok adalah: " + luasPermukaan);
        }
        cuboid.sort(Comparator.comparing(Cuboid :: hitungLuasPermukaan));
        try(FileWriter fw = new FileWriter("D:\\b.indo adji\\UAS PL\\src\\Urutan.txt")) {
            for (Cuboid balok : cuboid) {
                fw.write(balok.hitungLuasPermukaan() + "\n");
            }

        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

}

