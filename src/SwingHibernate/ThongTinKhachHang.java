/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingHibernate;

import dao.KhachhangDao;
import entities.Khachhang;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BatTu
 */
public class ThongTinKhachHang extends javax.swing.JInternalFrame {

    /**
     * Creates new form ThongTinKhachHang
     */
    DefaultTableModel dft;
    int index = 0;
    KhachhangDao kdao = new KhachhangDao();
    List<Khachhang> list2;
    public ThongTinKhachHang() {
        initComponents();
    }

    public void find() {
        dft = (DefaultTableModel) tbl_list.getModel();
        dft.setRowCount(0);
        list2 = kdao.timkiem(txttimkiem.getText(), "", "");
        if (list2 == null && list2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "KHÔNG CÓ KHÁCH HÀNG ĐƯỢC TÌM THẤY");
        } else {
            for (Khachhang kh : list2) {
                dft.addRow(new Object[]{kh.getCmnd(), kh.getHoten(), kh.getGtinh() ? "Nam" : "Nữ", kh.getSdt()});
            }
        }
    }

    public boolean kiemtra1() {
        String cmnd = txtcmnd.getText().trim();
        if (cmnd.length() == 0) {
            JOptionPane.showMessageDialog(this, "KHÔNG ĐỂ TRỐNG CMND");
            return false;
        }
        if (cmnd.length() > 12 || cmnd.length() < 9) {
            JOptionPane.showMessageDialog(this, "Độ dài CMND phải từ 9 - 12 Số");
            return false;
        }
        try {
            int CMND = Integer.parseInt(cmnd);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "CMND phải là Số");
            return false;
        }
        String hoten = txthoten.getText().trim();
        if (hoten.length() == 0) {
            JOptionPane.showMessageDialog(this, "KHÔNG ĐỂ TRỐNG HỌ TÊN");
            return false;
        }
        String sdt = txtsodt.getText().trim();
        if (sdt.length() == 0) {
            JOptionPane.showMessageDialog(this, "KHÔNG ĐỂ TRỐNG SỐ ĐIỆN THOẠI");
            return false;
        }
        try {
            int SDT = Integer.parseInt(sdt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số Điện Thoại phải là Số");
            return false;
        }
        if (sdt.length() != 10) {
            JOptionPane.showMessageDialog(this, "Số Điện Thoại phải có 10 số");
            return false;
        }
        return true;
    }

    public boolean kiemtratrung() {
        String cmnd = txtcmnd.getText().trim();
        Khachhang kh = kdao.find(cmnd);
        if (kh != null) {
            return true;
        } else {
            return false;
        }
    }
    public void showdetail(){
        index = tbl_list.getSelectedRow();
        txtcmnd.setText((String) tbl_list.getValueAt(index, 0));
        txthoten.setText((String) tbl_list.getValueAt(index, 1));
        txtsodt.setText((String) tbl_list.getValueAt(index, 3));
        String gt = (String) tbl_list.getValueAt(index, 2);
        if(gt.equalsIgnoreCase("Nam")){
            rdb_nam.setSelected(true);
            rdb_nu.setSelected(false);
        }else{
            rdb_nam.setSelected(false);
            rdb_nu.setSelected(true);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txttimkiem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_list = new javax.swing.JTable();
        txtcmnd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txthoten = new javax.swing.JTextField();
        txtsodt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rdb_nam = new javax.swing.JRadioButton();
        rdb_nu = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(950, 622));
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 0, 51))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incons/Search.png"))); // NOI18N
        jButton1.setText("Tìm Kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CMND");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txttimkiem)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(120, 50, 669, 81);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("THÔNG TIN KHÁCH HÀNG");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(290, 10, 350, 35);

        tbl_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CMND", "Họ Tên", "Giới Tính", "Số ĐT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_listMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_list);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(120, 130, 669, 194);
        getContentPane().add(txtcmnd);
        txtcmnd.setBounds(210, 350, 210, 30);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CMND :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 350, 53, 30);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Họ Tên :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(140, 380, 53, 30);
        getContentPane().add(txthoten);
        txthoten.setBounds(210, 380, 210, 30);
        getContentPane().add(txtsodt);
        txtsodt.setBounds(570, 350, 224, 30);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Số ĐT :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(490, 350, 70, 30);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Giới Tính"));
        jPanel2.setForeground(new java.awt.Color(255, 0, 51));

        buttonGroup1.add(rdb_nam);
        rdb_nam.setSelected(true);
        rdb_nam.setText("Nam");

        buttonGroup1.add(rdb_nu);
        rdb_nu.setText("Nữ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(rdb_nam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(rdb_nu)
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(rdb_nu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdb_nam))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(500, 380, 288, 60);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incons/Add.png"))); // NOI18N
        jButton2.setText("Thêm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(140, 460, 118, 34);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incons/Exit button.png"))); // NOI18N
        jButton3.setText("Thoát");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(670, 460, 118, 34);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incons/Edit.png"))); // NOI18N
        jButton4.setText("Sửa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(340, 460, 118, 34);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incons/Delete.png"))); // NOI18N
        jButton5.setText("Xóa");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(490, 460, 118, 34);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        find();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (kiemtra1()) {
            if (kiemtratrung()) {
                JOptionPane.showMessageDialog(this, "SỐ CMND NÀY ĐÃ ĐƯỢC ĐĂNG KÝ");
            } else {
                Khachhang kh = new Khachhang(txtcmnd.getText().trim(), txthoten.getText().trim(), rdb_nam.isSelected(), txtsodt.getText(), null);
                if (kdao.save(kh)) {
                    JOptionPane.showMessageDialog(this, "ĐÃ THÊM KHÁCH HÀNG THÀNH CÔNG");
                    find();
                } else {
                    JOptionPane.showMessageDialog(this, "XẢY RA LỖI KHÔNG THỂ THÊM");
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (kiemtra1()) {
            if (kiemtratrung()) {
                Khachhang kh = new Khachhang(txtcmnd.getText().trim(), txthoten.getText().trim(), rdb_nam.isSelected(), txtsodt.getText(), null);
                if (kdao.update(kh)) {
                    JOptionPane.showMessageDialog(this, "ĐÃ CẬP NHẬT KHÁCH HÀNG THÀNH CÔNG");
                    find();
                } else {
                    JOptionPane.showMessageDialog(this, "XẢY RA LỖI KHÔNG THỂ CẬP NHẬT");
                }
            } else {
                JOptionPane.showMessageDialog(this, "KHÔNG CÓ KHÁCH HÀNG NÀY ĐỂ CẬP NHẬT");
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbl_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_listMouseClicked
        // TODO add your handling code here:
        showdetail();
    }//GEN-LAST:event_tbl_listMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
          if (kiemtra1()) {
            if (kiemtratrung()) {
                Khachhang kh = new Khachhang(txtcmnd.getText().trim(), txthoten.getText().trim(), rdb_nam.isSelected(), txtsodt.getText(), null);
                if (kdao.delete(kh)) {
                    JOptionPane.showMessageDialog(this, "ĐÃ XÓA KHÁCH HÀNG THÀNH CÔNG");
                    find();
                } else {
                    JOptionPane.showMessageDialog(this, "XẢY RA LỖI KHÔNG THỂ XÓA");
                }
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdb_nam;
    private javax.swing.JRadioButton rdb_nu;
    private javax.swing.JTable tbl_list;
    private javax.swing.JTextField txtcmnd;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtsodt;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
