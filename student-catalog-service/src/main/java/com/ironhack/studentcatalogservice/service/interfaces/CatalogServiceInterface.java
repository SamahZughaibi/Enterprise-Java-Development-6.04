package com.ironhack.studentcatalogservice.service.interfaces;


import com.ironhack.studentcatalogservice.model.Catalog;

public interface CatalogServiceInterface {
    Catalog getCatalog(String courseCode);
}
