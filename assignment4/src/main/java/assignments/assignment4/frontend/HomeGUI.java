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
        frame.setTitle("Administrator - Sistem Akademik");

        ImageIcon gambar = new ImageIcon("assignment4/src/gambar.jpg");

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(7,0,10,10));
        panelCenter.setBackground(new Color(172,109,126,255));

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Selamat datang di Sistem Akademik");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        titleLabel.setForeground(new Color(86, 55, 63));
        panelCenter.add(titleLabel);
        panelCenter.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        //UNTUK TAMBAH MAHASISWA
        JButton tambahMahasiswa = new JButton();
        tambahMahasiswa.setText("Tambah Mahasiswa");
        tambahMahasiswa.setFont(SistemAkademikGUI.fontGeneral);
        tambahMahasiswa.setBackground(new Color(226,161,149,255));
        tambahMahasiswa.setOpaque(true);
        tambahMahasiswa.setBorderPainted(false);
        tambahMahasiswa.setForeground(new Color(98,67,82,255));
        tambahMahasiswa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new TambahMahasiswaGUI(frame, daftarMahasiswa, daftarMataKuliah);
            }
        });
        tambahMahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tambahMahasiswa.setBackground(new Color(182, 129, 148));
                tambahMahasiswa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tambahMahasiswa.setBackground(new Color(226,161,149,255));
            }
        });
        panelCenter.add(tambahMahasiswa);


        //UNTUK TAMBAH MATA KULIAH
        JButton tambahMatkul = new JButton();
        tambahMatkul.setText("Tambah Mata Kuliah");
        tambahMatkul.setFont(SistemAkademikGUI.fontGeneral);
        tambahMatkul.setBackground(new Color(226,161,149,255));
        tambahMatkul.setOpaque(true);
        tambahMatkul.setBorderPainted(false);
        tambahMatkul.setForeground(new Color(98,67,82,255));
        tambahMatkul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TambahMataKuliahGUI(frame, daftarMahasiswa, daftarMataKuliah);
            }
        });
        tambahMatkul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tambahMatkul.setBackground(new Color(182, 129, 148));
                tambahMatkul.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                tambahMatkul.setBackground(new Color(226,161,149,255));
            }
        });
        panelCenter.add(tambahMatkul);


        //UNTUK TAMBAH IRS
        JButton tambahIRS = new JButton();
        tambahIRS.setText("Tambah IRS");
        tambahIRS.setFont(SistemAkademikGUI.fontGeneral);
        tambahIRS.setBackground(new Color(226,161,149,255));
        tambahIRS.setOpaque(true);
        tambahIRS.setBorderPainted(false);
        tambahIRS.setForeground(new Color(98,67,82,255));
        tambahIRS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TambahIRSGUI(frame, daftarMahasiswa, daftarMataKuliah);
            }
        });
        tambahIRS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tambahIRS.setBackground(new Color(182, 129, 148));
                tambahIRS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                tambahIRS.setBackground(new Color(226,161,149,255));
            }
        });
        panelCenter.add(tambahIRS);


        //UNTUK HAPUS IRS
        JButton hapusIRS = new JButton();
        hapusIRS.setText("Hapus IRS");
        hapusIRS.setFont(SistemAkademikGUI.fontGeneral);
        hapusIRS.setBackground(new Color(226,161,149,255));
        hapusIRS.setOpaque(true);
        hapusIRS.setBorderPainted(false);
        hapusIRS.setForeground(new Color(98,67,82,255));
        hapusIRS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HapusIRSGUI(frame, daftarMahasiswa, daftarMataKuliah);
            }
        });
        hapusIRS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hapusIRS.setBackground(new Color(182, 129, 148));
                hapusIRS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                hapusIRS.setBackground(new Color(226,161,149,255));
            }
        });
        panelCenter.add(hapusIRS);


        //UNTUK LIHAT RINGKASAN MAHASISWA
        JButton lihatMhsw = new JButton();
        lihatMhsw.setText("Lihat Ringkasan Mahasiswa");
        lihatMhsw.setFont(SistemAkademikGUI.fontGeneral);
        lihatMhsw.setBackground(new Color(226,161,149,255));
        lihatMhsw.setOpaque(true);
        lihatMhsw.setBorderPainted(false);
        lihatMhsw.setForeground(new Color(98,67,82,255));
        lihatMhsw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RingkasanMahasiswaGUI(frame, daftarMahasiswa, daftarMataKuliah);
            }
        });
        lihatMhsw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lihatMhsw.setBackground(new Color(182, 129, 148));
                lihatMhsw.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                lihatMhsw.setBackground(new Color(226,161,149,255));
            }
        });
        panelCenter.add(lihatMhsw);


        //UNTUK LIHAT RINGKASAN MATA KULIAH
        JButton lihatMatkul = new JButton();
        lihatMatkul.setText("Lihat Ringkasan Mata Kuliah");
        lihatMatkul.setFont(SistemAkademikGUI.fontGeneral);
        lihatMatkul.setBackground(new Color(226,161,149,255));
        lihatMatkul.setOpaque(true);
        lihatMatkul.setBorderPainted(false);
        lihatMatkul.setForeground(new Color(98,67,82,255));
        lihatMatkul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RingkasanMataKuliahGUI(frame, daftarMahasiswa, daftarMataKuliah);
            }
        });
        lihatMatkul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lihatMatkul.setBackground(new Color(182, 129, 148));
                lihatMatkul.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                lihatMatkul.setBackground(new Color(226,161,149,255));
            }
        });
        panelCenter.add(lihatMatkul);

        JPanel panel1 = new JPanel(new GridLayout(0, 2));
        panel1.add(new JLabel(gambar));
        panel1.add(panelCenter);
        frame.add(panel1);

        frame.setVisible(true);
    }
}
