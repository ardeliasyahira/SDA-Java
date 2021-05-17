package assignments.assignment3;

public class Mahasiswa extends ElemenFasilkom {

    private MataKuliah[] daftarMataKuliah = new MataKuliah[10];
    
    private long npm;

    private String tanggalLahir;
    
    private String jurusan;

    private int seluruhMatkul;

    private MataKuliah[] mataKuliah;

    private String nama;

    public Mahasiswa(String nama, long npm) {
        super(nama, "Mahasiswa"); //Dari ElemenFasilkom
        this.npm = npm;
    }

    public MataKuliah[] getDaftarMataKuliah() {
        return this.daftarMataKuliah;
    }

    public int getSeluruhMatkul() {
        return this.seluruhMatkul;
    }

    public boolean searchMatkul(String namaMatkul) {
        //Validasi untuk daftarMataKuliah
        boolean Matkul = false;
        for (int i = 0; i < getDaftarMataKuliah().length; i++) {
            if (getDaftarMataKuliah()[i] != null && getDaftarMataKuliah()[i].getNama().equals(namaMatkul)) {
                Matkul = true;
                break;
            }
        }
        return Matkul;
    }

    public void addMatkul(MataKuliah mataKuliah) {
        /* Validasi untuk add Matkul  */
        if (searchMatkul(mataKuliah.getNama())) {
            System.out.printf("[DITOLAK] %s telah diambil sebelumnya\n", mataKuliah.getNama());
        }
        /* Bila kapasitas memenuhi kapasitas satu mata kuliah  */
        else if (mataKuliah.getKapasitas() <= mataKuliah.getSeluruhMahasiswa()) {
            System.out.printf("[DITOLAK] %s telah penuh kapasitasnya.\n", mataKuliah.getNama());
        }
        /* mahasiswa dari semua jurusan dapat mengambil mata kuliah apa saja */
        else {
            /* menambahkan mata kuliah ke daftar mata kuliah yang diambil saat ini */
            this.daftarMataKuliah[this.seluruhMatkul++] = mataKuliah;
            /* Agar berjalan ke kelas Mahasiswa addMahasiswa */
            mataKuliah.addMahasiswa(this);
            System.out.printf("%s berhasil menambahkan mata kuliah %s\n", this, mataKuliah.getNama());
        }
    }

    public void dropMatkul(MataKuliah mataKuliah) {
        /* drop mata kuliah dari daftar mata kuliah yang diambil */
        MataKuliah[] mataKuliahBaru = new MataKuliah[10];
        /* Tampung variabel */
        int varMatkul = 0;
        /* return di searchMatkul tapi false */
        if (!searchMatkul(mataKuliah.getNama())) {
            System.out.printf("[DITOLAK] %s belum pernah diambil\n", mataKuliah);
        }
        /* Bila true */
        else if (searchMatkul(mataKuliah.getNama())) {
            for (int j=0; j < this.seluruhMatkul; j++) {
                if (!getDaftarMataKuliah()[j].equals(mataKuliah)) {
                    /* Variabel mataKuliah diperbarui */
                    mataKuliahBaru[varMatkul] = this.daftarMataKuliah[j];
                    /* varMatkul bertambah sesuai jumlah mata kuliah */
                    varMatkul++;
                }
            }
            /* Karena matakuliah untuk seluruhMatkul telah di drop */
            this.seluruhMatkul--;
            this.daftarMataKuliah = mataKuliahBaru;
            /* Memanggil method dropMahasiswa */
            mataKuliah.dropMahasiswa(this);
            System.out.printf("%s berhasil drop mata kuliah %s\n", this, mataKuliah);
        }
    }

    public String getTanggalLahir() {
        return extractTanggalLahir(this.npm);
    }

    public String extractTanggalLahir(long npm) {
        String npmString = Long.toString(npm); //Mengubah NPM to String
        //Mengambil indeks tiap NPM
        String tanggalLahir = npmString.substring(4, 6);
        String bulanLahir = npmString.substring(6, 8);
        String tahunLahir = npmString.substring(8, 12);
        //Mengubah ke integer sebelum return
        int tanggal = Integer.parseInt(tanggalLahir);
        int bulan = Integer.parseInt(bulanLahir);
        int tahun = Integer.parseInt(tahunLahir);
        return (tanggal + "-" + bulan + "-" + tahun);
    }

    public String getJurusan() {
        return extractJurusan(this.npm);
    }

    public String extractJurusan(long npm) {
        String nomorJurusan = Long.toString(this.npm).substring(2,4);
        /* Validasi kode jurusan dengan switch statement */
        switch (nomorJurusan) {
            case "01":
                this.jurusan = "Ilmu Komputer"; break;
            case "02":
                this.jurusan = "Sistem Informasi"; break;
        }
        return this.jurusan;
    }
}