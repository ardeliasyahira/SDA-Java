package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class DetailRingkasanMataKuliahGUI {
    public DetailRingkasanMataKuliahGUI(JFrame frame, MataKuliah mataKuliah, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        // TODO: Implementasikan Detail Ringkasan Mata Kuliah
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 0, 10, 10));
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Detail Ringkasan Mata Kuliah");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        panel.add(titleLabel);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // TODO: Isi sesuai format keluaran
        JLabel nama = new JLabel();
        nama.setText("Nama matakuliah: " + mataKuliah.getNama());
        nama.setHorizontalAlignment(JLabel.CENTER);
        nama.setFont(SistemAkademikGUI.fontGeneral);
        panel.add(nama);

        /** Mengambil method getKode di class MataKuliah */
        JLabel kode = new JLabel();
        kode.setText("Kode: " + mataKuliah.getKode());
        kode.setHorizontalAlignment(JLabel.CENTER);
        kode.setFont(SistemAkademikGUI.fontGeneral);
        panel.add(kode);

        /** Mengambil method totalSKS() di class MataKuliah */
        JLabel sks = new JLabel();
        sks.setText("SKS: " + mataKuliah.getSKS());
        sks.setHorizontalAlignment(JLabel.CENTER);
        sks.setFont(SistemAkademikGUI.fontGeneral);
        panel.add(sks);

        JLabel jumlah = new JLabel();
        jumlah.setText("Jumlah mahasiswa: " + mataKuliah.getJumlahMahasiswa());
        jumlah.setHorizontalAlignment(JLabel.CENTER);
        jumlah.setFont(SistemAkademikGUI.fontGeneral);
        panel.add(jumlah);

        JLabel kapasitas = new JLabel();
        kapasitas.setText("Kapasitas: " + mataKuliah.getKapasitas());
        kapasitas.setHorizontalAlignment(JLabel.CENTER);
        kapasitas.setFont(SistemAkademikGUI.fontGeneral);
        panel.add(kapasitas);

        JLabel daftar = new JLabel();
        daftar.setText("Daftar mahasiswa: ");
        daftar.setHorizontalAlignment(JLabel.CENTER);
        daftar.setFont(SistemAkademikGUI.fontGeneral);

        //Mata kuliah dan mahasiswa yang dimasukkan tidak akan melebihi 100 orang
       /* TODO: Cetak hasil cek IRS
        Handle kasus jika tidak ada mahasiswa yang mengambil */
        if (mataKuliah.getJumlahMahasiswa() == 0) {
            JLabel belum = new JLabel();
            belum.setText("Belum ada mahasiswa yang mengambil mata kuliah ini.");
            belum.setHorizontalAlignment(JLabel.CENTER);
            belum.setFont(SistemAkademikGUI.fontGeneral);
        }
        else {
            for (int i = 0; i < mataKuliah.getJumlahMahasiswa(); i++) {
                JLabel daftarMhsw = new JLabel();
                daftarMhsw.setText((i + 1) + ". " + mataKuliah.getDaftarMahasiswa()[i]);
                daftarMhsw.setHorizontalAlignment(JLabel.CENTER);
                daftarMhsw.setFont(SistemAkademikGUI.fontGeneral);
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
