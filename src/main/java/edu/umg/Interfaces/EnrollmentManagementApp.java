package edu.umg.Interfaces;

//import edu.umg.DAO.CursosDAO;
//import edu.umg.DAO.EstudiantesDAO;
//import edu.umg.DAO.InscripcionesDAO;
//import edu.umg.DTO.CursosDTO;
//import edu.umg.DTO.EstudiantesDTO;
//import edu.umg.DTO.InscripcionesDTO;
//import edu.umg.HibernateUtil.HibernateUtil;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//public class EnrollmentManagementApp extends JFrame {
//    private CursosDAO cursosDAO = new CursosDAO();
//    private EstudiantesDAO estudiantesDAO = new EstudiantesDAO();
//    private InscripcionesDAO inscripcionesDAO = new InscripcionesDAO();
//
//    private JComboBox<EstudiantesDTO> studentComboBox;
//    private JComboBox<CursosDTO> courseComboBox;
//    private JButton enrollButton;
//    private JButton updateEnrollmentButton;
//    private JButton deleteEnrollmentButton;
//
//    public EnrollmentManagementApp() {
//        // Configura la ventana principal
//        setTitle("Gestión de Inscripciones");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(400, 250);
//        setLayout(new GridLayout(6, 2));
//
//        // Componentes de la interfaz gráfica para inscripciones
//        JLabel studentLabel = new JLabel("Estudiante:");
//        studentComboBox = new JComboBox<>();
//        JLabel courseLabel = new JLabel("Curso:");
//        courseComboBox = new JComboBox<>();
//        enrollButton = new JButton("Inscribir");
//        updateEnrollmentButton = new JButton("Actualizar Inscripción");
//        deleteEnrollmentButton = new JButton("Eliminar Inscripción");
//
//        // Obtener la lista de estudiantes y cursos
//        List<EstudiantesDTO> estudiantes = estudiantesDAO.obtenerTodosEstudiantes();
//        List<CursosDTO> cursos = cursosDAO.obtenerTodosCursos();
//
//        // Llenar los JComboBox con estudiantes y cursos
//        for (EstudiantesDTO estudiante : estudiantes) {
//            studentComboBox.addItem(estudiante);
//        }
//        for (CursosDTO curso : cursos) {
//            courseComboBox.addItem(curso);
//        }
//
//        // Agregar componentes a la ventana
//        add(studentLabel);
//        add(studentComboBox);
//        add(courseLabel);
//        add(courseComboBox);
//        add(enrollButton);
//        add(updateEnrollmentButton);
//        add(deleteEnrollmentButton);
//
//        // Configurar ActionListener para los botones de inscripciones
//        enrollButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                inscribirEstudianteEnCurso();
//            }
//        });
//
//        updateEnrollmentButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                actualizarInscripcion();
//            }
//        });
//
//        deleteEnrollmentButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                eliminarInscripcion();
//            }
//        });
//    }
//
//    private void inscribirEstudianteEnCurso() {
//        EstudiantesDTO estudiante = (EstudiantesDTO) studentComboBox.getSelectedItem();
//        CursosDTO curso = (CursosDTO) courseComboBox.getSelectedItem();
//
//        if (estudiante != null && curso != null) {
//            InscripcionesDTO inscripcion = new InscripcionesDTO();
//            inscripcion.setEstudiante(estudiante);
//            inscripcion.setCurso(curso);
//
//            inscripcionesDAO.guardarInscripcion(inscripcion);
//            JOptionPane.showMessageDialog(this, "Estudiante inscrito en el curso correctamente.");
//            limpiarCampos();
//        } else {
//            JOptionPane.showMessageDialog(this, "Selecciona un estudiante y un curso.");
//        }
//    }
//
//    private void actualizarInscripcion() {
//        // Implementa la actualización de inscripción aquí
//    }
//
//    private void eliminarInscripcion() {
//        // Implementa la eliminación de inscripción aquí
//    }
//
//    private void limpiarCampos() {
//        studentComboBox.setSelectedIndex(0);
//        courseComboBox.setSelectedIndex(0);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                EnrollmentManagementApp app = new EnrollmentManagementApp();
//                app.setVisible(true);
//            }
//        });
//    }
//}
