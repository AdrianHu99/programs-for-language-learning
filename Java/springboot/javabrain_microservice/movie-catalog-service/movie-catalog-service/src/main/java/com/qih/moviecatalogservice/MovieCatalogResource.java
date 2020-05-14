package com.qih.moviecatalogservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

// 1. How do I make this as a REST resource? Add an annotation!
@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    // 2. Make this mapping to certain request
    @RequestMapping("/{var1}")
    public List<CatalogItem> getCatalog(@PathVariable("var1") String userId) {
        return Collections.singletonList(
                new CatalogItem("Scent of a woman", "Test", 5)
        );
    }
}
