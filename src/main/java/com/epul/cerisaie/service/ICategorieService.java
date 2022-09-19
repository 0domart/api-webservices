package com.epul.cerisaie.service;

import com.epul.cerisaie.domains.CategorieEntity;

import java.util.List;

public interface ICategorieService {

    public List<CategorieEntity> getAllCategories();

    public CategorieEntity getCategorieById(String id) ;

}