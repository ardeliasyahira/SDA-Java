package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class TambahMataKuliahGUI{

    public TambahMataKuliahGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        frame.getContentPane().removeAll();
        frame.repaint();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11,0,10,10));
        panel.setBackground(new Color(172,109,126,255));

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Tambah Mata Kuliah");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        titleLabel.setForeground(new Color(86, 55, 63));
        panel.add(titleLabel);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel kodeMatkul = new JLabel("Kode Mata Kuliah:");
        kodeMatkul.setHorizontalAlignment(JLabel.CENTER);
        kodeMatkul.setFont(SistemAkademikGUI.fontGeneral);
        kodeMatkul.setForeground(new Color(86, 55, 63));
        panel.add(kodeMatkul);

        TextField inputKode = new TextField(30);
        inputKode.setColumns(45);
        inputKode.setFont(SistemAkademikGUI.fontGeneral);
        inputKode.setForeground(new Color(86, 55, 63));
        inputKode.setBackground(new Color(200,135,136,255));
        panel.add(inputKode);

        JLabel namaMatkul = new JLabel("Nama Mata Kuliah:");
        namaMatkul.setHorizontalAlignment(JLabel.CENTER);
        namaMatkul.setFont(SistemAkademikGUI.fontGeneral);
        namaMatkul.setForeground(new Color(86, 55, 63));
        panel.add(namaMatkul);

        TextField inputNama = new TextField(30);
        inputNama.setColumns(45);
        inputNama.setFont(SistemAkademikGUI.fontGeneral);
        inputNama.setForeground(new Color(86, 55, 63));
        inputNama.setBackground(new Color(200,135,136,255));
        panel.add(inputNama);

        JLabel sks = new JLabel("SKS:");
        sks.setHorizontalAlignment(JLabel.CENTER);
        sks.setFont(SistemAkademikGUI.fontGeneral);
        sks.setForeground(new Color(86, 55, 63));
        panel.add(sks);

        TextField inputSKS = new TextField(30);
        inputSKS.setColumns(45);
        inputSKS.setFont(SistemAkademikGUI.fontGeneral);
        inputSKS.setForeground(new Color(86, 55, 63));
        inputSKS.setBackground(new Color(200,135,136,255));
        panel.add(inputSKS);

        JLabel kapasitas = new JLabel("Kapasitas:");
        kapasitas.setHorizontalAlignment(JLabel.CENTER);
        kapasitas.setFont(SistemAkademikGUI.fontGeneral);
        kapasitas.setForeground(new Color(86, 55, 63));
        panel.add(kapasitas);

        TextField inputKapa = new TextField(30);
        inputKapa.setColumns(45);
        inputKapa.setFont(SistemAkademikGUI.fontGeneral);
        inputKapa.setForeground(new Color(86, 55, 63));
        inputKapa.setBackground(new Color(200,135,136,255));
        panel.add(inputKapa);

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
                if (inputKode.getText().equals("") || inputNama.getText().equals("") || inputSKS.getText().equals("")
                        || inputKapa.getText().equals("")) {
                    frame.setTitle("Message"); //Menambahkan judul frame
                    JOptionPane.showMessageDialog(frame, "Mohon isi seluruh Field");
                }
                else if (getMataKuliah(inputNama.getText(), daftarMataKuliah) == null) {
                    MataKuliah mataKuliah = new MataKuliah(inputKode.getText(), inputNama.getText(), Integer.parseInt(inputSKS.getText()), Integer.parseInt(inputKapa.getText()));
                    daftarMataKuliah.add(mataKuliah);
                    JOptionPane.showMessageDialog(frame, "Mata kuliah " + inputNama.getText() + " berhasil ditambahkan.");
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Mata Kuliah " + inputNama.getText() + " sudah pernah ditambahkan sebelumnya");
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

    private MataKuliah getMataKuliah(String nama, ArrayList<MataKuliah> daftarMataKuliah) {
        for (MataKuliah mataKuliah : daftarMataKuliah) {
            if (mataKuliah.getNama().equals(nama)){
                return mataKuliah;
            }
        }
        return null;
    }
}
