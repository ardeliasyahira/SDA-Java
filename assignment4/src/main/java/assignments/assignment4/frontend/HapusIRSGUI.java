package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class HapusIRSGUI {

    public HapusIRSGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        JLabel sambutan = new JLabel();
        sambutan.setText("Hapus IRS");
        sambutan.setHorizontalAlignment(JLabel.CENTER);
        sambutan.setFont(SistemAkademikGUI.fontTitle);

        // TODO: Implementasikan Hapus IRS
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 0, 10, 10));
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Hapus IRS");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        panel.add(titleLabel);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

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
        JComboBox menuMatkul = new JComboBox(matkul);
        panel.add(menuMatkul);

        JButton hapus = new JButton();
        hapus.setPreferredSize(new Dimension(90, 30));
        hapus.setText("Hapus");
        hapus.setFont(SistemAkademikGUI.fontGeneral);
        hapus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //MASIH SALAHH
                if (menuNPM.getSelectedItem() == null || menuMatkul.getSelectedItem() == null) {
                    frame.setTitle("Message"); //Menambahkan judul frame
                    JOptionPane.showMessageDialog(frame, "Mohon isi seluruh Field");
                } else {
                    MataKuliah matkulPilihan = (MataKuliah) menuMatkul.getSelectedItem();
                    Mahasiswa npmPilihan = (Mahasiswa) menuNPM.getSelectedItem();

                    String message = npmPilihan.dropMatkul(matkulPilihan);
                    JOptionPane.showMessageDialog(frame, message);
                }
            }
        });
        panel.add(hapus);

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
