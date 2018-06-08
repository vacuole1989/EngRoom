package com.cxd.engroom.controller;

import com.cxd.engroom.BizException;
import com.cxd.engroom.bean.*;
import com.cxd.engroom.dao.*;
import com.cxd.engroom.util.DateUtil;
import com.cxd.engroom.util.FileUtil;
import com.cxd.engroom.util.Levenshtein;
import com.cxd.engroom.util.PathUtil;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;


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
    @Autowired
    private LessonDao lessonDao;
    @Autowired
    private WordDao wordDao;
    @Autowired
    private UserWordDao userWordDao;
    @Autowired
    private AppTagDao appTagDao;
    @Autowired
    private UserInfoDao userInfoDao;


    @RequestMapping("/onLogin")
    public Object onLogin(@RequestParam String code, @RequestBody UserInfo userInfo) {

        AppTag appTag = appTagDao.findOnlyOne().get(0);

        Map map = restTemplate.getForObject("{sessionkey}?appid={APPID}&secret={SECRET}&js_code={JSCODE}&grant_type=authorization_code", Map.class, SESSION_KEY, appTag.getAppId(), appTag.getAppSecret(), code);

        if (null != map.get("openid")) {
            String openid = map.get("openid") + "";
            String sessionKey = map.get("session_key") + "";
            userInfo.setSessionKey(sessionKey);
            userInfo.setOpenId(openid);

            UserInfo userInfo1 = userInfoDao.findByOpenId(openid);
            if (null != userInfo1) {
                if(StringUtils.isEmpty(userInfo.getNickName())){
                    return userInfo1;
                }
                userInfo1.setAvatarUrl(userInfo.getAvatarUrl());
                userInfo1.setCity(userInfo.getCity());
                userInfo1.setCountry(userInfo.getCountry());
                userInfo1.setGender(userInfo.getGender());
                userInfo1.setNickName(userInfo.getNickName());
                userInfo1.setProvince(userInfo.getProvince());
                userInfoDao.save(userInfo1);

                BeanUtils.copyProperties(userInfo1, userInfo);
            } else {
                if(StringUtils.isEmpty(userInfo.getNickName())){
                    return new BizException("用户不存在登录失败");
                }
                userInfo.setCreateTime(DateUtil.format(new Date()));
                userInfoDao.save(userInfo);
            }
            return userInfo;
        } else {
            return new BizException("用户登录失败");
        }
    }


    @RequestMapping("/getCarousels")
    public Object getCarousels(long seqId) {
        return carouselPicDao.findCarousels(seqId);
    }

    @RequestMapping("/getCourses")
    public Object getCourses() {
        return courseDao.findIndexCourse();
    }


    @RequestMapping("/getCourse")
    public Object getCourse(long seqId) {
        return courseDao.findOne(seqId);
    }

    @RequestMapping("/getLevels")
    public Object getLevels(long seqId) {
        return levelDao.findLevels(seqId);
    }

    @RequestMapping("/getLevel")
    public Object getLevel(long seqId) {
        return levelDao.findOne(seqId);
    }

    @RequestMapping("/getLessons")
    public Object getLessons(long seqId) {
        List<Lesson> lessons = lessonDao.findLessons(seqId);
        for (int i = 0; i < lessons.size(); i++) {
            Lesson lesson = lessons.get(i);

            if (lesson.getPleft() < 50) {
                lesson.setPleft(50);
            }
            if (i % 2 == 0) {
                lesson.setShowStyle("left:" + lesson.getPleft() + "rpx;top:" + (i * 100) + "rpx");
            } else {
                lesson.setShowStyle("right:" + lesson.getPleft() + "rpx;top:" + (i * 100) + "rpx");
            }
        }
        return lessons;
    }

    @RequestMapping("/getLesson")
    public Object getLesson(long seqId) {
        return lessonDao.findOne(seqId);
    }


    @RequestMapping("/getWords")
    public Object getWords(long seqId,long userSeqId) {
        List<Word> words = wordDao.findWords(seqId);

        List<UserWord> userWords = userWordDao.findByUserSeqId(userSeqId);

        for (int i = 0; i < words.size(); i++) {
            Word word = words.get(i);
            for (UserWord userWord : userWords) {
                if(word.getSeqId()==userWord.getWordSeqId()){
                    word.setUserWord(userWord);
                }
            }

            if(null==word.getUserWord()){
                List<WordS> wordS=new ArrayList<>();
                String[] split = word.getStandardContent().split(" ");
                for (String s : split) {
                    WordS wordS1=new WordS();
                    wordS1.setRight(0);
                    wordS1.setValue(s);
                    wordS.add(wordS1);
                }
                word.setWordS(wordS);
            }else{
                List<WordS> wordS=new ArrayList<>();
                String[] split = word.getStandardContent().split(" ");
                String errorWords = word.getUserWord().getErrorWords();
                String[] split1 = errorWords.split(" ");
                List<String> stringB = Arrays.asList(split1);
                for (String s : split) {
                    if(stringB.contains(s.toLowerCase())){
                        WordS wordS1=new WordS();
                        wordS1.setRight(1);
                        wordS1.setValue(s);
                        wordS.add(wordS1);
                    }else{
                        WordS wordS1=new WordS();
                        wordS1.setRight(-1);
                        wordS1.setValue(s);
                        wordS.add(wordS1);
                    }
                }
                word.setWordS(wordS);
            }


        }
        return words;
    }

    @PostMapping("/uploadRecord")
    public Object getWords(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws EncoderException {
        String pathUrl = "/"+PathUtil.getInstance().getWebRootPath() + "/record/";
        FileUtil.makeDirectory(pathUrl);
        String result = request.getParameter("result").replace(".","").trim();
        String userSeqId = request.getParameter("userSeqId");
        String seqId = request.getParameter("seqId");
        System.out.println(result);


        UserWord userWord;
        long duration = 0;
        try {
            FileUtil.saveFileFromInputStream(file.getInputStream(), pathUrl + file.getOriginalFilename());

            File source =new File(pathUrl + file.getOriginalFilename());
            Encoder encoder = new Encoder();
            MultimediaInfo m = encoder.getInfo(source);
            long ls = m.getDuration();
            duration = ls/1000;
            System.out.println("此MP3长为:"+ls/60000+"分"+(ls/1000-ls/60000*60)+"秒！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        

        List<UserWord> userWords = userWordDao.findByUserSeqIdAndWordSeqId(Long.parseLong(userSeqId), Long.parseLong(seqId));
        if (userWords.size() > 0) {
            userWord = userWords.get(0);
            userWord.setReadCount(userWord.getReadCount() + 1);

        } else {
            userWord = new UserWord();
            userWord.setReadCount(1);
            userWord.setUserSeqId(Long.parseLong(userSeqId));
            userWord.setWordSeqId(Long.parseLong(seqId));
        }
        userWord.setUserAudio(file.getOriginalFilename());
        userWord.setUserContent(result);
        userWord.setUserDuration(duration);
        userWord.setUserFileSize(file.getSize());

        Word one = wordDao.findOne(userWord.getWordSeqId());
        Levenshtein levenshtein=new Levenshtein();
        float similarityRatio = levenshtein.getSimilarityRatio(userWord.getUserContent(), one.getStandardContent());
        userWord.setUserWordScore((int)(similarityRatio*100));


        String[] arr1 = one.getStandardContent().toLowerCase().split(" ") ;
        String[] arr2 = userWord.getUserContent().toLowerCase().split(" ") ;
        List<String> list=new ArrayList<>();
        for (int i = 0; i < arr2.length; i++){
            for (int j = 0; j < arr1.length; j++){
                if (arr1[j].equals(arr2[i])){
                    list.add(arr1[j]) ;
                }
            }
        }
        StringBuffer buffer=new StringBuffer();
        for (String s : arr1) {
            if(list.contains(s)) {
//                buffer.append("<text class=\"red\">"+s+"</text>");
//            }else{
                buffer.append(s);
            }
            buffer.append(" ");
        }

        userWord.setErrorWords(buffer.toString());
        userWordDao.save(userWord);

        return userWord;

    }

}
