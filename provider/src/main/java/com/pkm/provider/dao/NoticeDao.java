package com.pkm.provider.dao;

import com.pkm.service.object.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeDao {
    Notice getNoticeById(int id);
    List<Notice> getAllNotice();
    List<Notice> searchNotice(String keyword);
    Boolean addNotice(Notice object);
    Boolean delNotice(int id);
    Boolean upNotice(Notice object);
}
