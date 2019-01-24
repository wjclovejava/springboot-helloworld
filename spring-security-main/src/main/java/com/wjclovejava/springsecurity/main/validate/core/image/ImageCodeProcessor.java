package com.wjclovejava.springsecurity.main.validate.core.image;

import com.wjclovejava.springsecurity.main.validate.core.impl.AbstractValidateCodeProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/23 16:39
 */
@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {

    /**
     * 发送图形验证码,将其写入响应中
     * @param request
     * @return
     */
    @Override
    protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
        ImageIO.write(imageCode.getImage(),"JPEG" ,request.getResponse().getOutputStream());
    }
}
