package uz.pdp.backend.service.massegeService;

import uz.pdp.backend.model.massege.Massege;
import uz.pdp.backend.service.BaseService;

import java.util.List;

public interface MassegeService extends BaseService<Massege> {
    List<Massege> getChatGroupMassege(String chatGroup);
}
