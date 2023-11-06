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
public class data_pelanggan extends javax.swing.JInternalFrame {
   

    public final Connection conn = new koneksi().koneksi();
    private DefaultTableModel tabmode;
    private DefaultTableModel tabmode2; 


    private void aktif() {
    txtKodePelanggan.setEnabled(true);
    txtNamaPelanggan.setEnabled(true);
    txtNamaBarang.setEnabled(true);
    txtNoTelp.setEnabled(true);
    txtJumlah.setEnabled(true);

}

protected void kosong() {
    txtKodePelanggan.setText(null);
    txtNamaBarang.setText(null);
    txtNoTelp.setText(null);
    txtJumlah.setText(null);
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

    public void lebarKolom() {
        TableColumn kolom;
        tabelPelanggan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        kolom = tabelPelanggan.getColumnModel().getColumn(0);
        kolom.setPreferredWidth(40);
        kolom = tabelPelanggan.getColumnModel().getColumn(1);
        kolom.setPreferredWidth(100);
        kolom = tabelPelanggan.getColumnModel().getColumn(2);
        kolom.setPreferredWidth(100);
        kolom = tabelPelanggan.getColumnModel().getColumn(3);
        kolom.setPreferredWidth(120);
        kolom = tabelPelanggan.getColumnModel().getColumn(4);
        kolom.setPreferredWidth(130);
    }
    public void lebarKolom2() {
    TableColumn column2;
    tabelPelanggan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    column2 = tabelPelanggan.getColumnModel().getColumn(0);
    column2.setPreferredWidth(40);
    column2 = tabelPelanggan.getColumnModel().getColumn(1);
    column2.setPreferredWidth(150);
    column2 = tabelPelanggan.getColumnModel().getColumn(2);
    column2.setPreferredWidth(200);
} 

    public void dataTable() {
         Object[] Baris = {"No", "ID Pelanggan", "Nama Pelanggan"," Nomor telephon", "Nama Barang", "Jumlah"};
    tabmode = new DefaultTableModel(null, Baris);
    tabelPelanggan.setModel(tabmode);
    String sql = "select * from pelanggan order by id_pelanggan asc";
    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()) {
            String id_pelanggan = hasil.getString("id_pelanggan");
            String nama_pelanggan = hasil.getString("nama_pelanggan");
            String no_telp = hasil.getString("no_telp");
            String nama_barang = hasil.getString("nama_barang");
            String jumlah = hasil.getString("jumlah");
            String[] data = {"", id_pelanggan,nama_pelanggan, no_telp, nama_barang, jumlah};
            tabmode.addRow(data);
            noTable();
            lebarKolom();
        }
    } catch (Exception e) {
    }
    }
    public void dataTable2() {
        Object[] Baris = {"No", "ID Pelanggan","Nama Pelanggan","Nomor Telepon", "Nama Barang", "Jumlah",};
    tabmode2 = new DefaultTableModel(null, Baris);
    tabelPelanggan.setModel(tabmode2);
    String sql = "select * from pelanggan order by id_pelanggan asc";
    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()) {
            String id_pelanggan = hasil.getString("id_pelanggan");
             String nama_pelanggan = hasil.getString("nama_pelanggan");
            String no_telp = hasil.getString("no_telp");
            String nama_barang = hasil.getString("nama_barang");
            String jumlah = hasil.getString("jumlah");
            String[] data = {"", id_pelanggan, nama_pelanggan, no_telp, nama_barang, jumlah};
            tabmode2.addRow(data);
            noTable2();
            lebarKolom2();
        }
    } catch (Exception e) {
    }
} 

    public void pencarian(String sql) {
         Object[] Baris = {"No",  "ID Pelanggan", "Nama Pelanggan", "No Telephon"};
    tabmode = new DefaultTableModel(null, Baris);
    tabelPelanggan.setModel(tabmode);
    int brs = tabelPelanggan.getRowCount();
    for (int i = 0; 1 < brs; i++) {
        tabmode.removeRow(1);
    }
    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()) {
            String id_pelanggan = hasil.getString("id_pelanggan");
            String nama_pelanggan = hasil.getString("nama_pelanggan");
            String[] data = {"", id_pelanggan, nama_pelanggan};
            tabmode.addRow(data);
            noTable();
        }
    } catch (Exception e) {

    }
    }
    public void pencarian2(String sql) {
    Object[] Baris = {"No", "Kode Pelanggan", "Nama Pelanggan"};
    tabmode2 = new DefaultTableModel(null, Baris);
    tabelPelanggan.setModel(tabmode2);
    int brs = tabelPelanggan.getRowCount();
    for (int i = 0; 1 < brs; i++) {
        tabmode2.removeRow(1);
    }
    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()) {
            String id_pelanggan= hasil.getString("id_pelanggan");
            String nama_pelanggan = hasil.getString("nama_pelanggan");
            String[] data = {"", id_pelanggan, nama_pelanggan};
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
    
     public data_pelanggan() {
            initComponents();
            dataTable();
            lebarKolom();
            aktif();
            txtKodePelanggan.requestFocus();
        } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UbahPelanggan = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnTanggalUbah = new com.toedter.calendar.JDateChooser();
        txtNamaPelangganUbah = new javax.swing.JTextField();
        btnSimpanUbah = new javax.swing.JButton();
        btnBatalUbah = new javax.swing.JButton();
        txtKodePelangganUbah = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtNamaBarangUbah = new javax.swing.JTextField();
        txtJumlahUbah = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNoTelpUbah = new javax.swing.JTextField();
        listKategori = new javax.swing.JDialog();
        jLabel13 = new javax.swing.JLabel();
        txtCariKategori = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelKategori = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNamaPelanggan = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        txtKodePelanggan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNoTelp = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtNamaBarang = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnCari = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelPelanggan = new javax.swing.JTable();

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Ubah Pelanggan"));
        jPanel5.setToolTipText("");

        jLabel7.setText("Tanggal");

        jLabel8.setText("Kode Pelanggan");

        jLabel9.setText("Nama Pelanggan");

        btnTanggalUbah.setDateFormatString("dd-MM-yyyy");

        txtNamaPelangganUbah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaPelangganUbahKeyPressed(evt);
            }
        });

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

        jLabel14.setText("Nama Barang");

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

        jLabel15.setText("Jumlah");

        jLabel10.setText("Nomor Telepon");

        txtNoTelpUbah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoTelpUbahKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNamaPelangganUbah)
                            .addComponent(btnTanggalUbah, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addComponent(txtKodePelangganUbah)
                            .addComponent(txtNamaBarangUbah)
                            .addComponent(txtJumlahUbah)
                            .addComponent(txtNoTelpUbah)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(btnSimpanUbah)
                        .addGap(42, 42, 42)
                        .addComponent(btnBatalUbah)))
                .addContainerGap(121, Short.MAX_VALUE))
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
                        .addComponent(txtKodePelangganUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNamaPelangganUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNoTelpUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNamaBarangUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtJumlahUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatalUbah)
                    .addComponent(btnSimpanUbah))
                .addGap(227, 227, 227))
        );

        javax.swing.GroupLayout UbahPelangganLayout = new javax.swing.GroupLayout(UbahPelanggan.getContentPane());
        UbahPelanggan.getContentPane().setLayout(UbahPelangganLayout);
        UbahPelangganLayout.setHorizontalGroup(
            UbahPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
            .addGroup(UbahPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UbahPelangganLayout.setVerticalGroup(
            UbahPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
            .addGroup(UbahPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(UbahPelangganLayout.createSequentialGroup()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        listKategori.setTitle("List Data Kategori");

        jLabel13.setText("Cari pelanggan");

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
        jLabel1.setText("Pengolahan Data Pelanggan");

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
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Pelanggan"));

        jLabel3.setText("ID Pelanggan");

        jLabel4.setText("Nama Pelanggan");

        txtNamaPelanggan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaPelangganKeyPressed(evt);
            }
        });

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

        jLabel11.setText("Nomor Telpon");

        txtNoTelp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoTelpKeyPressed(evt);
            }
        });

        jLabel12.setText("Jumlah");

        txtJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtJumlahKeyPressed(evt);
            }
        });

        jLabel16.setText("Nama Barang");

        txtNamaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaBarangKeyPressed(evt);
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
                            .addComponent(jLabel4)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNamaPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addComponent(txtKodePelanggan)
                            .addComponent(txtJumlah)
                            .addComponent(txtNoTelp)
                            .addComponent(txtNamaBarang)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnTambah)
                        .addGap(32, 32, 32)
                        .addComponent(btnEdit)
                        .addGap(36, 36, 36)
                        .addComponent(btnReset))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(btnHapus)
                        .addGap(27, 27, 27)
                        .addComponent(btnBatal)))
                .addGap(83, 83, 83))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(txtKodePelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnEdit)
                    .addComponent(btnReset))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal))
                .addGap(167, 167, 167))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pelanggan"));

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

        tabelPelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tabelPelanggan.setShowGrid(true);
        tabelPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPelangganMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelPelanggan);

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

    private void txtNamaPelangganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaPelangganKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        txtNamaPelanggan.requestFocus();
} 
    }//GEN-LAST:event_txtNamaPelangganKeyPressed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if (txtKodePelanggan.getText().equals("")) {
    JOptionPane.showMessageDialog(null, "Kode pelanggan tidak boleh kosong");
} else if (txtNamaPelanggan.getText().equals("")) {
    JOptionPane.showMessageDialog(null, "Nama pelanggan tidak boleh kosong");
} else if (txtNoTelp.getText().equals("")) {
    JOptionPane.showMessageDialog(null, "No telpon tidak boleh kosong");
} else if (txtJumlah.getText().equals("")) {
    JOptionPane.showMessageDialog(null, "Jumlah tidak boleh kosong");
}  else {
    String sql = "insert into pelanggan values (?,?,?,?,?,?)";
    String tampilan = "dd-MM-yyyy";
    SimpleDateFormat fm = new SimpleDateFormat(tampilan);
    try {
        java.sql.PreparedStatement stat = koneksi.prepareStatement(sql);
        stat.setString(1, txtKodePelanggan.getText());
        stat.setString(2, txtNamaPelanggan.getText());
        stat.setString(3,txtNoTelp .getText());
        stat.setString(4, txtNamaBarang.getText());
        stat.setString(5, txtJumlah.getText());
        stat.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        kosong();
        dataTable();
        lebarKolom();
        txtKodePelanggan.requestFocus();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Data Gagal Disimpan" + e);
    }
}

    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        UbahPelanggan.setLocationRelativeTo(this);
        txtKodePelangganUbah.setEditable(false);
        UbahPelanggan.setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        dispose();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void tabelPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPelangganMouseClicked
        int bar = tabelPelanggan.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        Date dateValue = null;
        try {
            dateValue = date.parse((String) tabelPelanggan.getValueAt(bar, 1));
        } catch (ParseException ex) {
            Logger.getLogger(data_pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtKodePelanggan.setText(b);
        txtKodePelangganUbah.setText(b);
        txtNamaPelanggan.setText(c);
        txtNamaPelangganUbah.setText(c);
        txtNoTelp.setText(d);
        txtNoTelpUbah.setText(d);
        txtNamaBarang.setText(e);
        txtNamaBarangUbah.setText(e);
        txtJumlah.setText(f);
        txtJumlahUbah.setText(f);
       
    }//GEN-LAST:event_tabelPelangganMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

        kosong();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
         int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Menghapus Data", "Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
    if (ok == 0) {
        try {
            String sql = "DELETE FROM pelanggan WHERE id_pelanggan=?";
            java.sql.PreparedStatement stat = koneksi.prepareStatement(sql);
            stat.setString(1, txtKodePelanggan.getText());
            int rowsAffected = stat.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                kosong();
                dataTable();
                lebarKolom();
                txtKodePelanggan.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
        String sqlPencarian = "select * from pelanggan where id_pelanggan like '%" + txtCari.getText() + "%' or "
        + "nama_pelanggan like '%" + txtCari.getText() + "%' or "
        + "no_telp like '%" + txtCari.getText() + "%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_txtCariKeyTyped

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
         String sqlPencarian = "select * from pelanggan where id_pelanggan like '%" + txtCari.getText() + "%' or "
        + "nama_pelanggan like '%" + txtCari.getText() + "%' or "
        + "no_telp like '%" + txtCari.getText() + "%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_btnCariActionPerformed

    private void txtNoTelpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoTelpKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoTelpKeyPressed

    private void txtJumlahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahKeyPressed

    private void txtCariKategoriKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKategoriKeyTyped
       
    }//GEN-LAST:event_txtCariKategoriKeyTyped

    private void tabelKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKategoriMouseClicked
;
    }//GEN-LAST:event_tabelKategoriMouseClicked

    private void btnBatalUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalUbahActionPerformed
        UbahPelanggan.setVisible(false);
    }//GEN-LAST:event_btnBatalUbahActionPerformed

    private void btnSimpanUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanUbahActionPerformed
        String sql = "update pelanggan set id_pelanggan=?,nama_pelanggan=? where kode_pelanggan='" + txtKodePelangganUbah.getText() + "'";
        String tampilan = "dd-MM-yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(btnTanggalUbah.getDate()));
        try {
        java.sql.PreparedStatement stat = koneksi.prepareStatement(sql);
        stat.setString(1, txtKodePelanggan.getText());
        stat.setString(2, txtNamaPelanggan.getText());
        stat.setString(3, txtNoTelp.getText());
        stat.setString(4, txtNamaBarang.getText());
        stat.setString(5, txtJumlah.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            kosong();
            dataTable();
            lebarKolom();
            txtKodePelanggan.requestFocus();
            UbahPelanggan.dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah" + e);
        }
    }//GEN-LAST:event_btnSimpanUbahActionPerformed

    private void txtNamaPelangganUbahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaPelangganUbahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPelangganUbahKeyPressed

    private void txtNamaBarangUbahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaBarangUbahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaBarangUbahKeyPressed

    private void txtJumlahUbahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahUbahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahUbahKeyPressed

    private void txtNamaBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaBarangKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaBarangKeyPressed

    private void txtNoTelpUbahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoTelpUbahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoTelpUbahKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog UbahPelanggan;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnBatalUbah;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpanUbah;
    private javax.swing.JButton btnTambah;
    private com.toedter.calendar.JDateChooser btnTanggalUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JDialog listKategori;
    private javax.swing.JTable tabelKategori;
    private javax.swing.JTable tabelPelanggan;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtCariKategori;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtJumlahUbah;
    private javax.swing.JTextField txtKodePelanggan;
    private javax.swing.JTextField txtKodePelangganUbah;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtNamaBarangUbah;
    private javax.swing.JTextField txtNamaPelanggan;
    private javax.swing.JTextField txtNamaPelangganUbah;
    private javax.swing.JTextField txtNoTelp;
    private javax.swing.JTextField txtNoTelpUbah;
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
        
    

        
    

