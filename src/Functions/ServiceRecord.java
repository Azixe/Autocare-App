/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Functions;

import Main.Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author bebas
 */
public class ServiceRecord extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    private String Kendaraanid;
    private String tmp;
    
    private static final Map<String, Integer> SERVICE_PRICES = new HashMap<>();

    static {
        // Harga untuk Major Service
        SERVICE_PRICES.put("Ganti semua Oli dan Filter", 750000);
        SERVICE_PRICES.put("Ganti semua TimingBelt", 1250000);
        SERVICE_PRICES.put("Cek Sistem Mesin", 1000000);
        SERVICE_PRICES.put("Transmisi Kaki", 1500000);
        SERVICE_PRICES.put("AC", 1100000);
        SERVICE_PRICES.put("Exhaust", 1750000);
        
        // Harga untuk Minor Service
        SERVICE_PRICES.put("Ganti Oli dan Filter", 400000);
        SERVICE_PRICES.put("Cek Cairan", 200000);
        SERVICE_PRICES.put("Cek Ban", 200000);
        SERVICE_PRICES.put("Kelistrikan", 450000);
        SERVICE_PRICES.put("Aki", 300000);
        SERVICE_PRICES.put("Wiper", 300000);
    }
    /**
     * Creates new form ServiceRecordService
     */
    public ServiceRecord() {
        initComponents();
        conn = DatabaseConnection.getConnection();
        Fillcombo();
        Fillcombo1();
        Fillcombo2();
        Updatetable();
        setLocationRelativeTo(null);
    }
    
    private void Fillcombo(){
        try{
            String sql = "select * from jenisservice";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String jenisServis = rs.getString("minorService");
                MinorServis.addItem(jenisServis);
            }
        }catch(Exception e){
            
        }
    }
    
    private void Fillcombo1(){
        try{
            String sql = "select * from jenisservice";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String jenisServis = rs.getString("majorService");
                MajorServis.addItem(jenisServis);
            }
        }catch(Exception e){
            
        }
    }
    
    private void Fillcombo2(){
        try{
            String sql = "select * from vehicle";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String jenisServis = rs.getString("id");
                VehicleChooser.addItem(jenisServis);
            }
        }catch(Exception e){
            
        }
    }
    
     // Method untuk mendapatkan harga berdasarkan jenis servis
    private int getServicePrice(String serviceType) {
        Integer price = SERVICE_PRICES.get(serviceType);
        if (price != null) {
            return price;
        } else {
            throw new IllegalArgumentException("Unknown service type: " + serviceType);
        }
    }
    
    private void Updatetable(){
        
        try{
            String sql = "select * from service"; 
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            DataVehicleService.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        DataVehicleService = new javax.swing.JTable();
        BackButton = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        MinorServis = new javax.swing.JComboBox<>();
        DeleteButton = new javax.swing.JToggleButton();
        SimpanButton = new javax.swing.JToggleButton();
        CatatanTambahan = new javax.swing.JTextField();
        Servis = new javax.swing.JTextField();
        VehicleChooser = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        MajorServis = new javax.swing.JComboBox<>();
        NomorPolisi = new javax.swing.JTextField();
        MerekKendaraan = new javax.swing.JTextField();
        TanggalServis = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Autocare 1.0 | Service Record");
        setLocation(new java.awt.Point(400, 200));

        DataVehicleService.setModel(new javax.swing.table.DefaultTableModel(
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
        DataVehicleService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataVehicleServiceMouseClicked(evt);
            }
        });
        DataVehicleService.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DataVehicleServicePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(DataVehicleService);

        BackButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setText("Tanggal Servis");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setText("Catatan Tambahan");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setText("Jenis Servis");

        MinorServis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minor Service" }));
        MinorServis.setName(""); // NOI18N
        MinorServis.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                MinorServisPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        MinorServis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinorServisActionPerformed(evt);
            }
        });

        DeleteButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        DeleteButton.setForeground(new java.awt.Color(204, 0, 51));
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        SimpanButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        SimpanButton.setForeground(new java.awt.Color(102, 153, 255));
        SimpanButton.setText("Simpan");
        SimpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanButtonActionPerformed(evt);
            }
        });

        CatatanTambahan.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        CatatanTambahan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatatanTambahanActionPerformed(evt);
            }
        });

        VehicleChooser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kendaraan" }));
        VehicleChooser.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                VehicleChooserPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        VehicleChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VehicleChooserActionPerformed(evt);
            }
        });

        jLabel5.setText("Pilih Kendaraan");

        MajorServis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Major Service" }));
        MajorServis.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                MajorServisPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(MinorServis, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(MajorServis, 0, 123, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(DeleteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SimpanButton)
                                .addGap(43, 43, 43))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(VehicleChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NomorPolisi, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(MerekKendaraan)))
                            .addComponent(TanggalServis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Servis, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CatatanTambahan))))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VehicleChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(MerekKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NomorPolisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MinorServis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MajorServis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(12, 12, 12)
                        .addComponent(Servis, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CatatanTambahan, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SimpanButton)
                            .addComponent(DeleteButton)))
                    .addComponent(TanggalServis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(195, 44));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Service Record");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(309, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap())
        );

        id.setText("ID Service");
        id.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(id)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackButton)
                    .addComponent(id))
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SimpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanButtonActionPerformed
        Date tanggalservis = (Date) TanggalServis.getDate();
        SimpleDateFormat Date = new SimpleDateFormat();
        String tanggal = Date.format(tanggalservis);
        String tmp = (String)VehicleChooser.getSelectedItem();
        String catatantambaan = CatatanTambahan.getText();
        String servis = Servis.getText();
        int harga = getServicePrice(servis); // Mengambil harga servis berdasarkan jenis servis

        try {
            String sql="insert into service (vehicle_id, tanggalServis, catatanTambahan, jenisServis, harga) values('"
                    +Kendaraanid+"','"
                    +tanggal+"','"
                    +CatatanTambahan.getText()+"','"
                    +Servis.getText()+"','"
                    +harga+"')";
            pst=conn.prepareStatement(sql);
            pst = conn.prepareStatement(sql);
            pst.execute();
            Servis.setText("");
            CatatanTambahan.setText("");
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            this.dispose();
            ServiceRecord s = new ServiceRecord();
            s.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data");
            e.printStackTrace();
        }
    }//GEN-LAST:event_SimpanButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        dispose();
        Menu s = new Menu();
        s.setVisible(true);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        String sql = "delete from service where id = ?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, id.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Vehicle Deleted");
            dispose();
            ServiceRecord s = new ServiceRecord();
            s.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void MinorServisPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_MinorServisPopupMenuWillBecomeInvisible
        String tmp = (String)MinorServis.getSelectedItem();
        String sql = "select * from jenisservice where minorService = ?";
        try{
            conn=(java.sql.Connection)Functions.DatabaseConnection.getConnection();
            pst=conn.prepareStatement(sql);
            pst.setString(1,tmp);
            rs = pst.executeQuery();
            if(rs.next()){
                String add1 = rs.getString("minorService");
                Servis.setText(add1);
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Data not found");
        }
    }//GEN-LAST:event_MinorServisPopupMenuWillBecomeInvisible

    private void VehicleChooserPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_VehicleChooserPopupMenuWillBecomeInvisible
        String tmp = (String)VehicleChooser.getSelectedItem();
        String sql = "select * from vehicle where id = ?";
        Kendaraanid = tmp;
        try{
            conn=(java.sql.Connection)Functions.DatabaseConnection.getConnection();
            pst=conn.prepareStatement(sql);
            pst.setString(1,tmp);
            rs = pst.executeQuery();
            if(rs.next()){
                String add1 = rs.getString("model");
                MerekKendaraan.setText(add1);
                String add2 = rs.getString("nomorPolisi");
                NomorPolisi.setText(add2);
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Data not found");
        }
    }//GEN-LAST:event_VehicleChooserPopupMenuWillBecomeInvisible

    private void MajorServisPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_MajorServisPopupMenuWillBecomeInvisible
        String tmp = (String)MajorServis.getSelectedItem();
        String sql = "select * from jenisservice where majorService = ?";
        try{
            conn=(java.sql.Connection)Functions.DatabaseConnection.getConnection();
            pst=conn.prepareStatement(sql);
            pst.setString(1,tmp);
            rs = pst.executeQuery();
            if(rs.next()){
                String add2 = rs.getString("majorService");
                Servis.setText(add2);
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Data not found");
        }
    }//GEN-LAST:event_MajorServisPopupMenuWillBecomeInvisible

    private void VehicleChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VehicleChooserActionPerformed
        
    }//GEN-LAST:event_VehicleChooserActionPerformed

    private void MinorServisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinorServisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MinorServisActionPerformed

    private void CatatanTambahanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatatanTambahanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CatatanTambahanActionPerformed

    private void DataVehicleServicePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DataVehicleServicePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_DataVehicleServicePropertyChange

    private void DataVehicleServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataVehicleServiceMouseClicked
        try{
            int row = DataVehicleService.getSelectedRow();
            String Table_click = (DataVehicleService.getModel().getValueAt(row, 0).toString());
            String sql = "select * from service where id =" + Table_click + "";
            conn=(java.sql.Connection)Functions.DatabaseConnection.getConnection();
            pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                String add1 = rs.getString("id");
                id.setText(add1);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_DataVehicleServiceMouseClicked

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
            java.util.logging.Logger.getLogger(ServiceRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServiceRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServiceRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServiceRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServiceRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BackButton;
    private javax.swing.JTextField CatatanTambahan;
    private javax.swing.JTable DataVehicleService;
    private javax.swing.JToggleButton DeleteButton;
    private javax.swing.JComboBox<String> MajorServis;
    private javax.swing.JTextField MerekKendaraan;
    private javax.swing.JComboBox<String> MinorServis;
    private javax.swing.JTextField NomorPolisi;
    private javax.swing.JTextField Servis;
    private javax.swing.JToggleButton SimpanButton;
    private com.toedter.calendar.JDateChooser TanggalServis;
    private javax.swing.JComboBox<String> VehicleChooser;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
