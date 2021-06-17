package com.codegym.service;

import com.codegym.model.Img;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ImgService implements IImgService {
    List<Img> imgs = new ArrayList<>();
    private static long autoIncreaseId = 0;
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Img> findAll() {
        String queryStr = "SELECT img FROM Img AS img";
        TypedQuery<Img> query = entityManager.createQuery(queryStr, Img.class);
        return query.getResultList();
    }

    @Override
    public Img findOne(Long id) {
        String queryStr = "SELECT img FROM Img AS img WHERE img.id = :id";
        TypedQuery<Img> query = entityManager.createQuery(queryStr, Img.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Img save(Img img) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Img origin = new Img();
            if(origin.getId()!=null){
                origin = findOne(img.getId());
            }
            origin.setAuthor(img.getAuthor());
            origin.setFeedback(img.getFeedback());
            origin.setMark(img.getMark());
            session.saveOrUpdate(origin);
            transaction.commit();
            return origin;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

}
