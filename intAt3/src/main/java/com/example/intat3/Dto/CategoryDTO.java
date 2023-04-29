package com.example.intat3.Dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
    private String announcementCategory ;

    public  String getName(){
        return  announcementCategory;
    }

}
