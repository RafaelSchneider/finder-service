package com.finder.controller.v1;

import com.finder.facade.FinderFacade;
import com.finder.model.Output;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("finder-service/v1")
public class EndPoint {

    private FinderFacade facade;

    public EndPoint(FinderFacade facade) {
        this.facade = facade;
    }

    @GetMapping("/test")
    public String test(){
        return "Ok";
    }

    @GetMapping("/find")
    public Output find(@RequestParam("reference") String reference){
        return facade.findBooksAndAlbums(reference);
    }


}
