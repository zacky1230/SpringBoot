package com.zctech88.SpringBootIntegration.service.impl;

import com.zctech88.SpringBootIntegration.dao.filmDao;
import com.zctech88.SpringBootIntegration.service.filmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class filmServiceImpl implements filmService {

    @Resource
    private filmDao filmDao;

    @Override
    public List<HashMap> queryAllFilm() {
        return filmDao.queryAllFilm();
    }
}
