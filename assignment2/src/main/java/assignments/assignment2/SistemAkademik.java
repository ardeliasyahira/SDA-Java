package assignments.assignment2;

//Nama: Ardelia Syahira Yudiva
//Kelas: DDP-2 B
//NPM: 2006597216

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

    private Mahasiswa getMahasiswa(long npm) {
        /* TODO: Implementasikan kode Anda di sini */
        //Input NPM buat keluar nama Mahasiswa 
        for (int i=0; i<daftarMahasiswa.length; i++) {
            /** Menjalankan getNpm() pada class Mahasiswa */
            /** Bila NPM yang dicari sama, maka akan mengembalikan array daftarMahasiswa */
            if (daftarMahasiswa[i].getNpm() == npm) { 
                return daftarMahasiswa[i];
            }
        }
        return null;
    }

    private MataKuliah getMataKuliah(String namaMataKuliah) {
        /* TODO: Implementasikan kode Anda di sini */
        /** For each loop untuk Array MataKuliah */
        for (MataKuliah mataKuliah : daftarMataKuliah) {
            if (mataKuliah == null) {
                continue;
            }
            /** Mengambil getNama() di class MataKuliah */
            else if (mataKuliah.getNama().equals(namaMataKuliah)) {
                return mataKuliah;
            }
        }
        return null;
    }

    private void addMatkul(){
        /** menambahkan mata kuliah yang diambil seorang mahasiswa */
        System.out.println("\n--------------------------ADD MATKUL--------------------------\n");

        System.out.print("Masukkan NPM Mahasiswa yang akan melakukan ADD MATKUL : ");
        long npm = Long.parseLong(input.nextLine());

        /* TODO: Implementasikan kode Anda di sini 
        Jangan lupa lakukan validasi apabila banyaknya matkul yang diambil mahasiswa sudah 9*/
        //Ambil data mahasiswa
        //Habis itu ambil data lainnya 
        Mahasiswa daftarMhsw = getMahasiswa(npm);
        System.out.print("Banyaknya Matkul yang Ditambah: ");
        int banyakMatkul = Integer.parseInt(input.nextLine());
        System.out.print("Masukkan nama matkul yang ditambah");
        for(int i=0; i < banyakMatkul; i++){
            System.out.println("Nama matakuliah " + i+1 + " : ");
            String namaMataKuliah = input.nextLine();
            /* TODO: Implementasikan kode Anda di sini */
            MataKuliah simpanData = getMataKuliah(namaMataKuliah);
            if (daftarMhsw != null) {
                /** nama Mata kuliah yang akan masuk ke daftar Mahasiswa. */
                daftarMhsw.addMatkul(simpanData); 
            }
        }
        System.out.println("\nSilakan cek rekap untuk melihat hasil pengecekan IRS.\n");
    }

    private void dropMatkul(){
        System.out.println("\n--------------------------DROP MATKUL--------------------------\n");

        System.out.print("Masukkan NPM Mahasiswa yang akan melakukan DROP MATKUL : ");
        long npm = Long.parseLong(input.nextLine());
       /* TODO: Implementasikan kode Anda di sini 
        Jangan lupa lakukan validasi apabila mahasiswa belum mengambil mata kuliah*/
        /** Drop mata kuliah yang diambil seorang mahasiswa */
        Mahasiswa simpanNama = getMahasiswa(npm);
        /** Validasi bila seluruh matkul belum ada isinya */
        if (simpanNama.getSeluruhMatkul() == 0) {
            System.out.println("[DITOLAK] Belum ada mata kuliah yang diambil.");
        }
        else {
            System.out.print("Banyaknya Matkul yang Di-drop: ");
            int banyakMatkul = Integer.parseInt(input.nextLine());
            System.out.println("Masukkan nama matkul yang di-drop:");
            for(int i=0; i<banyakMatkul; i++) {
                System.out.println("Nama matakuliah " + i+1 + " : ");
                String namaMataKuliah = input.nextLine();
                /* TODO: Implementasikan kode Anda di sini */
                /** Menjalankan method dengan variabel simpanNama */
                simpanNama.dropMatkul(getMataKuliah(namaMataKuliah));
            }
            System.out.println("\nSilakan cek rekap untuk melihat hasil pengecekan IRS.\n");
        }
    }
    

    private void ringkasanMahasiswa() {
        /** menampilkan ringkasan seorang mahasiswa yang terdiri atas nama, NPM, jurusan, daftar mata kuliah yang diambil, serta hasil pengecekan IRS */
        System.out.print("Masukkan npm mahasiswa yang akan ditunjukkan ringkasannya : ");
        long npm = Long.parseLong(input.nextLine());

        /** Inisiasi Object Mahasiswa */
        Mahasiswa daftarMhsw = getMahasiswa(npm); 
        // TODO: Isi sesuai format keluaran
        System.out.println("\n--------------------------RINGKASAN--------------------------\n");
        System.out.println("Nama: " + daftarMhsw.getNama());
        System.out.println("NPM: " + npm);
        System.out.println("Jurusan: " + daftarMhsw.getJurusan());
        System.out.println("Daftar Mata Kuliah: ");
        /* TODO: Cetak daftar mata kuliah
        Handle kasus jika belum ada mata kuliah yang diambil*/
        if (daftarMhsw.getSeluruhMatkul() == 0){
            System.out.println("Belum ada mata kuliah yang diambil");
        } 
        else {
            for (int i=0; i < daftarMhsw.getSeluruhMatkul(); i++) {
                System.out.println((i+1) + ". " + daftarMhsw.getArraynyaMatkul()[i]);
            }
        }
        System.out.println("Total SKS: " + daftarMhsw.getTotalSKS()); 
        System.out.println("Hasil Pengecekan IRS:"); 
        /* TODO: Cetak hasil cek IRS
        Handle kasus jika IRS tidak bermasalah */
        /** Menjalani method cekIRS */
        daftarMhsw.cekIRS();
        if (daftarMhsw.getNgitungIRS() == 0) {
            System.out.println("IRS tidak bermasalah.");
        }
        else {
            for (int i = 0; i < daftarMhsw.getNgitungIRS(); i++) {
                System.out.println((i + 1) + ". " + daftarMhsw.getMasalahIRS()[i]);
            }
        }
    }

    private void ringkasanMataKuliah(){
        System.out.print("Masukkan nama mata kuliah yang akan ditunjukkan ringkasannya : ");
        String namaMataKuliah = input.nextLine();
        MataKuliah namaMatkul = getMataKuliah(namaMataKuliah);
        // TODO: Isi sesuai format keluaran
        System.out.println("\n--------------------------RINGKASAN--------------------------\n");
        System.out.println("Nama matakuliah: " + namaMataKuliah);
        /** Mengambil method getKode di class MataKuliah */
        System.out.println("Kode: " + namaMatkul.getKode()); 
        /** Mengambil method totalSKS() di class MataKuliah */
        System.out.println("SKS: " + namaMatkul.getSKS()); 
        System.out.println("Jumlah mahasiswa: " + namaMatkul.getSeluruhMahasiswa()); 
        System.out.println("Kapasitas: " + namaMatkul.getKapasitas());
        System.out.println("Daftar mahasiswa yang mengambil mata kuliah ini: "); 
        //Mata kuliah dan mahasiswa yang dimasukkan tidak akan melebihi 100 orang
       /* TODO: Cetak hasil cek IRS
        Handle kasus jika tidak ada mahasiswa yang mengambil */
        if (namaMatkul.getSeluruhMahasiswa() == 0) {
            System.out.println("Belum ada mahasiswa yang mengambil mata kuliah ini.");
        }
        else {
            for (int i = 0; i < namaMatkul.getSeluruhMahasiswa(); i++) {
                System.out.println((i + 1) + ". " + namaMatkul.getArrayMahasiswa()[i]);
            }
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
            /** Indexing dari input */
            String kode = dataMatkul[0];
            String nama = dataMatkul[1];
            //Inisiasi class mata kuliah
            MataKuliah siMatkul = new MataKuliah(kode, nama, sks, kapasitas);
            daftarMataKuliah[i] = siMatkul;

        }

        System.out.print("Banyaknya Mahasiswa di Fasilkom: ");
        int banyakMahasiswa = Integer.parseInt(input.nextLine());
        System.out.println("Masukkan data mahasiswa");
        System.out.println("format: [Nama] [NPM]");

        for(int i=0; i<banyakMahasiswa; i++){
            String[] dataMahasiswa = input.nextLine().split(" ", 2);
            long npm = Long.parseLong(dataMahasiswa[1]);
            /* TODO: Buat instance mata kuliah dan masukkan ke dalam Array */
            String nama = dataMahasiswa[0];
            Mahasiswa siMahasiswa = new Mahasiswa(nama,npm);
            daftarMahasiswa[i] = siMahasiswa;
        }
        daftarMenu();
        input.close();
    }

    public static void main(String[] args) {
        SistemAkademik program = new SistemAkademik();
        program.run();
    }
}
