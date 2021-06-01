package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class DetailRingkasanMahasiswaGUI {
    public DetailRingkasanMahasiswaGUI(JFrame frame, Mahasiswa mahasiswa, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        // TODO: Implementasikan Detail Ringkasan Mahasiswa
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 0, 10, 10));
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Detail Ringkasan Mahasiswa");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        panel.add(titleLabel);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // TODO: Isi sesuai format keluaran
        JLabel nama = new JLabel();
        nama.setText("Nama: " + mahasiswa.getNama());
        nama.setHorizontalAlignment(JLabel.CENTER);
        nama.setFont(SistemAkademikGUI.fontGeneral);
        panel.add(nama);

        JLabel npm = new JLabel();
        npm.setText("NPM: " + mahasiswa.getNpm());
        npm.setHorizontalAlignment(JLabel.CENTER);
        npm.setFont(SistemAkademikGUI.fontGeneral);
        panel.add(npm);

        JLabel jurusan = new JLabel();
        jurusan.setText("Jurusan: " + mahasiswa.getJurusan());
        jurusan.setHorizontalAlignment(JLabel.CENTER);
        jurusan.setFont(SistemAkademikGUI.fontGeneral);
        panel.add(jurusan);

        JLabel daftar = new JLabel();
        daftar.setText("Daftar Mata Kuliah: ");
        daftar.setHorizontalAlignment(JLabel.CENTER);
        daftar.setFont(SistemAkademikGUI.fontGeneral);
        panel.add(daftar);

        /* TODO: Cetak daftar mata kuliah
        Handle kasus jika belum ada mata kuliah yang diambil*/
        if (mahasiswa.getBanyakMatkul() == 0){
            JLabel belum = new JLabel();
            belum.setText("Belum ada mata kuliah yang diambil");
            belum.setHorizontalAlignment(JLabel.CENTER);
            belum.setFont(SistemAkademikGUI.fontGeneral);
            panel.add(belum);
        }
        else {
            for (int i=0; i < mahasiswa.getBanyakMatkul(); i++) {
                JLabel bisa = new JLabel();
                bisa.setText((i+1) + ". " + mahasiswa.getMataKuliah()[i]);
                bisa.setHorizontalAlignment(JLabel.CENTER);
                bisa.setFont(SistemAkademikGUI.fontGeneral);
                panel.add(bisa);
            }
        }

        JLabel sks = new JLabel();
        sks.setText("Total SKS: " + mahasiswa.getTotalSKS());
        sks.setHorizontalAlignment(JLabel.CENTER);
        sks.setFont(SistemAkademikGUI.fontGeneral);
        panel.add(sks);

        JLabel hasil = new JLabel();
        hasil.setText("Hasil Pengecekan IRS:");
        hasil.setHorizontalAlignment(JLabel.CENTER);
        hasil.setFont(SistemAkademikGUI.fontGeneral);
        panel.add(hasil);

        /* TODO: Cetak hasil cek IRS
        Handle kasus jika IRS tidak bermasalah */
        /** Menjalani method cekIRS */

        mahasiswa.cekIRS();
        if (mahasiswa.getBanyakMasalahIRS() == 0) {
            JLabel aman = new JLabel();
            aman.setText("IRS tidak bermasalah.");
            aman.setHorizontalAlignment(JLabel.CENTER);
            aman.setFont(SistemAkademikGUI.fontGeneral);
            panel.add(aman);
        }
        else {
            for (int i = 0; i < mahasiswa.getBanyakMasalahIRS(); i++) {
                JLabel masalah = new JLabel();
                masalah.setText((i + 1) + ". " + mahasiswa.getMasalahIRS()[i]);
                masalah.setHorizontalAlignment(JLabel.CENTER);
                masalah.setFont(SistemAkademikGUI.fontGeneral);
                panel.add(masalah);
            }
        }


        JButton selesai = new JButton();
        selesai.setPreferredSize(new Dimension(90, 30));
        selesai.setText("Selesai");
        selesai.setFont(SistemAkademikGUI.fontGeneral);
        selesai.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent evt) {
                  new HomeGUI(frame, daftarMahasiswa, daftarMataKuliah);
              }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
