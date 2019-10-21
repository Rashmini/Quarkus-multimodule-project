package org.acme;

import javax.servlet.http.*;
import java.util.ResourceBundle;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletApp extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            final ResourceBundle resourceBundle = ResourceBundle.getBundle("myproperties");
            try (final PrintWriter writer = response.getWriter()) {
                final JsonObject versionJsonObject = Json.createObjectBuilder()
                        .add("String1", resourceBundle.getString("String1"))
                        .add("String2", resourceBundle.getString("String2"))
                        .add("String3", resourceBundle.getString("String3")).build();

                writer.write(versionJsonObject.toString());
            }
        } catch (final Exception e) {
            // System.out.println("error");
        }
    }
}