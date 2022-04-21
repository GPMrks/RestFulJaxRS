//package dio.innovation.one.SoldierAPI.filter;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Collections;
//import java.util.Enumeration;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@Component
//public class FilterJava implements Filter {
//
//    private Logger logger = LoggerFactory.getLogger(FilterJava.class);
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//        logger.info("Filter accessed");
//
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
//        Map<String, String> mapHeaders = Collections.list(headerNames)
//                .stream()
//                .collect(Collectors.toMap(it -> it, httpServletRequest::getHeader));
//
//        if (mapHeaders.get("authorization") != null && mapHeaders.get("authorization").equals("P4SSW0RD")) {
//
//            chain.doFilter(request, response);
//
//            logger.info("Access granted.");
//
//        } else {
//            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//            httpServletResponse.sendError(403);
//            logger.info("Access denied.");
//        }
//
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
