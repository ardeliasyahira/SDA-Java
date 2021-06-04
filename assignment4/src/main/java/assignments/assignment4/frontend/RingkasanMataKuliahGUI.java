package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class RingkasanMataKuliahGUI {

    public RingkasanMataKuliahGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 0, 10, 10));
        panel.setBackground(new Color(172,109,126,255));

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Ringkasan Mata Kuliah");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        titleLabel.setForeground(new Color(86, 55, 63));
        panel.add(titleLabel);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel pilihMatkul = new JLabel();
        pilihMatkul.setText("Pilih Nama Matkul");
        pilihMatkul.setHorizontalAlignment(JLabel.CENTER);
        pilihMatkul.setFont(SistemAkademikGUI.fontGeneral);
        pilihMatkul.setForeground(new Color(86, 55, 63));
        MataKuliah[] matkul = daftarMataKuliah.toArray(new MataKuliah[0]);
        for (int i = 0; i < matkul.length; i++) {
            for (int j = i + 1; j < matkul.length; j++) { //Algoritma Bubble Sort
                if (matkul[i].getNama().compareTo(matkul[j].getNama()) > 0) {
                    MataKuliah elemenPertama = matkul[i];
                    MataKuliah elemenKedua = matkul[j];
                    matkul[i] = elemenKedua;
                    matkul[j] = elemenPertama;
                }
            }
        }

        String[] matkulStr = new String[matkul.length];
        for (int i = 0; i < matkul.length; i++) {
            matkulStr[i] = matkul[i].getNama();
        }

        JComboBox menuMatkul = new JComboBox(matkulStr);
        menuMatkul.setFont(SistemAkademikGUI.fontGeneral);
        JScrollPane pane = new JScrollPane(menuMatkul);
        menuMatkul.setMaximumRowCount(5);
        panel.add(menuMatkul);
        frame.add(pane);

        JButton lihat = new JButton();
        lihat.setPreferredSize(new Dimension(90, 30));
        lihat.setText("Lihat");
        lihat.setFont(SistemAkademikGUI.fontGeneral);
        lihat.setForeground(new Color(86, 55, 63));
        lihat.setBackground(new Color(226,161,149,255));
        lihat.setOpaque(true);
        lihat.setBorderPainted(false);
        lihat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (menuMatkul.getSelectedItem() == null) {
                    frame.setTitle("Message"); //Menambahkan judul frame
                    JOptionPane.showMessageDialog(frame, "Mohon isi seluruh Field");
                } else {
                    String matkulPilihan = (String) menuMatkul.getSelectedItem();
                    MataKuliah matkul = getMataKuliah(matkulPilihan, daftarMataKuliah);
                    new DetailRingkasanMataKuliahGUI(frame, matkul, daftarMahasiswa, daftarMataKuliah);
                }
            }
        });
        lihat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lihat.setBackground(new Color(182, 129, 148));
                lihat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                lihat.setBackground(new Color(226,161,149,255));
            }
        });
        panel.add(lihat);

        JButton kembali = new JButton();
        kembali.setPreferredSize(new Dimension(90, 30));
        kembali.setText("Kembali");
        kembali.setFont(SistemAkademikGUI.fontGeneral);
        kembali.setForeground(new Color(86, 55, 63));
        kembali.setBackground(new Color(226,161,149,255));
        kembali.setOpaque(true);
        kembali.setBorderPainted(false);
        kembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeGUI(frame, daftarMahasiswa, daftarMataKuliah);
            }
        });
        kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                kembali.setBackground(new Color(182, 129, 148));
                kembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                kembali.setBackground(new Color(226,161,149,255));
            }
        });
        panel.add(kembali);

        frame.add(panel);
        frame.setVisible(true);
    }

    private MataKuliah getMataKuliah(String nama, ArrayList<MataKuliah> daftarMataKuliah) {
        for (MataKuliah mataKuliah : daftarMataKuliah) {
            if (mataKuliah.getNama().equals(nama)){
                return mataKuliah;
            }
        }
        return null;
    }
}
