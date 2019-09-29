package com.finder.mapper;

import com.finder.model.BookAlbum;
import com.finder.model.itunes.ItunesResponse;
import com.finder.model.itunes.ItunesData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResponseAlbumMapper {

    public static List<BookAlbum> mapToList(ItunesResponse itunesResponse){
        return itunesResponse.getResults().stream()
                .map(ResponseAlbumMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    private static BookAlbum mapToResponse(ItunesData itunesData){
        return BookAlbum.builder()
                .title(itunesData.getCollectionName())
                .authorsArtists(Arrays.asList(itunesData.getArtistName()))
                .information("Album")
                .build();

    }
}
