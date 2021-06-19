package com.codegym.service;

import com.codegym.model.Blog;

public interface IBlogService extends IGeneralService<Blog>{
    boolean insertWithStoredProcedure(Blog blog);
}
