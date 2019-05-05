package com.my.blog.website;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Assert;

/**
 * @author akun
 * @since 2019-05-05
 */
@Slf4j
public class AntPathMatcherTest {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Test
    public void test() throws Exception {
//        boolean match = antPathMatcher.match("/admin/*/*.js", "/admin/js/base.js");
//        boolean match = antPathMatcher.match("/admin/*/*.css", "/admin/css/style.min.css");
//        boolean match = antPathMatcher.match("/admin/**/**.css", "/admin/plugins/tagsinput/jquery.tagsinput.css");
        boolean match = antPathMatcher.match("/**/**.css", "/admin/plugins/tagsinput/jquery.tagsinput.css");
        Assert.isTrue(match, "not match");
    }
}