package pl.korbanek.flightinfo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.korbanek.flightinfo.entity.Plane;
import pl.korbanek.flightinfo.repository.PlaneRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaneService {
    private final PlaneRepository planeRepository;
    public void saveAll(List<Plane> planeList){
        planeRepository.saveAll(planeList);
    }
    public List<Plane> findAll(){
        return planeRepository.findAll();
    }
}
