package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class DetailRingkasanMataKuliahGUI {
    public DetailRingkasanMataKuliahGUI(JFrame frame, MataKuliah mataKuliah, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(60, 0, 10, 10));
        panel.setBackground(new Color(172,109,126,255));
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Detail Ringkasan Mata Kuliah");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        titleLabel.setForeground(new Color(86, 55, 63));
        panel.add(titleLabel);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel nama = new JLabel();
        nama.setText("Nama matakuliah: " + mataKuliah.getNama());
        nama.setHorizontalAlignment(JLabel.CENTER);
        nama.setFont(SistemAkademikGUI.fontGeneral);
        nama.setForeground(new Color(86, 55, 63));
        panel.add(nama);

        /** Mengambil method getKode di class MataKuliah */
        JLabel kode = new JLabel();
        kode.setText("Kode: " + mataKuliah.getKode());
        kode.setHorizontalAlignment(JLabel.CENTER);
        kode.setFont(SistemAkademikGUI.fontGeneral);
        kode.setForeground(new Color(86, 55, 63));
        panel.add(kode);

        /** Mengambil method totalSKS() di class MataKuliah */
        JLabel sks = new JLabel();
        sks.setText("SKS: " + mataKuliah.getSKS());
        sks.setHorizontalAlignment(JLabel.CENTER);
        sks.setFont(SistemAkademikGUI.fontGeneral);
        sks.setForeground(new Color(86, 55, 63));
        panel.add(sks);

        JLabel jumlah = new JLabel();
        jumlah.setText("Jumlah mahasiswa: " + mataKuliah.getJumlahMahasiswa());
        jumlah.setHorizontalAlignment(JLabel.CENTER);
        jumlah.setFont(SistemAkademikGUI.fontGeneral);
        jumlah.setForeground(new Color(86, 55, 63));
        panel.add(jumlah);

        JLabel kapasitas = new JLabel();
        kapasitas.setText("Kapasitas: " + mataKuliah.getKapasitas());
        kapasitas.setHorizontalAlignment(JLabel.CENTER);
        kapasitas.setFont(SistemAkademikGUI.fontGeneral);
        kapasitas.setForeground(new Color(86, 55, 63));
        panel.add(kapasitas);

        JLabel daftar = new JLabel();
        daftar.setText("Daftar mahasiswa: ");
        daftar.setHorizontalAlignment(JLabel.CENTER);
        daftar.setFont(SistemAkademikGUI.fontGeneral);
        daftar.setForeground(new Color(86, 55, 63));
        panel.add(daftar);


        /* Handle kasus jika tidak ada mahasiswa yang mengambil */
        if (mataKuliah.getJumlahMahasiswa() == 0) {
            JLabel belum = new JLabel();
            belum.setText("Belum ada mahasiswa yang mengambil mata kuliah ini.");
            belum.setHorizontalAlignment(JLabel.CENTER);
            belum.setFont(SistemAkademikGUI.fontGeneral2);
            belum.setForeground(new Color(157,71,78));
            panel.add(belum);
        }
        else {
            for (int i = 0; i < mataKuliah.getJumlahMahasiswa(); i++) {
                JLabel daftarMhsw = new JLabel();
                daftarMhsw.setText((i + 1) + ". " + mataKuliah.getDaftarMahasiswa()[i].getNama());
                daftarMhsw.setHorizontalAlignment(JLabel.CENTER);
                daftarMhsw.setFont(SistemAkademikGUI.fontGeneral2);
                daftarMhsw.setForeground(new Color(86, 55, 63));
                panel.add(daftarMhsw);
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
