package com.meecat.doctorapp.restcontroller;

import com.meecat.doctorapp.domain.Announcement;
import com.meecat.doctorapp.domain.Functionality;
import com.meecat.doctorapp.service.AnnouncementService;
import com.meecat.doctorapp.service.FunctionalityService;
import com.meecat.doctorapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Directly mapping to src/main/java/resources/webapp/resoures/js/app/announcement.js file via URLs.
@RestController()
@Transactional
@RequestMapping("/api/amnt")
public class FunctionalityRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private FunctionalityService functionalityService;

    @GetMapping("/endUserFuncList")
    public List<Functionality> getEndUserFuncList () {
        return functionalityService.getEndUserFuncList();
    }

    @GetMapping("/doctorFuncList")
    public List<Functionality> getDoctorFuncList () {
        return functionalityService.getDoctorFuncList();
    }

    @GetMapping("/technicalTeamFuncList")
    public List<Functionality> getTechnicalTeamFuncList () {
        return functionalityService.getTechnicalTeamFuncList();
    }

    @PostMapping("/functionality")
    public Functionality saveFunc (@RequestBody Functionality functionality) {
        announcement.setCreator(userService.getCurrentUser());
        announcementService.saveANMT(announcement);
        return announcement;
    }

    @DeleteMapping("/functionality/{id}")
    public void deleteAMNT (@PathVariable("id") int id) {
        functionalityService.deleletFunc(id);
    }
}
