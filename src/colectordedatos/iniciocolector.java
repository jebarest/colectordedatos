/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colectordedatos;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import colectordedatos.idname;
/**
 *
 * @author Administrador
 */
public class iniciocolector extends javax.swing.JFrame {
    
    
    public iniciocolector() {
        initComponents();
        cargartransacciones();
        cargarhoras();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("inicio Colector de Errores");
    }
    
    public void cargartransacciones(){
        
    String strUrl = "http://10.43.11.143:8090/controller/rest/applications/Portales/business-transactions?output=JSON";
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
           
                JSONArray transacciones = new JSONArray(sb.toString());
                Object [] idname=new Object[transacciones.length()];
                
                for (int i = 0; i < transacciones.length(); i++) {
                    JSONObject obj = transacciones.getJSONObject(i);
                           idname idname1= new idname(obj.getString("id"),obj.getString("name"));
                           opciones.addItem(idname1);
                }
                
                
            } catch (MalformedURLException ex) {
                Logger.getLogger(iniciocolector.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(iniciocolector.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (JSONException ex) {
                Logger.getLogger(resultados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
    
    //metodo para generar horas en los jconbobox
    public void cargarhoras(){
        for (int i = 0; i < 25; i++) {
            horainicio.addItem(Integer.toString(i));
            horatermino.addItem(Integer.toString(i));
        }
        cargarfechas();
    
    }
    //metodo para generar fecha en jconbobox respctivo
    public void cargarfechas(){
    for (int i = 2020; i > 1950; i--) {
            Anoinicio.addItem(Integer.toString(i));
            Anotermino.addItem(Integer.toString(i));
        }
    for (int i = 1; i < 32; i++) {
            Diasinicio.addItem(Integer.toString(i));
            Diastermino.addItem(Integer.toString(i));
        }
    for (int i = 1; i < 13; i++) {
        Mesinicio.addItem(Integer.toString(i));
        Mestermino.addItem(Integer.toString(i));
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        Registrodeerrores = new javax.swing.JButton();
        opciones = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        cerrarseion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Diasinicio = new javax.swing.JComboBox();
        Mesinicio = new javax.swing.JComboBox();
        Diastermino = new javax.swing.JComboBox();
        Mestermino = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        horainicio = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        horatermino = new javax.swing.JComboBox();
        Anotermino = new javax.swing.JComboBox();
        Anoinicio = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Registrodeerrores.setText("Ver registro de errores");
        Registrodeerrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrodeerroresActionPerformed(evt);
            }
        });

        jLabel1.setText("Elegir transaccion :");

        cerrarseion.setText("Cerra sesion");
        cerrarseion.setMaximumSize(new java.awt.Dimension(141, 23));
        cerrarseion.setMinimumSize(new java.awt.Dimension(141, 23));
        cerrarseion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarseionActionPerformed(evt);
            }
        });

        jLabel2.setText("Elegir Fecha inicio :");

        jLabel3.setText("Elegis Fecha termino :");

        Diasinicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dias" }));

        Mesinicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mes" }));

        Diastermino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dias" }));

        Mestermino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mes" }));

        jLabel4.setText("Elegir Hora de inicio :");

        horainicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hora" }));

        jLabel5.setText("Elegir Hora de termino :");

        horatermino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hora" }));

        Anotermino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Año" }));

        Anoinicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Año" }));

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(Diasinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Mesinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Anoinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(opciones, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(horatermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(horainicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(Diastermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Mestermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Anotermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Registrodeerrores, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cerrarseion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cerrarseion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Diasinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Mesinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Anoinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Registrodeerrores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Mestermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Anotermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Diastermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(horainicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(horatermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //boton para ver el registro de errores
    private void RegistrodeerroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrodeerroresActionPerformed
        //captura de datos de la opcion a ver los errores
        idname opcion=(idname) opciones.getSelectedItem();
        String id= opcion.getId();
        String name=opcion.getName();
        
        //if para obligar al usuario a que complete todos lo campos pedidos en los Jconbobox
        if((Diasinicio.getSelectedItem().equals("Dias"))||(Mesinicio.getSelectedItem().equals("Mes"))||(Anoinicio.getSelectedItem().equals("Año"))||(horainicio.getSelectedItem().equals("Hora"))){
         
            JOptionPane.showMessageDialog(null,"Ingrese todos lo parametros solicitados","", JOptionPane.INFORMATION_MESSAGE);
        
        }else{
            //start_time con parse
        int enterodiaini= Integer.parseInt((String) Diasinicio.getSelectedItem());
        int enteromesini= Integer.parseInt((String) Mesinicio.getSelectedItem());
        int enteroanoini=Integer.parseInt((String) Anoinicio.getSelectedItem());
        int enterohoraini=Integer.parseInt((String) horainicio.getSelectedItem());
        
            //end_time con parse
        int enterodiater=Integer.parseInt((String) Diastermino.getSelectedItem());
        int enteromester=Integer.parseInt((String) Mestermino.getSelectedItem());
        int enteroanoter=Integer.parseInt((String) Anotermino.getSelectedItem());
        int enterohorater=Integer.parseInt((String) horatermino.getSelectedItem());
        
            //funcion para generar el calendario y psarlo como long a la url
        Calendar fechainicio= Calendar.getInstance();
        fechainicio.set(enteroanoini, enteromesini-1, enterodiaini, enterohoraini, 0);
        
        Calendar fechatermino= Calendar.getInstance();
        fechatermino.set(enteroanoter, enteromester-1, enterodiater, enterohorater, 0);
        
            //long que marcan el iniciocolector y fin a analizar los errores
        long start_time= fechainicio.getTimeInMillis();
        long end_time= fechatermino.getTimeInMillis();
        //if para definir que ventana abrir y generar el reporte
        
            resultados resul=new resultados(name, start_time, end_time, id);
            resul.setVisible(true);
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_RegistrodeerroresActionPerformed
//boton para cerrar sesion y que no quede cargada en memoria
    private void cerrarseionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarseionActionPerformed
      System.exit(0);
    }//GEN-LAST:event_cerrarseionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        inicio ini=new inicio();
        ini.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

   
    
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
            java.util.logging.Logger.getLogger(iniciocolector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(iniciocolector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(iniciocolector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(iniciocolector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Anoinicio;
    private javax.swing.JComboBox Anotermino;
    private javax.swing.JComboBox Diasinicio;
    private javax.swing.JComboBox Diastermino;
    private javax.swing.JComboBox Mesinicio;
    private javax.swing.JComboBox Mestermino;
    private javax.swing.JButton Registrodeerrores;
    private javax.swing.JButton cerrarseion;
    private javax.swing.JComboBox horainicio;
    private javax.swing.JComboBox horatermino;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox opciones;
    // End of variables declaration//GEN-END:variables
}
