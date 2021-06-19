package com.codegym.repository;

import com.codegym.model.Img;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ImgRepository implements IImgRepository{
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Img> findAll() {
         TypedQuery<Img> query = em.createQuery("select c from Img c",Img.class);
         return query.getResultList();
    }

    @Override
    public Img findById(Long id) {
        TypedQuery<Img> query = em.createQuery("select c from Img c where  c.id=:id", Img.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Img img) {
        if (img.getId() != null) {
            em.merge(img);
        } else {
            em.persist(img);
        }
    }

    @Override
    public void remove(Long id) {
        Img img = findById(id);
        if (img != null) {
            em.remove(img);
        }

    }
}
