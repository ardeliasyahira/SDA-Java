package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class SistemAkademik {

    public static void main(String[] args) { 
        new SistemAkademikGUI();
    }
}

class SistemAkademikGUI extends JFrame{
    private static ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<Mahasiswa>();
    private static ArrayList<MataKuliah> daftarMataKuliah = new ArrayList<MataKuliah>();
    public static Font fontGeneral = new Font("Courier", Font.PLAIN , 16);
    public static Font fontTitle = new Font("Courier", Font.BOLD, 20);
    public static Font fontGeneral2 = new Font("Courier", Font.BOLD, 16);

    public SistemAkademikGUI(){
        // Membuat Frame
        JFrame frame = new JFrame("Administrator - Sistem Akademik");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        // TODO: Tambahkan hal-hal lain yang diperlukan
        frame.setBackground(new Color(172,109,126,255));
        new HomeGUI(frame, daftarMahasiswa, daftarMataKuliah);
        frame.setVisible(true);
    }
}
