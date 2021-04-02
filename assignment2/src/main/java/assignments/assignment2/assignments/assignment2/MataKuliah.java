package assignments.assignment2;

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
        if (kapasitas < seluruhMahasiswa) {
            System.out.println("[DITOLAK] [namaMataKuliah] telah penuh kapasitasnya.");
        }
        else {
            daftarMahasiswa[this.seluruhMahasiswa++] = mahasiswa; //Menambahkan mahasiswa yang add mata kuliah
        }
    }

    public void dropMahasiswa(Mahasiswa mahasiswa) {
        /* TODO: implementasikan kode Anda di sini */
        /* mengurangi dari daftar mahasiswa apabila ada mahasiswa yang melakukan drop mata kuliah */
        Mahasiswa[] kurangMahasiswa = new Mahasiswa[]; //Ini masih error:(
        for (int i=0; i < this.seluruhMahasiswa; i++) {
            if (getArrayMahasiswa()[i] != null && !getArrayMahasiswa()[i].equals(mahasiswa)) {
                kurangMahasiswa[i] = getArrayMahasiswa()[i];
            }
        }
        this.seluruhMahasiswa--;
        this.daftarMahasiswa = kurangMahasiswa; //daftarMahasiswa diupdate isi Array kurangMahasiswa
    }

    public String toString() {
        /* TODO: implementasikan kode Anda di sini */
        /* Mengembalikan nama Mata Kuliah */
        return this.nama;
    }
}
