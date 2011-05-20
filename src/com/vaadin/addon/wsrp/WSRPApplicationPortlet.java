package com.vaadin.addon.wsrp;

import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.ApplicationPortlet2;
import com.vaadin.terminal.gwt.server.PortletApplicationContext2;

public class WSRPApplicationPortlet extends ApplicationPortlet2 {
    @Override
    protected PortletApplicationContext2 getApplicationContext(
            PortletSession portletSession) {
        return WSRPPortletContext.getApplicationContext(portletSession);
    }

    @Override
    protected Map<String, String> getVaadinConfigurationMap(
            RenderRequest request, RenderResponse response,
            Application application, String themeURI) throws PortletException {
        Map<String, String> map = super.getVaadinConfigurationMap(request,
                response, application, themeURI);
        map.put("WSRPMode", "true");

        return map;
    }
}
