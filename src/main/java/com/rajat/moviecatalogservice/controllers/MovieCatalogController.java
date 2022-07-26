package com.rajat.moviecatalogservice.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajat.moviecatalogservice.Model.CatalogItem;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
    
    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(String userId){
         return Collections.singletonList(
            new CatalogItem("Bahubali", "GOAT", "4")
         );
    }
}
