package assignments.assignment2;

public class Mahasiswa {
    private MataKuliah[] mataKuliah = new MataKuliah[10];
    private String[] masalahIRS;
    private int totalSKS;
    private String nama;
    private String jurusan;
    private long npm;
    private int seluruhMatkul;

    public Mahasiswa(String nama, long npm){
        /* TODO: implementasikan kode Anda di sini */
        this.nama = nama;
        this.npm = npm;
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

    public boolean searchMatkul(String namaMatkul) {
        boolean Matkul = true;
        for (int i = 0; i < getArraynyaMatkul().length; i++) {
            if(getArraynyaMatkul()[i] != null && getArraynyaMatkul()[i].getNama().equals(namaMatkul)) {
                Matkul = false;
            }
        }
        return Matkul;
    }

    public Long getNpm() {
        return this.npm;
    }

    public int getTotalSKS(Mahasiswa totalSKS) {
        //buat method biar ngambil semua sks yg mahasiswa ambil
        for (int i=0; i < seluruhMatkul; i++){
            this.totalSKS += mataKuliah[i].getSKS();
        }
        return this.totalSKS;
    }
    
    public void addMatkul(MataKuliah mataKul){
        /* TODO: implementasikan kode Anda di sini */
        if (this.seluruhMatkul >= 10) {
            System.out.println("DITOLAK] Maksimal mata kuliah yang diambil hanya 10.");
        }
        else {
            mataKuliah[this.seluruhMatkul++] = mataKul; //menambahkan mata kuliah ke daftar mata kuliah yang diambil saat ini
        }
    }

    public void dropMatkul(MataKuliah mataKuliah){
        /* TODO: implementasikan kode Anda di sini */
        /* drop mata kuliah dari daftar mata kuliah yang diambil */
        //ambil method getSeluruhMatkul()

        seluruhMatkul -= 1;
        //berarti hrs search dulu baru bisa di drop

        }
    }

    public void cekIRS(){
        /* TODO: implementasikan kode Anda di sini */
        if (masalahIRS >= 20) { //elahhh tai
            System.out.println("IRS bermasalah."); //gatau tapi bisa aja ini jalanin method
        }
        else{
            System.out.println("IRS tidak bermasalah."); //ini juga
        }

    }

    public String toString() {
        /* TODO: implementasikan kode Anda di sini */
        return "";
    }

    public String getNama() {
        return this.nama;
    }
}
