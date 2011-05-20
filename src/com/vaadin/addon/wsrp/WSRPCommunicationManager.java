package com.vaadin.addon.wsrp;

import java.io.IOException;
import java.net.URLDecoder;

import com.vaadin.Application;
import com.vaadin.addon.wsrp.gwt.client.VWSRPApplicationConnection;
import com.vaadin.terminal.gwt.server.PortletCommunicationManager;

public class WSRPCommunicationManager extends PortletCommunicationManager {

    public WSRPCommunicationManager(Application application) {
        super(application);
    }

    @Override
    protected String getRequestPayload(Request request) throws IOException {
        String payload = request
                .getParameter(VWSRPApplicationConnection.PARAMETER_PAYLOAD);
        if (payload == null || payload.length() == 0) {
            // Fallback to standard method if there was no payload parameter.
            // This is used if the widgetset is not compiled with the add-on.
            return super.getRequestPayload(request);
        } else {
            payload = URLDecoder.decode(payload, "UTF-8");
        }
        return payload;
    }
}
