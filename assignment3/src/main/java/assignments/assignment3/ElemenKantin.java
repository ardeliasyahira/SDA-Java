package assignments.assignment3;

class ElemenKantin extends ElemenFasilkom {

    Makanan[] daftarMakanan = new Makanan[10];

    private int isiMakanan = 0;

    public ElemenKantin(String nama) {
        super(nama, "Elemen Kantin"); //Diambil dari class ElemenFasilkom
    }

    public boolean searchMakanan(String nama) {
        for (int i = 0; i < isiMakanan; i++) {
            //Mencari namaMakanan
            if (nama.equals(daftarMakanan[i].toString())) {
                return true;
            }
        }
        return false;
    }

    public void setMakanan(String nama, long harga) {
        //Bila nama sesuai dengan daftarMakanan
        if (searchMakanan(nama)) {
            System.out.printf("[DITOLAK] %s sudah pernah terdaftar\n", nama);
        }
        else {
            //Casting class makanan dengan variabel objekMakanan
            Makanan objekMakanan = new Makanan(nama, harga);
            daftarMakanan[isiMakanan++] = objekMakanan; //Inisiasi Array baru untuk daftarMakanan
            System.out.printf("%s telah mendaftarkan makanan %s dengan harga %d\n", this, nama, harga);
        }
    }

    public Makanan getMakanan(String nama) {
        //Getter untuk daftarMakanan
        for (int i = 0; i < daftarMakanan.length; i++) {
            if (nama.equals(daftarMakanan[i].toString()) && daftarMakanan[i] != null) {
                return daftarMakanan[i];
            }
        }
        return null;
    }
}