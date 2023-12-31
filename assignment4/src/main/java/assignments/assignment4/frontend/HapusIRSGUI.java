package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class HapusIRSGUI {

    public HapusIRSGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 0, 10, 10));
        panel.setBackground(new Color(172,109,126,255));

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Hapus IRS");
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
        frame.add(pane);
        panel.add(menuNPM);

        JLabel pilihMatkul = new JLabel();
        pilihMatkul.setText("Pilih Nama Matkul");
        pilihNPM.setHorizontalAlignment(JLabel.CENTER);
        pilihNPM.setFont(SistemAkademikGUI.fontGeneral);
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

        JScrollPane panell = new JScrollPane(menuMatkul);
        menuMatkul.setMaximumRowCount(5);
        frame.add(panell);
        panel.add(menuMatkul);

        JButton hapus = new JButton();
        hapus.setPreferredSize(new Dimension(90, 30));
        hapus.setText("Hapus");
        hapus.setFont(SistemAkademikGUI.fontGeneral);
        hapus.setForeground(new Color(86, 55, 63));
        hapus.setBackground(new Color(226,161,149,255));
        hapus.setOpaque(true);
        hapus.setBorderPainted(false);
        hapus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (menuNPM.getSelectedItem() == null || menuMatkul.getSelectedItem() == null) {
                    frame.setTitle("Message"); //Menambahkan judul frame
                    JOptionPane.showMessageDialog(frame, "Mohon isi seluruh Field");
                } else {
                    String matkulPilihan = (String) menuMatkul.getSelectedItem();
                    String npmPilihan = (String) menuNPM.getSelectedItem();
                    Long npmLong = Long.parseLong(npmPilihan);
                    Mahasiswa mahasiswa = getMahasiswa(npmLong, daftarMahasiswa);
                    MataKuliah mataKuliah = getMataKuliah(matkulPilihan, daftarMataKuliah);

                    String message = mahasiswa.dropMatkul(mataKuliah);
                    JOptionPane.showMessageDialog(frame, message);
                }
            }
        });
        hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hapus.setBackground(new Color(182, 129, 148));
                hapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                hapus.setBackground(new Color(226,161,149,255));
            }
        });
        panel.add(hapus);

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
            if (mataKuliah.getNama().equals(nama)) {
                return mataKuliah;
            }
        }
        return null;
    }

    private Mahasiswa getMahasiswa(long npm, ArrayList<Mahasiswa> daftarMahasiswa) {

        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            if (mahasiswa.getNpm() == npm) {
                return mahasiswa;
            }
        }
        return null;
    }
}
