package com.caishi.capricorn.common.push.param;

import com.caishi.capricorn.common.push.constants.*;
import com.caishi.capricorn.common.push.protocol.BasicProtocol;

import java.io.Serializable;
import java.util.*;

public class PushParam implements Serializable {

    /**
     * push id
     */
    private String pushId;

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    /**
     * push type
     */
    private PushType pushType;

    public PushType getPushType() {
        return pushType;
    }

    public void setPushType(PushType pushType) {
        this.pushType = pushType;
    }

    /**
     * push group info collection
     */
    private Set<PushReceiverGroup> pushReceiverGroupSet = new HashSet<>();

    public Set<PushReceiverGroup> getPushReceiverGroupSet() {
        return pushReceiverGroupSet;
    }

    public void setPushReceiverGroupSet(Set<PushReceiverGroup> pushReceiverGroupSet) {
        this.pushReceiverGroupSet = pushReceiverGroupSet;
    }

    /**
     * push platform info collection
     */
    private Set<PlatForm> platFormSet = new HashSet<>();

    public Set<PlatForm> getPlatFormSet() {
        return platFormSet;
    }

    public void setPlatFormSet(Set<PlatForm> platFormSet) {
        this.platFormSet = platFormSet;
    }

    /**
     * title
     */
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * summary
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * push protocol
     */
    private BasicProtocol protocol;

    public BasicProtocol getProtocol() {
        return protocol;
    }

    public void setProtocol(BasicProtocol protocol) {
        this.protocol = protocol;
    }

    /**
     * make validation
     *
     * @return
     */
    public Map<Boolean, String> validation() {
        Map<Boolean, String> result = new HashMap<>();
        try {
            if (title == null || title.isEmpty() || title.length() >= 16) {
                throw new Exception("title can not be null and length must less than 16");
            }
            if (content == null || content.isEmpty() || content.length() >= 128) {
                throw new Exception("content can not be null and length must less than 128");
            }
            if (platFormSet == null || platFormSet.size() == 0) {
                throw new Exception("plateForm collection can not be null and size must be more than one");
            }
            if (protocol == null) {
                throw new Exception("protocol can not be null");
            } else {
                if (pushType == null) {
                    throw new Exception("push type can not be null");
                } else {
                    if (!(pushType.getType().equals(protocol))) {
                        throw new Exception("push type can not make adapter with protocol");
                    }
                }
            }
            result.put(true, "ok");
        } catch (Exception ex) {
            result.put(false, ex.getMessage());
        }
        return result;
    }
}