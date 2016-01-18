
package colectordedatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import colectordedatos.nametierName;
import java.io.FileReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Ventana extends javax.swing.JFrame {

    private JSONArray arrJSON;
    private JSONArray arrJSON2;
    private JSONArray arregloBackends;
    private JSONObject lecturadearchivo;
    private JSONArray nodo;
    File abre;

    
    public Ventana() {
        initComponents();
        cargardatos();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Regenerador de Dashboards Automatico");
    }

 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cargar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        transacciones = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        Cargarachivo = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        GenerarBackends = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Cargar.setText("Generar metricas");
        Cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarActionPerformed(evt);
            }
        });

        jLabel9.setText("Ruta de archivo :");

        jLabel1.setText("Transacción :");

        Cargarachivo.setText("Seleccionar dashboard");
        Cargarachivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarachivoActionPerformed(evt);
            }
        });

        Salir.setText("Cerrar");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Llamadas por minuto");
        jCheckBox1.setName("hgfghfdhgf"); // NOI18N

        jCheckBox2.setText("Tiempo medio de Respuesta");

        jCheckBox3.setText("Errores por minuto");

        jCheckBox4.setText("Número de llamadas lentas");

        jCheckBox5.setText("Número de llamadas muy lentas");

        GenerarBackends.setText("Generar Backends");
        GenerarBackends.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarBackendsActionPerformed(evt);
            }
        });

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel1))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(transacciones, 0, 215, Short.MAX_VALUE)
                                    .addComponent(Cargarachivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(Cargar)
                                .addGap(40, 40, 40)
                                .addComponent(Salir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GenerarBackends)
                        .addGap(84, 84, 84))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Cargarachivo))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(transacciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cargar)
                    .addComponent(Salir)
                    .addComponent(GenerarBackends)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Inicio de metodo para cargar al combobox los nodos
    public void cargardatos() {

        String strUrl = "http://10.43.11.143:8090/controller/rest/applications/Portales/business-transactions?output=JSON";

        URL url;
        try {
            url = new URL(strUrl);
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

            JSONArray transaccione = new JSONArray(sb.toString());
            for (int i = 0; i < transaccione.length(); i++) {
                JSONObject obj = transaccione.getJSONObject(i);
                nametierName nametiername = new nametierName(obj.getString("name"), obj.getString("tierName"));
                transacciones.addItem(nametiername);
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //Fin de metodo para cargar al combobox los nodos
    
    //Inicio de boton que extrae y carga los nodos a un JSON
    private void CargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarActionPerformed
        try {
            nametierName opcion = (nametierName) transacciones.getSelectedItem();
            String names = opcion.getname();
            String tiername = opcion.gettierName();

            String strUrl = "http://10.43.11.143:8090/controller/rest/applications/Portales/tiers/" + tiername + "/nodes?output=json";

            URL url;

            url = new URL(strUrl);
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

            nodo = new JSONArray(sb.toString());

        } catch (MalformedURLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }

        String call_per_minute = "Calls per Minute";
        String average_response_time = "Average Response Time (ms)";
        String errors_per_minute = "Errors per Minute";
        String number_of_slow_calls = "Number of Slow Calls";
        String number_of_very_slow_calls = "Number of Very Slow Calls";

        if (jCheckBox1.isSelected()) {
            cargardataSeriesTemplates(call_per_minute);
        }
        if (jCheckBox2.isSelected()) {

            cargardataSeriesTemplates(average_response_time);
        }
        if (jCheckBox3.isSelected()) {

            cargardataSeriesTemplates(errors_per_minute);
        }
        if (jCheckBox4.isSelected()) {

            cargardataSeriesTemplates(number_of_slow_calls);
        }
        if (jCheckBox5.isSelected()) {

            cargardataSeriesTemplates(number_of_very_slow_calls);
        }
        JOptionPane.showMessageDialog(this, "Se han Generado con exito las metricas");
            Escribir();
    }//GEN-LAST:event_CargarActionPerformed
    //Fin de boton que extrae y carga los nodos a un JSON
    
    //Inicio de Lectura de archivo que pasa el cliente la agregar las metricas y los backends
    private void CargarachivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarachivoActionPerformed
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(this);
        abre = file.getSelectedFile();

        if (abre != null) {
            try {
                // TODO add your handling code here: archivo.getText()
                File snapshotsFile = new File(abre.toString());
                FileInputStream fis = new FileInputStream(snapshotsFile);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader bf = new BufferedReader(isr);
                String linea = bf.readLine();
                StringBuffer sb = new StringBuffer();
                while (linea != null) {
                    sb.append(linea.trim());
                    linea = bf.readLine();
                }
                bf.close();
                isr.close();
                fis.close();

                lecturadearchivo = new JSONObject(sb.toString());

                arrJSON = lecturadearchivo.getJSONArray("widgetTemplates");

                if (lecturadearchivo.equals(null)) {
                    JOptionPane.showMessageDialog(this, "No hay datos para extraer", "mensaje", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "los datos han sido extraidos con exito", "mensaje", JOptionPane.INFORMATION_MESSAGE);

                }

            } catch (Exception ex) {

            }
        }

    }//GEN-LAST:event_CargarachivoActionPerformed
    //Fin de Lectura de archivo que pasa el cliente la agregar las metricas y los backends
    
    //Inicio de boton para salir del programa
    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed
    //Fin de boton para salir del programa
    
    //Inicio de boton que extrae y carga los backends en un JSON
    private void GenerarBackendsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarBackendsActionPerformed
        nametierName opcion = (nametierName) transacciones.getSelectedItem();
        String name = opcion.getname();
        String tiername = opcion.gettierName();
         try {
        
        String call_per_minute = "Calls per Minute";
        String average_response_time = "Average Response Time (ms)";
        String errors_per_minute = "Errors per Minute";

       
            
            String strUrl="http://10.43.11.143:8090/controller/rest/applications/Portales/metrics?metric-path=Business%20Transaction%20Performance%7CBusiness%20Transactions%7C"+tiername+"%7C"+name+"%7CExternal%20Calls&output=JSON";

            URL url;

            url = new URL(strUrl);
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
            
            arregloBackends = new JSONArray(sb.toString());
            
        if (jCheckBox1.isSelected()) {
        
            cargardataSeriesTemplatesBackends(call_per_minute);
        }
        if (jCheckBox2.isSelected()) {
            cargardataSeriesTemplatesBackends(average_response_time);
            
        }
        if (jCheckBox3.isSelected()) {
            cargardataSeriesTemplatesBackends(errors_per_minute);
            
        }
        JOptionPane.showMessageDialog(this, "Se han Generado con exito los Backends");
            
                Escribir();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_GenerarBackendsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        inicio ini=new inicio();
        ini.setVisible(true);
        this.dispose();
        

    }//GEN-LAST:event_jButton1ActionPerformed
    //Fin de boton que extrae y carga los backends en un JSON
    
    //Inicio de función para leer un template de dataSerie y cargar los nodos extraidos anteriormente
    public void cargardataSeriesTemplates(String metrica) {
        String nombre="Nodos";
        JSONObject dataSeriesTemplates = new JSONObject();
        JSONArray dataSeriefinal = new JSONArray();

        FileInputStream fis = null;
        try {
            File snapshotsFile = new File("C:\\Users\\Administrador\\Desktop\\pruebasJSON\\templates\\NododataSeriesTemplates.json");
            fis = new FileInputStream(snapshotsFile);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bf = new BufferedReader(isr);
            String linea = bf.readLine();
            StringBuffer sb = new StringBuffer();
            while (linea != null) {
                sb.append(linea.trim());
                linea = bf.readLine();
            }
            bf.close();
            isr.close();
            fis.close();

            dataSeriesTemplates = new JSONObject(sb.toString());
            JSONArray nuevodataSeriesTemplates = new JSONArray();

            JSONObject metricMatchCriteriaTemplate;

            metricMatchCriteriaTemplate = dataSeriesTemplates.getJSONObject("metricMatchCriteriaTemplate");
            JSONObject metricExpressionTemplate = metricMatchCriteriaTemplate.getJSONObject("metricExpressionTemplate");
            JSONObject scopeEntity = metricExpressionTemplate.getJSONObject("scopeEntity");
            nametierName opcion = (nametierName) transacciones.getSelectedItem();

            for (int i = 0; i < nodo.length(); i++) {

                

                JSONObject dato = nodo.getJSONObject(i);
                String serie = dato.getString("id");
                String OSBMOVIL = dato.getString("name");
                String transaccion = dato.getString("tierName");
                String datos1 = "Business Transaction Performance|Business Transactions|" + transaccion + "|" + opcion + "|Individual Nodes|" + OSBMOVIL + "|" + metrica;
                dataSeriesTemplates.put("name", serie);
                metricExpressionTemplate.put("metricPath", datos1);
                scopeEntity.put("entityName", OSBMOVIL);
                scopeEntity.put("scopingEntityName", transaccion);
                JSONObject archivoNuevo = new JSONObject(dataSeriesTemplates.toString());
                nuevodataSeriesTemplates.put(i, archivoNuevo);
            }
            
            cargarwidgetTemplates(nuevodataSeriesTemplates,metrica,nombre);

        } catch (JSONException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    //Fin de función para leer un template y cargar los nodos extraidos anteriormente
    
    //Inicio de función para leer un template de Widget y cargar las Series creadas anteriormente
    public void cargarwidgetTemplates(JSONArray datos,String metrica,String nombre) {
        String titulo=metrica+" "+nombre;
        JSONArray widgetfinal = new JSONArray();
        JSONObject widgetTemplates = new JSONObject();
        JSONArray dataserie = new JSONArray();
        FileInputStream fis = null;
        try {
            File snapshotsFile = new File("C:\\Users\\Administrador\\Desktop\\pruebasJSON\\templates\\NodowidgetTemplates.json");
            fis = new FileInputStream(snapshotsFile);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bf = new BufferedReader(isr);
            String linea = bf.readLine();
            StringBuffer sb = new StringBuffer();
            while (linea != null) {
                sb.append(linea.trim());
                linea = bf.readLine();
            }
            bf.close();
            isr.close();
            fis.close();

            widgetTemplates = new JSONObject(sb.toString());

            if (lecturadearchivo.getString("widgetTemplates").equals("null")) {
                widgetTemplates.put("dataSeriesTemplates", datos);
                widgetTemplates.put("title",titulo);
                widgetfinal.put(0, widgetTemplates);
                lecturadearchivo.put("widgetTemplates", widgetfinal);
            } else {
                arrJSON = lecturadearchivo.getJSONArray("widgetTemplates");
                widgetTemplates.put("dataSeriesTemplates", datos);
                widgetTemplates.put("title",titulo);
                arrJSON.put(widgetTemplates);

            }

        } catch (JSONException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //Fin de función para leer un template de Widget y cargar las Series creadas anteriormente
    
    //Inicio de función para leer un template de dataSerieBackends y cargar los backends extraidos anteriormente
    public void cargardataSeriesTemplatesBackends(String metrica) {

        String nombre="Backends";
        JSONObject dataSeriesTemplates = new JSONObject();
        JSONArray dataSeriefinal = new JSONArray();

        FileInputStream fis = null;
        try {
            File snapshotsFile = new File("C:\\Users\\Administrador\\Desktop\\pruebasJSON\\templates\\BackenddataSeriesTemplates.json");
            fis = new FileInputStream(snapshotsFile);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bf = new BufferedReader(isr);
            String linea = bf.readLine();
            StringBuffer sb = new StringBuffer();
            while (linea != null) {
                sb.append(linea.trim());
                linea = bf.readLine();
            }
            bf.close();
            isr.close();
            fis.close();

            dataSeriesTemplates = new JSONObject(sb.toString());
            JSONArray nuevodataSeriesTemplatesBackends = new JSONArray();
            
            
            JSONObject metricMatchCriteriaTemplate;
            
            metricMatchCriteriaTemplate = dataSeriesTemplates.getJSONObject("metricMatchCriteriaTemplate");
            JSONObject metricExpressionTemplate = metricMatchCriteriaTemplate.getJSONObject("metricExpressionTemplate");
            JSONObject scopeEntity = metricExpressionTemplate.getJSONObject("scopeEntity");
            nametierName opcion = (nametierName) transacciones.getSelectedItem();
            String tiername = opcion.gettierName();
            
            
            for (int i = 0; i < arregloBackends.length(); i++) {
                
                JSONObject backend = arregloBackends.getJSONObject(i);
                String name = backend.getString("name"); 
                String datos1 ="Business Transaction Performance|Business Transactions|"+ tiername +"|"+ opcion +"|External Calls|"+ name +"|"+ metrica;
                
                dataSeriesTemplates.put("name", "Serie "+i);
                metricExpressionTemplate.put("metricPath", datos1);
                scopeEntity.put("entityName", tiername);
                scopeEntity.put("scopingEntityName", name);
                JSONObject archivoNuevo = new JSONObject(dataSeriesTemplates.toString());
                nuevodataSeriesTemplatesBackends.put(i, archivoNuevo);
                
            }
            
                
            cargarwidgetTemplatesBackends(nuevodataSeriesTemplatesBackends,metrica,nombre);    
            
            

        } catch (JSONException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Fin de función para leer un template de dataSerieBackends y cargar los backends extraidos anteriormente
    
    //Inicio de función para leer un template de Widget y cargar las Series creadas anteriormente
    public void cargarwidgetTemplatesBackends(JSONArray datos,String metrica,String nombre) {
        String titulo=metrica+" "+nombre;
        JSONArray widgetfinal = new JSONArray();
        JSONObject widgetTemplates = new JSONObject();
        JSONArray dataserie = new JSONArray();
        FileInputStream fis = null;
        try {
            File snapshotsFile = new File("C:\\Users\\Administrador\\Desktop\\pruebasJSON\\templates\\BackendwidgetTemplates.json");
            fis = new FileInputStream(snapshotsFile);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bf = new BufferedReader(isr);
            String linea = bf.readLine();
            StringBuffer sb = new StringBuffer();
            while (linea != null) {
                sb.append(linea.trim());
                linea = bf.readLine();
            }
            bf.close();
            isr.close();
            fis.close();

            widgetTemplates = new JSONObject(sb.toString());
              
            if (lecturadearchivo.getString("widgetTemplates").equals("null")) {
                widgetTemplates.put("dataSeriesTemplates", datos);
                widgetTemplates.put("title",titulo);
                widgetfinal.put(0, widgetTemplates);
                lecturadearchivo.put("widgetTemplates", widgetfinal);
                
            } else {
                arrJSON = lecturadearchivo.getJSONArray("widgetTemplates");
                widgetTemplates.put("dataSeriesTemplates", datos);
                widgetTemplates.put("title",titulo);
                arrJSON.put(widgetTemplates);
            }

        } catch (JSONException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //Fin de función para leer un template de Widget y cargar las Series creadas anteriormente
    
    //Inicio de función para escribir el archivo del usuario con las metricas generadas
    public void Escribir(){

        File f;
        f = new File(abre.toString());
        FileWriter w = null;
        try {
            w = new FileWriter(f);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter bw = new BufferedWriter(w);
        PrintWriter wr = new PrintWriter(bw);
        wr.write(lecturadearchivo.toString());
        wr.close();
        try {
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    //Fin de función para escribir el archivo del usuario con las metricas generadas
    public static void main(String args[]) {
    
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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cargar;
    private javax.swing.JButton Cargarachivo;
    private javax.swing.JButton GenerarBackends;
    private javax.swing.JButton Salir;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox transacciones;
    // End of variables declaration//GEN-END:variables
}
