package com.codegym.service;

import com.codegym.model.Img;

import java.util.List;

public interface IImgService {
    List<Img> findAll();

    Img findOne(Long id);

    void save(Img img) throws Exception;
}
