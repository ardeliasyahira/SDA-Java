package assignments.assignment3;

class Dosen extends ElemenFasilkom {

    private MataKuliah mataKuliah;

    public Dosen(String nama) {
        super(nama, "Dosen"); //Diambil dari class ElemenFasilkom
    }

    public MataKuliah getmataKuliah() {
        return this.mataKuliah;
    }

    public void mengajarMataKuliah(MataKuliah mataKuliah) {
        /* mendaftarkan objek Dosen ke dalam mataKuliah */
        //Validasi Dosen sudah mengajar matkul
        if (this.getmataKuliah() != null) {
            System.out.printf("[DITOLAK] %s sudah mengajar mata kuliah %s\n", this.getNama(), this.mataKuliah);
        }
        //Bila matkul tersebut sudah ada pengajar
        else if (mataKuliah.getDosen() != null) {
            System.out.printf("[DITOLAK] %s sudah memiliki dosen pengajar\n", mataKuliah); // gatau
        }
        //Menambahkan Dosen ke Mata Kuliah
        else {
            mataKuliah.addDosen(this); //Memanggil method addDosen()
            this.mataKuliah = mataKuliah; //Inisiasi variabel baru
            System.out.printf("%s mengajar mata kuliah %s\n", this.getNama(), mataKuliah);
        }
    }

    public void dropMataKuliah() {
        /* drop mata kuliah dari daftar mata kuliah yang diambil */
        //Validasi bila dosen sudah memegang mata kuliah dengan menghindari null
        if (this.getmataKuliah() != null) {
            System.out.printf("%s berhenti mengajar %s\n", this.getNama(), mataKuliah);
            //variabel mataKuliah merupakan inisiasi class MataKuliah
            this.mataKuliah.dropDosen(); //Memanggil dropDosen()
            this.mataKuliah = null;
        }
        else {
            System.out.printf("%s sedang tidak mengajar mata kuliah apapun\n", this.getNama());
        }
    }
}