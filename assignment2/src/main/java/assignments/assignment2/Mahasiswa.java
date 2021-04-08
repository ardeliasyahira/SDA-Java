package assignments.assignment2;

//Nama: Ardelia Syahira Yudiva
//Kelas: DDP-2 B
//NPM: 2006597216

public class Mahasiswa {
    private MataKuliah[] mataKuliah = new MataKuliah[10];
    private String[] masalahIRS;
    private int totalSKS;
    private String nama;
    private String jurusan;
    private long npm;
    private int seluruhMatkul = 0;
    private int ngitungIRS;

    public Mahasiswa(String nama, long npm){
        /* TODO: implementasikan kode Anda di sini */
        /** Implementasi variabel private dengan method this */
        this.nama = nama;
        this.npm = npm;
    }

    public String getNama() {
        /** Mengembalikan dan mempublikasi variabel nama */
        return this.nama;
    }

    public String getJurusan() { //Getter untuk jurusan
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

    public int getSeluruhMatkul() {
        return this.seluruhMatkul;
    }

    public MataKuliah[] getArraynyaMatkul() {
        return this.mataKuliah;
    }

    public int getNgitungIRS() {
        return this.ngitungIRS;
    }

    public String[] getMasalahIRS() {
        return this.masalahIRS;
    }


    public boolean searchMatkul(String namaMatkul) {
        boolean Matkul = false;
        for (int i = 0; i < getArraynyaMatkul().length; i++) {
            if (getArraynyaMatkul()[i] != null && getArraynyaMatkul()[i].getNama().equals(namaMatkul)) {
                Matkul = true;
                break;
            }
        }
        return Matkul;
    }

    public Long getNpm() {
        return this.npm;
    }

    public int getTotalSKS() {
        return this.totalSKS;
    }
    
    public void addMatkul(MataKuliah mataKul){
        /* TODO: implementasikan kode Anda di sini */
        /** Validasi untuk add Matkul  */
        /** If FALSE */
        if (searchMatkul(mataKul.getNama())) { 
            System.out.printf("[DITOLAK] %s telah diambil sebelumnya.", mataKul.getNama());
        }
        /** Bila kapasitas memenuhi kapasitas satu mata kuliah  */
        else if (mataKul.getKapasitas() <= mataKul.getSeluruhMahasiswa()) {
            System.out.printf("[DITOLAK] %s telah penuh kapasitasnya.", mataKul.getNama());
        }
        /** Validasi agar matkul yang diambil kurang dari 10 */
        else if (this.seluruhMatkul >= 10) {
            System.out.println("DITOLAK] Maksimal mata kuliah yang diambil hanya 10.");
        }
        else {
            /** menambahkan mata kuliah ke daftar mata kuliah yang diambil saat ini */
            this.mataKuliah[this.seluruhMatkul++] = mataKul; 
            /** menambahkan SKS ke total mata kuliah */
            this.totalSKS += mataKul.getSKS(); 
            /** Agar berjalan ke kelas Mahasiswa addMahasiswa */
            mataKul.addMahasiswa(this); 
        }
    }

    public void dropMatkul(MataKuliah mataKul){
        /* TODO: implementasikan kode Anda di sini */
        /* drop mata kuliah dari daftar mata kuliah yang diambil */

        MataKuliah[] newDaftarMatkul = new MataKuliah[10];
        /** Tampung variabel */
        int varMatkul = 0;
            /** return di searchMatkul tapi false */
            if (!searchMatkul(mataKul.getNama())) { 
                System.out.printf("[DITOLAK] %s belum pernah diambil", mataKul);
            }
            /** Bila true */
            else if (searchMatkul(mataKul.getNama())) { 
                for (int j=0; j < this.seluruhMatkul; j++) {
                    if (!getArraynyaMatkul()[j].equals(mataKul)) {
                        /** Variabel mataKuliah diperbarui */
                        newDaftarMatkul[varMatkul] = this.mataKuliah[j]; 
                        /** varMatkul bertambah sesuai jumlah mata kuliah */
                        varMatkul++; 
                    }
                }
                /** Karena matakuliah untuk seluruhMatkul telah di drop */
                this.seluruhMatkul--;
                this.mataKuliah = newDaftarMatkul; 
                /** SKS berkurang karena susah di drop matkul */
                this.totalSKS -= mataKul.getSKS(); 
                /** Memanggil method dropMahasiswa */
                mataKul.dropMahasiswa(this); 
            }
    }

    public void cekIRS(){
        /* TODO: implementasikan kode Anda di sini */
        masalahIRS = new String[20]; //Inisiasi
        ngitungIRS = 0;

        if (totalSKS > 24) {
            System.out.println("SKS yang Anda ambil lebih dari 24");
        }
        for (int i = 0; i < seluruhMatkul; i++) {
            /** Mengecek tiap Matkul untuk IRS */
            if (getArraynyaMatkul()[i] != null && mataKuliah[i].getKode().equals("IK") && getJurusan().equals("Sistem Informasi")) {
                masalahIRS[ngitungIRS++] = "Mata Kuliah " + mataKuliah[i] + " tidak dapat diambil jurusan SI";
            }
            else if (getArraynyaMatkul()[i] != null && mataKuliah[i].getKode().equals("SI") && getJurusan().equals("Ilmu Komputer")) {
                masalahIRS[ngitungIRS++] = "Mata Kuliah " + mataKuliah[i] + " tidak dapat diambil jurusan IK";
            }
        }
    }

    public String toString() {
        /* TODO: implementasikan kode Anda di sini */
        /** Mengembalikan nama Mata Kuliah */
        return this.nama;
    }


}
