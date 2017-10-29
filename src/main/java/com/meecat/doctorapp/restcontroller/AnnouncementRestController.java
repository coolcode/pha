package com.meecat.doctorapp.restcontroller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.meecat.doctorapp.domain.*;
import com.meecat.doctorapp.service.*;

//Directly mapping to src/main/java/resources/webapp/resoures/js/app/announcement.js file via URLs.
@RestController()
@Transactional
@RequestMapping("/api/amnt")
public class AnnouncementRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private AnnouncementService announcementService;

    @GetMapping("/announcements")
    public List<Announcement> getList () {
        return announcementService.getList();
    }


    @PostMapping("/announcement")
    public Announcement saveAMNT (@RequestBody Announcement announcement) {
        announcement.setCreator(userService.getCurrentUser());
        announcementService.saveANMT(announcement);
        return announcement;
    }

    @DeleteMapping("/announcement/{id}")
    public void deleteAMNT (@PathVariable("id") int id) {
        announcementService.deleletANMT(id);
    }

    //sendmail()function used for testing situation. Not currently in used.
    @GetMapping("/sendemail")
    public Boolean sendemail () {
        Announcement a = new Announcement();
        a.setTitle("Hello");
        a.setContent("This is Content!");
        announcementService.sendEmailToAllUsers(a);

        return true;
    }
}
