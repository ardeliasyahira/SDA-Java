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

//    public void searchMahasiswa() {
//
//    }

    public String getNama() {
        return this.nama;
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
        for (int i=0; i < this.seluruhMahasiswa; i++) {
            if (daftarMahasiswa[i] == mahasiswa) {
                daftarMahasiswa[i] = null;
                this.seluruhMahasiswa--;
            } //Jangan lupa bikin while loop buat pindahin posisi si null
        }
    }

    public String toString() {
        /* TODO: implementasikan kode Anda di sini */
        /* Mengembalikan nama Mata Kuliah */
        return this.nama;
    }

    public int getSKS() {
        return this.sks;
    }
}
