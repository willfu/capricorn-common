package com.caishi.capricorn.common.news.test.util;

import com.caishi.capricorn.common.login.data.NetType;
import com.caishi.capricorn.common.login.util.DataUtil;
import com.caishi.capricorn.common.news.dto.LayoutInfo;
import com.caishi.capricorn.common.news.dto.NewsImageInfo;
import com.caishi.capricorn.common.news.dto.NewsSummaryInfo;
import com.caishi.capricorn.common.news.meta.NewsType;
import com.caishi.capricorn.common.news.meta.ParentType;
import com.caishi.capricorn.common.news.util.LayoutUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.*;
public class LayoutUtilUnitTest {
    private final static List<NewsSummaryInfo> newsSummaryInfoList;

    static{
        newsSummaryInfoList = new ArrayList<NewsSummaryInfo>();
        NewsSummaryInfo newsSummaryInfo;
        NewsImageInfo newsImageInfo;
        for (int i=0;i<2;i++){
            newsSummaryInfo = new NewsSummaryInfo();
            newsSummaryInfo.setNewsId(DataUtil.getRandomNumber(10));
            newsSummaryInfo.setTitle("世界十大预警机排行出炉：中国预警机排名让人意外！");
            newsSummaryInfo.setNewsType(NewsType.NEWS);
            newsSummaryInfo.setParentType(ParentType.CHANNEL);
            newsSummaryInfo.setParentId(1);
            newsSummaryInfo.setPublishTime(new Date().getTime());
            newsSummaryInfo.setPageView(((int) (Math.random() * 1000)) * 1000);
            boolean isGif = (i%2)==0;
            if(i!=2){
                newsImageInfo = new NewsImageInfo();
                newsImageInfo.setIsGif(isGif);
                newsImageInfo.setWidth(549);
                newsImageInfo.setHeight(306);
                newsImageInfo.setUrl("http://p3.pstatp.com/large/5947/6507242342");
                newsSummaryInfo.getNewsImageInfoList().add(newsImageInfo);
                newsImageInfo =new NewsImageInfo();
                newsImageInfo.setIsGif(isGif);
                newsImageInfo.setWidth(548);
                newsImageInfo.setHeight(322);
                newsImageInfo.setUrl("http://p2.pstatp.com/large/5950/3865726361");
                newsSummaryInfo.getNewsImageInfoList().add(newsImageInfo);
                newsImageInfo = new NewsImageInfo();
                newsImageInfo.setIsGif(isGif);
                newsImageInfo.setWidth(552);
                newsImageInfo.setHeight(331);
                newsImageInfo.setUrl("http://p3.pstatp.com/large/5948/6112163001");
                newsSummaryInfo.getNewsImageInfoList().add(newsImageInfo);
            }

            if(i!=4&i!=2){
                newsImageInfo = new NewsImageInfo();
                newsImageInfo.setIsGif(isGif);
                newsImageInfo.setWidth(548);
                newsImageInfo.setHeight(343);
                newsImageInfo.setUrl("http://p3.pstatp.com/large/5944/8068582067");
                newsSummaryInfo.getNewsImageInfoList().add(newsImageInfo);
                newsImageInfo = new NewsImageInfo();
                newsImageInfo.setIsGif(isGif);
                newsImageInfo.setWidth(548);
                newsImageInfo.setHeight(343);
                newsImageInfo.setUrl("http://p3.pstatp.com/large/5944/8068582067");
                newsSummaryInfo.getNewsImageInfoList().add(newsImageInfo);
                newsImageInfo = new NewsImageInfo();
                newsImageInfo.setIsGif(isGif);
                newsImageInfo.setWidth(548);
                newsImageInfo.setHeight(343);
                newsImageInfo.setUrl("http://p3.pstatp.com/large/5944/8068582067");
                newsSummaryInfo.getNewsImageInfoList().add(newsImageInfo);
                newsImageInfo = new NewsImageInfo();
                newsImageInfo.setIsGif(isGif);
                newsImageInfo.setWidth(548);
                newsImageInfo.setHeight(343);
                newsImageInfo.setUrl("http://p3.pstatp.com/large/5944/8068582067");
                newsSummaryInfo.getNewsImageInfoList().add(newsImageInfo);
            }

            newsSummaryInfoList.add(newsSummaryInfo);
        }
    }

    @Test
    public void testDesign(){
        System.out.println(newsSummaryInfoList.size());
        List<LayoutInfo> layoutInfoList = LayoutUtil.design(newsSummaryInfoList, NetType.WIFI,false);
        assertFalse(layoutInfoList.size()==0);
    }
}
