package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class RingkasanMahasiswaGUI {

    public RingkasanMahasiswaGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 0, 10, 10));
        panel.setBackground(new Color(172,109,126,255));

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Ringkasan Mahasiswa");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        titleLabel.setForeground(new Color(86, 55, 63));
        panel.add(titleLabel);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel pilihNPM = new JLabel();
        pilihNPM.setText("Pilih NPM");
        pilihNPM.setHorizontalAlignment(JLabel.CENTER);
        pilihNPM.setFont(SistemAkademikGUI.fontGeneral);
        pilihNPM.setForeground(new Color(86, 55, 63));
        Mahasiswa[] npm = daftarMahasiswa.toArray(new Mahasiswa[0]);
        for (int i = 0; i < npm.length; i++) {
            for (int j = i + 1; j < npm.length; j++) { //Algoritma Bubble Sort
                if (npm[i].getNpm() > npm[j].getNpm()) {
                    Mahasiswa elemenPertama = npm[i];
                    Mahasiswa elemenKedua = npm[j];
                    npm[i] = elemenKedua;
                    npm[j] = elemenPertama;
                }
            }
        }

        String[] npmStr = new String[npm.length];
        for (int i = 0; i < npm.length; i++) {
            npmStr[i] = Long.toString(npm[i].getNpm());
        }

        JComboBox menuNPM = new JComboBox(npmStr);
        menuNPM.setFont(SistemAkademikGUI.fontGeneral);

        JScrollPane pane = new JScrollPane(menuNPM);
        menuNPM.setMaximumRowCount(5);
        panel.add(menuNPM);
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
                if (menuNPM.getSelectedItem() == null) {
                    frame.setTitle("Message"); //Menambahkan judul frame
                    JOptionPane.showMessageDialog(frame, "Mohon isi seluruh Field");
                } else {
                    String npmPilihan = (String) menuNPM.getSelectedItem();
                    long longNPM = Long.parseLong(npmPilihan);
                    Mahasiswa mahasiswa = getMahasiswa(longNPM, daftarMahasiswa);
                    new DetailRingkasanMahasiswaGUI(frame, mahasiswa, daftarMahasiswa, daftarMataKuliah);
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

    // Uncomment method di bawah jika diperlukan
    private Mahasiswa getMahasiswa(long npm, ArrayList<Mahasiswa> daftarMahasiswa) {
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            if (mahasiswa.getNpm() == npm){
                return mahasiswa;
            }
        }
        return null;
    }
}
