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
        panel.setBackground(new Color(172,109,126,255));

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Tambah Mahasiswa");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        titleLabel.setForeground(new Color(86, 55, 63));
        panel.add(titleLabel);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel namaMahasiswa = new JLabel("Nama:");
        namaMahasiswa.setHorizontalAlignment(JLabel.CENTER);
        namaMahasiswa.setFont(SistemAkademikGUI.fontGeneral);
        namaMahasiswa.setForeground(new Color(86, 55, 63));
        panel.add(namaMahasiswa);

        TextField inputNama = new TextField(30);
        inputNama.setColumns(45);
        inputNama.setFont(SistemAkademikGUI.fontGeneral);
        inputNama.setForeground(new Color(86, 55, 63));
        inputNama.setBackground(new Color(200,135,136,255));
        panel.add(inputNama);


        JLabel npm = new JLabel("NPM:");
        npm.setHorizontalAlignment(JLabel.CENTER);
        npm.setFont(SistemAkademikGUI.fontGeneral);
        npm.setForeground(new Color(86, 55, 63));
        panel.add(npm);

        TextField inputNPM =new TextField(30);
        inputNPM.setColumns(45);
        inputNPM.setFont(SistemAkademikGUI.fontGeneral);
        inputNPM.setForeground(new Color(86, 55, 63));
        inputNPM.setBackground(new Color(200,135,136,255));
        panel.add(inputNPM);

        JButton tambahkan =new JButton();
        tambahkan.setPreferredSize(new Dimension(90,30));
        tambahkan.setText("Tambahkan");
        tambahkan.setFont(SistemAkademikGUI.fontGeneral);
        tambahkan.setForeground(new Color(86, 55, 63));
        tambahkan.setBackground(new Color(226,161,149,255));
        tambahkan.setOpaque(true);
        tambahkan.setBorderPainted(false);
        tambahkan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (inputNama.getText().equals("") || inputNPM.getText().equals("")) {
                    frame.setTitle("Message");
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
        tambahkan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tambahkan.setBackground(new Color(182, 129, 148));
                tambahkan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                tambahkan.setBackground(new Color(226,161,149,255));
            }
        });
        panel.add(tambahkan);

        JButton kembali =new JButton();
        kembali.setPreferredSize(new Dimension(90,30));
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

    private Mahasiswa getMahasiswa(long npm, ArrayList<Mahasiswa> daftarMahasiswa) {
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            if (mahasiswa.getNpm() == npm){
                return mahasiswa;
            }
        }
        return null;
    }
}
