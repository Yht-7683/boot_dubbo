package com.pkm.provider.service;


import com.pkm.provider.dao.NoticeDao;
import com.pkm.service.object.Notice;
import com.pkm.service.service.NoticeService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
@Component
@Service(version = "1.0.0" ,timeout = 2000,interfaceClass = NoticeService.class)
public class NoticeServiceImp implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;
    public Notice getNoticeById(int id){
        return noticeDao.getNoticeById(id);
    }
    public List<Notice> getAllNotice(){
        return noticeDao.getAllNotice();
    }
    public List<Notice> searchNotice(String keyword){
        return noticeDao.searchNotice("%"+keyword+"%");
    }
    public Boolean addNotice(Notice object){
        return noticeDao.addNotice(object);
    }
    public Boolean delNotice(int id){
        return noticeDao.delNotice(id);
    }
    public Boolean upNotice(Notice object){
        return noticeDao.upNotice(object);
    }
}
