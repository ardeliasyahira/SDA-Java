package assignments.assignment2;

import java.util.Arrays;
import java.util.Scanner;

public class SistemAkademik {
    private static final int ADD_MATKUL = 1;
    private static final int DROP_MATKUL = 2;
    private static final int RINGKASAN_MAHASISWA = 3;
    private static final int RINGKASAN_MATAKULIAH = 4;
    private static final int KELUAR = 5;
    private static Mahasiswa[] daftarMahasiswa = new Mahasiswa[100];
    private static MataKuliah[] daftarMataKuliah = new MataKuliah[100];
    
    private Scanner input = new Scanner(System.in);

    private Mahasiswa getMahasiswa(long npm) { //GATAU MASIH SALAH POKOKNYA GINI 
        /* TODO: Implementasikan kode Anda di sini */
        //Input NPM buat keluar nama Mahasiswa 
        for (int i=0; i<daftarMahasiswa.length; i++) {
            if (daftarMahasiswa[i].getNpm() == npm) { //Menjalankan getNpm() pada class Mahasiswa
                return daftarMahasiswa[i];
            }
        }
        return null;
    }

    private MataKuliah getMataKuliah(String namaMataKuliah) {
        /* TODO: Implementasikan kode Anda di sini */
        for (int i=0; i<daftarMataKuliah.length; i++) {
            if (daftarMataKuliah[i].getNama().equals(namaMataKuliah)) { //Mengambil getNama() di class MataKuliah
                return daftarMataKuliah[i];
            }
        }
        return null;
    }

    private void addMatkul(){
        //menambahkan mata kuliah yang diambil seorang mahasiswa
        System.out.println("\n--------------------------ADD MATKUL--------------------------\n");

        System.out.print("Masukkan NPM Mahasiswa yang akan melakukan ADD MATKUL : ");
        long npm = Long.parseLong(input.nextLine());

        /* TODO: Implementasikan kode Anda di sini 
        Jangan lupa lakukan validasi apabila banyaknya matkul yang diambil mahasiswa sudah 9*/
        //Ambil data mahasiswa
        //Habis itu ambil data lainnya 
        Mahasiswa daftarMhsw = getMahasiswa(npm);
        assert daftarMhsw != null;
        if (daftarMhsw.getSeluruhMatkul() >= 10){ //Validasi bila Mahasiswa mengambil mata kuliah lebih dari 10
            System.out.println("[DITOLAK] Maksimal mata kuliah yang diambil hanya 10");
        }

        System.out.print("Banyaknya Matkul yang Ditambah: ");
        int banyakMatkul = Integer.parseInt(input.nextLine());
        System.out.println("Masukkan nama matkul yang ditambah");
        for(int i=0; i<banyakMatkul; i++){
            System.out.print("Nama mata kuliah " + i+1 + " : ");
            String namaMataKuliah = input.nextLine();
            /* TODO: Implementasikan kode Anda di sini */
            daftarMhsw.addMatkul(getMataKuliah(namaMataKuliah)); //nama Mata kuliah yang akan masuk ke daftar Mahasiswa. 
        }
        System.out.println("\nSilakan cek rekap untuk melihat hasil pengecekan IRS.\n");
    }

    private void dropMatkul(){
        System.out.println("\n--------------------------DROP MATKUL--------------------------\n");

        System.out.print("Masukkan NPM Mahasiswa yang akan melakukan DROP MATKUL : ");
        long npm = Long.parseLong(input.nextLine());

       /* TODO: Implementasikan kode Anda di sini 
        Jangan lupa lakukan validasi apabila mahasiswa belum mengambil mata kuliah*/
        //drop mata kuliah yang diambil seorang mahasiswa

        System.out.print("Banyaknya Matkul yang Di-drop: ");
        int banyakMatkul = Integer.parseInt(input.nextLine());
        System.out.println("Masukkan nama matkul yang di-drop:");
        for(int i=0; i<banyakMatkul; i++){
            System.out.print("Nama matakuliah " + i+1 + " : ");
            String namaMataKuliah = input.nextLine();
            /* TODO: Implementasikan kode Anda di sini */
            if (getMataKuliah() < 1) { //Validasi untuk mahasiswa yang belum ambil mata kuliah
                System.out.println("[DITOLAK] Belum ada mata kuliah yang diambil.");
            }
                daftarMhsw.dropMatkul(getMataKuliah(namaMataKuliah));
        }
        System.out.println("\nSilakan cek rekap untuk melihat hasil pengecekan IRS.\n");
    }

    private void ringkasanMahasiswa() {
        //menampilkan ringkasan seorang mahasiswa yang terdiri atas nama, NPM, jurusan, daftar mata kuliah yang diambil, serta hasil pengecekan IRS
        System.out.print("Masukkan npm mahasiswa yang akan ditunjukkan ringkasannya : ");
        long npm = Long.parseLong(input.nextLine());

        Mahasiswa daftarMhsw = getMahasiswa(npm);
        // TODO: Isi sesuai format keluaran
        System.out.println("\n--------------------------RINGKASAN--------------------------\n");
        System.out.println("Nama: " + daftarMhsw.getNama());
        System.out.println("NPM: " + npm);
        System.out.println("Jurusan: " + daftarMhsw.getJurusan());
        System.out.println("Daftar Mata Kuliah: " + Arrays.toString(daftarMataKuliah));

        /* TODO: Cetak daftar mata kuliah 
        Handle kasus jika belum ada mata kuliah yang diambil*/
        if (daftarMhsw.getSeluruhMatkul() < 1) {
            System.out.println("Belum ada mata kuliah yang diambil.");
        }
        System.out.println("Total SKS: " + daftarMhsw.getTotalSKS()); //belum buat method
        System.out.println("Hasil Pengecekan IRS:" + daftarMhsw.cekIRS()); //belum buat method guys makanya error
        /* TODO: Cetak hasil cek IRS
        Handle kasus jika IRS tidak bermasalah */
    }

    private void ringkasanMataKuliah(){
        System.out.print("Masukkan nama mata kuliah yang akan ditunjukkan ringkasannya : ");
        String namaMataKuliah = input.nextLine();
        MataKuliah namaMatkul = getMataKuliah(namaMataKuliah);
        // TODO: Isi sesuai format keluaran
        System.out.println("\n--------------------------RINGKASAN--------------------------\n");
        System.out.println("Nama mata kuliah: " + namaMataKuliah);
        assert namaMatkul != null;
        System.out.println("Kode: " + namaMatkul.getKode()); //Mengambil method getKode di class MataKuliah
        System.out.println("SKS: " + namaMatkul.getSKS()); //Mengambil method totalSKS() di class MataKuliah; GATAU MASIH BINGUNG
        System.out.println("Jumlah mahasiswa: " + ""); //hah yang mana
        System.out.println("Kapasitas: " + ""); //yang mana lagi 
        System.out.println("Daftar mahasiswa yang mengambil mata kuliah ini: " + Arrays.toString(daftarMahasiswa)); //gatau soalnya hrs dri satu matkul
        //Mata kuliah dan mahasiswa yang dimasukkan tidak akan melebihi 100 orang
       /* TODO: Cetak hasil cek IRS
        Handle kasus jika tidak ada mahasiswa yang mengambil */
        if (daftarMataKuliah == null) { //gatau bener apa kaga
            System.out.println("Belum ada mahasiswa yang mengambil mata kuliah ini.");
        }
    }

    private void daftarMenu(){
        int pilihan = 0;
        boolean exit = false;
        while (!exit) {
            System.out.println("\n----------------------------MENU------------------------------\n");
            System.out.println("Silakan pilih menu:");
            System.out.println("1. Add Matkul");
            System.out.println("2. Drop Matkul");
            System.out.println("3. Ringkasan Mahasiswa");
            System.out.println("4. Ringkasan Mata Kuliah");
            System.out.println("5. Keluar");
            System.out.print("\nPilih: ");
            try {
                pilihan = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }
            System.out.println();
            if (pilihan == ADD_MATKUL) {
                addMatkul();
            } else if (pilihan == DROP_MATKUL) {
                dropMatkul();
            } else if (pilihan == RINGKASAN_MAHASISWA) {
                ringkasanMahasiswa();
            } else if (pilihan == RINGKASAN_MATAKULIAH) {
                ringkasanMataKuliah();
            } else if (pilihan == KELUAR) {
                System.out.println("Sampai jumpa!");
                exit = true;
            }
        }

    }


    private void run() {
        System.out.println("====================== Sistem Akademik =======================\n");
        System.out.println("Selamat datang di Sistem Akademik Fasilkom!");
        
        System.out.print("Banyaknya Matkul di Fasilkom: ");
        int banyakMatkul = Integer.parseInt(input.nextLine());
        System.out.println("Masukkan matkul yang ditambah");
        System.out.println("format: [Kode Matkul] [Nama Matkul] [SKS] [Kapasitas]");

        for(int i=0; i<banyakMatkul; i++){
            String[] dataMatkul = input.nextLine().split(" ", 4);
            int sks = Integer.parseInt(dataMatkul[2]);
            int kapasitas = Integer.parseInt(dataMatkul[3]);
            /* TODO: Buat instance mata kuliah dan masukkan ke dalam Array */
        }

        System.out.print("Banyaknya Mahasiswa di Fasilkom: ");
        int banyakMahasiswa = Integer.parseInt(input.nextLine());
        System.out.println("Masukkan data mahasiswa");
        System.out.println("format: [Nama] [NPM]");

        for(int i=0; i<banyakMahasiswa; i++){
            String[] dataMahasiswa = input.nextLine().split(" ", 2);
            long npm = Long.parseLong(dataMahasiswa[1]);
            /* TODO: Buat instance mata kuliah dan masukkan ke dalam Array */
        }
        daftarMenu();
        input.close();
    }

    public static void main(String[] args) {
        SistemAkademik program = new SistemAkademik();
        program.run();
    }

    


    
}
