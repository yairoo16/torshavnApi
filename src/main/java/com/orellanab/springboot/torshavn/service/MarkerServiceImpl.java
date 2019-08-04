package com.orellanab.springboot.torshavn.service;

import com.orellanab.springboot.torshavn.entity.Marker;
import com.orellanab.springboot.torshavn.repo.interfaces.MarkerRepo;
import com.orellanab.springboot.torshavn.service.interfaces.MarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkerServiceImpl implements MarkerService {

    public MarkerRepo _markerRepo;

    @Autowired
    public MarkerServiceImpl(MarkerRepo markerRepo) {
        _markerRepo = markerRepo;
    }

    @Override
    public List<Marker> findHistoricMarkers() {
        List<Marker> markers = _markerRepo.findHistoricMarkers();
        return markers;
    }

}
