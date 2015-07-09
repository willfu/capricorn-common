package com.caishi.capricorn.common.news.util;

import com.caishi.capricorn.common.login.data.NetType;
import com.caishi.capricorn.common.news.dto.LayoutInfo;
import com.caishi.capricorn.common.news.dto.NewsImageInfo;
import com.caishi.capricorn.common.news.dto.NewsSummaryInfo;
import com.caishi.capricorn.common.news.meta.LayoutType;

import java.text.MessageFormat;
import java.util.*;

public class LayoutUtil {

    /**
     *
     */
    private final static int LAYOUT_BIG_IMAGE_COUNT = 6;

    /**
     *
     */
    private final static double LAYOUT_BIG_IMAGE_WIDTH=500;

    /**
     *
     */
    private final static int LAYOUT_THREE_IMAGE_COUNT=3;

    /**
     *
     */
    private final static int LAYOUT_DOUBLE_IMAGE_MIN_COUNT=1;

    /**
     *
     */
    private final static int LAYOUT_DOUBLE_IMAGE_MAX_COUNT=3;

    /**
     * 根据新闻列表信息进行排版设计
     * @param newsSummaryInfoList 新闻信息列表
     * @param netType 网络类型
     * @param allowAdvanceLayout 是否允许高级排版
     * @return 排版信息列表
     */
    public final static List<LayoutInfo> design(List<NewsSummaryInfo> newsSummaryInfoList,NetType netType,boolean allowAdvanceLayout){
        List<LayoutInfo> layoutInfoList = new ArrayList<LayoutInfo>();
        if(netType==NetType.WIFI){
            layoutInfoList = complexDesign(newsSummaryInfoList);
        }else{
            if(allowAdvanceLayout){
                layoutInfoList = complexDesign(newsSummaryInfoList);
            }else{
                layoutInfoList = simpleDesign(newsSummaryInfoList);
            }
        }
        return layoutInfoList;
    }

    private final static List<LayoutInfo> simpleDesign(List<NewsSummaryInfo> newsSummaryInfoList){
        List<LayoutInfo> layoutInfoList = new ArrayList<LayoutInfo>();
        LayoutInfo layoutInfo;
        for(NewsSummaryInfo newsSummaryInfo : newsSummaryInfoList){
            layoutInfo = new LayoutInfo();
            if(newsSummaryInfo.getNewsImageInfoList().size()==0){
                layoutInfo.setLayoutType(LayoutType.BLANK);
            }else{
                layoutInfo.setLayoutType(LayoutType.SINGLE);
            }
            layoutInfo.getNewsSummaryInfoList().add(newsSummaryInfo);
            layoutInfoList.add(layoutInfo);
        }
        return layoutInfoList;
    }

    private final static List<LayoutInfo> complexDesign(List<NewsSummaryInfo> newsSummaryInfoList){
        List<LayoutInfo> layoutInfoList = new ArrayList<LayoutInfo>();
        int index = -1;
        String val;
        LayoutInfo layoutInfo;
        NewsSummaryInfo newsSummaryInfo;
        Map<LayoutType,String> layoutTypeIntegerMap = new HashMap<LayoutType,String>();
        for (int i = 0; i < newsSummaryInfoList.size(); i++) {
            newsSummaryInfo = newsSummaryInfoList.get(i);
            if(getCommonCount(layoutTypeIntegerMap)>=getAdvanceCount(layoutTypeIntegerMap)){
                //LayoutType.BIG
                if (!layoutTypeIntegerMap.containsKey(LayoutType.BIG)) {
                    if (newsSummaryInfo.getNewsImageInfoList().size() >= LAYOUT_BIG_IMAGE_COUNT) {
                        index = newsImageInfoListDetection(newsSummaryInfo.getNewsImageInfoList(), LAYOUT_BIG_IMAGE_WIDTH);
                        if (index >= 0) {
                            layoutTypeIntegerMap.put(LayoutType.BIG, String.valueOf(i));
                            continue;
                        }
                    }
                }
                //LayoutType.THREE
                if (!layoutTypeIntegerMap.containsKey(LayoutType.THREE)) {
                    if (newsSummaryInfo.getNewsImageInfoList().size() >= LAYOUT_THREE_IMAGE_COUNT) {
                        layoutTypeIntegerMap.put(LayoutType.THREE, String.valueOf(i));
                        continue;
                    }
                }
                //LayoutType.DOUBLE
                if ((!layoutTypeIntegerMap.containsKey(LayoutType.DOUBLE)) || (layoutTypeIntegerMap.get(LayoutType.DOUBLE).split(",").length < 2)) {
                    if (newsSummaryInfo.getNewsImageInfoList().size() >= LAYOUT_DOUBLE_IMAGE_MIN_COUNT && newsSummaryInfo.getNewsImageInfoList().size() <= LAYOUT_DOUBLE_IMAGE_MAX_COUNT) {
                        if (layoutTypeIntegerMap.containsKey(LayoutType.DOUBLE)) {
                            val = MessageFormat.format("{0},{1}", layoutTypeIntegerMap.get(LayoutType.DOUBLE), String.valueOf(i));
                        } else {
                            val = String.valueOf(i);
                        }
                        layoutTypeIntegerMap.put(LayoutType.DOUBLE, val);
                        continue;
                    }
                }
            }

            if(newsSummaryInfo.getNewsImageInfoList().size()>0) {
                //LayoutType.SINGLE
                if (layoutTypeIntegerMap.containsKey(LayoutType.SINGLE)) {
                    val = MessageFormat.format("{0},{1}", layoutTypeIntegerMap.get(LayoutType.SINGLE), String.valueOf(i));
                } else {
                    val = String.valueOf(i);
                }
                layoutTypeIntegerMap.put(LayoutType.SINGLE,val);
            }else{
                //LayoutType.BLANK
                if(layoutTypeIntegerMap.containsKey(LayoutType.BLANK)){
                    val = MessageFormat.format("{0},{1}",layoutTypeIntegerMap.get(LayoutType.BLANK),String.valueOf(i));
                }else{
                    val = String.valueOf(i);
                }
                layoutTypeIntegerMap.put(LayoutType.BLANK,val);
            }

        }

        int advanceCount = getAdvanceCount(layoutTypeIntegerMap);
        int commonCount = getCommonCount(layoutTypeIntegerMap);
        if(layoutTypeIntegerMap.containsKey(LayoutType.BIG)){
            layoutInfo = makeDesign(newsSummaryInfoList,layoutTypeIntegerMap);
            if(layoutInfo!=null){
                layoutInfoList.add(layoutInfo);
            }
            layoutInfo = makeDesign(LayoutType.BIG,newsSummaryInfoList,layoutTypeIntegerMap);
            layoutInfoList.add(layoutInfo);
        }

        if(layoutTypeIntegerMap.containsKey(LayoutType.THREE)){
            layoutInfo = makeDesign(newsSummaryInfoList,layoutTypeIntegerMap);
            if(layoutInfo!=null){
                layoutInfoList.add(layoutInfo);
            }
            layoutInfo = makeDesign(LayoutType.THREE,newsSummaryInfoList,layoutTypeIntegerMap);
            layoutInfoList.add(layoutInfo);
        }

        if(layoutTypeIntegerMap.containsKey(LayoutType.DOUBLE)){
            layoutInfo = makeDesign(newsSummaryInfoList,layoutTypeIntegerMap);
            if(layoutInfo!=null){
                layoutInfoList.add(layoutInfo);
            }
            layoutInfo = makeDesign(LayoutType.DOUBLE,newsSummaryInfoList,layoutTypeIntegerMap);
            layoutInfoList.add(layoutInfo);
        }

        int random;

        while (!layoutTypeIntegerMap.isEmpty()){
            random = ((int)(Math.random()*100000));
            layoutInfo = makeDesign(newsSummaryInfoList,layoutTypeIntegerMap);
            if(layoutInfoList.size()==0){
                layoutInfoList.add(layoutInfo);
            }else{
                layoutInfoList.add(random%layoutInfoList.size(),layoutInfo);
            }
        }

        return layoutInfoList;
    }

    private final static int newsImageInfoListDetection(List<NewsImageInfo> newsImageInfoList,double width){
        int result = -1;
        for (NewsImageInfo newsImageInfo : newsImageInfoList){
            if(newsImageInfo.getWidth()>=width){
                result++;
                break;
            }
        }
        return result;
    }

    private final static List<NewsSummaryInfo> getNewsSummaryInfo(List<NewsSummaryInfo> newsSummaryInfoList,Map<LayoutType,String> layoutTypeStringMap,LayoutType layoutType){
        List<NewsSummaryInfo> result = new ArrayList<NewsSummaryInfo>();
        String val = layoutTypeStringMap.get(layoutType);
        String[] array = val.split(",");
        NewsSummaryInfo newsSummaryInfo;
        if(layoutType==LayoutType.DOUBLE) {
            for (String index : layoutTypeStringMap.get(layoutType).split(",")) {
                newsSummaryInfo = newsSummaryInfoList.get(Integer.parseInt(index));
                result.add(newsSummaryInfo);
            }
            layoutTypeStringMap.remove(layoutType);
        }else{
            if(array.length==1){
                newsSummaryInfo = newsSummaryInfoList.get(Integer.parseInt(val));
                layoutTypeStringMap.remove(layoutType);
            }else{
                newsSummaryInfo = newsSummaryInfoList.get(Integer.parseInt(array[0]));
                val = val.substring(val.indexOf(",")+1);
                layoutTypeStringMap.put(layoutType,val);
            }
            result.add(newsSummaryInfo);
        }
        return result;
    }

    private final static LayoutInfo makeDesign(List<NewsSummaryInfo> newsSummaryInfoList,Map<LayoutType,String> layoutTypeStringMap){
        LayoutInfo layoutInfo = null;
        NewsSummaryInfo newsSummaryInfo;
        boolean result = (((int)(Math.random()*100))%2)==0;
        if(result){
            if(layoutTypeStringMap.containsKey(LayoutType.SINGLE)){
                layoutInfo = new LayoutInfo();
                layoutInfo.setLayoutType(LayoutType.SINGLE);
                newsSummaryInfo = getNewsSummaryInfo(newsSummaryInfoList,layoutTypeStringMap,LayoutType.SINGLE).get(0);
                layoutInfo.getNewsSummaryInfoList().add(newsSummaryInfo);
                layoutInfo.getNewsImageInfoList().add(newsSummaryInfo.getNewsImageInfoList().get(0));
            }
        }else{
            if(layoutTypeStringMap.containsKey(LayoutType.BLANK)){
                layoutInfo = new LayoutInfo();
                layoutInfo.setLayoutType(LayoutType.BLANK);
                newsSummaryInfo = getNewsSummaryInfo(newsSummaryInfoList,layoutTypeStringMap,LayoutType.BLANK).get(0);
                layoutInfo.getNewsSummaryInfoList().add(newsSummaryInfo);
            }
        }
        return layoutInfo;
    }

    private final static LayoutInfo makeDesign(LayoutType layoutType,List<NewsSummaryInfo> newsSummaryInfoList,Map<LayoutType,String> layoutTypeStringMap) {
        LayoutInfo layoutInfo = new LayoutInfo();
        layoutInfo.setLayoutType(layoutType);
        for(NewsSummaryInfo newsSummaryInfo : getNewsSummaryInfo(newsSummaryInfoList,layoutTypeStringMap,layoutType)){
            layoutInfo.getNewsSummaryInfoList().add(newsSummaryInfo);
            if(newsSummaryInfo.getNewsImageInfoList().size()>0){
                layoutInfo.getNewsImageInfoList().add(newsSummaryInfo.getNewsImageInfoList().get(0));
            }
        }
        return layoutInfo;
    }

    private final static int getCommonCount(Map<LayoutType,String> layoutTypeStringMap){
        int count = 0;
        LayoutType layoutType;
        Iterator<LayoutType> iterator = layoutTypeStringMap.keySet().iterator();
        while (iterator.hasNext()){
            layoutType = iterator.next();
            switch (layoutType){
                case SINGLE:{
                    count+=layoutTypeStringMap.get(layoutType).split(",").length;
                    break;
                }
                case BLANK:{
                    count+=layoutTypeStringMap.get(layoutType).split(",").length;
                    break;
                }
            }
        }
        return count;
    }

    private final static int getAdvanceCount(Map<LayoutType,String> layoutTypeStringMap){
        int count = 0;
        LayoutType layoutType;
        Iterator<LayoutType> iterator = layoutTypeStringMap.keySet().iterator();
        while (iterator.hasNext()){
            layoutType = iterator.next();
            switch (layoutType){
                case BIG:{
                    count++;
                    break;
                }
                case THREE:{
                    count++;
                    break;
                }
                case DOUBLE:{
                    count++;
                    break;
                }
            }
        }
        return count;
    }

}
