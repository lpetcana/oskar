package org.oskar.controller;

import org.oskar.model.Wig;
import org.oskar.repository.DummyRepository;
import org.oskar.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    @RequestMapping(value="/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHello(){
        return "Get a hello from the other side!";
    }



    @RequestMapping(value="/wigs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Wig> getAllWigs(){
        return stockService.getAllWigs();
    }

    @RequestMapping(value="/wigs/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Wig> getWigsByType(@PathVariable("type") String type){
        return stockService.getWigsByType(type);
    }

    @RequestMapping(value="/wigs/{type}/{color}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Wig> getWigsByType(@PathVariable("type") String type,
                                   @PathVariable("color") String color){
        return stockService.getWigsByColor(type, color);
    }


}
