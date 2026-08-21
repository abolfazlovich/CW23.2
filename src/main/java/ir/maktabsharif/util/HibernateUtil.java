package ir.maktabsharif.util;

import jakarta.persistence.*;

import java.util.Optional;
import java.util.function.Function;

public class HibernateUtil {

    public static final String PERSISTENCE_UNIT = "default";

    private static EntityManagerFactory emf;

    private HibernateUtil() {
    }

    public static synchronized EntityManagerFactory emf() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return emf;
    }

    public static EntityManager em() {
        return emf().createEntityManager();
    }

    public static <T> T read(Function<EntityManager, T> operation) {
        EntityManager em = em();
        try (em){
            return operation.apply(em);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public static <T> T inTxReturn(Function<EntityManager, T> operation) {
        EntityManager em = em();
        EntityTransaction tx = em.getTransaction();


        try (em) {
            tx.begin();
            T result = operation.apply(em);
            tx.commit();
            return result;
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }

    public static PersistenceUnitUtil getPersistenceUnitUtil() {
        return emf().getPersistenceUnitUtil();
    }

    public static void getState(EntityManager em, Object entity) {
        Object id = getPersistenceUnitUtil().getIdentifier(entity);
        boolean managed = em.contains(entity);
        String state = managed
                ? "MANAGED"
                : Optional.ofNullable(id).isEmpty() ? "TRANSIENT" : "DETACHED";
        System.out.println(state);
    }


    public static void shutdown() {

        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }


}