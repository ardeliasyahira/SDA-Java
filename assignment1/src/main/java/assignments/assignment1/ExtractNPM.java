package assignments.assignment1;

// Nama: Ardelia Syahira Yudiva
// Kelas: DDP-2 B
// NPM: 2006597216

import java.util.Scanner;

public class ExtractNPM {
    /*
    You can add other method do help you solve
    this problem
    
    Some method you probably need like
    - Method to get tahun masuk or else
    - Method to help you do the validation
    - and so on
    */

    /** Method untuk validasi NPM */
    public static boolean validate(long npm) { 
        // TODO: validate NPM, return it with boolean
        
        /** Menghitung input NPM */
        String inputNPM = Long.toString(npm);
        boolean panjangNPM = false;

        if (inputNPM.length() == 14) {
            panjangNPM = true;
        }

        /** Validasi Tahun Masuk */
        String tahunMasuk = inputNPM.substring(0,2);
        int inputInt = Integer.parseInt(tahunMasuk) + 2000;
        boolean cekInputInt = false;
        if (inputInt >= 2010 && inputInt <= 2021) {
            cekInputInt = true;
        }
        ////////////

        /** Validasi Jurusan */
        String nomorJurusan = inputNPM.substring(2,4);
        boolean cekNomorJurusan = false;
        /** Validasi kode jurusan dengan switch statement */
        switch (nomorJurusan) {
            case "01", "02", "03", "11", "12":cekNomorJurusan = true; break;
            default: cekNomorJurusan = false;
        }
        ///////////
       
        /** Validasi tanggal lahir */
        boolean cekTanggalLahir = false;
        String umur = inputNPM.substring(8,12);
        int angkaUmur = Integer.parseInt(umur);
        if (2021 - angkaUmur >= 15) {
            cekTanggalLahir = true;
        }
        ///////////
        
        /** Validasi penjumlahan NPM */
        int intJumlahNPM = Integer.parseInt(String.valueOf(inputNPM.charAt(6)));
        boolean cekJumlahNPM = false;
        for (int i = 0, j = 12; (i < 6 && j > 6); i++, j--){
            intJumlahNPM += Integer.parseInt(String.valueOf(inputNPM.charAt(i))) * Integer.parseInt(String.valueOf(inputNPM.charAt(j))) ;
        }
        int hasil = 0;
        while (intJumlahNPM != 0) {
                hasil += intJumlahNPM % 10; /** mengambil angka di belakang */
                intJumlahNPM /= 10; /** mengambil angka di depan */
        }
        if (hasil == Integer.parseInt(String.valueOf(inputNPM.charAt(13)))) {
            cekJumlahNPM = true;
        }
        return (panjangNPM && cekInputInt && cekNomorJurusan && cekTanggalLahir && cekJumlahNPM);
        ///////////
    }
        
    public static String extract(long npm) {
        // TODO: Extract information from NPM, return string with given format

        /** Deklarasi dan meng-casting beberapa variabel */
        String npmString = Long.toString(npm);
        String tahunMasuk = npmString.substring(0, 2);
        String kodeJurusan = npmString.substring(2, 4);
        String tanggalLahir = npmString.substring(4,6);
        String bulanLahir = npmString.substring(6,8);
        String tahunLahir = npmString.substring(8,12);

        /** Ekstraksi kode jurusan */
        String namaJurusan = ""; 
        switch (kodeJurusan) {
            case "01": 
                namaJurusan = "Ilmu Komputer"; break;
            case "02":
                namaJurusan = "Sistem Informasi"; break;
            case "03":
                namaJurusan = "Teknologi Informasi"; break;
            case "11":
                namaJurusan = "Teknik Telekomunikasi"; break;
            case "12":
                namaJurusan = "Teknik Elektro"; break;
        }
        return ("Tahun masuk: 20" + tahunMasuk + "\nJurusan: " + namaJurusan + "\nTanggal Lahir: " + tanggalLahir + "-" + bulanLahir + "-" + tahunLahir);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        boolean exitFlag = false;
        while (!exitFlag) {
            long npm = input.nextLong();
            if (npm < 0) {
                exitFlag = true;
                break;
            }

            // TODO: Check validate and extract NPM
            if (validate(npm)) {
                System.out.println(extract(npm));
            }
            else {
                System.out.println("NPM tidak valid!");
            }
        }
        input.close();
    }
}
