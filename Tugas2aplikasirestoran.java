import java.util.Scanner;

class Menu {

    String namaMenu;
    int harga;
    String kategori;

    Menu(String namaMenu, int harga, String kategori) {
        this.namaMenu = namaMenu;
        this.harga = harga;
        this.kategori = kategori;
    }
}

public class Tugas2aplikasirestoran {

    static Scanner input = new Scanner(System.in);

    static Menu[] daftarMenu = new Menu[20];
    static int jumlahMenu = 8;

    // =========================
    // INISIALISASI MENU AWAL
    // =========================
    static void inisialisasiMenu() {

        daftarMenu[0] = new Menu("Nasi Goreng", 25000, "Makanan");
        daftarMenu[1] = new Menu("Mie Ayam", 20000, "Makanan");
        daftarMenu[2] = new Menu("Ayam Bakar", 30000, "Makanan");
        daftarMenu[3] = new Menu("Soto Ayam", 22000, "Makanan");

        daftarMenu[4] = new Menu("Es Teh", 10000, "Minuman");
        daftarMenu[5] = new Menu("Jus Jeruk", 15000, "Minuman");
        daftarMenu[6] = new Menu("Kopi Hitam", 12000, "Minuman");
        daftarMenu[7] = new Menu("Air Mineral", 8000, "Minuman");
    }

    // =========================
    // TAMPIL MENU
    // =========================
    static void tampilkanMenu() {

        System.out.println("\n===== DAFTAR MENU RESTORAN =====");

        for (int kategori = 1; kategori <= 2; kategori++) {

            switch (kategori) {

                case 1:
                    System.out.println("\n--- MENU MAKANAN ---");
                    break;

                case 2:
                    System.out.println("\n--- MENU MINUMAN ---");
                    break;
            }

            for (int i = 0; i < jumlahMenu; i++) {

                if (kategori == 1 &&
                        daftarMenu[i].kategori.equalsIgnoreCase("Makanan")) {

                    System.out.println(
                            daftarMenu[i].namaMenu +
                                    " = Rp." +
                                    daftarMenu[i].harga);

                } else if (kategori == 2 &&
                        daftarMenu[i].kategori.equalsIgnoreCase("Minuman")) {

                    System.out.println(
                            daftarMenu[i].namaMenu +
                                    " = Rp." +
                                    daftarMenu[i].harga);
                }
            }
        }
    }

    // =========================
    // CARI HARGA
    // =========================
    static int cariHarga(String namaMenu) {

        for (int i = 0; i < jumlahMenu; i++) {

            if (daftarMenu[i].namaMenu
                    .equalsIgnoreCase(namaMenu)) {

                return daftarMenu[i].harga;
            }
        }

        return 0;
    }

    // =========================
    // CEK MINUMAN
    // =========================
    static boolean cekMinuman(String namaMenu) {

        for (int i = 0; i < jumlahMenu; i++) {

            if (daftarMenu[i].namaMenu
                    .equalsIgnoreCase(namaMenu)) {

                if (daftarMenu[i].kategori
                        .equalsIgnoreCase("Minuman")) {

                    return true;
                }
            }
        }

        return false;
    }

    // =========================
    // PESAN MENU
    // =========================
    static void pesanMenu() {

        String[] pesanan = new String[4];
        int[] jumlah = new int[4];

        int subtotal = 0;
        int diskon = 0;
        int promoMinuman = 0;
        int pajak;
        int pelayanan = 20000;

        System.out.println("\n===== PEMESANAN MENU =====");

        for (int i = 0; i < 4; i++) {

            System.out.print("Nama Menu ke-" + (i + 1) + " : ");
            pesanan[i] = input.nextLine();

            if (cariHarga(pesanan[i]) == 0) {

                System.out.println("Menu tidak tersedia.");
                jumlah[i] = 0;

            } else {

                System.out.print("Jumlah Pesanan : ");
                jumlah[i] = input.nextInt();
                input.nextLine();
            }
        }

        // HITUNG SUBTOTAL
        for (int i = 0; i < 4; i++) {

            int harga = cariHarga(pesanan[i]);

            subtotal += harga * jumlah[i];
        }

        // DISKON
        if (subtotal > 100000) {

            diskon = subtotal * 10 / 100;

        } else {

            diskon = 0;
        }

        // PROMO MINUMAN
        if (subtotal > 50000) {

            for (int i = 0; i < 4; i++) {

                if (cekMinuman(pesanan[i])) {

                    promoMinuman = cariHarga(pesanan[i]);
                    break;
                }
            }
        }

        // PAJAK DAN TOTAL
        pajak = subtotal * 10 / 100;

        int totalBayar =
                subtotal +
                        pajak +
                        pelayanan -
                        diskon -
                        promoMinuman;

        // CETAK STRUK
        System.out.println("\n========== STRUK PEMBAYARAN ==========");

        for (int i = 0; i < 4; i++) {

            if (jumlah[i] > 0) {

                int harga = cariHarga(pesanan[i]);
                int totalItem = harga * jumlah[i];

                System.out.println(
                        pesanan[i] +
                                " x " +
                                jumlah[i] +
                                " = Rp." +
                                totalItem);
            }
        }

        System.out.println("--------------------------------------");
        System.out.println("Subtotal            = Rp." + subtotal);
        System.out.println("Pajak 10%           = Rp." + pajak);
        System.out.println("Biaya Pelayanan     = Rp." + pelayanan);
        System.out.println("Diskon              = Rp." + diskon);
        System.out.println("Promo Minuman       = Rp." + promoMinuman);
        System.out.println("--------------------------------------");
        System.out.println("TOTAL BAYAR         = Rp." + totalBayar);
    }

    // =========================
    // TAMBAH MENU
    // =========================
    static void tambahMenu() {

        if (jumlahMenu >= daftarMenu.length) {

            System.out.println("Kapasitas menu penuh.");
            return;
        }

        System.out.println("\n===== TAMBAH MENU BARU =====");

        System.out.print("Nama Menu : ");
        String nama = input.nextLine();

        System.out.print("Harga Menu : ");
        int harga = input.nextInt();
        input.nextLine();

        System.out.print("Kategori (Makanan/Minuman) : ");
        String kategori = input.nextLine();

        daftarMenu[jumlahMenu] =
                new Menu(nama, harga, kategori);

        jumlahMenu++;

        System.out.println("Menu berhasil ditambahkan.");
    }

    // =========================
    // UBAH HARGA
    // =========================
    static void ubahHarga() {

        System.out.println("\n===== UBAH HARGA MENU =====");

        System.out.print("Masukkan nama menu : ");
        String nama = input.nextLine();

        boolean ditemukan = false;

        for (int i = 0; i < jumlahMenu; i++) {

            if (daftarMenu[i].namaMenu
                    .equalsIgnoreCase(nama)) {

                System.out.println(
                        "Harga Lama : Rp." +
                                daftarMenu[i].harga);

                System.out.print("Harga Baru : ");
                int hargaBaru = input.nextInt();
                input.nextLine();

                daftarMenu[i].harga = hargaBaru;

                System.out.println("Harga berhasil diubah.");

                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {

            System.out.println("Menu tidak ditemukan.");
        }
    }

    // =========================
    // KELOLA MENU
    // =========================
    static void kelolaMenu() {

        int pilihKelola;

        do {

            System.out.println("\n===== KELOLA MENU =====");
            System.out.println("1. Tambah Menu Baru");
            System.out.println("2. Ubah Harga Menu");
            System.out.println("3. Kembali");

            System.out.print("Pilih : ");
            pilihKelola = input.nextInt();
            input.nextLine();

            switch (pilihKelola) {

                case 1:
                    tambahMenu();
                    break;

                case 2:
                    ubahHarga();
                    break;

                case 3:
                    System.out.println("Kembali ke menu utama.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihKelola != 3);
    }

    // =========================
    // MENU UTAMA
    // =========================
    static void menuUtama() {

        System.out.println("\n===== APLIKASI RESTORAN =====");
        System.out.println("1. Tampilkan Daftar Menu");
        System.out.println("2. Pesan Menu");
        System.out.println("3. Kelola Menu Restoran");
        System.out.println("4. Keluar");

        System.out.print("Pilih Menu : ");
    }

    // =========================
    // MAIN METHOD
    // =========================
    public static void main(String[] args) {

        inisialisasiMenu();

        int pilihan;
        boolean jalan = true;

        do {

            menuUtama();

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:
                    tampilkanMenu();
                    break;

                case 2:
                    pesanMenu();
                    break;

                case 3:
                    kelolaMenu();
                    break;

                case 4:

                    System.out.print("Yakin ingin keluar? (Y/T) : ");
                    String jawab = input.nextLine();

                    if (jawab.equalsIgnoreCase("Y")) {

                        jalan = false;
                        System.out.println("Program selesai.");
                    }

                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (jalan);
    }
}