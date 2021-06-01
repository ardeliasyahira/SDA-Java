package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class TambahMahasiswaGUI{

    public TambahMahasiswaGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){
        frame.getContentPane().removeAll();
        frame.repaint();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7,0,10,10));
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Tambah Mahasiswa");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        panel.add(titleLabel);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel namaMahasiswa = new JLabel("Nama:");
        namaMahasiswa.setHorizontalAlignment(JLabel.CENTER);
        namaMahasiswa.setFont(SistemAkademikGUI.fontGeneral);
        TextField inputNama = new TextField(30);
        inputNama.setColumns(45);
        panel.add(namaMahasiswa);
        panel.add(inputNama);

        JLabel npm = new JLabel("NPM:");
        npm.setHorizontalAlignment(JLabel.CENTER);
        npm.setFont(SistemAkademikGUI.fontGeneral);
        TextField inputNPM =new TextField(30);
        inputNPM.setColumns(45);
        panel.add(npm);
        panel.add(inputNPM);

        JButton tambahkan =new JButton();
        JButton kembali =new JButton();
        tambahkan.setPreferredSize(new Dimension(90,30));
        tambahkan.setText("Tambahkan");
        tambahkan.setFont(SistemAkademikGUI.fontGeneral);
        tambahkan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (inputNama.getText().equals("") || inputNPM.getText().equals("")) {
                    frame.setTitle("Message"); //Menambahkan judul frame
                    JOptionPane.showMessageDialog(frame, "Mohon isi seluruh Field");
                }
                else if (getMahasiswa(Long.parseLong(inputNPM.getText()), daftarMahasiswa) == null) {
                    Mahasiswa mahasiswa = new Mahasiswa(inputNama.getText(), Long.parseLong(inputNPM.getText()));
                    daftarMahasiswa.add(mahasiswa);
                    JOptionPane.showMessageDialog(frame, "Mahasiswa " + inputNPM.getText() + "-" + inputNama.getText() + " berhasil ditambahkan");
                }
                else {
                    JOptionPane.showMessageDialog(frame, "NPM " + inputNPM.getText() + " sudah pernah ditambahkan sebelumnya");
                }
            }
        });
        panel.add(tambahkan);

        kembali.setPreferredSize(new Dimension(90,30));
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
    private Mahasiswa getMahasiswa(long npm, ArrayList<Mahasiswa> daftarMahasiswa) {
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            if (mahasiswa.getNpm() == npm){
                return mahasiswa;
            }
        }
        return null;
    }
}
