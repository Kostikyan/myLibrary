package com.listener;

import com.model.User;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.Date;

public class UserLoginListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String id = event.getSession().getId();
        String attrName = event.getName();
        User attrValue = (User) event.getValue();
        if (attrName.equalsIgnoreCase("user")) {
            System.out.println("User with " + attrValue.getEmail() +
                    " email logged in at " + new Date() + " sessionId=" + id);
        }
    }

}
