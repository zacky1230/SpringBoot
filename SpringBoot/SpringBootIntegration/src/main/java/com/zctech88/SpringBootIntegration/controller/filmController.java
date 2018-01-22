package com.zctech88.SpringBootIntegration.controller;

import com.zctech88.SpringBootIntegration.service.filmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("film")
public class filmController {

    @Autowired
    private filmService filmService;

    @RequestMapping("queryAllFilm")
    public List<HashMap> queryAllFilm() {
        return filmService.queryAllFilm();
    }
}
