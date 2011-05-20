package com.vaadin.addon.wsrp;

import javax.portlet.PortletSession;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.PortletApplicationContext2;
import com.vaadin.terminal.gwt.server.PortletCommunicationManager;

public class WSRPPortletContext extends PortletApplicationContext2 {
    public static PortletApplicationContext2 getApplicationContext(
            PortletSession session) {
        WSRPPortletContext cx = (WSRPPortletContext) session
                .getAttribute(WSRPPortletContext.class.getName());
        if (cx == null) {
            cx = new WSRPPortletContext();
            session.setAttribute(WSRPPortletContext.class.getName(), cx);
        }
        if (cx.session == null) {
            cx.session = session;
        }
        return cx;
    }

    @Override
    protected PortletCommunicationManager createPortletCommunicationManager(
            Application application) {
        return new WSRPCommunicationManager(application);
    }
}
