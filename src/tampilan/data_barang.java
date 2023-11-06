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
public class data_barang extends javax.swing.JInternalFrame {
   

    public final Connection conn = new koneksi().koneksi();
    private DefaultTableModel tabmode;
    private DefaultTableModel tabmode2; 

    private Object txtKodeKategori;

    private data_kategori data_kategori;

    private void initForm() {

        data_kategori = new data_kategori();

    }

    private void aktif() {
    txtKodeBarang.setEnabled(true);
    txtNamaBarang.setEnabled(true);
    jTextField1.setEnabled(true);
    txtJumlahBarang.setEnabled(true);
    txtKeterangan.setEnabled(true);
}

protected void kosong() {
    tanggal();
    txtKodeBarang.setText(null);
    txtNamaBarang.setText(null);
    jTextField1.setText(null);
    txtJumlahBarang.setText(null);
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
        tabelBarang.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        kolom = tabelBarang.getColumnModel().getColumn(0);
        kolom.setPreferredWidth(40);
        kolom = tabelBarang.getColumnModel().getColumn(1);
        kolom.setPreferredWidth(100);
        kolom = tabelBarang.getColumnModel().getColumn(2);
        kolom.setPreferredWidth(100);
        kolom = tabelBarang.getColumnModel().getColumn(3);
        kolom.setPreferredWidth(120);
        kolom = tabelBarang.getColumnModel().getColumn(4);
        kolom.setPreferredWidth(130);
    }
    public void lebarKolom2() {
    TableColumn column2;
    tabelKategori.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    column2 = tabelKategori.getColumnModel().getColumn(0);
    column2.setPreferredWidth(40);
    column2 = tabelKategori.getColumnModel().getColumn(1);
    column2.setPreferredWidth(150);
    column2 = tabelKategori.getColumnModel().getColumn(2);
    column2.setPreferredWidth(200);
} 

    public void dataTable() {
         Object[] Baris = {"No", "Tanggal", "Kode Barang", "Nama Barang","Kode Kategori", "Jumlah", "Keterangan"};
    tabmode = new DefaultTableModel(null, Baris);
    tabelBarang.setModel(tabmode);
    String sql = "select * from barang order by kode_barang asc";
    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()) {
            String tanggal = hasil.getString("tanggal");
            String kode_barang = hasil.getString("kode_barang");
            String nama_barang = hasil.getString("nama_barang");
            String kode_kategori = hasil.getString("kode_kategori");
            String jumlah = hasil.getString("jumlah");
            String keterangan = hasil.getString("keterangan");
            String[] data = {"", tanggal, kode_barang, nama_barang, kode_kategori, jumlah, keterangan};
            tabmode.addRow(data);
            noTable();
            lebarKolom();
        }
    } catch (Exception e) {
    }
    }
    public void dataTable2() {
       Object[] Baris = {"No", "Kode Kategori", "Nama Kategori"};
    tabmode2 = new DefaultTableModel(null, Baris);
    tabelKategori.setModel(tabmode2);
    String sql = "select * from kategori order by kode_kategori asc";
    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()) {
            String kode_kategori = hasil.getString("kode_kategori");
            String nama_kategori = hasil.getString("nama_kategori");
            String[] data = {"", kode_kategori, nama_kategori};
            tabmode2.addRow(data);
            noTable2();
            lebarKolom2();
        }
    } catch (Exception e) {
    }
} 

    public void pencarian(String sql) {
         Object[] Baris = {"No", "Tanggal", "Kode Barang", "Nama Barang", "Keterangan"};
    tabmode = new DefaultTableModel(null, Baris);
    tabelBarang.setModel(tabmode);
    int brs = tabelBarang.getRowCount();
    for (int i = 0; 1 < brs; i++) {
        tabmode.removeRow(1);
    }
    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()) {
            String tanggal = hasil.getString("tanggal");
            String kode_barang = hasil.getString("kode_barang");
            String nama_barang = hasil.getString("nama_barang");
            String keterangan = hasil.getString("keterangan");
            String[] data = {"", tanggal, kode_barang, nama_barang, keterangan};
            tabmode.addRow(data);
            noTable();
        }
    } catch (Exception e) {

    }
    }
    public void pencarian2(String sql) {
    Object[] Baris = {"No", "Kode Kategori", "Nama Kategori"};
    tabmode2 = new DefaultTableModel(null, Baris);
    tabelKategori.setModel(tabmode2);
    int brs = tabelKategori.getRowCount();
    for (int i = 0; 1 < brs; i++) {
        tabmode2.removeRow(1);
    }
    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()) {
            String kode_kategori = hasil.getString("kode_kategori");
            String nama_kategori = hasil.getString("nama_kategori");
            String[] data = {"", kode_kategori, nama_kategori};
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
    
     public data_barang() {
            initComponents();
            dataTable();
            lebarKolom();
            aktif();
            tanggal();
            txtKodeBarang.requestFocus();
        } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UbahBarang = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnTanggalUbah = new com.toedter.calendar.JDateChooser();
        txtNamaBarangUbah = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtKeteranganUbah = new javax.swing.JTextArea();
        btnSimpanUbah = new javax.swing.JButton();
        btnBatalUbah = new javax.swing.JButton();
        txtKodeBarangUbah = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtKodeKategoriUbah1 = new javax.swing.JTextField();
        txtNamaKategoriUbah2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        listKategori = new javax.swing.JDialog();
        jLabel13 = new javax.swing.JLabel();
        txtCariKategori = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelKategori = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnTanggal = new com.toedter.calendar.JDateChooser();
        txtNamaBarang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtKeterangan = new javax.swing.JTextArea();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        txtKodeBarang = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtJumlahBarang = new javax.swing.JTextField();
        btnKodeKategori = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnCari = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Ubah Barang"));
        jPanel5.setToolTipText("");

        jLabel7.setText("Tanggal");

        jLabel8.setText("Kode Barang");

        jLabel9.setText("Nama Barang");

        jLabel10.setText("Keterangan");

        btnTanggalUbah.setDateFormatString("dd-MM-yyyy");

        txtNamaBarangUbah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaBarangUbahKeyPressed(evt);
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

        jLabel14.setText("Kode Kategori");

        txtKodeKategoriUbah1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKodeKategoriUbah1KeyPressed(evt);
            }
        });

        txtNamaKategoriUbah2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaKategoriUbah2KeyPressed(evt);
            }
        });

        jLabel15.setText("Jumlah");

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
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnSimpanUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBatalUbah))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNamaBarangUbah)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                        .addComponent(btnTanggalUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtKodeBarangUbah)
                        .addComponent(txtKodeKategoriUbah1)
                        .addComponent(txtNamaKategoriUbah2)))
                .addContainerGap(136, Short.MAX_VALUE))
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
                        .addComponent(txtKodeBarangUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNamaBarangUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtKodeKategoriUbah1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtNamaKategoriUbah2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout UbahBarangLayout = new javax.swing.GroupLayout(UbahBarang.getContentPane());
        UbahBarang.getContentPane().setLayout(UbahBarangLayout);
        UbahBarangLayout.setHorizontalGroup(
            UbahBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
            .addGroup(UbahBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UbahBarangLayout.setVerticalGroup(
            UbahBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
            .addGroup(UbahBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Data Barang");

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 700));

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Pengolahan Data Barang");

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
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Barang"));

        jLabel2.setText("Tanggal");

        jLabel3.setText("Kode Barang");

        jLabel4.setText("Nama Barang");

        jLabel5.setText("Keterangan");

        btnTanggal.setDateFormatString("dd-MM-yyyy");

        txtNamaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaBarangKeyPressed(evt);
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

        jLabel11.setText("Kode Kategori");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jLabel12.setText("Jumlah");

        txtJumlahBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtJumlahBarangKeyPressed(evt);
            }
        });

        btnKodeKategori.setText("cari");
        btnKodeKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKodeKategoriActionPerformed(evt);
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
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNamaBarang)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addComponent(btnTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKodeBarang)
                            .addComponent(txtJumlahBarang)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnKodeKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(btnTambah)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReset))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(btnHapus)
                        .addGap(32, 32, 32)
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
                        .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKodeKategori))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnReset)
                    .addComponent(btnTambah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatal)
                    .addComponent(btnHapus))
                .addGap(83, 83, 83))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Barang"));

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

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelBarang.setShowGrid(true);
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelBarang);

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
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari)
                    .addComponent(jLabel6)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaBarangKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        txtKeterangan.requestFocus();
} 
    }//GEN-LAST:event_txtNamaBarangKeyPressed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if (txtKodeBarang.getText().equals("")) {
    JOptionPane.showMessageDialog(null, "Kode Barang tidak boleh kosong");
} else if (txtNamaBarang.getText().equals("")) {
    JOptionPane.showMessageDialog(null, "Nama Barang tidak boleh kosong");
} else if (jTextField1.getText().equals("")) {
    JOptionPane.showMessageDialog(null, "Kode Kategori tidak boleh kosong");
} else if (txtJumlahBarang.getText().equals("")) {
    JOptionPane.showMessageDialog(null, "Jumlah tidak boleh kosong");
}  else {
    String sql = "insert into barang values (?,?,?,?,?,?)";
    String tampilan = "dd-MM-yyyy";
    SimpleDateFormat fm = new SimpleDateFormat(tampilan);
    String tanggal = String.valueOf(fm.format(btnTanggal.getDate()));
    try {
        java.sql.PreparedStatement stat = koneksi.prepareStatement(sql);
         stat.setString(1, tanggal.toString());
        stat.setString(2, txtKodeBarang.getText());
        stat.setString(3, txtNamaBarang.getText());
        stat.setString(4, jTextField1.getText());
        stat.setString(5, txtJumlahBarang.getText());
        stat.setString(6, txtKeterangan.getText());
        stat.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        kosong();
        dataTable();
        lebarKolom();
        jTextField1.requestFocus();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Data Gagal Disimpan" + e);
    }
}

    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
         UbahBarang.setLocationRelativeTo(this);
        txtKodeBarangUbah.setEditable(false);
        UbahBarang.setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        dispose();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        int bar = tabelBarang.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        Date dateValue = null;
        try {
            dateValue = date.parse((String) tabelBarang.getValueAt(bar, 1));
        } catch (ParseException ex) {
            Logger.getLogger(data_barang.class.getName()).log(Level.SEVERE, null, ex);
        }

        btnTanggal.setDate(dateValue);
        btnTanggalUbah.setDate(dateValue);
        txtKodeBarang.setText(c);
        txtKodeBarangUbah.setText(c);
        txtNamaBarang.setText(d);
        txtNamaBarangUbah.setText(d);
        jTextField1.setText(e);
        txtKodeBarangUbah.setText(e);
        txtJumlahBarang.setText(f);
        txtNamaKategoriUbah2.setText(f);
        txtKeterangan.setText(g);
        txtKeteranganUbah.setText(g);
    }//GEN-LAST:event_tabelBarangMouseClicked

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
            stat.setString(1, txtKodeBarang.getText());
            int rowsAffected = stat.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                kosong();
                dataTable();
                lebarKolom();
                txtKodeBarang.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
        String sqlPencarian = "select * from kategori where kode_kategori like '%" + txtCari.getText() + "%' or "
        + "nama_kategori like '%" + txtCari.getText() + "%' or "
        + "keterangan like '%" + txtCari.getText() + "%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_txtCariKeyTyped

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        String sqlPencarian = "select * from kategori where kode_kategori like '%" + txtCari.getText() + "%' or "
        + "nama_kategori like '%" + txtCari.getText() + "%' or "
        + "keterangan like '%" + txtCari.getText() + "%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_btnCariActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyPressed

    private void txtJumlahBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahBarangKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahBarangKeyPressed

    private void btnKodeKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKodeKategoriActionPerformed
        dataTable2();
        lebarKolom2();
        listKategori.setLocationRelativeTo(this);
        listKategori.setVisible(true);
    }//GEN-LAST:event_btnKodeKategoriActionPerformed

    private void txtCariKategoriKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKategoriKeyTyped
        String sqlPencarian2 = "select * from kategori where kode_kategori like '%" + txtCariKategori.getText() + "%' or "
                + "nama_kategori like '%" + txtCariKategori.getText() + "%'";
        pencarian2(sqlPencarian2);
        lebarKolom2();
    }//GEN-LAST:event_txtCariKategoriKeyTyped

    private void tabelKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKategoriMouseClicked
        int bar = tabelKategori.getSelectedRow();
    String a = tabmode2.getValueAt(bar, 0).toString();
    String b = tabmode2.getValueAt(bar, 1).toString();
    String c = tabmode2.getValueAt(bar, 2).toString();

    jTextField1.setText(c);
    listKategori.dispose();
    txtJumlahBarang.requestFocus();
    }//GEN-LAST:event_tabelKategoriMouseClicked

    private void btnBatalUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalUbahActionPerformed
        UbahBarang.setVisible(false);
    }//GEN-LAST:event_btnBatalUbahActionPerformed

    private void btnSimpanUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanUbahActionPerformed
        String sql = "update kategori set tanggal=?,kode_kategori=?,nama_kategori=?,keterangan=? where kode_kategori='" + txtKodeBarangUbah.getText() + "'";
        String tampilan = "dd-MM-yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(btnTanggalUbah.getDate()));
        try {
            java.sql.PreparedStatement stat = koneksi.prepareStatement(sql);
            stat.setString(1, tanggal.toString());
        stat.setString(2, txtKodeBarang.getText());
        stat.setString(3, txtNamaBarang.getText());
        stat.setString(4, jTextField1.getText());
        stat.setString(5, txtJumlahBarang.getText());
        stat.setString(6, txtKeterangan.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            kosong();
            dataTable();
            lebarKolom();
            txtKodeBarang.requestFocus();
            UbahBarang.dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah" + e);
        }
    }//GEN-LAST:event_btnSimpanUbahActionPerformed

    private void txtNamaBarangUbahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaBarangUbahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaBarangUbahKeyPressed

    private void txtKodeKategoriUbah1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKodeKategoriUbah1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeKategoriUbah1KeyPressed

    private void txtNamaKategoriUbah2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaKategoriUbah2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaKategoriUbah2KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog UbahBarang;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnBatalUbah;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKodeKategori;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpanUbah;
    private javax.swing.JButton btnTambah;
    private com.toedter.calendar.JDateChooser btnTanggal;
    private com.toedter.calendar.JDateChooser btnTanggalUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JDialog listKategori;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JTable tabelKategori;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtCariKategori;
    private javax.swing.JTextField txtJumlahBarang;
    private javax.swing.JTextArea txtKeterangan;
    private javax.swing.JTextArea txtKeteranganUbah;
    private javax.swing.JTextField txtKodeBarang;
    private javax.swing.JTextField txtKodeBarangUbah;
    private javax.swing.JTextField txtKodeKategoriUbah1;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtNamaBarangUbah;
    private javax.swing.JTextField txtNamaKategoriUbah2;
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
        
    

        
    

