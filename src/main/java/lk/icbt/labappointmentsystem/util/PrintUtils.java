package lk.icbt.labappointmentsystem.util;


import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import java.io.ByteArrayOutputStream;

import org.springframework.core.io.ByteArrayResource;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import java.io.File;
import java.io.FileOutputStream;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.web.servlet.IServletWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

public class PrintUtils {

    public ByteArrayResource pdfGenerator(HttpServletRequest req, HttpServletResponse res, Object object, String fileName, TemplateEngine templateEngine) {

        WebContext context = createContext(req, res);
        context.setVariable("data", object);

        FileTemplateResolver templateResolver = new FileTemplateResolver();
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateResolver.setOrder(templateEngine.getTemplateResolvers().size());
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(false);
        templateResolver.setCheckExistence(true);
        String orderHtml = templateEngine.process(fileName, context);



        ByteArrayOutputStream target = new ByteArrayOutputStream();
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setBaseUri(req.getRequestURI());



        HtmlConverter.convertToPdf(orderHtml, target, converterProperties);

        return new ByteArrayResource(target.toByteArray());
    }

    public static WebContext createContext(HttpServletRequest req, HttpServletResponse res) {

        JakartaServletWebApplication jakartaServletWebApplication = JakartaServletWebApplication.buildApplication(req.getServletContext());
        IServletWebExchange iServletWebExchange = jakartaServletWebApplication.buildExchange(req, res);

        return new WebContext(iServletWebExchange);
    }


}
