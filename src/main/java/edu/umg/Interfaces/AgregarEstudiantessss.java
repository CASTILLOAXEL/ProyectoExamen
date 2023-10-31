package edu.umg.Interfaces;
//import edu.umg.DAO.EstudiantesDAO;
//import edu.umg.DTO.EstudiantesDTO;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class AgregarEstudiantessss extends JFrame {
//    private EstudiantesDAO estudiantesDAO = new EstudiantesDAO();
//    private JTextField idField;
//    private JTextField nameField;
//    private JTextField lastNameField;
//    private JTextField emailField;
//    private JButton addButton;
//    private JButton updateButton;
//    private JButton deleteButton;
//
//    public AgregarEstudiantessss() {
//        // Configura la ventana principal
//        setTitle("Gestión de Estudiantes");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(400, 300);
//        setLayout(new GridLayout(7, 2)); // Aumenta la cuadrícula para acomodar el campo "ID".
//
//        // Componentes de la interfaz gráfica
//        JLabel idLabel = new JLabel("ID:");
//        idField = new JTextField();
//        JLabel nameLabel = new JLabel("Nombre:");
//        nameField = new JTextField();
//        JLabel lastNameLabel = new JLabel("Apellido:");
//        lastNameField = new JTextField();
//        JLabel emailLabel = new JLabel("Correo Electrónico:");
//        emailField = new JTextField();
//        addButton = new JButton("Agregar");
//        updateButton = new JButton("Actualizar");
//        deleteButton = new JButton("Eliminar");
//
//        // Agregar componentes a la ventana
//        add(idLabel);
//        add(idField);
//        add(nameLabel);
//        add(nameField);
//        add(lastNameLabel);
//        add(lastNameField);
//        add(emailLabel);
//        add(emailField);
//        add(addButton);
//        add(updateButton);
//        add(deleteButton);
//
//        // Configurar ActionListener para los botones
//        addButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                agregarEstudiante();
//            }
//        });
//
//        updateButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                actualizarEstudiante();
//            }
//        });
//
//        deleteButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                eliminarEstudiante();
//            }
//        });
//    }
//
//    private void agregarEstudiante() {
//        int id = Integer.parseInt(idField.getText());
//        String nombre = nameField.getText();
//        String apellido = lastNameField.getText();
//        String email = emailField.getText();
//        EstudiantesDTO estudiante = new EstudiantesDTO();
//        estudiante.setIdEstudiante(id); // Establece el ID del estudiante.
//        estudiante.setNombre(nombre);
//        estudiante.setApellido(apellido);
//        estudiante.setEmail(email);
//        estudiantesDAO.guardarEstudiante(estudiante);
//        JOptionPane.showMessageDialog(this, "Estudiante agregado correctamente.");
//        limpiarCampos();
//    }
//
//    private void actualizarEstudiante() {
//        int id = Integer.parseInt(idField.getText());
//        String nombre = nameField.getText();
//        String apellido = lastNameField.getText();
//        String email = emailField.getText();
//        EstudiantesDTO estudiante = estudiantesDAO.obtenerEstudiante(id);
//        if (estudiante != null) {
//            estudiante.setNombre(nombre);
//            estudiante.setApellido(apellido);
//            estudiante.setEmail(email);
//            estudiantesDAO.actualizarEstudiante(estudiante);
//            JOptionPane.showMessageDialog(this, "Estudiante actualizado correctamente.");
//            limpiarCampos();
//        } else {
//            JOptionPane.showMessageDialog(this, "No se encontró el estudiante con ID " + id);
//        }
//    }
//
//    private void eliminarEstudiante() {
//        int id = Integer.parseInt(idField.getText());
//        EstudiantesDTO estudiante = estudiantesDAO.obtenerEstudiante(id);
//        if (estudiante != null) {
//            estudiantesDAO.eliminarEstudiante(estudiante);
//            JOptionPane.showMessageDialog(this, "Estudiante eliminado correctamente.");
//            limpiarCampos();
//        } else {
//            JOptionPane.showMessageDialog(this, "No se encontró el estudiante con ID " + id);
//        }
//    }
//
//    private void limpiarCampos() {
//        idField.setText("");
//        nameField.setText("");
//        lastNameField.setText("");
//        emailField.setText("");
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                AgregarEstudiantessss app = new AgregarEstudiantessss();
//                app.setVisible(true);
//            }
//        });
//    }
//}
//
//
////import edu.umg.DAO.EstudiantesDAO;
//import edu.umg.DTO.EstudiantesDTO;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class StudentManagementApp extends JFrame {
//    private EstudiantesDAO estudiantesDAO = new EstudiantesDAO();
//    private JTextField idField;
//    private JTextField nameField;
//    private JTextField lastNameField;  // Nuevo campo de apellido
//    private JTextField emailField;  // Nuevo campo de correo electrónico
//    private JButton addButton;
//    private JButton updateButton;
//    private JButton deleteButton;
//
//    public StudentManagementApp() {
//        // Configura la ventana principal
//        setTitle("Gestión de Estudiantes");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(400, 300);  // Aumenta el tamaño de la ventana para acomodar los nuevos campos
//        setLayout(new GridLayout(6, 2));  // Aumenta el diseño de la cuadrícula
//
//        // Componentes de la interfaz gráfica
//        JLabel idLabel = new JLabel("ID:");
//        idField = new JTextField();
//        JLabel nameLabel = new JLabel("Nombre:");
//        nameField = new JTextField();
//        JLabel lastNameLabel = new JLabel("Apellido:");  // Nuevo label de apellido
//        lastNameField = new JTextField();  // Nuevo campo de apellido
//        JLabel emailLabel = new JLabel("Correo Electrónico:");  // Nuevo label de correo electrónico
//        emailField = new JTextField();  // Nuevo campo de correo electrónico
//        addButton = new JButton("Agregar");
//        updateButton = new JButton("Actualizar");
//        deleteButton = new JButton("Eliminar");
//
//        // Agregar componentes a la ventana
//        add(idLabel);
//        add(idField);
//        add(nameLabel);
//        add(nameField);
//        add(lastNameLabel);
//        add(lastNameField);  // Agrega el campo de apellido
//        add(emailLabel);
//        add(emailField);
//        add(addButton);
//        add(updateButton);
//        add(deleteButton);
//
//        // Configurar ActionListener para los botones
//        addButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                agregarEstudiante();
//            }
//        });
//
//        updateButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                actualizarEstudiante();
//            }
//        });
//
//        deleteButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                eliminarEstudiante();
//            }
//        });
//    }
//
//    private void agregarEstudiante() {
//        String nombre = nameField.getText();
//        String apellido = lastNameField.getText();  // Obtén el valor del campo de apellido
//        String email = emailField.getText();  // Obtén el valor del campo de correo electrónico
//        EstudiantesDTO estudiante = new EstudiantesDTO();
//        estudiante.setNombre(nombre);
//        estudiante.setApellido(apellido);  // Establece el apellido en el objeto EstudiantesDTO
//        estudiante.setEmail(email);  // Establece el correo electrónico en el objeto EstudiantesDTO
//        estudiantesDAO.guardarEstudiante(estudiante);
//        JOptionPane.showMessageDialog(this, "Estudiante agregado correctamente.");
//        limpiarCampos();
//    }
//
//    private void actualizarEstudiante() {
//        String idText = idField.getText();
//        String nombre = nameField.getText();
//        String apellido = lastNameField.getText();  // Obtén el valor del campo de apellido
//        String email = emailField.getText();  // Obtén el valor del campo de correo electrónico
//        try {
//            int id = Integer.parseInt(idText);
//            EstudiantesDTO estudiante = estudiantesDAO.obtenerEstudiante(id);
//            if (estudiante != null) {
//                estudiante.setNombre(nombre);
//                estudiante.setApellido(apellido);  // Actualiza el apellido en el objeto EstudiantesDTO
//                estudiante.setEmail(email);  // Actualiza el correo electrónico en el objeto EstudiantesDTO
//                estudiantesDAO.actualizarEstudiante(estudiante);
//                JOptionPane.showMessageDialog(this, "Estudiante actualizado correctamente.");
//                limpiarCampos();
//            } else {
//                JOptionPane.showMessageDialog(this, "No se encontró el estudiante con ID " + id);
//            }
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(this, "ID no válido.");
//        }
//    }
//
//    private void eliminarEstudiante() {
//        String idText = idField.getText();
//        try {
//            int id = Integer.parseInt(idText);
//            EstudiantesDTO estudiante = estudiantesDAO.obtenerEstudiante(id);
//            if (estudiante != null) {
//                estudiantesDAO.eliminarEstudiante(estudiante);
//                JOptionPane.showMessageDialog(this, "Estudiante eliminado correctamente.");
//                limpiarCampos();
//            } else {
//                JOptionPane.showMessageDialog(this, "No se encontró el estudiante con ID " + id);
//            }
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(this, "ID no válido.");
//        }
//    }
//
//    private void limpiarCampos() {
//        idField.setText("");
//        nameField.setText("");
//        lastNameField.setText("");  // Limpia el campo de apellido
//        emailField.setText("");  // Limpia el campo de correo electrónico
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                StudentManagementApp app = new StudentManagementApp();
//                app.setVisible(true);
//            }
//        });
//    }
//}
