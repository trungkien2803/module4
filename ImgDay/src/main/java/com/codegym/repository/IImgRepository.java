package com.codegym.repository;

import com.codegym.model.Img;

import java.util.List;

public interface IImgRepository {
    List<Img> findAll();

    Img findById(Long id);

    void save(Img img);

    void remove(Long id);
}
