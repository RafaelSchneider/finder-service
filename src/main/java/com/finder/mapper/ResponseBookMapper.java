package com.finder.mapper;


import com.finder.model.BookAlbum;
import com.finder.model.google.GoogleResponse;
import com.finder.model.google.Item;

import java.util.List;
import java.util.stream.Collectors;

public class ResponseBookMapper {

    public static List<BookAlbum> mapToList(GoogleResponse googleResponse){
        return googleResponse.getItems().stream()
                .map(ResponseBookMapper::map)
                .collect(Collectors.toList());
    }

    private static BookAlbum map(Item item){
        return BookAlbum.builder()
                .title(item.getVolumeInfo().getTitle())
                .authorsArtists(item.getVolumeInfo().getAuthors())
                .information("Book")
                .build();
    }

}
