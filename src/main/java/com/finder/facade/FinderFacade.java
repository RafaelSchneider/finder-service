package com.finder.facade;

import com.finder.model.Output;
import com.finder.service.FinderService;
import org.springframework.stereotype.Component;

@Component
public class FinderFacade {

    private FinderService service;

    public FinderFacade(FinderService service) {
        this.service = service;
    }

    public Output findBooksAndAlbums(String reference){
        return Output.builder()
                .bookAlbums(service.findBooksAndAlbuns(reference))
                .build();
    }
}
