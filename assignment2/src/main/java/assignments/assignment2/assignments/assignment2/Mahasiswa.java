package assignments.assignment2;

public class Mahasiswa {
    private MataKuliah[] mataKuliah = new MataKuliah[10];
    private String[] masalahIRS;
    private int totalSKS;
    private String nama;
    private String jurusan;
    private long npm;
    private int seluruhMatkul;
    private int ngitungIRS;

    public Mahasiswa(String nama, long npm){
        /* TODO: implementasikan kode Anda di sini */
        this.nama = nama;
        this.npm = npm;
    }

    public String getNama() {
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
        boolean Matkul = true;
        for (int i = 0; i < getArraynyaMatkul().length; i++) {
            if (getArraynyaMatkul()[i] != null && getArraynyaMatkul()[i].getNama().equals(namaMatkul)) {
                Matkul = false;
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
        if (!searchMatkul(mataKul.getNama())) {
            System.out.printf("[DITOLAK] %s telah diambil sebelumnya.", mataKul.getNama());
        }
        else if (mataKul.getKapasitas() <= mataKul.getSeluruhMahasiswa()) {
            System.out.printf("[DITOLAK] %s telah penuh kapasitasnya.", mataKul.getNama());
        }
        else if (this.seluruhMatkul >= 10) {
            System.out.println("DITOLAK] Maksimal mata kuliah yang diambil hanya 10.");
        }
        else {
            this.mataKuliah[this.seluruhMatkul++] = mataKul; //menambahkan mata kuliah ke daftar mata kuliah yang diambil saat ini
            this.totalSKS += mataKul.getSKS();
        }
    }

    public void dropMatkul(MataKuliah mataKuliah){
        /* TODO: implementasikan kode Anda di sini */
        /* drop mata kuliah dari daftar mata kuliah yang diambil */
        //ambil method getSeluruhMatkul()
        MataKuliah[] newDaftarMatkul = new MataKuliah[10];
        for (int i = 0; i < this.mataKuliah.length; i++){
            if (this.mataKuliah[0] == null) {
                System.out.println("[DITOLAK] Belum ada mata kuliah yang diambil.");
                break;
            }
            else if (!searchMatkul(mataKuliah.getNama())) {
                System.out.printf("[DITOLAK] %s belum pernah diambil", mataKuliah.getNama());
                break;
            }
            else {
                for (int j = 0; j < getArraynyaMatkul().length; j++) {
                    //null berarti kalau matkulnya mahasiswa itu kosong ATAU ada suatu indeks yang belum ada matkulnya
                    if (getArraynyaMatkul()[j] != null && !getArraynyaMatkul()[j].equals(mataKuliah)) {
                        newDaftarMatkul[j] = getArraynyaMatkul()[j];
                    }
                }
            }
            this.mataKuliah = newDaftarMatkul; //mataKuliah diupdate isi Array newDaftarMatkul
            mataKuliah.dropMahasiswa(this); //Connect ke dropMahasiswa() biar daftar mahasiswa di matkul itu berkurang
            this.seluruhMatkul -= 1;
            this.totalSKS -= mataKuliah.getSKS(); //SKS ikut berkurang
        }
    }

    public void cekIRS(){
        /* TODO: implementasikan kode Anda di sini */
        masalahIRS = new String[20]; //Inisiasi
        ngitungIRS = 0;
        if (ngitungIRS <= 20) {
            if (totalSKS > 24) {
                System.out.println("SKS yang Anda ambil lebih dari 24");
            }
            for (int i = 0; i < seluruhMatkul; i++) {
                if (mataKuliah[i].getKode().equals("IK") && this.getJurusan().equals("Sistem Informasi")) {
                    masalahIRS[ngitungIRS++] = "Mata Kuliah" + mataKuliah[i] + " tidak dapat diambil jurusan SI";
                }
                else if (mataKuliah[i].getKode().equals("SI") && this.getJurusan().equals("Ilmu Komputer")) {
                    masalahIRS[ngitungIRS++] = "Mata Kuliah" + mataKuliah[i] + " tidak dapat diambil jurusan IK";
                }
            }
        }
    }

    public String toString() {
        /* TODO: implementasikan kode Anda di sini */
        //Mengembalikan nama Mata Kuliah
        return this.nama;
    }


}
