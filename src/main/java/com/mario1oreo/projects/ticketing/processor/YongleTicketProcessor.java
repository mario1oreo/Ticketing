package com.mario1oreo.projects.ticketing.processor;

import com.mario1oreo.projects.ticketing.download.SeleniumDownloader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by mario1oreo on 2017/8/21.
 */
@Component
@Slf4j
public class YongleTicketProcessor implements PageProcessor {

    private Site site;

    public YongleTicketProcessor() {
        if (site == null) {
            this.site = Site.me().setDomain("www.228.com.cn").setTimeOut(15000).setRetryTimes(3);
        }
    }

    @Override
    public void process(Page page) {
        log.info("show something, such as page html:"+page.getHtml().toString());
    }

    @Override
    public Site getSite() {
        return this.site;
    }

    public static void main(String[] args) {
        Spider spider = Spider.create(new YongleTicketProcessor()).setDownloader(new SeleniumDownloader()).thread(1);
        spider.addUrl("http://www.228.com.cn/sh/");
        spider.start();
    }
}
