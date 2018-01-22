package com.zctech88.SpringBootIntegration.dao;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface filmDao {
    List<HashMap> queryAllFilm();
}
