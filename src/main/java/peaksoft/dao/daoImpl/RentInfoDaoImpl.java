package peaksoft.dao.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.DataBaseConnection;
import peaksoft.dao.RentInfoDao;
import peaksoft.entities.RentInfo;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class RentInfoDaoImpl implements RentInfoDao, AutoCloseable {
    private final EntityManagerFactory entityManagerFactory = DataBaseConnection.getEntityManagerFactory();
    @Override
    public List<RentInfo> rentInfoBetweenDates(LocalDate fromDate, LocalDate toDate) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<RentInfo> houses = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            houses = entityManager.createQuery("select r from RentInfo r " +
                                    " where r.checkOut between :from and :to",
                            RentInfo.class)
                    .setParameter("from", fromDate)
                    .setParameter("to", toDate)
                    .getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
            System.out.println("Failed: " + e.getMessage());
        } finally {
            entityManager.close();
        }
        return houses;
    }

    @Override
    public Long housesByAgencyIdAndDate(Long agencyId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Long countHouse = 0L;
        try {
            entityManager.getTransaction().begin();

            countHouse = entityManager.createQuery("""
            select count(r) from RentInfo r
            where r.agency.id =:agencyId and r.checkIn <=:currentDate
            and r.checkOut >=:currentDate
            """, Long.class)
                    .setParameter("agencyId", agencyId)
                    .setParameter("currentDate", LocalDate.now())
                    .getSingleResult();

            entityManager.getTransaction().commit();
        }catch (Exception e){
            if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
            System.out.println("Failed: " + e.getMessage());
        }finally {
            entityManager.close();
        }
        return countHouse;
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}