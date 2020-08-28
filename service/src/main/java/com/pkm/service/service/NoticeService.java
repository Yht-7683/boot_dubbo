package com.pkm.service.service;


import com.pkm.service.object.Notice;

import java.util.List;


public interface NoticeService {

   Notice getNoticeById(int id);
   List<Notice> getAllNotice();
   List<Notice> searchNotice(String keyword);
   Boolean addNotice(Notice object);
   Boolean delNotice(int id);
   Boolean upNotice(Notice object);
}
