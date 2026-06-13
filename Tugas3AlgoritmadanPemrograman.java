import java.util.Scanner;

public class Tugas3AlgoritmadanPemrograman {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Deklarasi Array Gaji
        double[] gaji = {5000000, 6500000, 9500000};

        // Deklarasi Array Persentase Lembur
        double[] lembur = {0.30, 0.32, 0.34, 0.36, 0.38};

        // Deklarasi Variabel
        String golongan;
        int jamLembur;
        double gajiPokok = 0;
        double persenLembur = 0;
        double gajiLembur;
        double totalGaji;

        // Input Data
        System.out.println("=== PROGRAM PENGHASILAN KARYAWAN ===");

        System.out.print("Masukkan Golongan Karyawan (A/B/C): ");
        golongan = input.nextLine();

        System.out.print("Masukkan Jumlah Jam Lembur: ");
        jamLembur = input.nextInt();

        // Menentukan Gaji Pokok dari Array Gaji
        if (golongan.equalsIgnoreCase("A")) {
            gajiPokok = gaji[0];
        } else if (golongan.equalsIgnoreCase("B")) {
            gajiPokok = gaji[1];
        } else if (golongan.equalsIgnoreCase("C")) {
            gajiPokok = gaji[2];
        } else {
            System.out.println("Golongan tidak valid!");
            return;
        }

        // Menentukan Persentase Lembur dari Array Lembur
        if (jamLembur == 1) {
            persenLembur = lembur[0];
        } else if (jamLembur == 2) {
            persenLembur = lembur[1];
        } else if (jamLembur == 3) {
            persenLembur = lembur[2];
        } else if (jamLembur == 4) {
            persenLembur = lembur[3];
        } else if (jamLembur >= 5) {
            persenLembur = lembur[4];
        }

        // Perhitungan Gaji
        gajiLembur = gajiPokok * persenLembur;
        totalGaji = gajiPokok + gajiLembur;

        // Output Hasil Perhitungan
        System.out.println("\n=== HASIL PERHITUNGAN ===");
        System.out.println("Golongan Karyawan : " + golongan);
        System.out.println("Gaji Pokok        : Rp " + gajiPokok);
        System.out.println("Jam Lembur        : " + jamLembur);
        System.out.println("Gaji Lembur       : Rp " + gajiLembur);
        System.out.println("Total Penghasilan : Rp " + totalGaji);
    }
}