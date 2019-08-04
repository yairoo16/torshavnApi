package com.orellanab.springboot.torshavn.repo.interfaces;

import com.orellanab.springboot.torshavn.entity.Marker;

import java.util.List;

public interface MarkerRepo {

    public List<Marker> findHistoricMarkers();
}
