package top.joww.game.entity;

import java.util.Date;

public class Message {
    private long srcId, dstId;
    private String content;
    private Date createdId;

    public long getSrcId() {
        return srcId;
    }

    public long getDstId() {
        return dstId;
    }

    public String getContent() {
        return content;
    }

    public Date getCreatedId() {
        return createdId;
    }

    public void setSrcId(long srcId) {
        this.srcId = srcId;
    }

    public void setDstId(long dstId) {
        this.dstId = dstId;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
