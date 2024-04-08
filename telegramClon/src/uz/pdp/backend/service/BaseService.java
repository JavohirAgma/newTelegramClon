package uz.pdp.backend.service;

import java.util.List;

public interface BaseService<M> {
    boolean create(M m);
    void delete(String id);
    void update(M newM);
    void update(M newM,String id);
    M get(String id);

    List<M> getAll();

}