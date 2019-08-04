package com.orellanab.springboot.torshavn.service.interfaces;

import com.orellanab.springboot.torshavn.entity.Marker;

import java.util.List;

public interface MarkerService {

    public List<Marker> findHistoricMarkers();
}
