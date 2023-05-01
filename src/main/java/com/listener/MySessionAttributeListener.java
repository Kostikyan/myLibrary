package com.listener;

import com.model.User;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.Date;

public class MySessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String id = event.getSession().getId();
        String attrName = event.getName();
        User attrValue = (User) event.getValue();
        if(attrName.equalsIgnoreCase("user")) {
            System.out.println("User with " + attrValue.getEmail() + " email logged in at " + new Date() + " session Id " + id);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
    }
}
