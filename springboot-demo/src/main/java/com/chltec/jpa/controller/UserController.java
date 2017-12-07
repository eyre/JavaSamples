package com.chltec.jpa.controller;

import com.chltec.http.HttpUtil;
import com.chltec.http.Response;
import com.chltec.jpa.model.Mobile;
import com.chltec.jpa.model.User;
import com.chltec.jpa.repository.MobileRepository;
import com.chltec.jpa.repository.UserRepository;
import com.chltec.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author joker
 * Created on 2017/11/21.
 * Description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public Response add(@RequestBody User user) {
//        return HttpUtil.respondSuccess(userService.addUser(user));
//    }
//
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public Response add(@RequestBody Map<String, Object> map) {
//        return HttpUtil.respondSuccess();
//    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Response add(@RequestParam(name = "name") String name,
                           @RequestParam(name = "phone_number") String phoneNumber) {
        User user = new User();
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        return HttpUtil.respondSuccess(userService.addUser(user));
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Response get(@RequestParam(name = "uid") Long uid) {
        return HttpUtil.respondSuccess(userService.getUser(uid));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Response update(@RequestParam(name = "uid") Long uid,
                           @RequestParam(name = "name", required = false) String name,
                           @RequestParam(name = "phone_number", required = false) String phoneNumber) {
        User user = new User();
        user.setId(uid);
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        return HttpUtil.respondSuccess(userService.updateUser(user));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Response list() {
//        return HttpUtil.respondSuccess(userService.getUsers());
        return HttpUtil.respondSuccess(userService.getUsersWithPage(1,2));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Response delete(@RequestParam(name = "uid") Long uid) {
        userService.deleteUser(uid);
        return HttpUtil.respondSuccess();
    }

    @Autowired
    MobileRepository mobileRepository;
    @RequestMapping(value = "/bindMobile", method = RequestMethod.POST)
    public Response bindMobile(@RequestParam(name = "uid") Long uid,
                               @RequestParam(name = "device_id") String deviceId,
                               @RequestParam(name = "device_brand") String deviceBrand,
                               @RequestParam(name = "os_type") Integer osType) {
        User user = userService.getUser(uid);
        Mobile mobile = new Mobile();
        mobile.setDeviceId(deviceId);
        mobile.setDeviceBrand(deviceBrand);
        mobile.setOsType(osType);
        mobile = mobileRepository.save(mobile);

        user.setMobile(mobile);
        return HttpUtil.respondSuccess(userRepository.save(user));
    }
}
