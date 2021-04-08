package assignments.assignment2;

//Nama: Ardelia Syahira Yudiva
//Kelas: DDP-2 B
//NPM: 2006597216

public class MataKuliah {
    private String kode;
    private String nama;
    private int sks;
    private int kapasitas;
    private Mahasiswa[] daftarMahasiswa;
    private int seluruhMahasiswa;

    public MataKuliah(String kode, String nama, int sks, int kapasitas){
        /* TODO: implementasikan kode Anda di sini */
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.kapasitas = kapasitas;
        this.daftarMahasiswa = new Mahasiswa[kapasitas];
        this.seluruhMahasiswa = 0;
    }

    public String getKode() {
        return this.kode;
    }

    public String getNama() {
        return this.nama;
    }

    public int getSKS() {
        return this.sks;
    }

    public int getKapasitas() {
        return this.kapasitas;
    }

    public int getSeluruhMahasiswa() {
        return this.seluruhMahasiswa;
    }

    public Mahasiswa[] getArrayMahasiswa() {
        return this.daftarMahasiswa;
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        /* TODO: implementasikan kode Anda di sini */
        /** Menambahkan mahasiswa yang add mata kuliah */
        daftarMahasiswa[this.seluruhMahasiswa++] = mahasiswa; 
    }

    public void dropMahasiswa(Mahasiswa mahasiswa) {
        /* TODO: implementasikan kode Anda di sini */
        /* mengurangi dari daftar mahasiswa apabila ada mahasiswa yang melakukan drop mata kuliah */
        /** Array untuk referensi baru  */
        Mahasiswa[] kurangMahasiswa = new Mahasiswa[kapasitas];
        /** Tampung variabel  */ 
        int noDrop = 0; 
        for (int i=0; i < getSeluruhMahasiswa(); i++) {
            /** Mengecek seluruh mahasiswa dengan mahasiswa yang ingin drop  */
            if (!getArrayMahasiswa()[i].equals(mahasiswa)) {
                kurangMahasiswa[noDrop] = this.daftarMahasiswa[i];
                noDrop++;
            }
        }
        /** Mengurangi jumlah mahasiswa  */
        this.seluruhMahasiswa--;
        /** daftarMahasiswa diupdate isi Array kurangMahasiswa */
        this.daftarMahasiswa = kurangMahasiswa; 
    }

    public String toString() {
        /* TODO: implementasikan kode Anda di sini */
        /* Mengembalikan nama Mata Kuliah */
        return this.nama;
    }
}
