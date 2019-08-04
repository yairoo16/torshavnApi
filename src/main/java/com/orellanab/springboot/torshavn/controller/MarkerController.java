package com.orellanab.springboot.torshavn.controller;

import com.orellanab.springboot.torshavn.entity.Marker;
import com.orellanab.springboot.torshavn.service.interfaces.MarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marker")
public class MarkerController {

    private MarkerService markerService;

    @Autowired
    public MarkerController(MarkerService markerService) {
        this.markerService = markerService;
    }

    @CrossOrigin
    @GetMapping("/historicmarkers")
    public ResponseEntity<?> getHistoricMarkers() {

        List<Marker> historicMarkers = this.markerService.findHistoricMarkers();

        return ResponseEntity.ok(historicMarkers);

    }


}
