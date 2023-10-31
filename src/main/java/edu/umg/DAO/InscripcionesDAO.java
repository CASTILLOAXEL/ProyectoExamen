package edu.umg.DAO;

import edu.umg.DTO.InscripcionesDTO;
import edu.umg.HibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class InscripcionesDAO {

    // Método para obtener una inscripción por su ID
//    public InscripcionesDTO obtenerInscripcion(int idInscripcion) {
//        InscripcionesDTO inscripcion = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            inscripcion = session.get(InscripcionesDTO.class, idInscripcion);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return inscripcion;
//    }

    // Método para crear una nueva inscripción
    public static void guardarInscripcion(InscripcionesDTO inscripcion) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(inscripcion);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

//    // Método para actualizar los datos de una inscripción existente
//    public void actualizarInscripcion(InscripcionesDTO inscripcion) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            session.update(inscripcion);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//    }

    // Método para eliminar una inscripción
    public void eliminarInscripcion(InscripcionesDTO inscripcion) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(inscripcion);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public static void eliminarInscripcionPorID(int idInscripcion) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            InscripcionesDTO inscripcion = session.get(InscripcionesDTO.class, idInscripcion);
            if (inscripcion != null) {
                session.delete(inscripcion);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static InscripcionesDTO obtenerInscripcionPorID(int idInscripcion) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        InscripcionesDTO inscripcion = session.get(InscripcionesDTO.class, idInscripcion);
        session.close();
        return inscripcion;
    }

    public static void actualizarInscripcion(InscripcionesDTO inscripcion) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(inscripcion);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<InscripcionesDTO> obtenerTodasLasInscripciones() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<InscripcionesDTO> inscripciones = session.createQuery("FROM InscripcionesDTO", InscripcionesDTO.class).list();
        session.close();
        return inscripciones;
    }
}


//    public void inscribirEstudianteEnCurso(int idEstudiante, int idCurso) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            // Iniciar una transacción
//            transaction = session.beginTransaction();
//
//            // Crear una instancia de InscripcionesDTO y establecer las claves foráneas
//            InscripcionesDTO inscripcion = new InscripcionesDTO();
//            inscripcion.setIdEstudiante(idEstudiante);
//            inscripcion.setIdCurso(idCurso);
//
//            // Obtener la fecha actual y establecerla como fecha de inscripción
//            inscripcion.setFechaInscripcion(new Timestamp(System.currentTimeMillis()));
//
//            // Guardar la inscripción en la base de datos
//            session.save(inscripcion);
//
//            // Confirmar la transacción
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//    public List<InscripcionesDTO> obtenerInscripciones() {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            // Crear una consulta para obtener todas las inscripciones
//            Query<InscripcionesDTO> query = session.createQuery("FROM InscripcionesDTO", InscripcionesDTO.class);
//
//            // Ejecutar la consulta y obtener la lista de inscripciones
//            List<InscripcionesDTO> inscripciones = query.list();
//
//            return inscripciones;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//public List<Object[]> obtenerNombresEstudiantesYCursos() {
//    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//        // Crear una consulta que recupere los nombres de estudiantes y cursos
//        Query<Object[]> query = session.createQuery(
//                "SELECT e.nombre, c.nombreCurso " +
//                        "FROM InscripcionesDTO i " +
//                        "JOIN EstudiantesDTO e ON i.idEstudiante = e.idEstudiante " +
//                        "JOIN CursosDTO c ON i.idCurso = c.idCurso", Object[].class);
//
//        // Ejecutar la consulta y obtener una lista de objetos que contienen los nombres
//        List<Object[]> resultados = query.list();
//
//        return resultados;
//    } catch (Exception e) {
//        e.printStackTrace();
//        return null;
//    }
//public List<Object[]> obtenerNombresEstudiantesCursosEIds() {
//    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//        // Crear una consulta que recupere los nombres de estudiantes, cursos y IDs de inscripción
//        Query<Object[]> query = session.createQuery(
//                "SELECT i.idInscripcion, e.nombre, c.nombreCurso " +
//                        "FROM InscripcionesDTO i " +
//                        "JOIN EstudiantesDTO e ON i.idEstudiante = e.idEstudiante " +
//                        "JOIN CursosDTO c ON i.idCurso = c.idCurso", Object[].class);
//
//        // Ejecutar la consulta y obtener una lista de objetos que contienen los datos
//        List<Object[]> resultados = query.list();
//
//        return resultados;
//    } catch (Exception e) {
//        e.printStackTrace();
//        return null;
//    }
//}
//}
