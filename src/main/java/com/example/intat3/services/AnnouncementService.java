package com.example.intat3.services;

import com.example.intat3.Dto.AllAnnouncementDto;
import com.example.intat3.Dto.AnnouncementDto;
import com.example.intat3.Entity.Announcement;
import com.example.intat3.repositories.AnnouncementRepository;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementRepository announcementrepository;
        @Autowired
    private ModelMapper modelMapper;

    public AnnouncementDto getAnnouncementById(Integer announcementId) {
        Announcement a = announcementrepository.findById(announcementId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Announcement id " + announcementId +  " " + "does not exist !!!"));
        return modelMapper.map(a,AnnouncementDto.class);
    }

//     public List<Announcement> getByCategory(Integer id){
//         return announcementrepository.findByCategory(id);
//    }
    public List<AllAnnouncementDto> getAllAnnouncement() {
        List<Announcement> aa = announcementrepository.findAll();
        Collections.reverse(aa);
        if(aa.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No Announcement");
        }

        return aa.stream().map(x->modelMapper.map(x, AllAnnouncementDto.class)).collect(Collectors.toList());
    }


}
