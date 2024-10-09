package dev.example.restaurantManager.controller;


import dev.example.restaurantManager.model.Menu;
import dev.example.restaurantManager.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/api/v1/menu")
@RestController
public class MenuController {


    @Autowired
    private MenuService menuService;

    @GetMapping("/allMenus")
    public ResponseEntity<List<Menu>> getAllMenus(){
        List<Menu> menus = menuService.getAllMenus();
        HttpHeaders headers1 = getCommonHeaders("get all menus");
        return menus !=null && !menus.isEmpty()
                ? new ResponseEntity<>(menus, headers1, HttpStatus.OK)
                : new ResponseEntity<>(headers1, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
        Menu createdMenu = menuService.createMenu(menu);
        HttpHeaders headers1 = getCommonHeaders("Create new menu");

        return createdMenu !=null
                ? new ResponseEntity<>(createdMenu, headers1,HttpStatus.CREATED)
                : new ResponseEntity<>(headers1,HttpStatus.BAD_REQUEST);
    }




    private HttpHeaders getCommonHeaders(String description) {
        HttpHeaders headers1 = new HttpHeaders();
        headers1.add("desc", description);
        headers1.add("content-type", "application/json");
        headers1.add("date", new Date().toString());
        headers1.add("server", "H2 Database");
        headers1.add("version", "1.0.0");
        headers1.add("menus-count", String.valueOf(menuService.countMenus()));
        headers1.add("object", "menus");
        return headers1;
    }

}
