package cn.samnya.arcadedbserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.NoSuchElementException;

/**
 * @author sam_nya (samnya@outlook.com)
 */
@ControllerAdvice
public class ErrorHandlerController {

    private static Logger logger = LoggerFactory.getLogger(ErrorHandlerController.class);

    @ExceptionHandler(value = NoSuchElementException.class)
    public String elementNotFound(Model model) {
        model.addAttribute("message", "未找到该项目");
        return "commons/error";
    }

    @ExceptionHandler(value = NumberFormatException.class)
    public String numberFormat(Model model) {
        model.addAttribute("message", "参数错误");
        return "commons/error";
    }

    @ExceptionHandler(value = RequestRejectedException.class)
    public String requestRejected(Model model) {
        model.addAttribute("message", "参数错误");
        return "commons/error";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle404(Model model) {
        model.addAttribute("message", "未找到该项目");
        return "commons/error";
    }


}
