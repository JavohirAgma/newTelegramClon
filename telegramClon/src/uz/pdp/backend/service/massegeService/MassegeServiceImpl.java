package uz.pdp.backend.service.massegeService;

import uz.pdp.backend.model.massege.Massege;

import java.util.ArrayList;
import java.util.List;

public class MassegeServiceImpl implements MassegeService{
    List<Massege> massegeList;

    public MassegeServiceImpl() {
        this.massegeList = new ArrayList<>();
    }

    @Override
    public boolean create(Massege massege) {
        return false;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(Massege newM) {

    }

    @Override
    public void update(Massege newM, String id) {

    }

    @Override
    public Massege get(String id) {
        return null;
    }

    @Override
    public List<Massege> getAll() {
        return null;
    }

    static MassegeService massegeService;
    public static MassegeService getInstance(){
        if (massegeService==null){
            massegeService = new MassegeServiceImpl();
        }
        return massegeService;
    }
}
