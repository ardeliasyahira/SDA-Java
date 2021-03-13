package assignments.assignment1;

import java.util.Scanner;

public class ExtractNPM {
    /*
    You can add other method do help you solve
    this problem
    
    Some method you probably need like
    - Method to get tahun masuk or else
    - Method to help you do the validation
    - and so on
    */

    public static boolean validate(long npm) {
        // TODO: validate NPM, return it with boolean
        return false;
        
        /** Ngitungin input NPM */
        String inputNPM = Long.toString(npm);
        boolean panjangNPM = false;

        if (inputNPM.length() == 14) {
            panjangNPM = true;
        }

        String tahunMasuk = inputNPM.substring(0,2);
        int inputInt = Integer.parseInt(tahunMasuk) + 2000;
        boolean cekInputInt = false;
        if (inputInt >= 2010 && inputInt <= 2021) {
            cekInputInt = true;
        }
        
        String nomorJurusan = inputNPM.substring(2,4);
        boolean cekNomorJurusan = false;
        switch (nomorJurusan) {
            case "01":
            case "02":
            case "03":
            case "11":
            case "12": cekNomorJurusan = true; break;
            default: cekNomorJurusan = false;
        }
        
        String tanggalLahir = inputNPM.substring(4,12);
        boolean cekTanggalLahir = false;
        String umur = inputNPM.substring(8,12);
        int angkaUmur = Integer.parseInt(umur);
        if (2021 - angkaUmur >= 15) {
            cekTanggalLahir = true;
        }

        String jumlahNPM = inputNPM.substring(0,12);
        int intJumlahNPM = Integer.parseInt(inputNPM);
        boolean cekJumlahNPM = false;
        for (int i=0, j=12; (i))



    

        



        
        

        
        

    }

    public static String extract(long npm) {
        // TODO: Extract information from NPM, return string with given format
        return "";
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        boolean exitFlag = false;
        while (!exitFlag) {
            long npm = input.nextLong();
            if (npm < 0) {
                exitFlag = true;
                break;
            }

            // TODO: Check validate and extract NPM
            
        }
        input.close();
    }
}
