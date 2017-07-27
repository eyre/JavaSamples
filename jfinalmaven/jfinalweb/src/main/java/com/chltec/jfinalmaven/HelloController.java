package com.chltec.jfinalmaven;

import com.jfinal.core.Controller;

/**
 * Author joker
 * Created on 2017/7/27.
 * Description
 */
public class HelloController extends Controller{
    public void index(){
        renderText("hello world");
    }
}
