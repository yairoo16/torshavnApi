package com.orellanab.springboot.torshavn.repo;

import com.orellanab.springboot.torshavn.entity.Marker;
import com.orellanab.springboot.torshavn.repo.interfaces.MarkerRepo;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MarkerRepoImpl implements MarkerRepo {

    private EntityManager _entityManager;

    @Autowired
    public MarkerRepoImpl(EntityManager entityManager) {
        _entityManager = entityManager;
    }

    public List<Marker> findHistoricMarkers() {

        Session currentSession = _entityManager.unwrap(Session.class);

        Query<Marker> query = currentSession.createQuery("from Marker", Marker.class);

        List<Marker> markers = query.getResultList();

        return markers;
    }
}
