/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package tampilan;


import com.mysql.cj.xdevapi.Statement;
import java.awt.event.KeyEvent;
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
public class data_gudang extends javax.swing.JInternalFrame {
   

    public final Connection conn = new koneksi().koneksi();
    private DefaultTableModel tabmode;
    private DefaultTableModel tabmode2; 

    private Object txtKodeKategori;

    private data_kategori data_kategori;

    private void initForm() {

        data_kategori = new data_kategori();

    }

    private void aktif() {
        txtKodeGudang.setEnabled(true);
        txtNamaGudang.setEnabled(true);
        txtAlamat.setEnabled(true);
        txtKeterangan.setEnabled(true);
    }

    protected void kosong() {
        tanggal();
        txtKodeGudang.setText(null);
        txtNamaGudang.setText(null);
        txtAlamat.setText(null);
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
        tabelGudang.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        kolom = tabelGudang.getColumnModel().getColumn(0);
        kolom.setPreferredWidth(40);
        kolom = tabelGudang.getColumnModel().getColumn(1);
        kolom.setPreferredWidth(100);
        kolom = tabelGudang.getColumnModel().getColumn(2);
        kolom.setPreferredWidth(100);
        kolom = tabelGudang.getColumnModel().getColumn(3);
        kolom.setPreferredWidth(120);
        kolom = tabelGudang.getColumnModel().getColumn(4);
        kolom.setPreferredWidth(130);
    }
    public void lebarKolom2() {
    TableColumn column2;
    tabelGudang.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    column2 = tabelGudang.getColumnModel().getColumn(0);
    column2.setPreferredWidth(40);
    column2 = tabelGudang.getColumnModel().getColumn(1);
    column2.setPreferredWidth(150);
    column2 = tabelGudang.getColumnModel().getColumn(2);
    column2.setPreferredWidth(200);
} 

    public void dataTable() {
         Object[] Baris = {"No", "Tanggal", "Kode Gudang", "Nama Gudang","Alamat", "Keterangan"};
    tabmode = new DefaultTableModel(null, Baris);
    tabelGudang.setModel(tabmode);
    String sql = "select * from gudang order by kode_gudang asc";
    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()) {
            String tanggal = hasil.getString("tanggal");
            String kode_gudang = hasil.getString("kode_gudang");
            String nama_gudang = hasil.getString("nama_gudang");
            String alamat = hasil.getString("alamat");
            String keterangan = hasil.getString("keterangan");
            String[] data = {"", tanggal, kode_gudang, nama_gudang,alamat, keterangan};
            tabmode.addRow(data);
            noTable();
            lebarKolom();
        }
    } catch (Exception e) {
    }
    }
    public void dataTable2() {
    Object[] Baris = {"No", "Tanggal", "Kode Gudang", "Nama Gudang","Alamat", "Keterangan"};
    tabmode = new DefaultTableModel(null, Baris);
    tabelGudang.setModel(tabmode);
    String sql = "select * from gudang order by kode_gudang asc";
    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()) {
            String tanggal = hasil.getString("tanggal");
            String kode_gudang = hasil.getString("kode_gudang");
            String nama_gudang = hasil.getString("nama_gudang");
            String alamat = hasil.getString("alamat");
            String keterangan = hasil.getString("keterangan");
            String[] data = {"", tanggal, kode_gudang, nama_gudang,alamat, keterangan};
            tabmode.addRow(data);
            noTable();
            lebarKolom();
        }
    } catch (Exception e) {
    }
} 

    public void pencarian(String sql) {
         Object[] Baris = {"No", "Tanggal", "Kode Gudang", "Nama Gudang","Alamat", "Keterangan"};
    tabmode = new DefaultTableModel(null, Baris);
    tabelGudang.setModel(tabmode);
    int brs = tabelGudang.getRowCount();
    for (int i = 0; 1 < brs; i++) {
        tabmode.removeRow(1);
    }
    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()) {
            String tanggal = hasil.getString("tanggal");
            String kode_gudang = hasil.getString("kode_gudang");
            String nama_gudang = hasil.getString("nama_gudang");
            String alamat = hasil.getString("alamat");
            String keterangan = hasil.getString("keterangan");
            String[] data = {"", tanggal, kode_gudang, nama_gudang,alamat, keterangan};
          tabmode.addRow(data);
            noTable();
        }
    } catch (Exception e) {

    }
    }
    public void pencarian2(String sql) {
    Object[] Baris = {"No", "Kode Gudang", "Nama gudang"};
    tabmode2 = new DefaultTableModel(null, Baris);
    tabelGudang.setModel(tabmode2);
    int brs = tabelGudang.getRowCount();
    for (int i = 0; 1 < brs; i++) {
        tabmode2.removeRow(1);
    }
    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()) {
            String kode_gudang = hasil.getString("kode_gudang");
            String nama_gudang = hasil.getString("nama_gudang");
            String[] data = {"", kode_gudang, nama_gudang};
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
    
     public data_gudang() {
            initComponents();
            dataTable();
            lebarKolom();
            aktif();
            tanggal();
            txtKodeGudang.requestFocus();
        } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ubahKategori = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnTanggalUbah = new com.toedter.calendar.JDateChooser();
        txtNamaKategoriUbah = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtKeteranganUbah = new javax.swing.JTextArea();
        btnSimpanUbah = new javax.swing.JButton();
        btnBatalUbah = new javax.swing.JButton();
        txtKodeKategoriUbah = new javax.swing.JTextField();
        listKategori = new javax.swing.JDialog();
        jLabel13 = new javax.swing.JLabel();
        txtCariKategori = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelKategori = new javax.swing.JTable();
        ListGudang = new javax.swing.JDialog();
        jLabel12 = new javax.swing.JLabel();
        txtCariGudang = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        TabelGudang1 = new javax.swing.JTable();
        ubahGudang = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnTanggalUbah1 = new com.toedter.calendar.JDateChooser();
        txtNamaGudangUbah = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtKeteranganUbah1 = new javax.swing.JTextArea();
        btnSimpanEdit = new javax.swing.JButton();
        btnBatalEdit = new javax.swing.JButton();
        txtKodeGudangUbah = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtAlamatUbah = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnTanggal = new com.toedter.calendar.JDateChooser();
        txtNamaGudang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtKeterangan = new javax.swing.JTextArea();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        txtKodeGudang = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnCari = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelGudang = new javax.swing.JTable();

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Ubah Kategori"));
        jPanel5.setToolTipText("");

        jLabel7.setText("Tanggal");

        jLabel8.setText("Kode Kategori");

        jLabel9.setText("Nama Kategori");

        jLabel10.setText("Keterangan");

        btnTanggalUbah.setDateFormatString("dd-MM-yyyy");

        txtNamaKategoriUbah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaKategoriUbahKeyPressed(evt);
            }
        });

        txtKeteranganUbah.setColumns(20);
        txtKeteranganUbah.setRows(5);
        jScrollPane3.setViewportView(txtKeteranganUbah);

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnSimpanUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBatalUbah))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNamaKategoriUbah)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                        .addComponent(btnTanggalUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtKodeKategoriUbah)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(btnTanggalUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel8))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtKodeKategoriUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNamaKategoriUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpanUbah)
                    .addComponent(btnBatalUbah))
                .addGap(84, 84, 84))
        );

        javax.swing.GroupLayout ubahKategoriLayout = new javax.swing.GroupLayout(ubahKategori.getContentPane());
        ubahKategori.getContentPane().setLayout(ubahKategoriLayout);
        ubahKategoriLayout.setHorizontalGroup(
            ubahKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
            .addGroup(ubahKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ubahKategoriLayout.setVerticalGroup(
            ubahKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
            .addGroup(ubahKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listKategori.setTitle("List Data Kategori");

        jLabel13.setText("Cari Kategori");

        txtCariKategori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariKategoriKeyTyped(evt);
            }
        });

        tabelKategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelKategori.setShowGrid(true);
        tabelKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKategoriMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabelKategori);

        javax.swing.GroupLayout listKategoriLayout = new javax.swing.GroupLayout(listKategori.getContentPane());
        listKategori.getContentPane().setLayout(listKategoriLayout);
        listKategoriLayout.setHorizontalGroup(
            listKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listKategoriLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel13)
                .addGap(34, 34, 34)
                .addComponent(txtCariKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listKategoriLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        listKategoriLayout.setVerticalGroup(
            listKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listKategoriLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(listKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtCariKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel12.setText("Cari Gudang");

        txtCariGudang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariGudangKeyTyped(evt);
            }
        });

        TabelGudang1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TabelGudang1.setShowGrid(true);
        TabelGudang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelGudang1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TabelGudang1);

        javax.swing.GroupLayout ListGudangLayout = new javax.swing.GroupLayout(ListGudang.getContentPane());
        ListGudang.getContentPane().setLayout(ListGudangLayout);
        ListGudangLayout.setHorizontalGroup(
            ListGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListGudangLayout.createSequentialGroup()
                .addGroup(ListGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ListGudangLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel12)
                        .addGap(31, 31, 31)
                        .addComponent(txtCariGudang, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ListGudangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        ListGudangLayout.setVerticalGroup(
            ListGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListGudangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ListGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCariGudang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Edit Data Gudang"));
        jPanel6.setToolTipText("");

        jLabel14.setText("Kode Gudang");

        jLabel15.setText("Nama Gudang");

        jLabel16.setText("Keterangan");

        btnTanggalUbah1.setDateFormatString("dd-MM-yyyy");

        txtNamaGudangUbah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaGudangUbahKeyPressed(evt);
            }
        });

        txtKeteranganUbah1.setColumns(20);
        txtKeteranganUbah1.setRows(5);
        jScrollPane6.setViewportView(txtKeteranganUbah1);

        btnSimpanEdit.setText("Simpan");
        btnSimpanEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanEditActionPerformed(evt);
            }
        });

        btnBatalEdit.setText("Batal");
        btnBatalEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalEditActionPerformed(evt);
            }
        });

        jLabel17.setText("Tanggal");

        jLabel18.setText("Alamat");

        txtAlamatUbah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAlamatUbahKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnSimpanEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBatalEdit))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNamaGudangUbah)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                        .addComponent(btnTanggalUbah1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtKodeGudangUbah)
                        .addComponent(txtAlamatUbah)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(btnTanggalUbah1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel14))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtKodeGudangUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtNamaGudangUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtAlamatUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpanEdit)
                    .addComponent(btnBatalEdit))
                .addGap(84, 84, 84))
        );

        javax.swing.GroupLayout ubahGudangLayout = new javax.swing.GroupLayout(ubahGudang.getContentPane());
        ubahGudang.getContentPane().setLayout(ubahGudangLayout);
        ubahGudangLayout.setHorizontalGroup(
            ubahGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ubahGudangLayout.setVerticalGroup(
            ubahGudangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Data Gudang");

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 700));

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Pengolahan Data Gudang");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(508, 508, 508)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Gudang"));

        jLabel2.setText("Tanggal");

        jLabel3.setText("Kode Gudang");

        jLabel4.setText("Nama Gudang");

        jLabel5.setText("Keterangan");

        btnTanggal.setDateFormatString("dd-MM-yyyy");

        txtNamaGudang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaGudangKeyPressed(evt);
            }
        });

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

        jLabel11.setText("Alamat");

        txtAlamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAlamatKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNamaGudang)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addComponent(btnTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKodeGudang)
                            .addComponent(txtAlamat)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnTambah)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBatal)))
                .addGap(83, 83, 83))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(btnTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtKodeGudang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNamaGudang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnEdit)
                    .addComponent(btnReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal))
                .addGap(130, 130, 130))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Gudang"));

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

        tabelGudang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tabelGudang.setShowGrid(true);
        tabelGudang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelGudangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelGudang);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari)
                    .addComponent(jLabel6)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1142, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Data Barang");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaGudangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaGudangKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        txtNamaGudang.requestFocus();
} 
    }//GEN-LAST:event_txtNamaGudangKeyPressed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if (txtKodeGudang.getText().equals("")) {
    JOptionPane.showMessageDialog(null, "Kode Barang tidak boleh kosong");
} else if (txtNamaGudang.getText().equals("")) {
    JOptionPane.showMessageDialog(null, "Nama Barang tidak boleh kosong");
} else if (txtAlamat.getText().equals("")) {
    JOptionPane.showMessageDialog(null, "Kode Kategori tidak boleh kosong");
}   else {
    String sql = "insert into gudang values (?,?,?,?,?)";
    String tampilan = "dd-MM-yyyy";
    SimpleDateFormat fm = new SimpleDateFormat(tampilan);
    String tanggal = String.valueOf(fm.format(btnTanggal.getDate()));
    try {
        java.sql.PreparedStatement stat = koneksi.prepareStatement(sql);
        stat.setString(1, tanggal.toString());
        stat.setString(2, txtKodeGudang.getText());
        stat.setString(3, txtNamaGudang.getText());
        stat.setString(4, txtAlamat.getText());;
        stat.setString(5, txtKeterangan.getText());
        stat.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        kosong();
        dataTable();
        lebarKolom();
        txtKodeGudang.requestFocus();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Data Gagal Disimpan" + e);
    }
}

    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        ubahGudang.setLocationRelativeTo(this);
        txtKodeGudangUbah.setEditable(false);
        ubahGudang.setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        dispose();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void txtNamaKategoriUbahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaKategoriUbahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaKategoriUbahKeyPressed

    private void btnBatalUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalUbahActionPerformed
        ubahKategori.setVisible(false);
    }//GEN-LAST:event_btnBatalUbahActionPerformed

    private void tabelGudangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelGudangMouseClicked
        int bar = tabelGudang.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();

        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        Date dateValue = null;
        try {
            dateValue = date.parse((String) tabelGudang.getValueAt(bar, 1));
        } catch (ParseException ex) {
            Logger.getLogger(data_gudang.class.getName()).log(Level.SEVERE, null, ex);
        }

        btnTanggal.setDate(dateValue);
        btnTanggalUbah1.setDate(dateValue);
        txtKodeGudang.setText(b);
        txtKodeGudangUbah.setText(b);
        txtNamaGudang.setText(c);
        txtNamaGudangUbah.setText(c);
        txtAlamat.setText(d);
        txtAlamatUbah.setText(d);
        txtKeterangan.setText(e);
        txtKeteranganUbah1.setText(e);
    }//GEN-LAST:event_tabelGudangMouseClicked

    private void btnSimpanUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanUbahActionPerformed
        String sql = "update gudang set tanggal=?,kode_gudang=?,nama_gudang=?,alamat=?,keterangan=? where kode_alamat='" + txtKodeGudangUbah.getText() + "'";
        String tampilan = "dd-MM-yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(btnTanggalUbah1.getDate()));
        try {
             java.sql.PreparedStatement stat = koneksi.prepareStatement(sql);
             stat.setString(1, tanggal.toString());
             stat.setString(2, txtKodeGudangUbah.getText());
             stat.setString(3, txtNamaGudangUbah.getText());
             stat.setString(4, txtAlamatUbah.getText());
             stat.setString(5, txtKeteranganUbah1.getText());
             stat.executeUpdate();
             JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
             kosong();
             dataTable();
             lebarKolom();
             txtKodeGudang.requestFocus();
             ubahGudang.dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah" + e);
        }
    }//GEN-LAST:event_btnSimpanUbahActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
       tanggal();
        kosong();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
       int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Menghapus Data", "Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
    if (ok == 0) {
        try {
            String sql = "DELETE FROM gudang WHERE kode_gudang=?";
            java.sql.PreparedStatement stat = koneksi.prepareStatement(sql);
            stat.setString(1, txtKodeGudang.getText());
            int rowsAffected = stat.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                kosong();
                dataTable();
                lebarKolom();
                txtKodeGudang.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
        String sqlPencarian = "select * from gudang where kode_gudang like '%" + txtCari.getText() + "%' or "
        + "nama_gudang like '%" + txtCari.getText() + "%' or "
        + "keterangan like '%" + txtCari.getText() + "%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_txtCariKeyTyped

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        String sqlPencarian = "select * from gudang where kode_gudang like '%" + txtCari.getText() + "%' or "
        + "nama_gudang like '%" + txtCari.getText() + "%' or "
        + "keterangan like '%" + txtCari.getText() + "%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_btnCariActionPerformed

    private void txtAlamatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlamatKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlamatKeyPressed

    private void txtCariKategoriKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKategoriKeyTyped
        String sqlPencarian2 = "select * from kategori where kode_kategori like '%" + txtCariKategori.getText() + "%' or "
                + "nama_kategori like '%" + txtCariKategori.getText() + "%'";
        pencarian2(sqlPencarian2);
        lebarKolom2();
    }//GEN-LAST:event_txtCariKategoriKeyTyped

    private void tabelKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKategoriMouseClicked

    }//GEN-LAST:event_tabelKategoriMouseClicked

    private void txtCariGudangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariGudangKeyTyped
        String sqlPencarian2 = "select * gudang where kode_gudang like '%" + txtCariGudang.getText() + "%' or "
                + "nama_gudang like '%" + txtCariGudang.getText() + "%'";
    pencarian2(sqlPencarian2);
    lebarKolom2();
    }//GEN-LAST:event_txtCariGudangKeyTyped

    private void TabelGudang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelGudang1MouseClicked
        int bar = tabelGudang.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
    txtKodeGudang.setText(c);
    ListGudang.dispose();

    }//GEN-LAST:event_TabelGudang1MouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked

    }//GEN-LAST:event_btnEditMouseClicked

    private void txtNamaGudangUbahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaGudangUbahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaGudangUbahKeyPressed

    private void btnSimpanEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanEditActionPerformed
        String sql = "update gudang set tanggal=?,kode_gudang=?,nama_gudang=?,alamat=?,keterangan=? where kode_gudang='" + txtKodeGudangUbah.getText() + "'";
        String tampilan = "dd-MM-yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(btnTanggalUbah1.getDate()));
        try {
            java.sql.PreparedStatement stat = koneksi.prepareStatement(sql);
            stat.setString(1, tanggal.toString());
            stat.setString(2, txtKodeGudangUbah.getText());
            stat.setString(3, txtNamaGudangUbah.getText());
            stat.setString(4, txtAlamatUbah.getText());
            stat.setString(5, txtKeteranganUbah1.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            kosong();
            dataTable();
            lebarKolom();
            txtKodeGudang.requestFocus();
            ubahKategori.dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah" + e);
        }
    }//GEN-LAST:event_btnSimpanEditActionPerformed

    private void btnBatalEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalEditActionPerformed
        ubahGudang.setVisible(false);
    }//GEN-LAST:event_btnBatalEditActionPerformed

    private void txtAlamatUbahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlamatUbahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlamatUbahKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog ListGudang;
    private javax.swing.JTable TabelGudang1;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnBatalEdit;
    private javax.swing.JButton btnBatalUbah;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpanEdit;
    private javax.swing.JButton btnSimpanUbah;
    private javax.swing.JButton btnTambah;
    private com.toedter.calendar.JDateChooser btnTanggal;
    private com.toedter.calendar.JDateChooser btnTanggalUbah;
    private com.toedter.calendar.JDateChooser btnTanggalUbah1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JDialog listKategori;
    private javax.swing.JTable tabelGudang;
    private javax.swing.JTable tabelKategori;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtAlamatUbah;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtCariGudang;
    private javax.swing.JTextField txtCariKategori;
    private javax.swing.JTextArea txtKeterangan;
    private javax.swing.JTextArea txtKeteranganUbah;
    private javax.swing.JTextArea txtKeteranganUbah1;
    private javax.swing.JTextField txtKodeGudang;
    private javax.swing.JTextField txtKodeGudangUbah;
    private javax.swing.JTextField txtKodeKategoriUbah;
    private javax.swing.JTextField txtNamaGudang;
    private javax.swing.JTextField txtNamaGudangUbah;
    private javax.swing.JTextField txtNamaKategoriUbah;
    private javax.swing.JDialog ubahGudang;
    private javax.swing.JDialog ubahKategori;
    // End of variables declaration//GEN-END:variables

    private static class PreparedStatement {

        public PreparedStatement() throws ClassNotFoundException, SQLException {
         try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/inventory";
        String username = "root";
        String password = "";

        // Membuat koneksi
        Connection connection = DriverManager.getConnection(url, username, password);
        // Membuat objek Statement dari koneksi
        
         } catch (SQLException e){
            System.out.println("Gagal Koneksi Database"+e);
    }
        }

         
        }

       
    }
        
    

        
    

