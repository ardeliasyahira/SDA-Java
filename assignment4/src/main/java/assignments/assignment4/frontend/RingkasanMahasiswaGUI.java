package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class RingkasanMahasiswaGUI {

    public RingkasanMahasiswaGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        // TODO: Implementasikan Ringkasan Mahasiswa
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 0, 10, 10));
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Ringkasan Mahasiswa");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        panel.add(titleLabel);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

//        JScrollPane pane = new JScrollPane(panel);
//        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        frame.getContentPane().add(pane, new GridLayout());

        JLabel pilihNPM = new JLabel();
        pilihNPM.setText("Pilih NPM");
        pilihNPM.setHorizontalAlignment(JLabel.CENTER);
        pilihNPM.setFont(SistemAkademikGUI.fontGeneral);
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
        JComboBox menuNPM = new JComboBox(npm);
        panel.add(menuNPM);

        JButton lihat = new JButton();
        lihat.setPreferredSize(new Dimension(90, 30));
        lihat.setText("Lihat");
        lihat.setFont(SistemAkademikGUI.fontGeneral);
        lihat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //MASIH SALAHH
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
        panel.add(lihat);

        JButton kembali = new JButton();
        kembali.setPreferredSize(new Dimension(90, 30));
        kembali.setText("Kembali");
        kembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeGUI(frame, daftarMahasiswa, daftarMataKuliah);
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
