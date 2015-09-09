package com.caishi.capricorn.common.base;

/**
 * This class defines extended constants those used as keys(subkeys) in FeedMessage object
 *
 * @author humphrey.han@9icaishi.net
 * @since 0.0.1
 */
public class FeedConstants {
    /**
     * key of source type in feed message.
     *
     * usage:
     * SourceType sourceType = (SourceType) (feedMessage.getSourceMeta().get(FEED_SOURCE_META_SOURCE_TYPE));
     **/
    public static String FEED_SOURCE_META_SOURCE_TYPE = "sourceType";

    /**
     * key of display template in feed message.
     *
     * usage:
     * MessageType displayTemplate = (MessageType) (feedMessage.getSourceMeta().get(FEED_SOURCE_META_DISPLAY_TEMPLATE));
     **/
    public static String FEED_SOURCE_META_DISPLAY_TEMPLATE = "displayTemplate";

    /**
     * key of image source link in feed message.
     *
     * usage:
     * String sourceLink = (String) (feedMessage.getMedia().getMedia().get(FEED_MEDIA_IMAGES).get(0).get(FEED_MEDIA_IMAGES_SRC));
     * **/
    public static String FEED_MEDIA_IMAGES_SRC = "src";

    /**
     * source id in debug info
     *
     * usage:
     * Integer sourceId = (Integer) (feedMessage.getExtra().get(FEED_EXTRA_DEBUG_INFO).get(FEED_EXTRA_DEBUG_INFO_SOURCEID));
     * **/
    public static String  FEED_EXTRA_DEBUG_INFO_SOURCEID = "sourceId";

    /**
     * movie score
     *
     * usage:
     * String movieScore = (String) (feedMessage.getExtra().get(FEED_EXTRA_MOVIE_SCORE));
     **/
    public static String FEED_EXTRA_MOVIE_SCORE = "movie-score";

    /**
     * movie actor in list format
     *
     * usage:
     * List movieActor = (List) (feedMessage.getExtra().get(FEED_EXTRA_MOVIE_ACTOR));
     **/
    public static String FEED_EXTRA_MOVIE_ACTOR = "movie-actor";

    /**
     * movie release date
     *
     * usage:
     * String movieReleaseDate = (String) (feedMessage.getExtra().get(FEED_EXTRA_MOVIE_RELEASE_DATE));
     **/
    public static String FEED_EXTRA_MOVIE_RELEASE_DATE = "movie-releasedate";

}
