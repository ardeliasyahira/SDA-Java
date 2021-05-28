package assignments.assignment4.frontend;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class HomeGUI {

    private JPanel panelCenter;
    
    public HomeGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Selamat datang di Sistem Akademik");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        
        //UNTUK TAMBAH MAHASISWA
        JButton tambahMahasiswa = new JButton();
        tambahMahasiswa.setText("Tambah Mahasiswa");
        tambahMahasiswa.setFont(SistemAkademikGUI.fontGeneral);
        tambahMahasiswa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TambahMahasiswaGUI kelasTambah = new TambahMahasiswaGUI(frame, daftarMahasiswa, daftarMataKuliah);
                //gatau apa lagi hehe
            }
        });
        panelCenter = new JPanel();
        this.setLayout(new BorderLayout()); //keknya salah
        panelCenter.setLayout(new BorderLayout());
        panelCenter.setBackground(Color.GREEN);
        panelCenter.add(tambahMahasiswa);
//        this.add(panelCenter, "Center");

        //UNTUK TAMBAH MATA KULIAH
        JButton tambahMatkul = new JButton();
        tambahMatkul.setText("Tambah Mata Kuliah");
        tambahMatkul.setFont(SistemAkademikGUI.fontGeneral);
        tambahMatkul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TambahMataKuliahGUI kelasTambah = new TambahMataKuliahGUI(frame, daftarMahasiswa, daftarMataKuliah)
                //gatau apa lagi hehe
            }
        });
        panelCenter = new JPanel();
        this.setLayout(new BorderLayout()); //salah
        panelCenter.setLayout(new BorderLayout());
        panelCenter.setBackground(Color.GREEN);
        panelCenter.add(tambahMatkul);

        //UNTUK TAMBAH IRS
        JButton tambahIRS = new JButton();
        tambahIRS.setText("Tambah IRS");
        tambahIRS.setFont(SistemAkademikGUI.fontGeneral);
        tambahIRS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TambahIRSGUI kelasTambah = new TambahIRSGUI(frame, daftarMahasiswa, daftarMataKuliah);
                //gatau apa lagi hehe
            }
        });
        panelCenter = new JPanel();
        this.setLayout(new BorderLayout()); //salah
        panelCenter.setLayout(new BorderLayout());
        panelCenter.setBackground(Color.GREEN);
        panelCenter.add(tambahIRS);

        //UNTUK HAPUS IRS
        JButton hapusIRS = new JButton();
        hapusIRS.setText("Hapus IRS");
        hapusIRS.setFont(SistemAkademikGUI.fontGeneral);
        hapusIRS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HapusIRSGUI kelasTambah = new HapusIRSGUI(frame, daftarMahasiswa, daftarMataKuliah);
                //gatau apa lagi hehe
            }
        });
        panelCenter = new JPanel();
        this.setLayout(new BorderLayout()); //salah
        panelCenter.setLayout(new BorderLayout());
        panelCenter.setBackground(Color.GREEN);
        panelCenter.add(hapusIRS);

        //UNTUK LIHAT RINGKASAN MAHASISWA
        JButton lihatMhsw = new JButton();
        lihatMhsw.setText("Lihat Ringkasan Mahasiswa");
        lihatMhsw.setFont(SistemAkademikGUI.fontGeneral);
        lihatMhsw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RingkasanMahasiswaGUI kelasTambah = new RingkasanMahasiswaGUI(frame, daftarMahasiswa, daftarMataKuliah);
                //gatau apa lagi hehe
            }
        });
        panelCenter = new JPanel();
        this.setLayout(new BorderLayout()); //salah
        panelCenter.setLayout(new BorderLayout());
        panelCenter.setBackground(Color.GREEN);
        panelCenter.add(lihatMhsw);

        //UNTUK LIHAT RINGKASAN MATA KULIAH
        JButton lihatMatkul = new JButton();
        lihatMatkul.setText("Lihat Ringkasan Mata Kuliah");
        lihatMatkul.setFont(SistemAkademikGUI.fontGeneral);
        lihatMatkul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TambahMahasiswaGUI kelasTambah = new TambahMahasiswaGUI(frame, daftarMahasiswa, daftarMataKuliah);
                //gatau apa lagi hehe
            }
        });
        panelCenter = new JPanel();
        this.setLayout(new BorderLayout()); //salah
        panelCenter.setLayout(new BorderLayout());
        panelCenter.setBackground(Color.GREEN);
        panelCenter.add(lihatMatkul);
    }

    private void setLayout(BorderLayout borderLayout) {
    }
}
