package assignments.assignment3;

import java.util.Scanner;

public class Main {

    private static ElemenFasilkom[] daftarElemenFasilkom = new ElemenFasilkom[100];

    private static MataKuliah[] daftarMataKuliah = new MataKuliah[100];

    private static int totalMataKuliah = 0;

    private static int totalElemenFasilkom = 0;

    public static ElemenFasilkom getElemenFasilkom(String nama) {
        //Getter untuk daftarElemenFasilkom[]
        for (int i = 0; i < totalElemenFasilkom; i++) {
            if (daftarElemenFasilkom[i].toString().equals(nama)) {
                return daftarElemenFasilkom[i];
            }
        }
        return null;
    }

    public static MataKuliah getMataKuliah(String nama) {
        //Getter untuk daftarMataKuliah[]
        for (int i = 0; i < totalMataKuliah; i++) {
            if (daftarMataKuliah[i].toString().equals(nama)) {
                return daftarMataKuliah[i];
            }
        }
        return null;
    }

    public static void addMahasiswa(String nama, long npm) {
        //Mengambil class Mahasiswa dengan variabel mahasiswa
        Mahasiswa mahasiswa  = new Mahasiswa(nama, npm);
        //Inisiasi array baru
        daftarElemenFasilkom[totalElemenFasilkom++] = mahasiswa;
        System.out.println(mahasiswa + " berhasil ditambahkan");
    }

    public static void addDosen(String nama) {
        //Mengambil class Dosen dengan variabel dosem
        Dosen dosen = new Dosen(nama);
        //Inisiasi array baru
        daftarElemenFasilkom[totalElemenFasilkom++] = dosen;
        System.out.println(dosen + " berhasil ditambahkan");
    }

    public static void addElemenKantin(String nama) {
        //Mengambil class ElemenKantin dengan variabel elemenKantin
        ElemenKantin elemenKantin = new ElemenKantin(nama);
        //Inisiasi array baru
        daftarElemenFasilkom[totalElemenFasilkom++] = elemenKantin;
        System.out.println(elemenKantin + " berhasil ditambahkan");
    }

    public static void menyapa(String objek1, String objek2) {
        //Menghindari objek yang sama
        if (!objek1.equals(objek2)) {
            getElemenFasilkom(objek1).menyapa(getElemenFasilkom(objek2));
        }
        else {
            System.out.println("[DITOLAK] Objek yang sama tidak bisa saling menyapa");
        }
    }

    public static void addMakanan(String objek, String namaMakanan, long harga) {
        //Validasi agar objel berasal dari getElemenFasilkom()
        if (getElemenFasilkom(objek).getTipe().equals("Elemen Kantin")) {
            //Menambahkan makanan si namaMakanan
            ((ElemenKantin) getElemenFasilkom(objek)).setMakanan(namaMakanan, harga);
        }
        else {
            System.out.printf("[DITOLAK] %s bukan merupakan elemen kantin\n", objek);
        }
    }

    public static void membeliMakanan(String objek1, String objek2, String namaMakanan) {
        //Validasi agar objek merupakan bagian dari getElemenFasilkom()
        if (!getElemenFasilkom(objek2).getTipe().equals("Elemen Kantin")) {
            System.out.println("[DITOLAK] Hanya elemen kantin yang dapat menjual makanan");
        }
        //Bila objeknya mirip
        else if (objek1.equals(objek2)) {
            System.out.println("[DITOLAK] Elemen kantin tidak bisa membeli makanan sendiri");
        }
        else {
            //Memanggil method membeliMakanan dengan objek dari daftarElemenFasilkom[]
            getElemenFasilkom(objek1).membeliMakanan(getElemenFasilkom(objek1), getElemenFasilkom(objek2),
                    namaMakanan);
        }
    }

    public static void createMatkul(String nama, int kapasitas) {
        //Memanggil clas MataKuliah dengan parameter mataKuliah
        MataKuliah mataKuliah = new MataKuliah(nama, kapasitas);
        //Inisiasi array baru
        daftarMataKuliah[totalMataKuliah++] = mataKuliah;
        System.out.printf("%s berhasil ditambahkan dengan kapasitas %d\n", nama, kapasitas);
    }

    public static void addMatkul(String objek, String namaMataKuliah) {
        //Validasi agar objek merupakan Mahasiswa
        if (!getElemenFasilkom(objek).getTipe().equals("Mahasiswa")) {
            System.out.println("[DITOLAK] Hanya mahasiswa yang dapat menambahkan matkul");
        }
        else {
            //Memanggil method addMatkul di class Mahasiswa
            ((Mahasiswa) getElemenFasilkom(objek)).addMatkul(getMataKuliah(namaMataKuliah));
        }
    }

    public static void dropMatkul(String objek, String namaMataKuliah) {
        //Validasi agar objek merupakan Mahasiswa
        if (!getElemenFasilkom(objek).getTipe().equals("Mahasiswa")) {
            System.out.println("[DITOLAK] Hanya mahasiswa yang dapat drop matkul");
        }
        else {
            //Memanggil method dropMatkul di class Mahasiswa
            ((Mahasiswa) getElemenFasilkom(objek)).dropMatkul(getMataKuliah(namaMataKuliah));
        }
    }

    public static void mengajarMatkul(String objek, String namaMataKuliah) {
        //Validasi agar objek merupakan Dosen
        if (!getElemenFasilkom(objek).getTipe().equals("Dosen")) {
            System.out.println("[DITOLAK] Hanya dosen yang dapat mengajar matkul");
        }
        else {
            //Memanggil method mengajarMataKuliah() di class Dosen
            ((Dosen) getElemenFasilkom(objek)).mengajarMataKuliah(getMataKuliah(namaMataKuliah));
        }
    }

    public static void berhentiMengajar(String objek) {
        //Vaidasi agar objek merupakan Dosen
        if (!getElemenFasilkom(objek).getTipe().equals("Dosen")) {
            System.out.println("[DITOLAK] Hanya dosen yang dapat berhenti mengajar");
        }
        else {
            //Memanggil method dropMataKuliah() di class Dosen
            ((Dosen) getElemenFasilkom(objek)).dropMataKuliah();
        }
    }

    public static void ringkasanMahasiswa(String objek) {
        //Validasi agar objek merupakan Mahasiswa
        if (!getElemenFasilkom(objek).getTipe().equals("Mahasiswa")) {
            System.out.printf("[DITOLAK] %s bukan merupakan seorang mahasiswa\n", objek);
        }
        else {
            //Memanggil class Mahasiswa dengan parameter mahasiswa
            Mahasiswa mahasiswa = (Mahasiswa) getElemenFasilkom(objek);
            System.out.println("Nama: " + objek);
            System.out.println("Tanggal lahir: " + mahasiswa.getTanggalLahir());
            System.out.println("Jurusan: " + mahasiswa.getJurusan());
            System.out.println("Daftar Mata Kuliah: ");
            /* Handle kasus jika belum ada mata kuliah yang diambil */
            if (mahasiswa.getSeluruhMatkul() == 0){
                System.out.println("Belum ada mata kuliah yang diambil");
            }
            else {
                for (int i=0; i < mahasiswa.getSeluruhMatkul(); i++) {
                    System.out.println((i+1) + ". " + mahasiswa.getDaftarMataKuliah()[i]);
                }
            }
        }
    }

    public static void ringkasanMataKuliah(String namaMataKuliah) {
        //Memanggil class MataKuliah dengan paramater mataKuliah
        MataKuliah mataKuliah = (MataKuliah) getMataKuliah(namaMataKuliah);
        System.out.println("Nama mata kuliah: " + namaMataKuliah);
        System.out.println("Jumlah mahasiswa: " + mataKuliah.getSeluruhMahasiswa());
        System.out.println("Kapasitas: " + mataKuliah.getKapasitas());
        //Handle kasus bila getDosen() null
        if (mataKuliah.getDosen() == null) {
            System.out.println("Dosen pengajar: Belum ada");
        }
        else {
            System.out.println("Dosen pengajar: " + mataKuliah.getDosen());
        }
        System.out.println("Daftar mahasiswa yang mengambil mata kuliah ini: ");
        //Handle kasus bila getSeluruhMahasiswa() = 0
        if (mataKuliah.getSeluruhMahasiswa() == 0) {
            System.out.println("Belum ada mahasiswa yang mengambil mata kuliah ini.");
        }
        else {
            for (int i = 0; i < mataKuliah.getSeluruhMahasiswa(); i++) {
                System.out.println((i + 1) + ". " + mataKuliah.getDaftarMahasiswa()[i]);
            }
        }
    }

    public static void nextDay() {
        for (int i = 0; i < totalElemenFasilkom; i++) {
            //objek pada ElemenFasilkom telah menyapa lebih dari atau sama dengan setengah dari total elemenFasilkom
            // (tidak termasuk diri sendiri),maka tingkat friendship akan bertambah sebesar 10.
            if (daftarElemenFasilkom[i].getCounter() >= (totalElemenFasilkom - 1) / 2.0) {
                daftarElemenFasilkom[i].setFriendship(10);
            }
            else {
                //ElemenFasilkom tidak menyapa lebih dari setengah dari total elemenFasilkom
                daftarElemenFasilkom[i].setFriendship(-5);
            }
        }
        for (int i = 0; i < totalElemenFasilkom; i++) {
            //validasi agar nilai friendship tidak akan melewati batas 0-100
            if (daftarElemenFasilkom[i].getFriendship() <= 0) {
                daftarElemenFasilkom[i].setFriendship(0);
            }
            else if (daftarElemenFasilkom[i].getFriendship() >= 100) {
                daftarElemenFasilkom[i].setFriendship(100);
            }
        }
        System.out.println("Hari telah berakhir dan nilai friendship telah diupdate");
        friendshipRanking(); //Memanggil friendshipRanking()
    }

    public static void friendshipRanking() {
        /* TODO: implementasikan kode Anda di sini */
        for (int i = 0; i < daftarElemenFasilkom.length; i++) {
            for (int j = i + 1; j < daftarElemenFasilkom.length; j++) {
                if (daftarElemenFasilkom[j] == null) {
                    break;
                }
                else if (daftarElemenFasilkom[i].getFriendship() == daftarElemenFasilkom[j].getFriendship()) {
                    for (int k = 0; k < Math.min(daftarElemenFasilkom[i].getNama().length(),
                            daftarElemenFasilkom[j].getNama().length()); k++) {
                        if (daftarElemenFasilkom[i].getNama().charAt(k) > daftarElemenFasilkom[j].getNama().charAt(k)) {
                            ElemenFasilkom elemenPertama = daftarElemenFasilkom[i];
                            ElemenFasilkom elemenKedua = daftarElemenFasilkom[j];
                            daftarElemenFasilkom[i] = elemenKedua;
                            daftarElemenFasilkom[j] = elemenPertama;
                            break;
                        }
                        else if (daftarElemenFasilkom[i].getNama().charAt(k) <
                                daftarElemenFasilkom[j].getNama().charAt(k)) {
                            break;
                        }
                    }
                }
                else if (daftarElemenFasilkom[i].getFriendship() < daftarElemenFasilkom[j].getFriendship()) {
                    ElemenFasilkom elemenPertama = daftarElemenFasilkom[i];
                    ElemenFasilkom elemenKedua = daftarElemenFasilkom[j];
                    daftarElemenFasilkom[i] = elemenKedua;
                    daftarElemenFasilkom[j] = elemenPertama;
                }
            }
        }
        for (int i = 0; i < totalElemenFasilkom; i++) {
            System.out.println((i + 1) + ". " + daftarElemenFasilkom[i].getNama() + "("
                    + daftarElemenFasilkom[i].getFriendship() + ")");
            daftarElemenFasilkom[i].resetMenyapa(); //Setelah dihitung score maka di reset lagi
        }
    }

    public static void programEnd() {
        System.out.println("Program telah berakhir. Berikut nilai terakhir dari friendship pada Fasilkom :");
        friendshipRanking(); //Memanggil friendshipRanking()
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        while (true) {
            String in = input.nextLine();
            if (in.split(" ")[0].equals("ADD_MAHASISWA")) {
                addMahasiswa(in.split(" ")[1], Long.parseLong(in.split(" ")[2]));
            } else if (in.split(" ")[0].equals("ADD_DOSEN")) {
                addDosen(in.split(" ")[1]);
            } else if (in.split(" ")[0].equals("ADD_ELEMEN_KANTIN")) {
                addElemenKantin(in.split(" ")[1]);
            } else if (in.split(" ")[0].equals("MENYAPA")) {
                menyapa(in.split(" ")[1], in.split(" ")[2]);
            } else if (in.split(" ")[0].equals("ADD_MAKANAN")) {
                addMakanan(in.split(" ")[1], in.split(" ")[2], Long.parseLong(in.split(" ")[3]));
            } else if (in.split(" ")[0].equals("MEMBELI_MAKANAN")) {
                membeliMakanan(in.split(" ")[1], in.split(" ")[2], in.split(" ")[3]);
            } else if (in.split(" ")[0].equals("CREATE_MATKUL")) {
                createMatkul(in.split(" ")[1], Integer.parseInt(in.split(" ")[2]));
            } else if (in.split(" ")[0].equals("ADD_MATKUL")) {
                addMatkul(in.split(" ")[1], in.split(" ")[2]);
            } else if (in.split(" ")[0].equals("DROP_MATKUL")) {
                dropMatkul(in.split(" ")[1], in.split(" ")[2]);
            } else if (in.split(" ")[0].equals("MENGAJAR_MATKUL")) {
                mengajarMatkul(in.split(" ")[1], in.split(" ")[2]);
            } else if (in.split(" ")[0].equals("BERHENTI_MENGAJAR")) {
                berhentiMengajar(in.split(" ")[1]);
            } else if (in.split(" ")[0].equals("RINGKASAN_MAHASISWA")) {
                ringkasanMahasiswa(in.split(" ")[1]);
            } else if (in.split(" ")[0].equals("RINGKASAN_MATKUL")) {
                ringkasanMataKuliah(in.split(" ")[1]);
            } else if (in.split(" ")[0].equals("NEXT_DAY")) {
                nextDay();
            } else if (in.split(" ")[0].equals("PROGRAM_END")) {
                programEnd();
                break;
            }
        }
    }
}