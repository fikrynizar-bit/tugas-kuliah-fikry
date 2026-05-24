import java.util.Scanner;

public class AplikasiGajiKaryawan {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Deklarasi Variabel
        String golongan;
        int jamLembur;
        double gajiPokok = 0;
        double persenLembur = 0;
        double gajiLembur;
        double totalGaji;

        // Input Data
        System.out.println("=== PROGRAM PERHITUNGAN GAJI KARYAWAN ===");

        System.out.print("Masukkan Golongan Karyawan (A/B/C) : ");
        golongan = input.nextLine();

        System.out.print("Masukkan Jumlah Jam Lembur : ");
        jamLembur = input.nextInt();

        // Menentukan Gaji Pokok Berdasarkan Golongan
        if (golongan.equalsIgnoreCase("A")) {
            gajiPokok = 5000000;
        }
        else if (golongan.equalsIgnoreCase("B")) {
            gajiPokok = 6500000;
        }
        else if (golongan.equalsIgnoreCase("C")) {
            gajiPokok = 9500000;
        }
        else {
            System.out.println("Golongan tidak valid!");
        }

        // Menentukan Persentase Lembur
        if (jamLembur == 1) {
            persenLembur = 0.30;
        }
        else if (jamLembur == 2) {
            persenLembur = 0.32;
        }
        else if (jamLembur == 3) {
            persenLembur = 0.34;
        }
        else if (jamLembur == 4) {
            persenLembur = 0.36;
        }
        else if (jamLembur >= 5) {
            persenLembur = 0.38;
        }

        // Perhitungan Gaji
        gajiLembur = gajiPokok * persenLembur;
        totalGaji = gajiPokok + gajiLembur;

        // Output
        System.out.println("\n=== HASIL PERHITUNGAN ===");
        System.out.println("Golongan Karyawan : " + golongan);
        System.out.println("Gaji Pokok        : Rp " + gajiPokok);
        System.out.println("Jam Lembur        : " + jamLembur);
        System.out.println("Gaji Lembur       : Rp " + gajiLembur);
        System.out.println("Total Penghasilan : Rp " + totalGaji);

    }
}