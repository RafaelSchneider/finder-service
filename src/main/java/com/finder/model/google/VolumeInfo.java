package com.finder.model.google;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VolumeInfo {
    private String title;
    private ArrayList<String> authors;

    }
