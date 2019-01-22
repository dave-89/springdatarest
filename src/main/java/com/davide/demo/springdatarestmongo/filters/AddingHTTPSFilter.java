package com.davide.demo.springdatarestmongo.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddingHTTPSFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        JsonResponseWrapper capturingResponseWrapper = new JsonResponseWrapper(
                (HttpServletResponse) response);

        filterChain.doFilter(request, capturingResponseWrapper);

        if (response.getContentType() != null
                && response.getContentType().contains("text/html")) {

            String content = capturingResponseWrapper.getCaptureAsString();

            // replace stuff here
            String replacedContent = content.replaceAll(
                    "\"href\"[ ]{0,1}:[ ]{0,1}\"http:\\/\\/(.*?)\"",
                    "\"href\" : \"https:\\/\\/$1\"");


            response.getWriter().write(replacedContent);

        }

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}