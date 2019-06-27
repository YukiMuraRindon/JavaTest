/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elms.bin;

import elms.po.Purchase;
import elms.service.purchaseserviceimpl;
import elms.util.ExportExcel;
import elms.util.FrameUtil2;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YukiMuraRindon
 */
public class cgtjinternalframe extends javax.swing.JInternalFrame {
    purchaseserviceimpl p = new purchaseserviceimpl();
    /**
     * Creates new form cgtjinternalframe
     */
    public cgtjinternalframe() {
        initComponents();
    }
    public void refresh(List<Purchase> list,String key){
        if(key.equals("pro")){
             DefaultTableModel model = (DefaultTableModel) this.tab.getModel();
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            for (Purchase p : list) {
                Vector v = new Vector();
                v.add(p.getProid());
                v.add(p.getProname());
                v.add(p.getProtype());
                v.add(p.getCountnum());
                v.add(p.getCountmoney());
                model.addRow(v);
            }
        }
        else if(key.equals("sup")){
             DefaultTableModel model = (DefaultTableModel) this.tab.getModel();
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            for (Purchase p : list) {
                Vector v = new Vector();
                v.add(p.getSupid());
                v.add(p.getSupfullname());
                v.add(p.getCountmoney());
                model.addRow(v);
            }
        }
        else if(key.equals("gyssp")){
            DefaultTableModel model = (DefaultTableModel) this.tab.getModel();
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            for (Purchase p : list) {
                Vector v = new Vector();
                v.add(p.getSupid());
                v.add(p.getSupfullname());
                v.add(p.getProid());
                v.add(p.getProname());
                v.add(p.getProtype());
                v.add(p.getCountnum());
                v.add(p.getUnit());
                v.add(p.getCountmoney());
                model.addRow(v);
            }
        }
        else{
            DefaultTableModel model = (DefaultTableModel) this.tab.getModel();
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            for (Purchase p : list) {
                Vector v = new Vector();
                v.add(p.getProid());
                v.add(p.getProname());
                v.add(p.getProtype());
                v.add(p.getSupid());
                v.add(p.getSupfullname());
                v.add(p.getCountnum());
                v.add(p.getUnit());
                v.add(p.getCountmoney());
                model.addRow(v);
            }
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

        jLabel1 = new javax.swing.JLabel();
        box = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        datestart = new elms.util.DateChooserJButton();
        dateend = new elms.util.DateChooserJButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("采购统计");
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

        jLabel1.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        jLabel1.setText("按");

        box.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "商品", "供应商", "供应商（商品）", "商品（供应商）" }));

        jLabel2.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        jLabel2.setText("从");

        jLabel3.setText("-");

        jButton1.setText("汇总");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "商品编号", "商品名称", "采购数量", "采购金额"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        jButton3.setText("退出");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datestart, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateend, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jButton1)
                    .addComponent(datestart, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateend, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        FrameUtil2.framemap.remove(cgtjinternalframe.class.getName());
        this.dispose();
    }//GEN-LAST:event_formInternalFrameClosing

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        FrameUtil2.framemap.remove(cgtjinternalframe.class.getName());
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String box = (String) this.box.getSelectedItem();
        JFileChooser savefile = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Excel文件(*.xls)", "xls");
        savefile.addChoosableFileFilter(filter);
        savefile.setFileFilter(filter);
        int flag = savefile.showSaveDialog(this);
        File file = null;
        //System.out.println(box);
        if (box.equals("商品")) {
            List<Purchase> list = p.get(this.datestart.getText(), this.dateend.getText(),"pro");
            refresh(list,"pro");
            if (flag == JFileChooser.APPROVE_OPTION) {
                file = savefile.getSelectedFile();
                //System.out.println("文件名:"+file.getAbsolutePath());
                String filename = file.getAbsolutePath();
                String filetype = filename.substring(filename.length()-4);
                if(!filetype.equals(".xls")){
                    file = new File(filename+".xls");
                }
                List<Map<String,String>> ls = new ArrayList<Map<String,String>>();
                 //String[] str ={"采购编号","商品名称","供应商","采购价格"
                Map<String,String> map = new LinkedHashMap<String,String>();
                map.put("商品编号", null);
                map.put("商品名称", null);
                map.put("商品型号", null);
                map.put("采购数量", null);
                map.put("采购金额", null);
                ls.add(map);
                Map<String, String> mm;
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                for (Purchase p : list) {
                    mm = new LinkedHashMap<String, String>();
                    mm.put("商品编号", String.valueOf(p.getProid()));
                    mm.put("商品名称", p.getProname());
                    mm.put("商品型号", p.getProtype());
                    mm.put("采购金额", String.valueOf(p.getCountmoney()));
                    ls.add(mm);
                }
                ExportExcel.printSale(ls, file); 
                JOptionPane.showMessageDialog(this, "打印成功");
            }
        } else if (box.equals("供应商")) {
            List<Purchase> list = p.get(this.datestart.getText(), this.dateend.getText(),"sup");
            refresh(list,"sup");
           if (flag == JFileChooser.APPROVE_OPTION) {
                file = savefile.getSelectedFile();
                //System.out.println("文件名:"+file.getAbsolutePath());
                String filename = file.getAbsolutePath();
                String filetype = filename.substring(filename.length()-4);
                if(!filetype.equals(".xls")){
                    file = new File(filename+".xls");
                }
                List<Map<String,String>> ls = new ArrayList<Map<String,String>>();
                 //String[] str ={"采购编号","商品名称","供应商","采购价格"
                Map<String, String> map = new LinkedHashMap<String, String>();
                map.put("供应商编号", null);
                map.put("供应商名称", null);
                map.put("采购金额", null);
                ls.add(map);
                Map<String, String> mm;
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                for (Purchase p : list) {
                    mm = new LinkedHashMap<String, String>();
                    mm.put("供应商编号", String.valueOf(p.getSupid()));
                    mm.put("供应商名称", p.getSupfullname());
                    mm.put("采购金额", String.valueOf(p.getCountmoney()));
                    ls.add(mm);
                }
                ExportExcel.printSale(ls, file); 
                JOptionPane.showMessageDialog(this, "打印成功");
            }
        }
        else if (box.equals("供应商（商品）")) {
             List<Purchase> list = p.get(this.datestart.getText(), this.dateend.getText(),"gyssp");
             refresh(list,"gyssp");
             if (flag == JFileChooser.APPROVE_OPTION) {
                file = savefile.getSelectedFile();
                //System.out.println("文件名:"+file.getAbsolutePath());
                String filename = file.getAbsolutePath();
                String filetype = filename.substring(filename.length()-4);
                if(!filetype.equals(".xls")){
                    file = new File(filename+".xls");
                }
                List<Map<String,String>> ls = new ArrayList<Map<String,String>>();
                 //String[] str ={"采购编号","商品名称","供应商","采购价格"
                Map<String, String> map = new LinkedHashMap<String, String>();
                map.put("供应商编号", null);
                map.put("供应商名称", null);
                map.put("商品编号", null);
                map.put("商品名称", null);
                map.put("商品型号", null);
                map.put("采购数量", null);
                map.put("采购金额", null);
                ls.add(map);
                Map<String, String> mm;
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                for (Purchase p : list) {
                    mm = new LinkedHashMap<String, String>();
                    mm.put("供应商编号", String.valueOf(p.getSupid()));
                    mm.put("供应商名称", p.getSupfullname());
                    mm.put("商品编号", String.valueOf(p.getProid()));
                    mm.put("商品名称", p.getProname());
                    mm.put("商品型号", p.getProtype());
                    mm.put("采购数量", String.valueOf(p.getCountnum()));
                    mm.put("采购金额", String.valueOf(p.getCountmoney()));
                    ls.add(mm);
                }
                ExportExcel.printSale(ls, file); 
                JOptionPane.showMessageDialog(this, "打印成功");
            }
        }
        else{
            List<Purchase> list = p.get(this.datestart.getText(), this.dateend.getText(),"spgys");
            refresh(list,"spgys");
           if (flag == JFileChooser.APPROVE_OPTION) {
                file = savefile.getSelectedFile();
                //System.out.println("文件名:"+file.getAbsolutePath());
                String filename = file.getAbsolutePath();
                String filetype = filename.substring(filename.length()-4);
                if(!filetype.equals(".xls")){
                    file = new File(filename+".xls");
                }
                List<Map<String,String>> ls = new ArrayList<Map<String,String>>();
                 //String[] str ={"采购编号","商品名称","供应商","采购价格"
                Map<String, String> map = new LinkedHashMap<String, String>();
                map.put("商品编号", null);
                map.put("商品名称", null);
                map.put("商品型号", null);
                map.put("供应商编号", null);
                map.put("供应商名称", null);
                map.put("采购数量", null);
                map.put("采购金额", null);
                ls.add(map);
                Map<String, String> mm;
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                for (Purchase p : list) {
                    mm = new LinkedHashMap<String, String>();
                    mm.put("商品编号", String.valueOf(p.getProid()));
                    mm.put("商品名称", p.getProname());
                    mm.put("商品型号", p.getProtype());
                    mm.put("供应商编号", String.valueOf(p.getSupid()));
                    mm.put("供应商名称", p.getSupfullname());
                    mm.put("采购数量", String.valueOf(p.getCountnum()));
                    mm.put("采购金额", String.valueOf(p.getCountmoney()));
                    ls.add(mm);
                }
                ExportExcel.printSale(ls, file);
                JOptionPane.showMessageDialog(this, "打印成功");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String box = (String) this.box.getSelectedItem();
        if (box.equals("商品")) {
            this.tab.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "商品编号", "商品名称", "商品型号", "当前库存", "采购金额"
                }
            ));
            List<Purchase> list = p.get(this.datestart.getText(), this.dateend.getText(),"pro");
            refresh(list,"pro");
        } else if (box.equals("供应商")) {
            this.tab.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "供应商编号", "供应商简称","采购金额"
                }
            ));
            List<Purchase> list = p.get(this.datestart.getText(), this.dateend.getText(),"sup");
            refresh(list,"sup");
        }
        else if (box.equals("供应商（商品）")) {
            this.tab.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{},
                    new String[]{
                        "供应商编号", "供应商名称", "商品编号", "商品名称", "商品型号", "采购数量", "商品单位", "采购金额"
                    }
            ));
            List<Purchase> list = p.get(this.datestart.getText(), this.dateend.getText(),"gyssp");
            refresh(list,"gyssp");
        } else if (box.equals("商品（供应商）")) {
            this.tab.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{},
                    new String[]{
                        "商品编号", "商品名称", "商品型号", "供应商编号", "供应商名称", "采购数量", "商品单位", "采购金额"
                    }
            ));
            List<Purchase> list = p.get(this.datestart.getText(), this.dateend.getText(),"spgys");
            refresh(list,"spgys");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box;
    private elms.util.DateChooserJButton dateend;
    private elms.util.DateChooserJButton datestart;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tab;
    // End of variables declaration//GEN-END:variables
}
