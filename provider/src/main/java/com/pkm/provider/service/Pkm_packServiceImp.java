package com.pkm.provider.service;


import com.pkm.provider.dao.Pkm_packDao;
import com.pkm.service.object.Pkm_pack;
import com.pkm.service.service.Pkm_packService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
@Component
@Service(version = "1.0.0" ,timeout = 2000,interfaceClass = Pkm_packService.class)
public class Pkm_packServiceImp implements Pkm_packService {
    @Autowired
    private Pkm_packDao pkm_packDao;
    public Pkm_pack getPkm_packById(int id){
        return pkm_packDao.getPkm_packById(id);
    }
    public List<Pkm_pack> getAllPkm_pack(){
        return pkm_packDao.getAllPkm_pack();
    }
    public List<Pkm_pack> searchPkm_pack(String keyword){
        return pkm_packDao.searchPkm_pack("%"+keyword+"%");
    }
    public Boolean addPkm_pack(Pkm_pack object){
        return pkm_packDao.addPkm_pack(object);
    }
    public Boolean delPkm_pack(int id){
        return pkm_packDao.delPkm_pack(id);
    }
    public Boolean upPkm_pack(Pkm_pack object){
        return pkm_packDao.upPkm_pack(object);
    }
}
