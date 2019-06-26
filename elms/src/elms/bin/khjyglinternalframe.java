/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package elms.bin;
import elms.po.*;
import elms.service.customerserviceimpl;
import elms.service.sellserviceimpl;
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
public class khjyglinternalframe extends javax.swing.JInternalFrame {

    /** Creates new form khjyglinternalframe */
    public khjyglinternalframe() {
        initComponents();        
    }
    public void refresh(List<Sell> list){
        DefaultTableModel model = (DefaultTableModel) this.tab.getModel();
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
         for (Sell p : list) {
            //将数据放到一个集合里 然后在放到表格中
            Vector v = new Vector();
            v.add(p.getCusid());
            v.add(p.getCusname());
            v.add(p.getSellprice());
            //放到表格里
            model.addRow(v);
        }
        
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        datestart = new elms.util.DateChooserJButton();
        jLabel3 = new javax.swing.JLabel();
        dateend = new elms.util.DateChooserJButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Top 10 客户历史交易记录");
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

        jButton1.setText("查询");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "客户编号", "客户简称", "交易金额"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
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

        jLabel3.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(datestart, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(dateend, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel3)
                    .addComponent(dateend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datestart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        FrameUtil2.framemap.remove(khjyglinternalframe.class.getName());
    }//GEN-LAST:event_formInternalFrameClosing

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        FrameUtil2.framemap.remove(khjyglinternalframe.class.getName());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        sellserviceimpl c = new sellserviceimpl();
        String start = this.datestart.getText();
        String end = this.dateend.getText();
        List<Sell> list = c.getByCus(start,end);
        refresh(list);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        sellserviceimpl p = new sellserviceimpl();
        String start = this.datestart.getText();
        String end = this.dateend.getText();
        List<Sell> list = p.getByCus(start,end);
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
            map.put("客户编号", null);
            map.put("客户简称",null);
            map.put("交易金额",null);
            ls.add(map);
            
            Map<String,String> mm;
            for(Sell p1:list){
                mm = new LinkedHashMap<String,String>();
                mm.put("客户编号",String.valueOf(p1.getCusid()));
                mm.put("客户简称",p1.getCusname());
                mm.put("交易金额",String.valueOf(p1.getSellprice()));
                ls.add(mm);
            }
            ExportExcel.printSale(ls, file);
            JOptionPane.showMessageDialog(this, "打印成功");
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private elms.util.DateChooserJButton dateend;
    private elms.util.DateChooserJButton datestart;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tab;
    // End of variables declaration//GEN-END:variables

}
