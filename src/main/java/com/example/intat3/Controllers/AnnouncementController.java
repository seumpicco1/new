package com.example.intat3.Controllers;


import com.example.intat3.Dto.AllAnnouncementDto;
import com.example.intat3.Dto.AnnouncementDto;
import com.example.intat3.Entity.Announcement;
import com.example.intat3.services.AnnouncementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://ip22at3.sit.kmutt.ac.th:3000")
@RestController
@RequestMapping("/api/announcements")

public class AnnouncementController {
    @Autowired
    private AnnouncementService service;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping("")
    public List<AllAnnouncementDto> getAllAnnouncement (){

        return  service.getAllAnnouncement();
    }

    @GetMapping("/{id}")
    public AnnouncementDto getById(@PathVariable Integer id){
        return service.getAnnouncementById(id);
    }







}
