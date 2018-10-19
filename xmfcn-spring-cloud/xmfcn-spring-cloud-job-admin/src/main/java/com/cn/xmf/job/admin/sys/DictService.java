package com.cn.xmf.job.admin.sys;

import com.alibaba.fastjson.JSONObject;
import com.cn.xmf.base.model.Partion;
import com.cn.xmf.model.dict.Dict;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Service(数据字典表)
 *
 * @author 数据字典表
 * @version 2017-11-23
 */
@FeignClient(value = "${base-service.sys-service}")// 配置远程服务名以及自定义权限验证配置
@RequestMapping("/server/dict/")// 配置远程服务路径
@SuppressWarnings("all")
public interface DictService {


    /**
     * save:(新增或编辑，对于保存数据库同时更新到ssdb中)
     *
     * @param dict
     * @return
     * @Author 数据字典表
     */
    @RequestMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    Dict save(@RequestBody Dict dict);

    /**
     * 分页查询Dict集合
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "getList", consumes = MediaType.APPLICATION_JSON_VALUE)
    Partion list(@RequestBody JSONObject map);

    /**
     * 不带分页查询Dict集合
     *
     * @param dict
     * @return
     */
    @RequestMapping(value = "getDictList", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Dict> getDictList(@RequestBody Dict dict);
    /**
     * 逻辑删除数据
     *
     * @return the data return
     */
    @RequestMapping(value = "delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    boolean delete(@RequestParam("id") Long id);

    /**
     * 获取字典值
     * @param dictType
     * @param dictKey
     * @return
     */
    @RequestMapping("getDictValue")
    String getDictValue(@RequestParam("dictType") String dictType, @RequestParam("dictKey") String dictKey);

    /*
     * getFsoUrl(获取FSO接口地址)
     * @param tags
     * @author airufei
     * @date 2018/2/24 10:16
     */
    @RequestMapping("getFsoUrl")
    public String getFsoUrl(@RequestParam("dictKey") String dictKey);

}