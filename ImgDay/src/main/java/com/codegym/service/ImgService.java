package com.codegym.service;

import com.codegym.model.Img;
import com.codegym.repository.IImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void save(Img img) throws Exception {
        if ("xyz".equals(img.getFeedback())){
            throw new Exception("Tu ngu khong phu hop\n"+img.getFeedback()+"\n" );
        } else {
            imgRepository.save(img);
        }
    }

}
