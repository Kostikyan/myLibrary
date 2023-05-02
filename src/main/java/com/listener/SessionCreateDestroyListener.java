package com.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;

public class SessionCreateDestroyListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        String id = se.getSession().getId();
        System.out.println("Session created at " + new Date()
                + " sessionId = " + id);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        String id = se.getSession().getId();
        System.out.println("Session destroyed at " + new Date()
                + " sessionId = " + id);
    }
}
