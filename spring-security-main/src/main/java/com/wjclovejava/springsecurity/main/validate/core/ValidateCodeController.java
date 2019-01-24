package com.wjclovejava.springsecurity.main.validate.core;

import com.wjclovejava.springsecurity.main.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/23 9:18
 */
@RestController
public class ValidateCodeController {

//    private SessionStrategy sessionStrategy=new HttpSessionSessionStrategy();
//
//    @Autowired
//    private ValidateCodeGenerator imageCodeGenerator;
//
//    @Autowired
//    private ValidateCodeGenerator smsCodeGenerator;
//
//    @Autowired
//    private SmsCodeSender smsCodeSender;
//    /**
//     * 图形验证码接口
//     * @param request
//     * @param response
//     * @throws IOException
//     */
//    @GetMapping("/code/image")
//    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        ImageCode imageCode= (ImageCode) imageCodeGenerator.generator(new ServletWebRequest(request));
//        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);
//        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
//    }
//
//    /**
//     * 短信验证码接口
//     * @param request
//     * @param response
//     * @throws IOException
//     */
//    @GetMapping("/code/sms")
//    public void createSmsCode(HttpServletRequest request, HttpServletResponse response) throws  ServletRequestBindingException {
//        ValidateCode smsCode=smsCodeGenerator.generator(new ServletWebRequest(request));
//        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, smsCode);
//        String mobile = ServletRequestUtils.getRequiredStringParameter(request, "mobile");
//        //通过短信供应商发送短信
//        smsCodeSender.send(mobile, smsCode.getCode());
//    }

    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;

   @GetMapping(SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws Exception {
       validateCodeProcessorHolder.findValidateCodeProcessor(type).create(new ServletWebRequest(request,response));
   }

}
