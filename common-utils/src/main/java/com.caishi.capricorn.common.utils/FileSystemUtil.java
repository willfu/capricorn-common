package com.caishi.capricorn.common.utils;

import java.io.File;

/**
 * File system utility
 *
 * @author humphrey.han@9icaishi.net
 * @since 0.0.1
 */
public class FileSystemUtil {

    /**
     * Check if folder existed, if not create it.
     * @param absolutePath
     * @return true if folder existed or created successfully, or false
     */
    public static boolean assureFolderExist(String absolutePath) {
        File folder = new File(absolutePath);

        if (folder.exists()) {
            return true;
        } else {
            return folder.mkdirs();
        }
    }

}
