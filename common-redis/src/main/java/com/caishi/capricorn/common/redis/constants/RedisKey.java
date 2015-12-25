package com.caishi.capricorn.common.redis.constants;

public class RedisKey {

    /**
     * static
     */
    public final static String STATIC_KEY = "static";

    public final static String STATIC_SCENE = "scene";

    public final static String STATIC_SCENE_LAYOUT_SNAPSHOT = "scene:layout:snapshot";

    public final static String STATIC_CHANNEL = "channel";

    public final static String STATIC_CHANNEL_VERSION = "channel_version";

    public final static String STATIC_HOROSCOPE = "horoscope";

    public final static String STATIC_WEATHER_ICON = "weather_icon";


    /**
     * message
     */
    public final static String MESSAGE_KEY = "message:{0}:_{1}";

    public final static String MESSAGE_PAGEVIEW_KEY = "message:{0}:_{1}:page_view";

    public final static String MESSAGE_PAGEVIEW_TREND_KEY = "message:{0}:_{1}:page_view_trend";

    public final static String MESSAGE_PAGEVIEW_TOPNS_KEY = "message:page_view_top_{0}";

    public final static String MESSAGE_USERVIEW_KEY = "message:{0}:_{1}:user_view";

    public final static String MESSAGE_USERVIEW_TREND_KEY = "message:{0}:_{1}:user_view_trend";

    public final static String MESSAGE_USERVIEW_TOPNS_KEY = "message:user_view_top_{0}";

    public final static String MESSAGE_SUMMARY = "summary";

    public final static String MESSAGE_DETAIL = "detail";

    public final static String MESSAGE_LAYOUT = "layout";

    public final static String MESSAGE_PAGEVIEW = "page_view";

    public final static String MESSAGE_USERVIEW = "user_view";

    public final static String MESSAGE_PAGEVIEW_BASIC = "page_view_basic";

    public final static String MESSAGE_INTERACT_PAGEVIEW = "interact_page_view";

    public final static String MESSAGE_INTERACT_PAGEVIEW_BASIC = "interact_page_view_basic";

    public final static String MESSAGE_COMMENT_LEVEL = "comment_level";

    public final static String MESSAGE_COMMENT_COUNT = "comment_count";

    public final static String MESSAGE_COMMENT_DETAIL = "comment_{0}";

    public final static String MESSAGE_COMMENT_TOP_ENGINE = "comment_top";

    public final static String MESSAGE_COMMENT_HOT_ENGINE = "comment_hot";

    public final static String MESSAGE_COMMENT_PICKED_ENGINE = "comment_picked";

    public final static String MESSAGE_COMMENT_DYNAMIC_ENGINE = "comment_dynamic";

    public final static String MESSAGE_OFFLINE = "message:offline";

    /**
     * weather
     */
    public final static String WEATHER_ICON_KEY = "weather:icon:_{0}";

    /**
     * horoscope
     */
    public final static String HOROSCOPE_KEY = "horoscope:_{0}";

    /**
     * fortune
     */
    public final static String FORTUNE_KEY = "fortune:_{0}";

    /**
     * version
     */
    public final static String VERSION_KEY = "version:_{0}:_{1}";

    public final static String VERSION_NUMBER = "number";

    public final static String VERSION_DETAIL = "detail";

    /**
     * channel
     */
    public final static String CHANNEL_KEY = "channel:_{0}";

    public final static String CHANNEL_DETAIL = "detail";

    public final static String CHANNEL_MESSAGE_PAGEVIEW_TOPNS_KEY = "channel:_{0}:message:page_view_{1}";

    public final static String CHANNEL_MESSAGE_PAGEVIEW_TOTAL_KEY = "channel:_{0}:message:page_view_total_{1}";

    public final static String CHANNEL_MESSAGE_USERVIEW_TOPNS_KEY = "channel:_{0}:message:user_view_{1}";

    public final static String CHANNEL_MESSAGE_USERVIEW_TOTAL_KEY = "channel:_{0}:message:user_view_total_{1}";

    /**
     * scene
     */
    public final static String SCENE_KEY = "scene:_{0}";

    public final static String SCENE_SNAPSHOT = "snapshot";

    public final static String SCENE_DETAIL = "detail";

    public final static String SCENE_SCHEDULER = "scene:scheduler:_{0}";

    public final static String SCENE_PAGEVIEW_KEY = "scene:_{0}:page_view:{1}";

    public final static String SCENE_PAGEVIEW_TREND_KEY = "scene:_{0}:page_view_trend:{1}";

    public final static String SCENE_MESSAGE_PAGEVIEW_TOPNS_KEY = "scene:_{0}:message:page_view_{1}";

    public final static String SCENE_MESSAGE_PAGEVIEW_TOTAL_KEY = "scene:_{0}:message:page_view_total_{1}";

    public final static String SCENE_USERVIEW_KEY = "scene:_{0}:user_view:{1}";

    public final static String SCENE_USERVIEW_TREND_KEY = "scene:_{0}:user_view_trend:{1}";

    public final static String SCENE_MESSAGE_USERVIEW_TOPNS_KEY = "scene:_{0}:message:user_view_{1}";

    public final static String SCENE_MESSAGE_USERVIEW_TOTAL_KEY = "scene:_{0}:message:user_view_total_{1}";


    /**
     * theme
     */
    public final static String THEME_KEY = "theme";

    public final static String THEME_SCENE = "scene:_{0}";

    /**
     * doc
     */
    public final static String DOC_KEY = "doc";

    public final static String DOC_SCENE = "scene:_{0}";

    /**
     * video
     */
    public final static String VIDEO_KEY = "video";

    public final static String VIDEO_SCENE = "scene:_{0}";

    /**
     * game
     */
    public final static String GAME_KEY = "game";

    public final static String GAME_SCENE = "scene:_{0}";

    /**
     * layout
     */
    public final static String LAYOUT_SCENE_KEY = "layout:scene:_{0}";

    /**
     * filter
     */
    public final static String FILTER_IMAGE_KEY = "filter:image:_{0}";

    public final static String FILTER_CATEGORY_KEY = "filter:category:_{0}";

    public final static String FILTER_CATEGORY_LAYOUT = "layout";

    /**
     * activity
     */
    public final static String ACTIVITY_KEY = "activity";

    public final static String ACTIVITY_POSITION = "position:_{0}";

    public final static String ACTIVITY_DETAIL = "detail:_{0}_{1}";

    /**
     * queue
     */
    public final static String QUEUE_COMMENT_KEY = "queue:comment";

    public final static String QUEUE_MESSAGE_PAGEVIEW = "queue:message:page_view";

    public final static String QUEUE_MESSAGE_INTERACT_PAGEVIEW = "queue:message:interact:page_view";

    public final static String QUEUQ_USER_PROFILE = "queue:user:profile:_{0}";

    public final static String QUEUQ_USER_TOKEN = "queue:user:token:_{0}";

    /**
     * user
     */
    public final static String USER_KEY = "user:_{0}";

    public final static String USER_PORTRAIT = "portrait";

    /**
     * comment
     */
    public final static String COMMENT_DYNAMIC_ENGINE_KEY = "comment:dynamic:{0}:_{1}";

    public final static String COMMENT_TOP_ENGINE_KEY = "comment:top:{0}:_{1}";

    public final static String COMMENT_PICKED_ENGINE_KEY = "comment:picked:{0}:_{1}";

    public final static String COMMENT_HOT_ENGINE_KEY = "comment:hot:{0}:_{1}";

    /**
     * mobile
     */
    public final static String MOBILE_VALIDATION_CODE = "{0}:mobile:validation:code:_{1}";

    public final static String MOBILE_SECURITY = "{0}:mobile:security:_{1}";

    /**
     * category
     */
    public final static String CATEGORY_PAGEVIEW_KEY = "category:_{0}:page_view:{1}";

    public final static String CATEGORY_PAGEVIEW_TREND_KEY = "category:_{0}:page_view_trend:{1}";

    public final static String CATEGORY_PAGEVIEW_TOPNS_KEY = "category:page_view_top_{0}";

    public final static String CATEGORY_USERVIEW_KEY = "category:_{0}:user_view:{1}";

    public final static String CATEGORY_USERVIEW_TREND_KEY = "category:_{0}:user_view_trend:{1}";

    public final static String CATEGORY_USERVIEW_TOPNS_KEY = "category:user_view_top_{0}";

    public final static String CATEGOTY_MESSAGE_PAGEVIEW_TOPNS_KEY = "category:_{0}:message:page_view_top_{1}";

    public final static String CATEGORY_MESSAGE_PAGEVIEW_TOTAL_KEY = "category:_{0}:message:page_view_total_{1}";

    public final static String CATEGORY_MESSAGE_USERVIEW_TOPNS_KEY = "category:_{0}:message:user_view_top_{1}";

    public final static String CATEGORY_MESSAGE_USERVIEW_TOTAL_KEY = "category:_{0}:message:user_view_total_{1}";

    /**
     * vote
     */
    public final static String VOTE_KEY = "vote:_{0}";

    public final static String VOTE_STATISTIC_KEY = "option:_{0}";
}