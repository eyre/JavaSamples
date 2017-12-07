package com.chltec.jpa.controller;

import com.chltec.http.HttpUtil;
import com.chltec.http.Response;
import com.chltec.jpa.model.Mobile;
import com.chltec.jpa.model.User;
import com.chltec.jpa.repository.MobileRepository;
import com.chltec.jpa.repository.UserRepository;
import com.chltec.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Author joker
 * Created on 2017/11/21.
 * Description
 */
@RestController
@RequestMapping("/mobile")
public class MobileController {

    @Autowired
    MobileRepository mobileRepository;

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public Response add(@RequestParam(name = "device_id") String deviceId,
//                           @RequestParam(name = "device_brand") String deviceBrand,
//                        @RequestParam(name = "os_type") Integer osType ) {
//        Mobile mobile = new Mobile();
//        mobile.setDeviceId(deviceId);
//        mobile.setDeviceBrand(deviceBrand);
//        mobile.setOsType(osType);
//        return HttpUtil.respondSuccess(mobileRepository.save(mobile));
//    }

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public Response add(@RequestParam Map<String, String> params) {
//        return HttpUtil.respondSuccess(params);
//    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Response add(@RequestBody Mobile mobile) {
        return HttpUtil.respondSuccess(mobile);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Response list() {
        return HttpUtil.respondSuccess(mobileRepository.findAll());
    }

}
