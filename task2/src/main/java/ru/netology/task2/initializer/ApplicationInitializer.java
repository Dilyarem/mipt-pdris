package ru.netology.task2.initializer;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;

public class ApplicationInitializer implements WebApplicationInitializer {
    private static final String tmpFolder = "/tmp";
    private static final int maxUploadSize = 5 * 1024 * 1024;

    @Override
    public void onStartup(ServletContext servletContext) {
        final var context = new AnnotationConfigWebApplicationContext();
        context.scan("ru.netology");
        context.refresh();

        final var servlet = new DispatcherServlet(context);
        final var registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);

        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(tmpFolder,
                maxUploadSize, maxUploadSize * 2, maxUploadSize / 2);

        registration.setMultipartConfig(multipartConfigElement);

        registration.addMapping("/");
    }
}