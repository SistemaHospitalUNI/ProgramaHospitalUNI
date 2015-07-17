/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Citas;

import Conexion.DAO;
import Decoracion.RangeEvaluator;
import Pojo.DiasMedico;
import Pojo.Especialidad;
import Pojo.HorarioMedico;
import Pojo.Medico;
import Pojo.Paciente;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author crdzbird
 */
public class FrameCitas extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * Creates new form FrameCitas
     */
    SessionFactory sf;
    Session s;

    RangeEvaluator evaluator = new RangeEvaluator();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date date = new Date();
    String[] horas = {"1:00", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "24:00"};
    int idEspecialidad, idMedicos, diferencia, horaInicioC, horaFinalC;
    String horaInicios, horaFinals, tiempoDia;

    public FrameCitas(SessionFactory sf) {
        jCalendario.setDate(date);
        this.fechas = jCalendario.getDate();
        initComponents();
        InicializarTabla();
        llenartabla();
        cmbEspecialidad.setSelectedIndex(0);
        cmbMedico.setSelectedIndex(0);
        cmbPacientes.setSelectedIndex(0);
        this.sf = sf;
    }
    
    Date fechas;
    JDateChooser seleccionFecha = new JDateChooser(fechas);
    
    
    public void InstanciarDateTime() throws ParseException {
        evaluator.setStartDate(dateFormat.parse(date.toString()));
        evaluator.setEndDate(dateFormat.parse("31-12-2036"));
        RangeEvaluator re = new RangeEvaluator();
        JCalendar jc = new JCalendar();
        jc.getDayChooser().addDateEvaluator(re);
        jCalendario.setDate(Calendar.getInstance().getTime());
        jCalendario.getDayChooser().addDateEvaluator(evaluator);
    }

    public void llenarComboCitas() {
        DAO d = new DAO(sf);
        List<Especialidad> lstEspecialidades = DAO.Listar_Especialidades();
        for (Especialidad especialidades : lstEspecialidades) {
            s = sf.openSession();
            cmbEspecialidad.addItem(especialidades.getNombreEspecialidad());
            s.close();
        }
    }

    public void llenartabla() {
        limpiar();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < horas.length; i++) {
            modelo.addRow(new Object[]{horas[i]});
        }
        jTable1.setModel(modelo);
    }

    public void limpiar() {
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Tiempo", "Disponibilidad"}
        ) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class
            };

        });
    }

    public void llenarComboMedicos() {
        int idMedicoEspecialidad;
        DAO d = new DAO(sf);
        List<Medico> lstMedico = DAO.Listar_Medicos();
        for (Medico medicos : lstMedico) {
            if (medicos.getEspecialidad().getIdEspecialidad().equals(idEspecialidad)) {
                cmbID.addItem(medicos.getIdMedico());
                cmbMedico.addItem(medicos.getPrimernombre()+" "+medicos.getSegundonombre()+" "+
                        medicos.getPrimerapellido()+" "+medicos.getSegundoapellido());
            }
        }
    }

    public void llenarComboPacientes() {
        DAO d = new DAO(sf);
        List<Paciente> lstPacientes = DAO.Listar_Pacientes();
        for (Paciente p : lstPacientes) {
            s = sf.openSession();
            cmbPacientes.addItem(p.getNombre() + " " + p.getApellido());
            s.close();
        }
    }

    public void InicializarTabla() {
        dtm.addColumn("Tiempo");
        dtm.addColumn("Disponibilidad");
        jTable1.setModel(dtm);
    }

    public void ObtenerEspecialidad() {
        int n = cmbEspecialidad.getSelectedIndex();
        DAO d = new DAO(sf);
        idEspecialidad = DAO.busquedaEspecialidadId(n).getIdEspecialidad();
        System.out.println("Especialidad: " + idEspecialidad);
    }

    public void ObtenerNombreMedico(String nombre) {
       
//        String n = cmbMedico.getSelectedItem().toString();
//        DAO d = new DAO(sf);
//        idMedicos = DAO.busquedaMedicoNombre(n).getIdMedico();
//        System.out.println("Medico: " + idMedicos);
        int index = cmbMedico.getSelectedIndex();
        if(index>0){
        idMedicos = (int) cmbID.getItemAt(index);
        ListarHorarioMedicoUnico(idMedicos);
        }
        
    }

    public void LimpiarComboBox() {
        cmbMedico.removeAllItems();
        cmbID.removeAllItems();
        cmbID.addItem("ID");
        cmbMedico.addItem("Seleccione un medico");
    }

    public void ValidacionHoraFinal(String HoraFinal) {
        if (HoraFinal.equals("1:00")) {
            horaFinalC = 1;
        }

        if (HoraFinal.equals("2:00")) {
            horaFinalC = 2;
        }

        if (HoraFinal.equals("3:00")) {
            horaFinalC = 3;
        }

        if (HoraFinal.equals("4:00")) {
            horaFinalC = 4;
        }

        if (HoraFinal.equals("5:00")) {
            horaFinalC = 5;
        }

        if (HoraFinal.equals("6:00")) {
            horaFinalC = 6;
        }
        if (HoraFinal.equals("7:00")) {
            horaFinalC = 7;
        }
        if (HoraFinal.equals("8:00")) {
            horaFinalC = 8;
        }

        if (HoraFinal.equals("9:00")) {
            horaFinalC = 9;
        }

        if (HoraFinal.equals("10:00")) {
            horaFinalC = 10;
        }

        if (HoraFinal.equals("11:00")) {
            horaFinalC = 11;
        }

        if (HoraFinal.equals("12:00")) {
            horaFinalC = 12;
        }

        if (HoraFinal.equals("13:00")) {
            horaFinalC = 13;
        }

        if (HoraFinal.equals("14:00")) {
            horaFinalC = 14;
        }

        if (HoraFinal.equals("15:00")) {
            horaFinalC = 15;
        }

        if (HoraFinal.equals("16:00")) {
            horaFinalC = 16;
        }

        if (HoraFinal.equals("17:00")) {
            horaFinalC = 17;
        }

        if (HoraFinal.equals("18:00")) {
            horaFinalC = 18;
        }

        if (HoraFinal.equals("19:00")) {
            horaFinalC = 19;
        }

        if (HoraFinal.equals("20:00")) {
            horaFinalC = 20;
        }

        if (HoraFinal.equals("21:00")) {
            horaFinalC = 21;
        }

        if (HoraFinal.equals("22:00")) {
            horaFinalC = 22;
        }

        if (HoraFinal.equals("23:00")) {
            horaFinalC = 23;
        }

        if (HoraFinal.equals("24:00")) {
            horaFinalC = 24;
        }
    }

    public void ValidacionHoraInicio(String HoraInicio) {
        if (HoraInicio.equals("1:00")) {
            horaInicioC = 1;
        }

        if (HoraInicio.equals("2:00")) {
            horaInicioC = 2;
        }

        if (HoraInicio.equals("3:00")) {
            horaInicioC = 3;
        }

        if (HoraInicio.equals("4:00")) {
            horaInicioC = 4;
        }

        if (HoraInicio.equals("5:00")) {
            horaInicioC = 5;
        }

        if (HoraInicio.equals("6:00")) {
            horaInicioC = 6;
        }
        if (HoraInicio.equals("7:00")) {
            horaInicioC = 7;
        }
        if (HoraInicio.equals("8:00")) {
            horaInicioC = 8;
        }

        if (HoraInicio.equals("9:00")) {
            horaInicioC = 9;
        }

        if (HoraInicio.equals("10:00")) {
            horaInicioC = 10;
        }

        if (HoraInicio.equals("11:00")) {
            horaInicioC = 11;
        }

        if (HoraInicio.equals("12:00")) {
            horaInicioC = 12;
        }

        if (HoraInicio.equals("13:00")) {
            horaInicioC = 13;
        }

        if (HoraInicio.equals("14:00")) {
            horaInicioC = 14;
        }

        if (HoraInicio.equals("15:00")) {
            horaInicioC = 15;
        }

        if (HoraInicio.equals("16:00")) {
            horaInicioC = 16;
        }

        if (HoraInicio.equals("17:00")) {
            horaInicioC = 17;
        }

        if (HoraInicio.equals("18:00")) {
            horaInicioC = 18;
        }

        if (HoraInicio.equals("19:00")) {
            horaInicioC = 19;
        }

        if (HoraInicio.equals("20:00")) {
            horaInicioC = 20;
        }

        if (HoraInicio.equals("21:00")) {
            horaInicioC = 21;
        }

        if (HoraInicio.equals("22:00")) {
            horaInicioC = 22;
        }

        if (HoraInicio.equals("23:00")) {
            horaInicioC = 23;
        }

        if (HoraInicio.equals("24:00")) {
            horaInicioC = 24;
        }
    }

    public void ListarMedicoDiaUnico(String cedula) {
        s = sf.openSession();
        List<Medico> lstMedico = (List<Medico>) s.createQuery("from Medico").list();
        for (Medico medico : lstMedico) {
            if (medico.getCedula().equals(cedula)) {
                System.out.println("ID: " + medico.getDiasMedicos().size());
                ListarDiaHorarioUnico(medico.getDiasMedicos().size());

            }
        }
        s.close();
    }

    public void ListarDiaHorarioUnico(int idDias) {
        s = sf.openSession();
        int idMedic;
        List<DiasMedico> lstDiasMedic = (List<DiasMedico>) s.createQuery("from DiasMedico").list();
        for (DiasMedico diaMedic : lstDiasMedic) {
            idMedic = diaMedic.getMedico().getIdMedico();
            if (diaMedic.getIdDiaMedico().equals(idDias)) {
                System.out.println("MEDICO: " + diaMedic.getMedico().getPrimernombre());
                System.out.println("ID HORARIO: " + diaMedic.getHorarioMedicos().size());
                ListarHorarioMedicoUnico(diaMedic.getHorarioMedicos().size());
            }
        }
    }

    public void ListarHorarioMedicoUnico(int idDiaMedico) {
        limpiar();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        s = sf.openSession();
        List<HorarioMedico> lstHorario = new ArrayList<>();
        List<HorarioMedico> lstHorarioMedico = (List<HorarioMedico>) s.createQuery("from HorarioMedico").list();
        for (HorarioMedico hMedico : lstHorarioMedico) {
            if (hMedico.getIdHorariomedico().equals(idDiaMedico)) {
                System.out.println("MEDICO: " + hMedico.getDiasMedico().getMedico().getPrimernombre() + " " + hMedico.getDiasMedico().getMedico().getPrimerapellido());
                System.out.println("HORA: " + hMedico.getHoraEntrada() + "   " + "HORA SALIDA: " + hMedico.getHoraSalida());
                ValidacionHoraInicio(hMedico.getHoraEntrada());
                ValidacionHoraFinal(hMedico.getHoraSalida());
                diferencia = horaFinalC - horaInicioC;
                for (int i = 1; i <= diferencia; i++) {
                    if (i >= 12) {
                        tiempoDia = "PM";
                    } else {
                        tiempoDia = "AM";
                    }
                    System.out.println("Diferencias: " + i);
                    modelo.addRow(new Object[]{i + ":00" + tiempoDia, "Disponible"});
                }

            }
        }
        jTable1.setModel(modelo);
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
        cmbPacientes = new javax.swing.JComboBox();
        cmbEspecialidad = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbMedico = new javax.swing.JComboBox();
        jCalendario = new com.toedter.calendar.JCalendar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cmbID = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Elaboracion de Citas");
        setMaximumSize(new java.awt.Dimension(900, 650));
        setMinimumSize(new java.awt.Dimension(900, 650));
        setPreferredSize(new java.awt.Dimension(900, 650));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setText("Seleccione el Paciente:");

        cmbPacientes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un paciente" }));

        cmbEspecialidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una especialidad" }));
        cmbEspecialidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEspecialidadItemStateChanged(evt);
            }
        });

        jLabel2.setText("Tipo Cita(Especialidad.)");

        jLabel3.setText("Doctor a cargo de Cita:");

        cmbMedico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un medico" }));
        cmbMedico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMedicoItemStateChanged(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(252, 191, 191));
        jTable1.setFont(new java.awt.Font("Ubuntu", 3, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tiempo", "Disponibilidad"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Realizar Cita");

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cmbID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(cmbMedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmbEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbPacientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(47, 47, 47)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmbPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(cmbID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
       // llenarComboCitas();
       // llenarComboPacientes();
    }//GEN-LAST:event_formInternalFrameOpened

    private void cmbEspecialidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEspecialidadItemStateChanged
        // TODO add your handling code here:
        LimpiarComboBox();
        ObtenerEspecialidad();
        llenarComboMedicos();
    }//GEN-LAST:event_cmbEspecialidadItemStateChanged

    private void cmbMedicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMedicoItemStateChanged
        // TODO add your handling code here:
        //ObtenerNombreMedico();
        //ListarMedicoDia(idMedicos);

        System.out.println("cmb " + cmbMedico.getSelectedItem());
        
        ObtenerNombreMedico(String.valueOf(cmbMedico.getSelectedItem()));
        
    }//GEN-LAST:event_cmbMedicoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbEspecialidad;
    private javax.swing.JComboBox cmbID;
    private javax.swing.JComboBox cmbMedico;
    private javax.swing.JComboBox cmbPacientes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JCalendar jCalendario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
