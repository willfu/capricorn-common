package com.caishi.capricorn.common.scene.utils;

public class SceneUtils {

    /**
     * get scene id from scene id (recommendation system generated)
     *
     * @param sceneId scene id
     * @return scene id (data)
     */
    public static int getSceneId(String sceneId) {
        String[] data = sceneId.split("_");
        if (data.length == 1) {
            return Integer.parseInt(sceneId);
        }
        return Integer.parseInt(data[0]);
    }
}