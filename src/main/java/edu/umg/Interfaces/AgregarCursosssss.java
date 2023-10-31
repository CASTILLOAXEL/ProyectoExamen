package edu.umg.Interfaces;
//
//import edu.umg.DAO.CursosDAO;
//import edu.umg.DTO.CursosDTO;
//
//import javax.swing.*;
//import javax.swing.border.TitledBorder;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//public class AgregarCursosssss extends JFrame {
//    private CursosDAO cursosDAO = new CursosDAO();
//    private JTextField idField;
//    private JTextField courseNameField;
//    private JTextField professorField;
//    private JButton addCourseButton;
//    private JButton updateCourseButton;
//    private JButton deleteCourseButton;
//    private JTextArea courseListTextArea;
//
//    public AgregarCursosssss() {
//        // Configura la ventana principal
//        setTitle("Gestión de Cursos");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(600, 600);
//        setLayout(new GridLayout(8, 2));
//
//        // Componentes de la interfaz gráfica para cursos
//        JLabel idLabel = new JLabel("ID del Curso:");
//        idField = new JTextField();
//        JLabel courseNameLabel = new JLabel("Nombre del Curso:");
//        courseNameField = new JTextField();
//        JLabel professorLabel = new JLabel("Profesor:");
//        professorField = new JTextField();
//        addCourseButton = new JButton("Agregar Curso");
//        updateCourseButton = new JButton("Actualizar Curso");
//        deleteCourseButton = new JButton("Eliminar Curso");
//
//        // JTextArea para mostrar la lista de cursos
//        courseListTextArea = new JTextArea(40, 40);
//        courseListTextArea.setEditable(false);
//        JScrollPane scrollPane = new JScrollPane(courseListTextArea);
//        TitledBorder border = BorderFactory.createTitledBorder("Lista de Cursos");
//        scrollPane.setBorder(border);
//
//
//        // Agregar componentes a la ventana
//        add(idLabel);
//        add(idField);
//        add(courseNameLabel);
//        add(courseNameField);
//        add(professorLabel);
//        add(professorField);
//        add(addCourseButton);
//        add(updateCourseButton);
//        add(deleteCourseButton);
//        add(scrollPane);
//
//        // Cargar la lista de cursos al abrir la ventana
//        cargarListaCursos();
//
//        // Configurar ActionListener para los botones de cursos
//        addCourseButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                agregarCurso();
//            }
//        });
//
//        updateCourseButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                actualizarCurso();
//            }
//        });
//
//        deleteCourseButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                eliminarCurso();
//            }
//        });
//    }
//
//    private void cargarListaCursos() {
//        List<CursosDTO> cursos = cursosDAO.obtenerTodosLosCursos();
//        courseListTextArea.setText("");
//        for (CursosDTO curso : cursos) {
//            courseListTextArea.append("ID: " + curso.getIdCurso() + "\n");
//            courseListTextArea.append("Nombre del Curso: " + curso.getNombreCurso() + "\n");
//            courseListTextArea.append("Profesor: " + curso.getProfesor() + "\n");
//            courseListTextArea.append("\n");
//        }
//    }
//
//    private void agregarCurso() {
//        int id = Integer.parseInt(idField.getText());
//        String nombreCurso = courseNameField.getText();
//        String profesor = professorField.getText();
//        CursosDTO curso = new CursosDTO();
//        curso.setIdCurso(id);
//        curso.setNombreCurso(nombreCurso);
//        curso.setProfesor(profesor);
//        cursosDAO.agregarCurso(curso);
//        JOptionPane.showMessageDialog(this, "Curso agregado correctamente.");
//        limpiarCampos();
//        cargarListaCursos(); // Actualizar la lista después de agregar un curso
//    }
//
//    private void actualizarCurso() {
//        int idCurso = Integer.parseInt(idField.getText());
//        String nombreCurso = courseNameField.getText();
//        String profesor = professorField.getText();
//        CursosDTO curso = cursosDAO.obtenerCurso(idCurso);
//        if (curso != null) {
//            curso.setNombreCurso(nombreCurso);
//            curso.setProfesor(profesor);
//            cursosDAO.actualizarCurso(curso);
//            JOptionPane.showMessageDialog(this, "Curso actualizado correctamente.");
//            limpiarCampos();
//            cargarListaCursos(); // Actualizar la lista después de actualizar un curso
//        } else {
//            JOptionPane.showMessageDialog(this, "No se encontró el curso con ID " + idCurso);
//        }
//    }
//
//    private void eliminarCurso() {
//        int idCurso = Integer.parseInt(idField.getText());
//        CursosDTO curso = cursosDAO.obtenerCurso(idCurso);
//        if (curso != null) {
//            cursosDAO.eliminarCurso(curso);
//            JOptionPane.showMessageDialog(this, "Curso eliminado correctamente.");
//            limpiarCampos();
//            cargarListaCursos(); // Actualizar la lista después de eliminar un curso
//        } else {
//            JOptionPane.showMessageDialog(this, "No se encontró el curso con ID " + idCurso);
//        }
//    }
//
//    private void limpiarCampos() {
//        idField.setText("");
//        courseNameField.setText("");
//        professorField.setText("");
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                AgregarCursosssss app = new AgregarCursosssss();
//                app.setVisible(true);
//            }
//        });
//    }
//}
//BUENO FUNCIONANDO
//import edu.umg.DAO.CursosDAO;
//import edu.umg.DTO.CursosDTO;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class AgregarCursos extends JFrame {
//    private CursosDAO cursosDAO = new CursosDAO();
//    private JTextField idField;
//    private JTextField courseNameField;
//    private JTextField professorField;
//    private JButton addCourseButton;
//    private JButton updateCourseButton;
//    private JButton deleteCourseButton;
//
//    public AgregarCursos() {
//        // Configura la ventana principal
//        setTitle("Gestión de Cursos");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(400, 200);
//        setLayout(new GridLayout(6, 2));
//
//        // Componentes de la interfaz gráfica para cursos
//        JLabel idLabel = new JLabel("ID del Curso:");
//        idField = new JTextField();
//        JLabel courseNameLabel = new JLabel("Nombre del Curso:");
//        courseNameField = new JTextField();
//        JLabel professorLabel = new JLabel("Profesor:");
//        professorField = new JTextField();
//        addCourseButton = new JButton("Agregar Curso");
//        updateCourseButton = new JButton("Actualizar Curso");
//        deleteCourseButton = new JButton("Eliminar Curso");
//
//        // Agregar componentes a la ventana
//        add(idLabel);
//        add(idField);
//        add(courseNameLabel);
//        add(courseNameField);
//        add(professorLabel);
//        add(professorField);
//        add(addCourseButton);
//        add(updateCourseButton);
//        add(deleteCourseButton);
//
//        // Configurar ActionListener para los botones de cursos
//        addCourseButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                agregarCurso();
//            }
//        });
//
//        updateCourseButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                actualizarCurso();
//            }
//        });
//
//        deleteCourseButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                eliminarCurso();
//            }
//        });
//    }
//
//    private void agregarCurso() {
//        int id = Integer.parseInt(idField.getText());
//        String nombreCurso = courseNameField.getText();
//        String profesor = professorField.getText();
//        CursosDTO curso = new CursosDTO();
//        curso.setIdCurso(id);
//        curso.setNombreCurso(nombreCurso);
//        curso.setProfesor(profesor);
//        cursosDAO.agregarCurso(curso);
//        JOptionPane.showMessageDialog(this, "Curso agregado correctamente.");
//        limpiarCampos();
//    }
//
//    private void actualizarCurso() {
//        int idCurso = Integer.parseInt(idField.getText());
//        String nombreCurso = courseNameField.getText();
//        String profesor = professorField.getText();
//        CursosDTO curso = cursosDAO.obtenerCurso(idCurso);
//        if (curso != null) {
//            curso.setNombreCurso(nombreCurso);
//            curso.setProfesor(profesor);
//            cursosDAO.actualizarCurso(curso);
//            JOptionPane.showMessageDialog(this, "Curso actualizado correctamente.");
//            limpiarCampos();
//        } else {
//            JOptionPane.showMessageDialog(this, "No se encontró el curso con ID " + idCurso);
//        }
//    }
//
//    private void eliminarCurso() {
//        int idCurso = Integer.parseInt(idField.getText());
//        CursosDTO curso = cursosDAO.obtenerCurso(idCurso);
//        if (curso != null) {
//            cursosDAO.eliminarCurso(curso);
//            JOptionPane.showMessageDialog(this, "Curso eliminado correctamente.");
//            limpiarCampos();
//        } else {
//            JOptionPane.showMessageDialog(this, "No se encontró el curso con ID " + idCurso);
//        }
//    }
//
//    private void limpiarCampos() {
//        idField.setText("");
//        courseNameField.setText("");
//        professorField.setText("");
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                AgregarCursos app = new AgregarCursos();
//                app.setVisible(true);
//            }
//        });
//    }
//}
