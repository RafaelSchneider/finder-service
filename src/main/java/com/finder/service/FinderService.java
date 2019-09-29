package com.finder.service;

import com.finder.client.GoogleClient;
import com.finder.client.ItunesClient;
import com.finder.mapper.ResponseAlbumMapper;
import com.finder.mapper.ResponseBookMapper;
import com.finder.model.BookAlbum;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

@Service
public class FinderService {

    private GoogleClient googleClient;
    private ItunesClient itunesClient;

    public FinderService(GoogleClient googleClient, ItunesClient itunesClient) {
        this.googleClient = googleClient;
        this.itunesClient = itunesClient;
    }

    public List<BookAlbum> findBooksAndAlbuns(String reference){
        return findBooks()
                .andThen(findAlbums(reference))
                .apply(reference);
    }

    private Function<String, List<BookAlbum>> findBooks(){
        return (String reference)->
            ResponseBookMapper.mapToList(googleClient.findBooks(reference));
    }

    private UnaryOperator<List<BookAlbum>> findAlbums(String reference){
        return (List<BookAlbum> bookAlbumList) ->{
            bookAlbumList.addAll(ResponseAlbumMapper.mapToList(itunesClient.findAlbums(reference)));
            bookAlbumList.sort(Comparator.comparing(BookAlbum::getTitle));
            return bookAlbumList;
        };
    }
}
