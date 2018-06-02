package com.cxd.engroom.controller;

import com.cxd.engroom.dao.CarouselPicDao;
import com.cxd.engroom.dao.CourseDao;
import com.cxd.engroom.dao.LevelDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/app")
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    private static final String SESSION_KEY = "https://api.weixin.qq.com/sns/jscode2session";
    private static final char[] DIGITS_LOWER =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CarouselPicDao carouselPicDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private LevelDao levelDao;

    @RequestMapping("/getCarousels")
    public Object getCarousels(long seqId) {
        return carouselPicDao.findCarousels(seqId);
    }

    @RequestMapping("/getCourses")
    public Object getCourses() {
        return courseDao.findIndexCourse();
    }

    @RequestMapping("/getLevels")
    public Object getLevels(long seqId) {
        return levelDao.findLevels(seqId);
    }


}
