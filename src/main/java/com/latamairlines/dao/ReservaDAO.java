package com.latamairlines.dao;

import com.latamairlines.entities.Reserva;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class ReservaDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LatamAirlinesPU");

    public void crearReserva(Reserva reserva) {

        EntityManager manager = emf.createEntityManager();

        try {
            manager.getTransaction().begin();
            manager.persist(reserva);
            manager.getTransaction().commit();
            System.out.println("Reserva creada correctamente");

        } catch (Exception e) {

            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }

            throw e;

        } finally {
            manager.close();
        }
    }

    public Reserva buscarPorId(int id) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Reserva.class, id);
        } finally {
            em.close();
        }
    }

    public List<Reserva> listarReservas() {

        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT r FROM Reserva r", Reserva.class
            ).getResultList();

        } finally {
            em.close();
        }
    }

    public void actualizarReserva(int id, String origen,
            String destino, int pasajeros) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Reserva reserva = em.find(Reserva.class, id);

            if (reserva != null) {

                // ACTUALIZAR DATOS
                reserva.setOrigen(origen);
                reserva.setDestino(destino);
                reserva.setNumeroPasajeros(pasajeros);

                em.getTransaction().commit();

            } else {
                em.getTransaction().rollback();
                throw new IllegalArgumentException("Reserva no encontrada");
            }

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;

        } finally {
            em.close();
        }
    }

    public void eliminarReserva(int id) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Reserva reserva = em.find(Reserva.class, id);

            if (reserva != null) {

                em.remove(reserva);

                em.getTransaction().commit();

                System.out.println("Reserva eliminada correctamente");

            } else {

                System.out.println("Reserva no encontrada");
                em.getTransaction().rollback();
            }

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            throw e;

        } finally {
            em.close();
        }
    }

    public void cerrar() {
        emf.close();
    }
}
