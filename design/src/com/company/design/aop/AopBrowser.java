package com.company.design.aop;

import com.company.design.proxy.Html;
import com.company.design.proxy.IBrowser;

public class AopBrowser implements IBrowser {

    private String url;
    private Html html;
    private Runnable before;
    private Runnable after;


    public AopBrowser(String url, Runnable before, Runnable after) {
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show() throws InterruptedException {
        before.run();
        if (html == null) {
            this.html = new Html(url);
            System.out.println("AopBrowser html loading from : " + url);
            Thread.sleep(1500);
        }
        after.run();
        System.out.println("AopBrowser html cache : " + url);
        return html;
    }
}
