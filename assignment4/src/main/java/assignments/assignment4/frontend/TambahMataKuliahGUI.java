package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class TambahMataKuliahGUI{

    public TambahMataKuliahGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){
        
        // TODO: Implementasikan Tambah Mata Kuliah
        frame.getContentPane().removeAll();
        frame.repaint();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11,0,10,10));
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Tambah Mata Kuliah");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);
        panel.add(titleLabel);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel kodeMatkul = new JLabel("Kode Mata Kuliah:");
        kodeMatkul.setHorizontalAlignment(JLabel.CENTER);
        kodeMatkul.setFont(SistemAkademikGUI.fontGeneral);
        TextField inputKode = new TextField(30);
        inputKode.setColumns(45);
        panel.add(kodeMatkul);
        panel.add(inputKode);

        JLabel namaMatkul = new JLabel("Nama Mata Kuliah:");
        namaMatkul.setHorizontalAlignment(JLabel.CENTER);
        namaMatkul.setFont(SistemAkademikGUI.fontGeneral);
        TextField inputNama = new TextField(30);
        inputNama.setColumns(45);
        panel.add(namaMatkul);
        panel.add(inputNama);

        JLabel sks = new JLabel("SKS:");
        sks.setHorizontalAlignment(JLabel.CENTER);
        sks.setFont(SistemAkademikGUI.fontGeneral);
        TextField inputSKS = new TextField(30);
        inputSKS.setColumns(45);
        panel.add(sks);
        panel.add(inputSKS);

        JLabel kapasitas = new JLabel("Kapasitas:");
        kapasitas.setHorizontalAlignment(JLabel.CENTER);
        kapasitas.setFont(SistemAkademikGUI.fontGeneral);
        TextField inputKapa = new TextField(30);
        inputKapa.setColumns(45);
        panel.add(kapasitas);
        panel.add(inputKapa);

        JButton tambahkan =new JButton();
        JButton kembali =new JButton();
        tambahkan.setPreferredSize(new Dimension(90,30));
        tambahkan.setText("Tambahkan");
        tambahkan.setFont(SistemAkademikGUI.fontGeneral);
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
    private MataKuliah getMataKuliah(String nama, ArrayList<MataKuliah> daftarMataKuliah) {
        for (MataKuliah mataKuliah : daftarMataKuliah) {
            if (mataKuliah.getNama().equals(nama)){
                return mataKuliah;
            }
        }
        return null;
    }
}
