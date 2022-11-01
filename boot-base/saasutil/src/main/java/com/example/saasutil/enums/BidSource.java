package com.example.saasutil.enums;

/**
 * 标段来源枚举类型
 *
 * @author ：MiHaiDong
 * @date ：Created in 2022/5/10 12:00
 */
public enum BidSource {
    TC("0"),
    CRAWLERS("1"),
    USER("2"),
    WORKER("3"),
    SYNC("4");

    //值
    private String bidSource;

    BidSource(String bidSource) {
        this.bidSource = bidSource;
    }

    public String getBidSource() {
        return bidSource;
    }

    public void setBidSource(String bidSource) {
        this.bidSource = bidSource;
    }
}
