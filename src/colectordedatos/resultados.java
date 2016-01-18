/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colectordedatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author ushiro-sec
 */
public class resultados extends javax.swing.JFrame {
    private MyTableModel modelotabla= new MyTableModel();
    private String opcion;
    private long start_time;
    private long end_time;
    private String id;
    
    
    //constructor sobrecargado para recivir parametros antes que se inicie las construcciones de la tabla
    public resultados(String opcion, long start_time, long end_time,String ID) {
        this.opcion=opcion;
        this.start_time=start_time;
        this.end_time=end_time;
        this.id=ID;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Resultados");
        actualizaTabla();
    }
    //metodo para actualizar la tabla una vez crea, para que cargue los datos sin importar nada !metodo importante!
public void actualizaTabla() {

        modelotabla = new MyTableModel();
        jTable1.setModel(modelotabla);
        modelotabla.fireTableDataChanged();
        

    }
    //difiniendo parametros de construcion de la tabla agregando el JSONarra y las columnas
   class MyTableModel extends AbstractTableModel {

    private JSONArray arregloerrores=new JSONArray();
    private int columnas = 3;
    String nombresColumnas[] = {"URL", "errorDetails", "requestGUID"};
    
    //metodo para pasar parametros a la tabla
    public MyTableModel() {
        
        //if necesario para que no quede en blanco la tabla cuando se crea
        if(opcion != null){
            
         //if que permite construir la tabla con datos especificos elegidos en el iniciocolector   
            String numerohome=id;
            tipodecuenta.setText("Registro de Errores de "+ opcion);
            
        String strUrl = "http://10.43.11.143:8090/controller/rest/applications/Portales/request-snapshots?time-range-type=BETWEEN_TIMES&start-time=" + start_time + "&end-time=" + end_time + "&applicationComponentId=11&business-transaction-ids="+ numerohome +"&user-experience=error&need-props=true&need-exit-calls=true&output=JSON";
        
        try {
              URL  url = new URL(strUrl);
              URLConnection urlCon = url.openConnection();
            InputStream is = urlCon.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bf = new BufferedReader(isr);
            String linea = bf.readLine();
            StringBuffer sb = new StringBuffer();
            int size = urlCon.getContentLength();
            
            while (linea != null) {
                sb.append(linea.trim());
                linea = bf.readLine();
            }
            
                
                
                JSONArray arregloerrores = new JSONArray(sb.toString());
                this.arregloerrores=arregloerrores;
                
            } catch (MalformedURLException ex) {
                Logger.getLogger(iniciocolector.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(iniciocolector.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (JSONException ex) {
                Logger.getLogger(resultados.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        
        }
    }
    //parametros de la tabla columnas pasando los datos declarados anteriormente
    public int getColumnCount() {
        return nombresColumnas.length;
    }
    //parametros de la tabla filas pasando el JSONArray
    public int getRowCount() {    
        return arregloerrores.length();
    }
    //parametros de la tabla columnas y sus nombres declarados anteriormente
    public String getColumnName(int col) {
        return nombresColumnas[col];
    }
    //metodo para capturar solo los datos necesarios a pasar a la tabla
    public Object getValueAt(int row, int col) {
        
        Object obj = null;
        try{
        JSONObject objJson = arregloerrores.getJSONObject(row);
        
        switch (col) {
            case 0:
                obj = objJson.getString("URL");
                break;
            case 1:
                obj = objJson.getString("errorDetails");
                if(objJson.getString("errorDetails").equals("[]")){
                        obj="Sin detalle de errores";
                }
                break;
                
            case 2:
                obj = objJson.getString("requestGUID");
                break;
            
        
        }
        }catch(Exception e){
            System.out.println("error");
        }
        return obj;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
//            if (col < 2) {
//                return false;
//            } else {
//                return true;
//            }
        return false;
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        //data[row][col] = value;
        //fireTableCellUpdated(row, col);
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

        jPanel2 = new javax.swing.JPanel();
        Exportar_a_Excel = new javax.swing.JButton();
        Reporte = new javax.swing.JButton();
        tipodecuenta = new javax.swing.JTextField();
        Atras = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        Exportar_a_Excel.setText("Descargar en Excel");
        Exportar_a_Excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exportar_a_ExcelActionPerformed(evt);
            }
        });

        Reporte.setText("Generar reporte");
        Reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteActionPerformed(evt);
            }
        });

        tipodecuenta.setEditable(false);
        tipodecuenta.setToolTipText("");
        tipodecuenta.setBorder(null);

        Atras.setText("Atras");
        Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasActionPerformed(evt);
            }
        });

        jTable1.setModel(modelotabla);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Atras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                        .addComponent(Exportar_a_Excel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Reporte))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(tipodecuenta))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(tipodecuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Atras)
                    .addComponent(Exportar_a_Excel)
                    .addComponent(Reporte))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
            iniciocolector ini=new iniciocolector();
            ini.setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_AtrasActionPerformed

    private void ReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteActionPerformed
        
    }//GEN-LAST:event_ReporteActionPerformed
    
//boton para exportar a un archivo excel
    private void Exportar_a_ExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exportar_a_ExcelActionPerformed
        if (jTable1.getRowCount() > 0) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("Guardar archivo");
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                List<JTable> tb = new ArrayList<JTable>();
                List<String> nom = new ArrayList<String>();
                tb.add(jTable1);
                nom.add("Reporte de Errores");
                String file = chooser.getSelectedFile().toString().concat(".xls");
                try {
                    exportaraexcel e = new exportaraexcel (new File(file), tb, nom);
                    if (e.export()) {
                        JOptionPane.showMessageDialog(null, "Los datos fueron exportados a excel en el directorio seleccionado", "Mensaje de Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Hubo un error " + e.getMessage(), " Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "No hay datos para exportar","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        }   
    }//GEN-LAST:event_Exportar_a_ExcelActionPerformed

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
            java.util.logging.Logger.getLogger(resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atras;
    private javax.swing.JButton Exportar_a_Excel;
    private javax.swing.JButton Reporte;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTextField tipodecuenta;
    // End of variables declaration//GEN-END:variables
}
