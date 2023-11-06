/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package tampilan;

import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.Statement;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;


import koneksi.koneksi;
/**
 *
 * @author ASUS
 */
public class data_transaksi_keluar extends javax.swing.JInternalFrame {

    public final Connection conn = new koneksi().koneksi();
    private DefaultTableModel tabmode;
    private DefaultTableModel tabmode2;

    private data_transaksi_keluar data_transaksi_keluar;

     public data_transaksi_keluar() {
            initComponents();
            dataTable();
            lebarKolom();
            aktif();
            tanggal();
            txtIDBK.requestFocus();
        } 
     
    private void aktif() {
        txtIDBK.setEnabled(true);
        txtKodeGudang.setEnabled(true);
//        txtKodeBarang.setEnabled(true);
        txtNamaBarang.setEnabled(true);
        txtJumlah.setEnabled(true);
        txtKeterangan.setEnabled(true);
    }

    protected void kosong() {
        tanggal();
        txtIDBK.setEnabled(true);
        txtKodeGudang.setEnabled(true);
//        txtKodeBarang.setEnabled(true);
        txtNamaBarang.setEnabled(true);
        txtJumlah.setEnabled(true);
        txtKeterangan.setEnabled(true);
        txtKeterangan.setText(null);
    }

    public void noTable() {
        int Baris = tabmode.getRowCount();
        for (int a = 0; a < Baris; a++) {
            String nomor = String.valueOf(a + 1);
            tabmode.setValueAt(nomor + ".", a, 0);
        }
    }
    public void noTable2() {
    int Baris = tabmode2.getRowCount();
    for (int a = 0; a < Baris; a++) {
        String nomor = String.valueOf(a + 1);
        tabmode2.setValueAt(nomor + ".", a, 0);
    }
} 

    public void tanggal() {
        Date tgl = new Date();
        btnTanggal.setDate(tgl);
    }

    public void lebarKolom() {
        TableColumn kolom;
        tabelTransaksiBK.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        kolom = tabelTransaksiBK.getColumnModel().getColumn(0);
        kolom.setPreferredWidth(40);
        kolom = tabelTransaksiBK.getColumnModel().getColumn(1);
        kolom.setPreferredWidth(100);
        kolom = tabelTransaksiBK.getColumnModel().getColumn(2);
        kolom.setPreferredWidth(100);
        kolom = tabelTransaksiBK.getColumnModel().getColumn(3);
        kolom.setPreferredWidth(120);
        kolom = tabelTransaksiBK.getColumnModel().getColumn(4);
        kolom.setPreferredWidth(130);
        kolom = tabelTransaksiBK.getColumnModel().getColumn(5);
        kolom.setPreferredWidth(120);
 

    }
    public void lebarKolom2() {
    TableColumn column2;
    tabelTransaksiBK.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    column2 = tabelTransaksiBK.getColumnModel().getColumn(0);
    column2.setPreferredWidth(40);
    column2 = tabelTransaksiBK.getColumnModel().getColumn(1);
    column2.setPreferredWidth(150);
    column2 = tabelTransaksiBK.getColumnModel().getColumn(2);
    column2.setPreferredWidth(200);
} 

    public void dataTable() {
       Object[] Baris = {"No", "Tanggal", "ID Barang Keluar", "Kode Gudang", "Nama Barang", "Jumlah", "Keterangan"};
    tabmode = new DefaultTableModel(null, Baris);
    tabelTransaksiBK.setModel(tabmode);
    String sql = "select * from barang_keluar order by id_bk asc";
    
    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        
        int no = 1; 
        
        while (hasil.next()) {
            String tanggal = hasil.getString("tanggal");
            String id_bk = hasil.getString("id_bk");
            String kode_gudang = hasil.getString("kode_gudang");
//            String kode_barang = hasil.getString("kode_barang");
            String nama_barang = hasil.getString("nama_barang");
            String jumlah = hasil.getString("jumlah");
            String keterangan = hasil.getString("keterangan");
            
            String[] data = {String.valueOf(no), tanggal, id_bk, kode_gudang, nama_barang, jumlah, keterangan};
            tabmode.addRow(data);
            
            no++; 
        }
        
        lebarKolom(); 
    } catch (SQLException e) {
        e.printStackTrace(); 
    }
    }
    public void dataTable2() {
   Object[] Baris = {"No", "Tanggal", "ID Barang Keluar", "Kode Gudang","Nama Barang", "Jumlah",  "Keterangan"};
    tabmode2 = new DefaultTableModel(null, Baris);
    tabelTransaksiBK.setModel(tabmode);
    String sql = "select * from barang_keluar order by id_bk asc";
    try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String tanggal = hasil.getString("tanggal");
                String id_bk = hasil.getString("id_bk");
                String kode_gudang = hasil.getString("kode_gudang");
//                String kode_barang = hasil.getString("kode_barang");
                String nama_barang = hasil.getString("nama_barang");
                String jumlah = hasil.getString("jumlah");
                String keterangan = hasil.getString("keterangan");
                String[] data = {"", tanggal, id_bk, kode_gudang, nama_barang,jumlah, keterangan};
                tabmode2.addRow(data);
                noTable2();
                lebarKolom();
            }
        } catch (Exception e) {
        }
} 

    public void pencarian(String sql) {
        Object[] Baris = {"No", "Kode Gudang", "Nama gudang"};
    tabmode = new DefaultTableModel(null, Baris);
    tabelTransaksiBK.setModel(tabmode);
    int brs = tabelTransaksiBK.getRowCount();
    for (int i = 0; 1 < brs; i++) {
        tabmode.removeRow(1);
    }
    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()) {
            String id_bk = hasil.getString("id_bk");
            String kode_barang = hasil.getString("kode_barang");
            String[] data = {"", id_bk, kode_barang};
            tabmode.addRow(data);
            noTable();
            lebarKolom2();
        }
    } catch (Exception e) {

    }
    }
    public void pencarian2(String sql) {
    Object[] Baris = {"No", "Kode Gudang", "Nama gudang"};
    tabmode2 = new DefaultTableModel(null, Baris);
    tabelTransaksiBK.setModel(tabmode2);
    int brs = tabelTransaksiBK.getRowCount();
    for (int i = 0; 1 < brs; i++) {
        tabmode2.removeRow(1);
    }
    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()) {
            String id_bk = hasil.getString("id_bk");
            String kode_barang = hasil.getString("kode_barang");
            String[] data = {"", id_bk, kode_barang};
            tabmode2.addRow(data);
            noTable2();
            lebarKolom2();
        }
    } catch (Exception e) {

    }
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ubahBK = new javax.swing.JDialog();
        jPanel11 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        btnTanggalUbah = new com.toedter.calendar.JDateChooser();
        txtKodeBarangUbah = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtKeteranganUbah = new javax.swing.JTextArea();
        btnSimpanUbah = new javax.swing.JButton();
        btnBatalUbah = new javax.swing.JButton();
        txtIDBKUbah = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        txtNamaBarangUbah = new javax.swing.JTextField();
        txtJumlahUbah = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        txtKodeGudangUbah1 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnTanggal = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtKeterangan = new javax.swing.JTextArea();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        txtIDBK = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNamaBarang = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtKodeGudang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnCari = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelTransaksiBK = new javax.swing.JTable();

        jPanel13.setBackground(new java.awt.Color(255, 255, 204));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Transaksi Barang Keluar"));

        jLabel50.setText("Tanggal");

        jLabel51.setText("ID Barang Keluar");

        jLabel52.setText("Kode Barang");

        jLabel53.setText("Keterangan");

        btnTanggalUbah.setDateFormatString("dd-MM-yyyy");

        txtKodeBarangUbah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKodeBarangUbahKeyPressed(evt);
            }
        });

        txtKeteranganUbah.setColumns(20);
        txtKeteranganUbah.setRows(5);
        jScrollPane9.setViewportView(txtKeteranganUbah);

        btnSimpanUbah.setText("Simpan");
        btnSimpanUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanUbahActionPerformed(evt);
            }
        });

        btnBatalUbah.setText("Batal");
        btnBatalUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalUbahActionPerformed(evt);
            }
        });

        jLabel54.setText("Nama Barang");

        txtNamaBarangUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaBarangUbahActionPerformed(evt);
            }
        });
        txtNamaBarangUbah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaBarangUbahKeyPressed(evt);
            }
        });

        txtJumlahUbah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtJumlahUbahKeyPressed(evt);
            }
        });

        jLabel55.setText("Jumlah");

        jLabel56.setText("Kode Gudang");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51)
                            .addComponent(jLabel50)
                            .addComponent(jLabel52)
                            .addComponent(jLabel53)
                            .addComponent(jLabel54)
                            .addComponent(jLabel55)
                            .addComponent(jLabel56))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKodeBarangUbah)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addComponent(btnTanggalUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIDBKUbah)
                            .addComponent(txtNamaBarangUbah)
                            .addComponent(txtJumlahUbah)
                            .addComponent(txtKodeGudangUbah1)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btnSimpanUbah)
                        .addGap(34, 34, 34)
                        .addComponent(btnBatalUbah)))
                .addGap(83, 83, 83))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel50)
                    .addComponent(btnTanggalUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel51))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtIDBKUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel56))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtKodeGudangUbah1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(txtKodeBarangUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(txtNamaBarangUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJumlahUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSimpanUbah)
                    .addComponent(btnBatalUbah))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout ubahBKLayout = new javax.swing.GroupLayout(ubahBK.getContentPane());
        ubahBK.getContentPane().setLayout(ubahBKLayout);
        ubahBKLayout.setHorizontalGroup(
            ubahBKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ubahBKLayout.setVerticalGroup(
            ubahBKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setIconifiable(true);
        setMaximizable(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setPreferredSize(new java.awt.Dimension(1200, 700));

        jPanel3.setBackground(new java.awt.Color(255, 204, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Data Transaksi Barang Keluar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(508, 508, 508)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Transaksi Barang Keluar"));

        jLabel2.setText("Tanggal");

        jLabel3.setText("ID Barang Keluar");

        jLabel5.setText("Keterangan");

        btnTanggal.setDateFormatString("dd-MM-yyyy");

        txtKeterangan.setColumns(20);
        txtKeterangan.setRows(5);
        jScrollPane1.setViewportView(txtKeterangan);

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        jLabel11.setText("Nama Barang");

        txtNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaBarangActionPerformed(evt);
            }
        });
        txtNamaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaBarangKeyPressed(evt);
            }
        });

        txtJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtJumlahKeyPressed(evt);
            }
        });

        jLabel12.setText("Jumlah");

        jLabel7.setText("Kode Gudang");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel5))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addComponent(btnTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIDBK)
                            .addComponent(txtNamaBarang)
                            .addComponent(txtJumlah)
                            .addComponent(txtKodeGudang)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnHapus)
                            .addComponent(btnTambah))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnEdit)
                                .addGap(18, 18, 18)
                                .addComponent(btnReset))
                            .addComponent(btnBatal))))
                .addGap(83, 83, 83))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(btnTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtIDBK, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtKodeGudang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnEdit)
                    .addComponent(btnReset))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal))
                .addContainerGap(206, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Transaksi Keluar"));

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jLabel6.setText("Pencarian");

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariKeyTyped(evt);
            }
        });

        tabelTransaksiBK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        tabelTransaksiBK.setShowGrid(true);
        tabelTransaksiBK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelTransaksiBKMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelTransaksiBK);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(184, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari)
                    .addComponent(jLabel6)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if (txtIDBK.getText().equals("")) {
    JOptionPane.showMessageDialog(null, "ID Barang keluar tidak boleh kosong");
} else if (txtKodeGudang.getText().equals("")) {
    JOptionPane.showMessageDialog(null, "Nama Gudang tidak boleh kosong");

}   else {
    String sql = "insert into barang_keluar values (?,?,?,?,?)";
    String tampilan = "dd-MM-yyyy";
    SimpleDateFormat fm = new SimpleDateFormat(tampilan);
    String tanggal = String.valueOf(fm.format(btnTanggal.getDate()));
    try {
        java.sql.PreparedStatement stat = koneksi.prepareStatement(sql);
        stat.setString(1, tanggal.toString());
        stat.setString(2, txtIDBK.getText());
        stat.setString(3, txtKodeGudang.getText());
        stat.setString(4, txtNamaBarang.getText());
        stat.setString(5, txtJumlah.getText());
        stat.setString(6, txtKeterangan.getText());
        stat.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        kosong();
        dataTable();
        lebarKolom();
        txtIDBK.requestFocus();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Data Gagal Disimpan" + e);
    }
}
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        ubahBK.setLocationRelativeTo(this);
        txtKodeBarangUbah.setEditable(false);
        ubahBK.setVisible(true);
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
       ubahBK.setLocationRelativeTo(this);
        txtIDBKUbah.setEditable(false);
        ubahBK.setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        tanggal();
        kosong();
    }//GEN-LAST:event_btnResetActionPerformed

    
    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
         int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Menghapus Data", "Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
    if (ok == 0) {
        try {
            String sql = "DELETE FROM barang_keluar WHERE id_bk=?";
            java.sql.PreparedStatement stat = koneksi.prepareStatement(sql);
            stat.setString(1, txtIDBK.getText());
            int rowsAffected = stat.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                kosong();
                dataTable();
                lebarKolom();
                txtIDBK.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        dispose();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void txtNamaBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaBarangKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaBarangKeyPressed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
         String sqlPencarian = "select * from barang_keluar where kode_gudang like '%" + txtCari.getText() + "%' or "
        + "kode_barang like '%" + txtCari.getText() + "%' or "
        + "keterangan like '%" + txtCari.getText() + "%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_btnCariActionPerformed

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
       String sqlPencarian = "select * from barang_keluar where kode_gudang like '%" + txtCari.getText() + "%' or "
        + "kode_barang like '%" + txtCari.getText() + "%' or "
        + "keterangan like '%" + txtCari.getText() + "%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_txtCariKeyTyped

    private void tabelTransaksiBKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelTransaksiBKMouseClicked
         int bar = tabelTransaksiBK.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        Date dateValue = null;
        try {
            dateValue = date.parse((String) tabelTransaksiBK.getValueAt(bar, 1));
        } catch (ParseException ex) {
            Logger.getLogger(data_barang.class.getName()).log(Level.SEVERE, null, ex);
        }

        btnTanggal.setDate(dateValue);
        btnTanggalUbah.setDate(dateValue);
        txtKodeGudang.setText(c);
        txtKodeBarangUbah.setText(c);
        txtNamaBarang.setText(d);
        txtNamaBarangUbah.setText(d);
        txtJumlah.setText(e);
        txtJumlahUbah.setText(e);
        txtKeterangan.setText(f);
        txtKeteranganUbah.setText(f);
    }//GEN-LAST:event_tabelTransaksiBKMouseClicked

    private void txtJumlahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahKeyPressed

    private void txtNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaBarangActionPerformed

    private void txtKodeBarangUbahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKodeBarangUbahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeBarangUbahKeyPressed

    private void btnSimpanUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanUbahActionPerformed
        String sql = "update data_keluar set tanggal=?,id_bk=?,kode_gudang=?, nama_barang=?,jumlah=?,keterangan=? where id_bk='" + txtIDBKUbah.getText() + "'";
        String tampilan = "dd-MM-yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(btnTanggalUbah.getDate()));
        try {
            java.sql.PreparedStatement stat = koneksi.prepareStatement(sql);
            stat.setString(1, tanggal.toString());
            stat.setString(2, txtIDBKUbah.getText());
            stat.setString(3, txtKodeGudangUbah1.getText());
            stat.setString(4, txtNamaBarangUbah.getText());
            stat.setString(5, txtJumlahUbah.getText());
            stat.setString(6, txtKeteranganUbah.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            kosong();
            dataTable();
            lebarKolom();
            txtIDBK.requestFocus();
            ubahBK.dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah" + e);
        }
    }//GEN-LAST:event_btnSimpanUbahActionPerformed

    private void btnBatalUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalUbahActionPerformed
       btnBatalUbah.setVisible(false);
    }//GEN-LAST:event_btnBatalUbahActionPerformed

    private void txtNamaBarangUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaBarangUbahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaBarangUbahActionPerformed

    private void txtNamaBarangUbahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaBarangUbahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaBarangUbahKeyPressed

    private void txtJumlahUbahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahUbahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahUbahKeyPressed

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked

             tanggal();
             kosong();
  
    }//GEN-LAST:event_btnResetMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnBatalUbah;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpanUbah;
    private javax.swing.JButton btnTambah;
    private com.toedter.calendar.JDateChooser btnTanggal;
    private com.toedter.calendar.JDateChooser btnTanggalUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable tabelTransaksiBK;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIDBK;
    private javax.swing.JTextField txtIDBKUbah;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtJumlahUbah;
    private javax.swing.JTextArea txtKeterangan;
    private javax.swing.JTextArea txtKeteranganUbah;
    private javax.swing.JTextField txtKodeBarangUbah;
    private javax.swing.JTextField txtKodeGudang;
    private javax.swing.JTextField txtKodeGudangUbah1;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtNamaBarangUbah;
    private javax.swing.JDialog ubahBK;
    // End of variables declaration//GEN-END:variables
}
