package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class DetailRingkasanMahasiswaGUI {
    public DetailRingkasanMahasiswaGUI(JFrame frame, Mahasiswa mahasiswa, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon gambar = new ImageIcon("assignment4/src/gambar.jpg");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(60, 0,10,10));
        panel.setBackground(new Color(172,109,126,255));

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Detail Ringkasan Mahasiswa");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        titleLabel.setForeground(new Color(86, 55, 63));
        panel.add(titleLabel);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 30));

        JLabel nama = new JLabel();
        nama.setText("Nama: " + mahasiswa.getNama());
        nama.setHorizontalAlignment(JLabel.CENTER);
        nama.setFont(SistemAkademikGUI.fontGeneral);
        nama.setForeground(new Color(86, 55, 63));
        panel.add(nama);

        JLabel npm = new JLabel();
        npm.setText("NPM: " + mahasiswa.getNpm());
        npm.setHorizontalAlignment(JLabel.CENTER);
        npm.setFont(SistemAkademikGUI.fontGeneral);
        npm.setForeground(new Color(86, 55, 63));
        panel.add(npm);

        JLabel jurusan = new JLabel();
        jurusan.setText("Jurusan: " + mahasiswa.getJurusan());
        jurusan.setHorizontalAlignment(JLabel.CENTER);
        jurusan.setFont(SistemAkademikGUI.fontGeneral);
        jurusan.setForeground(new Color(86, 55, 63));
        panel.add(jurusan);

        JLabel daftar = new JLabel();
        daftar.setText("Daftar Mata Kuliah: ");
        daftar.setHorizontalAlignment(JLabel.CENTER);
        daftar.setFont(SistemAkademikGUI.fontGeneral);
        daftar.setForeground(new Color(86, 55, 63));
        panel.add(daftar);
        /* Handle kasus jika belum ada mata kuliah yang diambil*/
        if (mahasiswa.getBanyakMatkul() == 0){
            JLabel belum = new JLabel();
            belum.setText("Belum ada mata kuliah yang diambil");
            belum.setHorizontalAlignment(JLabel.CENTER);
            belum.setFont(SistemAkademikGUI.fontGeneral2);
            belum.setForeground(new Color(157,71,78));
            panel.add(belum);
        }
        else {
            for (int i=0; i < mahasiswa.getBanyakMatkul(); i++) {
                JLabel bisa = new JLabel();
                bisa.setText((i+1) + ". " + mahasiswa.getMataKuliah()[i]);
                bisa.setHorizontalAlignment(JLabel.CENTER);
                bisa.setFont(SistemAkademikGUI.fontGeneral2);
                bisa.setForeground(new Color(86, 55, 63));
                panel.add(bisa);
            }
        }

        JLabel sks = new JLabel();
        sks.setText("Total SKS: " + mahasiswa.getTotalSKS());
        sks.setHorizontalAlignment(JLabel.CENTER);
        sks.setFont(SistemAkademikGUI.fontGeneral);
        sks.setForeground(new Color(86, 55, 63));
        panel.add(sks);

        JLabel hasil = new JLabel();
        hasil.setText("Hasil Pengecekan IRS:");
        hasil.setHorizontalAlignment(JLabel.CENTER);
        hasil.setFont(SistemAkademikGUI.fontGeneral);
        hasil.setForeground(new Color(86, 55, 63));
        panel.add(hasil);
        /*
        Handle kasus jika IRS tidak bermasalah */
        /** Menjalani method cekIRS */
        mahasiswa.cekIRS();
        if (mahasiswa.getBanyakMasalahIRS() == 0) {
            JLabel aman = new JLabel();
            aman.setText("IRS tidak bermasalah.");
            aman.setHorizontalAlignment(JLabel.CENTER);
            aman.setFont(SistemAkademikGUI.fontGeneral2);
            aman.setForeground(new Color(70, 99, 79));
            panel.add(aman);
        }
        else {
            for (int i = 0; i < mahasiswa.getBanyakMasalahIRS(); i++) {
                JLabel masalah = new JLabel();
                masalah.setText((i + 1) + ". " + mahasiswa.getMasalahIRS()[i]);
                masalah.setHorizontalAlignment(JLabel.CENTER);
                masalah.setFont(SistemAkademikGUI.fontGeneral2);
                masalah.setForeground(new Color(157,71,78));
                panel.add(masalah);
            }
        }

        JButton selesai = new JButton();
        selesai.setPreferredSize(new Dimension(90, 30));
        selesai.setText("Selesai");
        selesai.setFont(SistemAkademikGUI.fontGeneral);
        selesai.setForeground(new Color(86, 55, 63));
        selesai.setBackground(new Color(226,161,149,255));
        selesai.setOpaque(true);
        selesai.setBorderPainted(false);
        selesai.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent evt) {
                  new HomeGUI(frame, daftarMahasiswa, daftarMataKuliah);
              }
        });
        selesai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selesai.setBackground(new Color(182, 129, 148));
                selesai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                selesai.setBackground(new Color(226,161,149,255));
            }
        });
        panel.add(selesai);
        frame.add(panel);

        JScrollPane pane = new JScrollPane(panel);
        frame.add(pane);

        frame.setVisible(true);
    }
}
