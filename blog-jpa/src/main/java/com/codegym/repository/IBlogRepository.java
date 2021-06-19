package com.codegym.repository;

import com.codegym.model.Blog;

public interface IBlogRepository extends IGeneralRepository<Blog> {
    boolean insertWithStoredProcedure(Blog blog);
}
