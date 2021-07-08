package com.java.controller;

import com.java.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/getMenu.do")
    @ResponseBody
    public List<Map<String, Object>> getMenu(HttpSession session, @RequestParam(name = "id", defaultValue = "0") Long parentId) {
        String username = session.getAttribute("username").toString();
        return adminService.findMenu(username, parentId);
    }

    /**
     * 查询横向菜单，并分页
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/getWebMenu.do")
    @ResponseBody
    public Map<String, Object> getWebMenu(Integer page, Integer rows) {
        return adminService.findWebMenu(page, rows);
    }

    /**
     * 添加横向菜单
     *
     * @param hxMenuName
     * @param hxMenuUrl
     * @return
     */
    @RequestMapping("/addHxMenu.do")
    @ResponseBody
    public boolean addHxMenu(String hxMenuName, String hxMenuUrl) {
        return adminService.addHxMenu(hxMenuName, hxMenuUrl);
    }

    /**
     * 根据id修改横向菜单信息
     *
     * @param id
     * @param hxMenuName
     * @param hxMenuUrl
     * @return
     */
    @RequestMapping("/updateHxMenu.do")
    @ResponseBody
    public boolean updateHxMenu(Long id, String hxMenuName, String hxMenuUrl) {
        return adminService.modify(id, hxMenuName, hxMenuUrl);
    }

    /**
     * 根据id删除横向菜单信息
     *
     * @param idStr
     * @return
     */
    @RequestMapping("/deleteHxMenu.do")
    @ResponseBody
    public boolean deleteHxMenu(String idStr) {
        return adminService.removeHxMenu(idStr);
    }
}
