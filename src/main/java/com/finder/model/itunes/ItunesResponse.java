package com.finder.model.itunes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ItunesResponse {
    private Integer resultCount;
    private ArrayList<ItunesData> results;
}
