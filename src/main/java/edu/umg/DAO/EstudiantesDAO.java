package edu.umg.DAO;

import edu.umg.DTO.EstudiantesDTO;
import edu.umg.HibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EstudiantesDAO {

    public EstudiantesDTO obtenerEstudiante(int idEstudiante) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(EstudiantesDTO.class, idEstudiante);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void guardarEstudiante(EstudiantesDTO estudiante) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Iniciar una transacción
            transaction = session.beginTransaction();

            // Guardar el estudiante en la base de datos
            session.save(estudiante);

            // Confirmar la transacción
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void actualizarEstudiante(EstudiantesDTO estudiante) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(estudiante);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void eliminarEstudiante(EstudiantesDTO estudiante) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(estudiante);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public List<EstudiantesDTO> obtenerTodosLosEstudiantes() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Utiliza HQL (Hibernate Query Language) para obtener todos los estudiantes
            String hql = "FROM EstudiantesDTO";
            Query<EstudiantesDTO> query = session.createQuery(hql, EstudiantesDTO.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
//
//import edu.umg.DTO.EstudiantesDTO;
//import edu.umg.HibernateUtil.HibernateUtil;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//public class EstudiantesDAO {
//
//    //Metodo para leer los estudiantes ya Guardados en la base de Datos
//    public EstudiantesDTO obtenerEstudiante(int idEstudiante) {
//       EstudiantesDTO estudiante = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            estudiante = session.get(EstudiantesDTO.class, idEstudiante);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return estudiante;
//    }
//    //Metodo para Actualizar Estudiantes ya Guardados en la base de Datos
//    public void actualizarEstudiante(EstudiantesDTO estudiante) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            // Iniciar una transacción
//            transaction = session.beginTransaction();
//
//            // Guardar el estudiante en la base de datos
//            session.update(estudiante);
//
//            // Confirmar la transacción
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }}
//
//
//    public void guardarEstudiante(EstudiantesDTO estudiante) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            // Iniciar una transacción
//            transaction = session.beginTransaction();
//
//            // Guardar el estudiante en la base de datos
//            session.save(estudiante);
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
//
//public void eliminarEstudiante(EstudiantesDTO estudiante)
//{
//    Transaction transaction = null;
//    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//        transaction = session.beginTransaction();
//        session.delete(estudiante);
//        transaction.commit();
//    } catch (Exception e) {
//        if (transaction != null) {
//            transaction.rollback();
//        }
//        e.printStackTrace();
//    }
//}
//    public void eliminarEstudiante(int idEstudiante) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            // Iniciar una transacción
//            transaction = session.beginTransaction();
//
//            // Obtener el estudiante por su ID y eliminarlo
//            EstudiantesDTO estudiante = session.get(EstudiantesDTO.class, idEstudiante);
//            if (estudiante != null) {
//                session.delete(estudiante);
//            }
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
