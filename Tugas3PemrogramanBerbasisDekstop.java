import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

// ABSTRACT CLASS
abstract class MenuItem {

    private String nama;
    private double harga;
    private String kategori;

    public MenuItem(String nama, double harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }

    // getter
    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public String getKategori() {
        return kategori;
    }

    // setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    // abstract method
    public abstract void tampilMenu();
}

// CLASS MAKANAN
class Makanan extends MenuItem {

    public Makanan(String nama, double harga) {
        super(nama, harga, "Makanan");
    }

    @Override
    public void tampilMenu() {
        System.out.println(
                "Makanan : " + getNama() +
                        " | Harga : Rp" + getHarga());
    }
}

// CLASS MINUMAN
class Minuman extends MenuItem {

    public Minuman(String nama, double harga) {
        super(nama, harga, "Minuman");
    }

    @Override
    public void tampilMenu() {
        System.out.println(
                "Minuman : " + getNama() +
                        " | Harga : Rp" + getHarga());
    }
}

// CLASS DISKON
class Diskon extends MenuItem {

    private double persenDiskon;

    public Diskon(String nama,
                  double harga,
                  double persenDiskon) {

        super(nama, harga, "Diskon");

        this.persenDiskon = persenDiskon;
    }

    public double getPersenDiskon() {
        return persenDiskon;
    }

    public void setPersenDiskon(double persenDiskon) {
        this.persenDiskon = persenDiskon;
    }

    @Override
    public void tampilMenu() {

        System.out.println(
                "Diskon : " + getNama() +
                        " | Potongan : " +
                        persenDiskon + "%");
    }
}

// CLASS MENU
class Menu {

    private ArrayList<MenuItem> daftarMenu =
            new ArrayList<>();

    // tambah menu
    public void tambahMenu(MenuItem item) {
        daftarMenu.add(item);
    }

    // tampil semua menu
    public void tampilSemuaMenu() {

        System.out.println(
                "\n===== DAFTAR MENU =====");

        for (MenuItem item : daftarMenu) {
            item.tampilMenu();
        }
    }

    // cari menu
    public MenuItem cariMenu(String nama) {

        for (MenuItem item : daftarMenu) {

            if (item.getNama()
                    .equalsIgnoreCase(nama)) {

                return item;
            }
        }

        return null;
    }

    // getter daftar menu
    public ArrayList<MenuItem> getDaftarMenu() {
        return daftarMenu;
    }
}

// CLASS PESANAN
class Pesanan {

    private ArrayList<MenuItem> daftarPesanan =
            new ArrayList<>();

    // tambah pesanan
    public void tambahPesanan(MenuItem item) {
        daftarPesanan.add(item);
    }

    // hitung total
    public double hitungTotal() {

        double total = 0;

        for (MenuItem item : daftarPesanan) {
            total += item.getHarga();
        }

        return total;
    }

    // tampil struk
    public void tampilStruk() {

        System.out.println(
                "\n===== STRUK PESANAN =====");

        for (MenuItem item : daftarPesanan) {
            item.tampilMenu();
        }

        System.out.println("-------------------------");
        System.out.println(
                "Total Bayar : Rp" +
                        hitungTotal());
    }

    // getter daftar pesanan
    public ArrayList<MenuItem> getDaftarPesanan() {
        return daftarPesanan;
    }
}

// CLASS FILE MANAGER
class FileManager {

    // simpan menu
    public static void simpanMenu(Menu menu) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter("menu.txt"));

            for (MenuItem item :
                    menu.getDaftarMenu()) {

                writer.write(
                        item.getNama() + " | " +
                                item.getHarga() + " | " +
                                item.getKategori());

                writer.newLine();
            }

            writer.close();

            System.out.println(
                    "Data menu berhasil disimpan.");

        } catch (IOException e) {

            System.out.println(
                    "Terjadi kesalahan saat menyimpan file.");
        }
    }

    // simpan pesanan
    public static void simpanPesanan(
            Pesanan pesanan) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter("pesanan.txt"));

            for (MenuItem item :
                    pesanan.getDaftarPesanan()) {

                writer.write(
                        item.getNama() + " | " +
                                item.getHarga());

                writer.newLine();
            }

            writer.close();

            System.out.println(
                    "Data pesanan berhasil disimpan.");

        } catch (IOException e) {

            System.out.println(
                    "Terjadi kesalahan saat menyimpan file.");
        }
    }
}

// MAIN CLASS
public class Tugas3PemrogramanBerbasisDekstop {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Menu menu = new Menu();
        Pesanan pesanan = new Pesanan();

        // data awal
        menu.tambahMenu(
                new Makanan(
                        "Nasi Goreng", 25000));

        menu.tambahMenu(
                new Minuman(
                        "Es Teh", 10000));

        menu.tambahMenu(
                new Diskon(
                        "Diskon Spesial",
                        0,
                        10));

        int pilihan;

        do {

            System.out.println(
                    "\n===== SISTEM RESTORAN =====");

            System.out.println(
                    "1. Tambah Menu");

            System.out.println(
                    "2. Tampilkan Menu");

            System.out.println(
                    "3. Pesan Menu");

            System.out.println(
                    "4. Tampilkan Struk");

            System.out.println(
                    "5. Simpan Data");

            System.out.println(
                    "6. Keluar");

            System.out.print(
                    "Pilih Menu : ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:

                    try {

                        System.out.print(
                                "Nama Menu : ");

                        String nama =
                                input.nextLine();

                        System.out.print(
                                "Harga : ");

                        double harga =
                                input.nextDouble();

                        input.nextLine();

                        System.out.print(
                                "Kategori (Makanan/Minuman) : ");

                        String kategori =
                                input.nextLine();

                        if (kategori.equalsIgnoreCase(
                                "Makanan")) {

                            menu.tambahMenu(
                                    new Makanan(
                                            nama,
                                            harga));

                        } else if (kategori.equalsIgnoreCase(
                                "Minuman")) {

                            menu.tambahMenu(
                                    new Minuman(
                                            nama,
                                            harga));

                        } else {

                            System.out.println(
                                    "Kategori tidak valid.");
                        }

                        System.out.println(
                                "Menu berhasil ditambahkan.");

                    } catch (Exception e) {

                        System.out.println(
                                "Input tidak valid.");

                        input.nextLine();
                    }

                    break;

                case 2:

                    menu.tampilSemuaMenu();
                    break;

                case 3:

                    System.out.print(
                            "Masukkan nama menu : ");

                    String cari =
                            input.nextLine();

                    MenuItem item =
                            menu.cariMenu(cari);

                    if (item != null) {

                        pesanan.tambahPesanan(item);

                        System.out.println(
                                "Pesanan berhasil ditambahkan.");

                    } else {

                        System.out.println(
                                "Menu tidak ditemukan.");
                    }

                    break;

                case 4:

                    pesanan.tampilStruk();
                    break;

                case 5:

                    FileManager.simpanMenu(menu);

                    FileManager.simpanPesanan(
                            pesanan);

                    break;

                case 6:

                    System.out.println(
                            "Program selesai.");
                    break;

                default:

                    System.out.println(
                            "Pilihan tidak tersedia.");
            }

        } while (pilihan != 6);

        input.close();
    }
}