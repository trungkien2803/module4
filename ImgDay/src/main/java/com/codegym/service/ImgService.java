package com.codegym.service;

import com.codegym.model.Img;
import com.codegym.repository.IImgRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ImgService implements IImgService {
    @Autowired
    IImgRepository imgRepository;

    @Override
    public List<Img> findAll() {
        return imgRepository.findAll();
    }

    @Override
    public Img findOne(Long id) {
        return imgRepository.findById(id);
    }

    @Override
    public void save(Img img) {
        imgRepository.save(img);
    }

}
