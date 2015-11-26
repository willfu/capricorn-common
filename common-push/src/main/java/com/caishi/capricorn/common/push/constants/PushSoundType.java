package com.caishi.capricorn.common.push.constants;

public enum PushSoundType {

    /**
     * no sound will be display when receive push message in terminal
     */
    SILENCE(1, "SILENCE", "silence", "silence.wav"),

    /**
     * sound will be display when get push message in terminal
     */
    SOUND(2, "SOUND", "default1", "default1.mp3");

    /**
     * constructors
     *
     * @param id           push sound type id
     * @param name         push sound type name
     * @param fileName     push sound file name
     * @param fullFileName push sound full file name
     */
    PushSoundType(int id, String name, String fileName, String fullFileName) {
        setId(id);
        setName(name);
        setFileName(fileName);
        setFullFileName(fullFileName);
    }

    /**
     * push sound type id
     */
    private int id;

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    /**
     * push sound type name
     */
    private String name;

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    /**
     * push sound file name
     */
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    private void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * push sound file name
     */
    private String fullFileName;

    public String getFullFileName() {
        return fullFileName;
    }

    private void setFullFileName(String fullFileName) {
        this.fullFileName = fullFileName;
    }

    /**
     * get push sound type by push sound type id
     *
     * @param id push sound type id
     * @return push sound type
     */
    public final static PushSoundType getPushSoundTypeById(int id) {
        if (id >= 1 && id <= 2) {
            for (PushSoundType pushSoundType : PushSoundType.values()) {
                if (pushSoundType.getId() == id) {
                    return pushSoundType;
                }
            }
        }
        return null;
    }

    /**
     * get push sound type by push sound name
     *
     * @param name push sound name
     * @return push sound type
     */
    public final static PushSoundType getPushSoundTypeByName(String name) {
        if (name != null && !((name = name.replace(" ", "")).isEmpty())) {
            for (PushSoundType pushSoundType : PushSoundType.values()) {
                if (pushSoundType.getName().equalsIgnoreCase(name)) {
                    return pushSoundType;
                }
            }
        }
        return null;
    }

    /**
     * make validation by push sound type id
     *
     * @param id push sound type id
     * @return validation status
     */
    public final static Boolean validation(int id) {
        return getPushSoundTypeById(id) != null;
    }

    /**
     * make validation by push sound type name
     *
     * @param name push sound type name
     * @return validation status
     */
    public final static Boolean validation(String name) {
        return getPushSoundTypeByName(name) != null;
    }
}