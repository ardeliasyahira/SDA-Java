package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class RingkasanMataKuliahGUI {

    public RingkasanMataKuliahGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        // TODO: Implementasikan Ringkasan Mata Kuliah
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 0, 10, 10));
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Ringkasan Mata Kuliah");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        panel.add(titleLabel);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel pilihMatkul = new JLabel();
        pilihMatkul.setText("Pilih Nama Matkul");
        pilihMatkul.setHorizontalAlignment(JLabel.CENTER);
        pilihMatkul.setFont(SistemAkademikGUI.fontGeneral);
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
        JComboBox menuMatkul = new JComboBox(matkul);
        panel.add(menuMatkul);

        JButton lihat = new JButton();
        lihat.setPreferredSize(new Dimension(90, 30));
        lihat.setText("Lihat");
        lihat.setFont(SistemAkademikGUI.fontGeneral);
        lihat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //MASIH SALAHH
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

    // Uncomment method di bawah jika diperluka
    private MataKuliah getMataKuliah(String nama, ArrayList<MataKuliah> daftarMataKuliah) {
        for (MataKuliah mataKuliah : daftarMataKuliah) {
            if (mataKuliah.getNama().equals(nama)){
                return mataKuliah;
            }
        }
        return null;
    }
}
