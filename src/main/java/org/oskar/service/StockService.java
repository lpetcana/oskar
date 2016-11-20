package org.oskar.service;

import org.oskar.model.Wig;
import org.oskar.repository.DummyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StockService {

    @Autowired
    DummyRepository dummyRepository;



    public List<Wig> getAllWigs(){
        return dummyRepository.getWigsList();
    }


    public List<Wig> getWigsByType(final String type){
        return dummyRepository.getWigsList()
                .stream()
                .filter(wig -> wig.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    public List<Wig> getWigsByColor(final String type, final String color){
        return this.getAllWigs().stream()
                .filter(wig->wig.getType().equalsIgnoreCase(type) && wig.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }
}
