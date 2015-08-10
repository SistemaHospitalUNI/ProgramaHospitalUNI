/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Citas;

import Conexion.DAO;
import Decoracion.RangeEvaluator;
import static Medicos.FrameMedicos.IdModificar;
import Pojo.Cita;
import Pojo.DiasMedico;
import Pojo.Especialidad;
import Pojo.HorarioMedico;
import Pojo.Medico;
import Pojo.Paciente;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    Cita citaMedicoFecha;
    HorarioMedico horarioCitaMedico;
    List<Cita> lstCitaMedico = new ArrayList<>();
    RangeEvaluator evaluator = new RangeEvaluator();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date hoy = new Date();
    String[] horas = {"1:00", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "24:00"};
    int idEspecialidad, idMedicos, diferencia, horaInicioC, horaFinalC;
    String horaInicios, horaFinals, tiempoDia;

    public FrameCitas(SessionFactory sf) throws ParseException {
        initComponents();
        hoy = new Date();
        jCalendario.setMinSelectableDate(hoy);
        InicializarTabla();
        llenartabla();
        cmbEspecialidad.setSelectedIndex(0);
        cmbMedico.setSelectedIndex(0);
        cmbPacientes.setSelectedIndex(0);
        this.sf = sf;
    }

    Date fechas;
    JDateChooser seleccionFecha = new JDateChooser(fechas);

    /*public void InstanciarDateTime() throws ParseException {
     evaluator.setStartDate(dateFormat.parse(date.toString()));
     evaluator.setEndDate(dateFormat.parse("31-12-2036"));
     RangeEvaluator re = new RangeEvaluator();
     JCalendar jc = new JCalendar();
     jc.getDayChooser().addDateEvaluator(re);
     jCalendario.setDate(Calendar.getInstance().getTime());
     jCalendario.getDayChooser().addDateEvaluator(evaluator);
     }*/
    public void llenarComboCitas() {
        Session s;
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
                cmbMedico.addItem(medicos.getPrimernombre() + " " + medicos.getSegundonombre() + " "
                        + medicos.getPrimerapellido() + " " + medicos.getSegundoapellido());
            }
        }
    }

    public void llenarComboPacientes() {
        Session s;
        DAO d = new DAO(sf);
        List<Paciente> lstPacientes = DAO.Listar_Pacientes();
        for (Paciente p : lstPacientes) {
            s = sf.openSession();
            cmbPacientes.addItem(p.getNombre() + " " + p.getApellido());
            s.close();
        }
    }
    int idPacienteGuardar;

    public void ObtenerPacienteSeleccionado(int idPaciente) {
        DAO d = new DAO(sf);
        Paciente paci = DAO.busquedaPacienteId(idPaciente);
        idPacienteGuardar = paci.getIdPaciente();
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
        if (index > 0) {
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
        Session s;
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
        Session s;
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
    DiasMedico medicoDias;

    int MedicoBuscado;

    public void ListarTodasCitas() {
        DAO d = new DAO(sf);
        lstCitaMedico = DAO.Listar_Cita_Medico_Especifico();
        for (Cita cit : lstCitaMedico) {
            System.out.println("ID CITA:" + cit.getIdCita());
            System.out.println("HORA DE LA CITA:" + cit.getHora());
            System.out.println("FECHA DE LA CITA:" + dateFormat.format(cit.getFecha()));
            System.out.println("MEDICO A CARGO:" + cit.getMedico().getPrimernombre() + " " + cit.getMedico().getSegundonombre() + " " + cit.getMedico().getPrimerapellido() + " " + cit.getMedico().getSegundoapellido());
            System.out.println("PACIENTE DE LA CITA:" + cit.getPaciente().getNombre() + " " + cit.getPaciente().getApellido());
        }
    }

    int idMedicoHorario;
    String[] horasMedicoCita;

    public void ListarHorarioMedicoUnico(int idDiaMedico) {

        limpiar();
        Session s;
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        s = sf.openSession();
        List<HorarioMedico> lstHorario = new ArrayList<>();
        List<HorarioMedico> lstHorarioMedico = (List<HorarioMedico>) s.createQuery("from HorarioMedico").list();
        for (HorarioMedico hMedico : lstHorarioMedico) {
            if (hMedico.getIdHorariomedico().equals(idDiaMedico)) {
                MedicoBuscado = hMedico.getDiasMedico().getMedico().getIdMedico();
                horarioCitaMedico = hMedico;
                idMedicoHorario = hMedico.getDiasMedico().getMedico().getIdMedico();
                medicoDias = hMedico.getDiasMedico();
                System.out.println("MEDICO: " + hMedico.getDiasMedico().getMedico().getPrimernombre() + " " + hMedico.getDiasMedico().getMedico().getPrimerapellido());
                System.out.println("HORA: " + hMedico.getHoraEntrada() + "   " + "HORA SALIDA: " + hMedico.getHoraSalida());
                ValidacionHoraInicio(hMedico.getHoraEntrada());
                ValidacionHoraFinal(hMedico.getHoraSalida());
                diferencia = horaFinalC - horaInicioC;

                for (int i = horaInicioC; i <= horaFinalC; i++) {
                    /*  if (i >= 12) {
                     tiempoDia = "PM";
                     } else {
                     tiempoDia = "AM";
                     }*/
                    System.out.println("Diferencias: " + i);
                    modelo.addRow(new Object[]{i + ":00", "Disponible"});
                }

            }
        }

        SimpleDateFormat sdfr = new SimpleDateFormat("yyyy-MM-dd");
        DAO dd = new DAO(sf);
        citaMedicoFecha = DAO.busquedaCitaId(MedicoBuscado);
        System.out.println("CITA ID: " + citaMedicoFecha.getIdCita());
        System.out.println("MEDICO: " + citaMedicoFecha.getMedico().getPrimernombre());
        System.out.println("FECHA CITA: " + sdfr.format(citaMedicoFecha.getFecha()));
        System.out.println("HORA CITA: " + citaMedicoFecha.getHora());
        s.close();
        jTable1.setModel(modelo);
        jCalendario.setEnabled(true);
        FechasCargadas();
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
        jLabel4 = new javax.swing.JLabel();
        cmbEstadoCita = new javax.swing.JComboBox();

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

        jCalendario.setEnabled(false);
        jCalendario.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendarioPropertyChange(evt);
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Realizar Cita");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cmbID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID" }));

        jLabel4.setText("Estado de la Cita:");

        cmbEstadoCita.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(342, 342, 342))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCalendario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(190, 190, 190)
                                        .addComponent(cmbID, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbPacientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbEspecialidad, 0, 459, Short.MAX_VALUE)
                                    .addComponent(cmbMedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbEstadoCita, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(15, 15, 15)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmbPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbEstadoCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(jCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbID, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(43, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(43, 43, 43))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        try {
            setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FrameCitas.class.getName()).log(Level.SEVERE, null, ex);
        }
        ListarTodasCitas();
        jCalendario.setMinSelectableDate(hoy);
        llenarComboCitas();
        llenarComboPacientes();
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

    int lunes, martes, miercoles, jueves, viernes, sabado, domingo;

    public void FechasCargadas() {
        if (medicoDias.isLunes()) {
            lunes = 2;
        }
        if (medicoDias.isMartes()) {
            martes = 3;
        }
        if (medicoDias.isMiercoles()) {
            miercoles = 4;
        }
        if (medicoDias.isJueves()) {
            jueves = 5;
        }
        if (medicoDias.isViernes()) {
            viernes = 6;
        }
        if (medicoDias.isSabado()) {
            sabado = 7;
        }
        if (medicoDias.isDomingo()) {
            domingo = 1;
        }

    }

    Date selectedDate;
    Calendar today;
    boolean diaTrabajo = false;

    public void TablaCitaMedico(Date fechaSeleccionada) {

        String estado = "";
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        SimpleDateFormat sdfr = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("NUEVA HORA: " + citaMedicoFecha.getHora());

        for (Cita ccc : lstCitaMedico) {
            ccc.setHora(citaMedicoFecha.getHora().replace(':', ' '));
            for (int i = horaInicioC; i <= horaFinalC; i++) {

                if (sdfr.format(fechaSeleccionada).equals(sdfr.format(ccc.getFecha())) && ((ccc.getHora().startsWith(String.valueOf(i)))) && (ccc.getMedico().getIdMedico()).equals(idMedicoHorario)) {
                    estado = "Ocupado por " + ccc.getPaciente().getNombre() + " " + ccc.getPaciente().getApellido();
                } else {
                    estado = "Disponible";
                }

                modelo.addRow(new Object[]{i + ":00", estado});

            }
        }
        jTable1.setModel(modelo);
    }


    private void jCalendarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendarioPropertyChange
        // TODO add your handling code here:
        today = Calendar.getInstance();
        selectedDate = ((JCalendar) evt.getSource()).getDate();
        System.out.println("FECHA " + selectedDate);
        today.setTime(selectedDate);
        if (today.get(Calendar.DAY_OF_WEEK) == lunes || today.get(Calendar.DAY_OF_WEEK) == martes || today.get(Calendar.DAY_OF_WEEK) == miercoles || today.get(Calendar.DAY_OF_WEEK) == jueves || today.get(Calendar.DAY_OF_WEEK) == viernes || today.get(Calendar.DAY_OF_WEEK) == sabado || today.get(Calendar.DAY_OF_WEEK) == domingo) {
            System.out.println("Dia Disponible");

            //  ValidacionHoraInicio(horarioCitaMedico.getHoraEntrada());
            //  ValidacionHoraFinal(horarioCitaMedico.getHoraSalida());
            diaTrabajo = true;
            limpiar();
            TablaCitaMedico(selectedDate);
        } else {
            System.out.println("Dia Indispuesto");
            diaTrabajo = false;
        }

        System.out.println("FECHA: " + today.get(Calendar.DAY_OF_WEEK));
        /*Domingo =1, Lunes=2, Martes=3, Miercoles=4, Jueves=5, Viernes=6, Sabado=7*/
    }//GEN-LAST:event_jCalendarioPropertyChange

    String HoraCita = "";

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int fila = this.jTable1.getSelectedRow();
        HoraCita = jTable1.getValueAt(fila, 0).toString();
    }//GEN-LAST:event_jTable1MouseClicked
    Medico medico;
    Paciente paciente;
    Date fecha;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ObtenerPacienteSeleccionado(cmbPacientes.getSelectedIndex());
        fecha = today.getTime();

        //SimpleDateFormat sdfr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfr = new SimpleDateFormat("yyyy-MM-dd");
        boolean Estado = true;
        if (cmbEstadoCita.getSelectedItem().toString().equals("Activo")) {
            Estado = true;
        }
        if (cmbEstadoCita.getSelectedItem().toString().equals("Inactivo")) {
            Estado = false;
        }
        if (!diaTrabajo) {
            JOptionPane.showMessageDialog(this, "Medico no disponible en el dia seleccionado", "Medico Indisponible", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (HoraCita.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una hora de consulta", "Informacion del Sistema", JOptionPane.INFORMATION_MESSAGE);
        } else if (today.get(Calendar.DAY_OF_WEEK) == lunes || today.get(Calendar.DAY_OF_WEEK) == martes || today.get(Calendar.DAY_OF_WEEK) == miercoles || today.get(Calendar.DAY_OF_WEEK) == jueves || today.get(Calendar.DAY_OF_WEEK) == viernes || today.get(Calendar.DAY_OF_WEEK) == sabado || today.get(Calendar.DAY_OF_WEEK) == domingo) {
            String fechaGuardar = sdfr.format(fecha);
            System.out.println("FECHA: " + fechaGuardar);
            GuardarCitaMedica(fechaGuardar, HoraCita, Estado);
        } else {
            JOptionPane.showMessageDialog(this, "EL dia elegido " + selectedDate.toString() + "\n el medico " + "no puede trabajar", "Fecha Erronea", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

//    Insert into Cita(id_medico,id_paciente,fecha,hora,estado) values(1,1,'2015-08-06','2015-08-06 11:00:00',true);
    public void GuardarCitaMedica(String fechaGuardada, String horaCita, boolean Estado) {
        DAO df = new DAO(sf);
        System.out.println("ID MEDICO:" + MedicoBuscado);
        System.out.println("ID PACIENTE:" + idPacienteGuardar);
        System.out.println("FECHA DE LA CITA:" + fechaGuardada);
        System.out.println("HORA DE CITA:" + horaCita);
        System.out.println("ESTADO CITA:" + Estado);
        int citaGuardada;
        citaGuardada = DAO.GuardarCita(MedicoBuscado, idPacienteGuardar, fechaGuardada, horaCita, Estado);
        if (citaGuardada != -1) {
            JOptionPane.showMessageDialog(this, "Cita Registrada", "Guardado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Error en la cita", "Error de Codigo", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbEspecialidad;
    private javax.swing.JComboBox cmbEstadoCita;
    private javax.swing.JComboBox cmbID;
    private javax.swing.JComboBox cmbMedico;
    private javax.swing.JComboBox cmbPacientes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JCalendar jCalendario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
