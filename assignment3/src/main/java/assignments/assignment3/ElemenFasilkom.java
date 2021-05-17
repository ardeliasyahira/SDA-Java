package assignments.assignment3;

import java.util.Arrays;

public class ElemenFasilkom {

    private String tipe;

    private String nama;

    private int friendship; //Sesuai NEXT_DAY

    private int counter = 0;

    private final ElemenFasilkom[] telahMenyapa = new ElemenFasilkom[100];

    public ElemenFasilkom(String nama, String tipe) {
        this.nama = nama;
        this.tipe = tipe;
    }

    public String getNama() {
        return this.nama;
    }

    public String getTipe() {
        return this.tipe;
    }

    public int getFriendship() {
        return this.friendship;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setFriendship(int tambah) {
        if (tambah == 0) { //validasi variabel tambah
            this.friendship = 0;
        }
        else if (tambah == 100) { //validasi variabel tambah
            this.friendship = 100;
        }
        else {
            //agar untuk score friendship dapat ditambah
            this.friendship = friendship + tambah;
        }
    }

    public void searchElemen(ElemenFasilkom elemen) {
        //Untuk mencari Dosen dengan Mahasiswa dalam satu elemen yang sama
        if (elemen.getTipe().equals("Dosen") && this.tipe.equals("Mahasiswa")) {
            MataKuliah matkulDosen; //Inisiasi variabel untuk MataKuliah
            matkulDosen = ((Dosen) elemen).getmataKuliah(); //Casting untuk ambil method getmataKuliah()
            MataKuliah[] matkulMahasiswa;
            matkulMahasiswa = ((Mahasiswa) this).getDaftarMataKuliah();
            //Menghindari null
            if (matkulDosen != null && matkulMahasiswa != null) {
                //Menggunakan for loop dan mengambil method getSeluruhMahasiswa()
                for (int i = 0; i < matkulDosen.getSeluruhMahasiswa(); i++) {
                    //Setelah casting, kita dapat membandingkan Dosen dengan objek Mahasiswa
                    //Dosen dan Mahasiswa dalam satu mata kuliah yang sama
                    if (matkulMahasiswa[i] != null && matkulMahasiswa[i].equals(matkulDosen)) {
                        this.setFriendship(2);
                        elemen.setFriendship(2);
                    }
                }
            }

        }
        //Untuk mencari Mahasiswa dengan Dosen dalam satu elemen yang sama
        else if (elemen.getTipe().equals("Mahasiswa") && this.tipe.equals("Dosen")) {
            MataKuliah[] matkulMhsw; //Inisiasi variabel Array MataKuliah
            matkulMhsw = ((Mahasiswa) elemen).getDaftarMataKuliah();
            MataKuliah matkulDsen = ((Dosen) this).getmataKuliah();
            if (matkulDsen != null && matkulMhsw != null) {
                for (int i = 0; i < matkulDsen.getSeluruhMahasiswa(); i++) {
                    if (matkulDsen.getDaftarMahasiswa()[i].equals(matkulMhsw)) {
                        this.setFriendship(2);
                        elemen.setFriendship(2);
                    }
                }
            }
        }
    }

    public boolean sudahMenyapa(ElemenFasilkom nama) {
        for (int i = 0; i < counter; i ++) {
            if (telahMenyapa[i] != null && telahMenyapa[i].equals(nama)) {
                return true;
            }
        }
        return false;
    }

    public void menyapa(ElemenFasilkom elemenFasilkom) {
        //validasi dengan method sudahMenyapa()
        if(sudahMenyapa(elemenFasilkom)) {
            System.out.printf("[DITOLAK] %s telah menyapa %s hari ini\n", this, elemenFasilkom);
        }
        else {
            //Menambah array baru ke array telahMenyaoa[]
            telahMenyapa[counter++] = elemenFasilkom;
            elemenFasilkom.telahMenyapa[elemenFasilkom.counter++] = this;
            //Memanggil searchElemen()
            searchElemen(elemenFasilkom);
            System.out.printf("%s menyapa dengan %s\n", this, elemenFasilkom);
        }
    }

    public void resetMenyapa() {
        Arrays.fill(telahMenyapa, null); //Menghapus daftar orang yang telah disapa
        this.counter = 0; //Variabel counter direset menjadi 0
    }

    public void membeliMakanan(ElemenFasilkom pembeli, ElemenFasilkom penjual, String namaMakanan) {
        ElemenKantin cekPenjual = (ElemenKantin) penjual; //Inisiasi class ElemenKantin
        if (cekPenjual.searchMakanan(namaMakanan)) { //Validasi dengan method searchMakanan()
            System.out.printf("%s berhasil membeli %s seharga %d\n", pembeli, namaMakanan,
                    cekPenjual.getMakanan(namaMakanan).getHarga());
            penjual.friendship += 1; //Untuk score friendship
            pembeli.friendship += 1; //Untuk score friendship
        }
        else {
            System.out.printf("[DITOLAK] %s tidak menjual %s\n", penjual, namaMakanan);
        }
    }

    public String toString() {
        return this.nama;
    }
}