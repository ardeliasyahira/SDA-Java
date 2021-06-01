package assignments.assignment4.frontend;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class HomeGUI {

    public HomeGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        frame.getContentPane().removeAll();
        frame.repaint();
        JLabel titleLabel = new JLabel();
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(7,0,10,10));
        titleLabel.setText("Selamat datang di Sistem Akademik");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        panelCenter.add(titleLabel);
        panelCenter.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        //UNTUK TAMBAH MAHASISWA
        JButton tambahMahasiswa = new JButton();
        tambahMahasiswa.setText("Tambah Mahasiswa");
        tambahMahasiswa.setFont(SistemAkademikGUI.fontGeneral);
        tambahMahasiswa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new TambahMahasiswaGUI(frame, daftarMahasiswa, daftarMataKuliah);
            }
        });
//        this.setLayout(new BorderLayout()); //keknya salah
        panelCenter.add(tambahMahasiswa);


        //UNTUK TAMBAH MATA KULIAH
        JButton tambahMatkul = new JButton();
        tambahMatkul.setText("Tambah Mata Kuliah");
        tambahMatkul.setFont(SistemAkademikGUI.fontGeneral);
        tambahMatkul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TambahMataKuliahGUI(frame, daftarMahasiswa, daftarMataKuliah);
            }
        });
        panelCenter.add(tambahMatkul);


        //UNTUK TAMBAH IRS
        JButton tambahIRS = new JButton();
        tambahIRS.setText("Tambah IRS");
        tambahIRS.setFont(SistemAkademikGUI.fontGeneral);
        tambahIRS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TambahIRSGUI(frame, daftarMahasiswa, daftarMataKuliah);
            }
        });
        panelCenter.add(tambahIRS);


        //UNTUK HAPUS IRS
        JButton hapusIRS = new JButton();
        hapusIRS.setText("Hapus IRS");
        hapusIRS.setFont(SistemAkademikGUI.fontGeneral);
        hapusIRS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HapusIRSGUI(frame, daftarMahasiswa, daftarMataKuliah);
            }
        });
        panelCenter.add(hapusIRS);


        //UNTUK LIHAT RINGKASAN MAHASISWA
        JButton lihatMhsw = new JButton();
        lihatMhsw.setText("Lihat Ringkasan Mahasiswa");
        lihatMhsw.setFont(SistemAkademikGUI.fontGeneral);
        lihatMhsw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RingkasanMahasiswaGUI(frame, daftarMahasiswa, daftarMataKuliah);
            }
        });
        panelCenter.add(lihatMhsw);


        //UNTUK LIHAT RINGKASAN MATA KULIAH
        JButton lihatMatkul = new JButton();
        lihatMatkul.setText("Lihat Ringkasan Mata Kuliah");
        lihatMatkul.setFont(SistemAkademikGUI.fontGeneral);
        lihatMatkul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TambahMahasiswaGUI(frame, daftarMahasiswa, daftarMataKuliah);
            }
        });
        panelCenter.add(lihatMatkul);
        frame.add(panelCenter);
        frame.setVisible(true);
    }
}
