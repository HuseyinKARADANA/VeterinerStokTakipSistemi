
package Arayuz;

import Database.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class StokBilgi extends javax.swing.JFrame implements minLogo{

  
    public StokBilgi() {
        initComponents();
        stokDoldur();
        azStokDoldur();
    }
    ResultSet rs;
    Connection conn = null;
    PreparedStatement pst = null;
    Statement statement=null;
    DefaultTableModel model;

    public void stokDoldur(){
        tableBosalt(tb_stok);
        model = (DefaultTableModel) tb_stok.getModel();
        try {
            
            try {
                
                conn = db.java_db();
                rs = conn.prepareStatement("SELECT *FROM Stok").executeQuery();

                while (rs.next()) {

                    int id=Integer.parseInt(rs.getString(1));
                    String ilacAdi = rs.getString(2);
                    String ilacAciklama = rs.getString(3);
                    String ilacAdet = rs.getString(4);
                    String ilacFiyat = rs.getString(5);
                    ilacFiyat+=" TL";
                    Object[] eklenecek = {id,ilacAdi,ilacAciklama,ilacAdet,ilacFiyat};
                    model.addRow(eklenecek);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }

        } catch (Exception e) {
        }

        
    }
    public void azStokDoldur(){
        tableBosalt(tb_azStok);
        model = (DefaultTableModel) tb_azStok.getModel();
        try {
            
            try {
               
                conn = db.java_db();
                rs = conn.prepareStatement("SELECT *FROM Stok WHERE adet<11").executeQuery();

                 while (rs.next()) {

                    int id=Integer.parseInt(rs.getString(1));
                    String ilacAdi = rs.getString(2);
                    String ilacAciklama = rs.getString(3);
                    String ilacAdet = rs.getString(4);
                    String ilacFiyat = rs.getString(5);
                    ilacFiyat+=" TL";
                    Object[] eklenecek = {id,ilacAdi,ilacAciklama,ilacAdet,ilacFiyat};
                    model.addRow(eklenecek);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }

        } catch (Exception e) {
        }

    
    }
    
    public void temizle(){
        txt_fiyat.setText("");
        txt_hakkında.setText("");
        txt_ilacAdet.setText("");
        txt_ilacAdi.setText("");
    }
     public void tableBosalt(javax.swing.JTable tb) {
        DefaultTableModel dm = (DefaultTableModel) tb.getModel();
        int rowCount = dm.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
    }
     
     public void tiklananTablo(javax.swing.JTable tb){
         int SeciliSatır = tb.getSelectedRow();
        DefaultTableModel dm = (DefaultTableModel) tb.getModel();
        int id = (int) dm.getValueAt(SeciliSatır, 0);
       txt_ilacAdi.setText(String.valueOf(dm.getValueAt(SeciliSatır, 1)));
        txt_hakkında.setText(String.valueOf(dm.getValueAt(SeciliSatır, 2)));
        txt_ilacAdet.setText(String.valueOf(dm.getValueAt(SeciliSatır, 3)));
       
          txt_fiyat.setText(String.valueOf(dm.getValueAt(SeciliSatır, 4)));
     }
     
     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_azStok = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_stok = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_ilacAdi = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_hakkında = new javax.swing.JTextArea();
        txt_ilacAdet = new javax.swing.JTextField();
        txt_fiyat = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stok Bilgileri");

        jPanel1.setBackground(new java.awt.Color(204, 51, 255));

        tb_azStok.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "İd", "İlaç Adı", "İlaç Açıklama", "Adet", "Fiyat"
            }
        ));
        tb_azStok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_azStokMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_azStok);
        if (tb_azStok.getColumnModel().getColumnCount() > 0) {
            tb_azStok.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        tb_stok.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "İd", "İlaç Adı", "İlaç Açıklama", "Adet", "Fiyat"
            }
        ));
        tb_stok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_stokMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_stok);
        if (tb_stok.getColumnModel().getColumnCount() > 0) {
            tb_stok.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Az Kalan İlaçlar");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Stoktaki İlaçlar");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Çıkış");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("İlaç Ekle");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Stoktan Sil");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("Stok Arttır");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("İlaç Adı:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("İlaç Adet:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("İlaç Hakkında:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("İlaç Fiyat:");

        txt_ilacAdi.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        txt_hakkında.setColumns(20);
        txt_hakkında.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_hakkında.setRows(5);
        jScrollPane3.setViewportView(txt_hakkında);

        txt_ilacAdet.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        txt_fiyat.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setText("Stoktan Düş");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_ilacAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_fiyat)
                                            .addComponent(txt_ilacAdet))))
                                .addGap(259, 259, 259)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(509, 509, 509)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton6)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton5)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ilacAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ilacAdet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fiyat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            
            String ilacAdi=txt_ilacAdi.getText();
            String aciklama=txt_hakkında.getText();
           String fiyat=txt_fiyat.getText();
           String ilacAdet=txt_ilacAdet.getText();
            
            if (ilacAdi.equals("") || ilacAdet.equals("") || fiyat.equals("")) {
                System.out.println("Lütfen ilaç adı,adet ve fiyatı giriniz...");
            } else {
                conn = db.java_db();

                String sql = "INSERT INTO stok (ilacadi,aciklama,adet,fiyat) VALUES (?,?,?,?)";
                pst=conn.prepareStatement(sql);
                pst.setString(1,ilacAdi);
                pst.setString(2, aciklama);
                pst.setString(3, ilacAdet);
                pst.setString(4, fiyat);
                

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"İlaç Ekleme Başarılı");
                temizle();
               stokDoldur();
               azStokDoldur();
            }
        } catch (Exception e) {
            System.out.println("Beklenmeyen Bir Hata Oluştu...");
        }finally {
            try {

                conn.close();
            } catch (SQLException ex) {

            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         int SeciliSatır = tb_stok.getSelectedRow();

        DefaultTableModel dm = (DefaultTableModel) tb_stok.getModel();
        if (SeciliSatır == -1) {
            if (tb_stok.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "İlaçlar Tablosu Boş");
            } else {
                JOptionPane.showMessageDialog(null, "Silinecek İlacı Seçiniz");
            }
        } else {

            try {

                conn = db.java_db();
                int silinecek = (int) dm.getValueAt(SeciliSatır, 0);
                String sql = "DELETE FROM Stok WHERE id ="+silinecek;
                pst=conn.prepareStatement(sql);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "İlaç Başarıyla Silinmiştir");
                stokDoldur();
                azStokDoldur();
                temizle();
            } catch (Exception e) {
                System.out.println("Beklenmeyen Bir Hata Oluştu...");
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tb_stokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_stokMouseClicked
        tiklananTablo(tb_stok);
    }//GEN-LAST:event_tb_stokMouseClicked

    private void tb_azStokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_azStokMouseClicked
        tiklananTablo(tb_azStok);
    }//GEN-LAST:event_tb_azStokMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            int stok_arttir=Integer.parseInt(JOptionPane.showInputDialog("Eklemek İstediğiniz Stok Adedini Giriniz:"));
            int SeciliSatır = tb_stok.getSelectedRow();
            DefaultTableModel dm = (DefaultTableModel) tb_stok.getModel();
            int eklenecekId = (int) dm.getValueAt(SeciliSatır, 0);
            
            try {
                conn=db.java_db();
               int adet=Integer.parseInt(dm.getValueAt(SeciliSatır, 3).toString());
               String guncelStok=String.valueOf(adet+stok_arttir);
                String sql = "UPDATE Stok SET adet=?  WHERE id=?";

            pst= conn.prepareStatement(sql);
            pst.setString(1, guncelStok);
            pst.setInt(2, eklenecekId);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, stok_arttir+" Kadar ilaç stoğa başarıyla eklendi");
            stokDoldur();
            azStokDoldur();
            temizle();
            } catch (Exception e) {
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lütfen sayısal olarak giriniz...");
        }
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       try {
            int stok_azalt=Integer.parseInt(JOptionPane.showInputDialog("Çıkarmak İstediğiniz Stok Adedini Giriniz:"));
            int SeciliSatır = tb_stok.getSelectedRow();
            DefaultTableModel dm = (DefaultTableModel) tb_stok.getModel();
            int cikarilacakId = (int) dm.getValueAt(SeciliSatır, 0);
            
            try {
                conn=db.java_db();
               int adet=Integer.parseInt(dm.getValueAt(SeciliSatır, 3).toString());
               String guncelStok=String.valueOf(adet-stok_azalt);
                String sql = "UPDATE Stok SET adet=?  WHERE id=?";

            pst= conn.prepareStatement(sql);
            pst.setString(1, guncelStok);
            pst.setInt(2, cikarilacakId);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, stok_azalt+" Kadar ilaç stokdan çıktı");
            stokDoldur();
            azStokDoldur();
            temizle();
            } catch (Exception e) {
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lütfen sayısal olarak giriniz...");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StokBilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StokBilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StokBilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StokBilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StokBilgi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tb_azStok;
    private javax.swing.JTable tb_stok;
    private javax.swing.JTextField txt_fiyat;
    private javax.swing.JTextArea txt_hakkında;
    private javax.swing.JTextField txt_ilacAdet;
    private javax.swing.JTextField txt_ilacAdi;
    // End of variables declaration//GEN-END:variables
}
