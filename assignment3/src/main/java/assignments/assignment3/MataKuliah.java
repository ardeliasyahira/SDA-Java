package assignments.assignment3;

public class MataKuliah {

    private String nama;
    
    private int kapasitas;

    private Dosen dosen;

    private Mahasiswa[] daftarMahasiswa;
    
    private int seluruhMahasiswa;

    public MataKuliah(String nama, int kapasitas) {
        this.nama = nama;
        this.kapasitas = kapasitas;
        this.seluruhMahasiswa = 0;
        this.daftarMahasiswa = new Mahasiswa[kapasitas];
    }

    public Dosen getDosen() {
        return this.dosen;
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        //Inisiasi Array
        daftarMahasiswa[this.seluruhMahasiswa++] = mahasiswa;
    }

    public void dropMahasiswa(Mahasiswa mahasiswa) {
        /* mengurangi dari daftar mahasiswa apabila ada mahasiswa yang melakukan drop mata kuliah */
        /* inisiasi Array */
        Mahasiswa[] kurangMahasiswa = new Mahasiswa[kapasitas];
        /* Tampung variabel */
        int noDrop = 0;
        for (int i = 0; i < getSeluruhMahasiswa(); i++) {
            /** Mengecek seluruh mahasiswa dengan mahasiswa yang ingin drop  */
            if (!getDaftarMahasiswa()[i].equals(mahasiswa)) {
                kurangMahasiswa[noDrop] = this.daftarMahasiswa[i];
                noDrop++;
            }
        }
        /** Mengurangi jumlah mahasiswa  */
        this.seluruhMahasiswa--;
        /** daftarMahasiswa diupdate isi Array kurangMahasiswa */
        this.daftarMahasiswa = kurangMahasiswa;
    }

    public void addDosen(Dosen dosen) {
        this.dosen = dosen;
    }

    public void dropDosen() {
        this.dosen = null;
    }

    public String toString() {
        return this.nama;
    }

    public String getNama() {
        return this.nama;
    }

    public int getKapasitas() {
        return this.kapasitas;
    }

    public Mahasiswa[] getDaftarMahasiswa() {
        return this.daftarMahasiswa;
    }

    public int getSeluruhMahasiswa() {
        return this.seluruhMahasiswa;
    }
}