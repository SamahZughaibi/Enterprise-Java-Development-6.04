package com.ironhack.studentcatalogservice.controller;

import com.ironhack.studentcatalogservice.model.*;
import com.ironhack.studentcatalogservice.service.interfaces.CatalogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CatalogController {

    @Autowired
    private CatalogServiceInterface catalogService;

    @GetMapping("/catalogs/course/{courseCode}")
    @ResponseStatus(HttpStatus.OK)
    public Catalog getCatalog(@PathVariable String courseCode) {

        return catalogService.getCatalog(courseCode);
    }
}
