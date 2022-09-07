/*
 * Copyright 2022 Red Hat Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apicurio.codegen.tests.widget.api;

import java.util.ArrayList;
import java.util.List;

import io.apicurio.codegen.tests.widget.api.beans.Widget;

/**
 * @author eric.wittmann@gmail.com
 */
public class WidgetsResourceImpl implements WidgetsResource {
    
    private static List<Widget> widgets = new ArrayList<>();

    /**
     * @see io.apicurio.codegen.tests.widget.api.WidgetsResource#getWidgets()
     */
    @Override
    public List<Widget> getWidgets() {
        System.out.println("==> Getting widgets.");
        return widgets;
    }

    /**
     * @see io.apicurio.codegen.tests.widget.api.WidgetsResource#createWidget(io.apicurio.codegen.tests.widget.api.beans.Widget)
     */
    @Override
    public void createWidget(Widget data) {
        System.out.println("==> Creating widget: " + data.getName());
        widgets.add(data);
    }

    /**
     * @see io.apicurio.codegen.tests.widget.api.WidgetsResource#getWidget(java.lang.String)
     */
    @Override
    public Widget getWidget(String widgetId) {
        return null;
    }

    /**
     * @see io.apicurio.codegen.tests.widget.api.WidgetsResource#updateWidget(java.lang.String, io.apicurio.codegen.tests.widget.api.beans.Widget)
     */
    @Override
    public void updateWidget(String widgetId, Widget data) {
    }

    /**
     * @see io.apicurio.codegen.tests.widget.api.WidgetsResource#deleteWidget(java.lang.String)
     */
    @Override
    public void deleteWidget(String widgetId) {
    }

}
