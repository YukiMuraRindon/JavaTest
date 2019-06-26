/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elms.bin;
import elms.po.Purchase;
import elms.po.Supplier;
import elms.service.purchaseserviceimpl;
import elms.service.supplierserviceimpl;
import elms.util.ExportExcel;
import elms.util.FrameUtil2;
import java.beans.PropertyVetoException;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author YukiMuraRindon
 */
public class gysjyglinternalframe extends javax.swing.JInternalFrame {
    purchaseserviceimpl p = new purchaseserviceimpl();
    /**
     * Creates new form gysjyglinternalframe
     */
    public gysjyglinternalframe() {
        initComponents();
        List<Purchase> list = p.findAll("a");
        refresh(list);
    }

     public void refresh(List<Purchase> list){
       DefaultTableModel model = (DefaultTableModel) this.tab.getModel();
        while(model.getRowCount()>0){
         model.removeRow(0);
     }
        //便利集合
        for (Purchase p : list) {
            //将数据放到一个集合里 然后在放到表格中
            Vector v = new Vector();
            v.add(p.getSupid());
            v.add(p.getSupfullname());
            v.add(p.getProtype());
            v.add(p.getPurnumber());
            v.add(p.getTotalmoney());
            //放到表格里
            model.addRow(v);
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
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        datestart = new elms.util.DateChooserJButton();
        dateend = new elms.util.DateChooserJButton();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("供应商交易管理");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("编号");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("简称");

        jButton1.setText("查询");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        jLabel3.setText("按供应商");

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "供应商编号", "供应商简称", "商品名称", "交易数量", "交易金额"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tab);

        jButton2.setText("打印报表");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("关闭");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(datestart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearch)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(27, 27, 27)
                .addComponent(jButton3)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jLabel3)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datestart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        FrameUtil2.framemap.remove(gysjyglinternalframe.class.getName());
    }//GEN-LAST:event_formInternalFrameClosing

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            this.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(gysjyglinternalframe.class.getName()).log(Level.SEVERE, null, ex);
        }
        FrameUtil2.framemap.remove(gysjyglinternalframe.class.getName());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String start = this.datestart.getText();
        String end = this.dateend.getText();
        String key = this.txtSearch.getText();
        String str = "";
        if(jRadioButton1.isSelected()){
            str = "pur.supid";
        }
        else{
            str = "sup.supfullname";
        }
        List<Purchase> list = p.getBySup(start,end,key,str);
        refresh(list);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String start = this.datestart.getText();
        String end = this.dateend.getText();
        String key = this.txtSearch.getText();
        String str = "";
        if(jRadioButton1.isSelected()){
            str = "pur.supid";
        }
        else{
            str = "sup.supfullname";
        }
        List<Purchase> list = p.getBySup(start,end,key,str);
        refresh(list);
        JFileChooser savefile = new JFileChooser();
        FileNameExtensionFilter  f = new FileNameExtensionFilter("Excel文件(*.xls)","*.xls");
        savefile.addChoosableFileFilter(f);
        savefile.setFileFilter(f);
        int flag = savefile.showSaveDialog(this);
        File file = null;
        if(flag == JFileChooser.APPROVE_OPTION){
            file = savefile.getSelectedFile();
            System.out.println("文件名:"+file.getAbsolutePath());
            String filename = file.getAbsolutePath();
            String filetype = filename.substring(filename.length()-4);
            if(!filetype.equals(".xls")){
                file = new File(filename+".xls");
            }
            List<Map<String,String>> ls = new ArrayList<Map<String,String>>();
            //String[] str ={"采购编号","商品名称","供应商","采购价格"
            Map<String,String> map = new LinkedHashMap<String,String>();
            map.put("供应商编号", null);
            map.put("供应商简称",null);
            map.put("商品名称",null);
            map.put("交易数量",null);
            map.put("交易金额",null);
            ls.add(map);
            
            Map<String,String> mm;
            for(Purchase p1:list){
                mm = new LinkedHashMap<String,String>();
                mm.put("供应商编号",String.valueOf(p1.getSupid()));
                mm.put("供应商简称",p1.getSupfullname());
                mm.put("商品名称",p1.getProtype());
                mm.put("交易数量",String.valueOf(p1.getPurnumber()));
                mm.put("交易金额",String.valueOf(p1.getTotalmoney()));
                ls.add(mm);
            }
            ExportExcel.printSale(ls, file);
            JOptionPane.showMessageDialog(this, "打印成功");
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private elms.util.DateChooserJButton dateend;
    private elms.util.DateChooserJButton datestart;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tab;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
