package com.alex.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;

import java.util.*;
import java.util.logging.Logger;

/**
 * Json 工具类
 * Created by shipeng on 2018/6/4.
 */
public class JsonUtils {

    /**
     * 将List对象序列化为JSON文本
     * @param list
     * @param <T>
     * @return
     */
    public static <T> String toJsonString(List<T> list){
        JSONArray jsonArray = JSONArray.fromObject(list);
        return  jsonArray.toString();
    }

    /**
     * 将对象序列化为JSON文本
     * @param object
     * @return
     */
    public static String toJsonString(Object object){
        JSONArray jsonArray = JSONArray.fromObject(object);
        return jsonArray.toString();
    }

    /**
     * 将对象转换为List
     * @param object
     * @return
     */
    public static List toArrayList(Object object){
        List arrayList = new ArrayList();
        JSONArray jsonArray = JSONArray.fromObject(object);
        Iterator it = jsonArray.iterator();

        while (it.hasNext()){
            JSONObject jsonObject = (JSONObject)it.next();
            Iterator keys = jsonObject.keys();
            while (keys.hasNext()){
                Object key = keys.next();
                Object value = jsonObject.get(key);
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    /**
     * 将对象转换为Collection对象
     * @param object
     * @return
     */
    public static Collection toCollection(Object object){
        JSONArray jsonArray = JSONArray.fromObject(object);
        return JSONArray.toCollection(jsonArray);
    }

    /**
     * 将对象转换为HashMap
     * @param object
     * @return
     */
    public static HashMap toHashMap(Object object) {
        HashMap<String, Object> data = new HashMap<String, Object>();
        JSONObject jsonObject = JSONObject.fromObject(object);
        Iterator it = jsonObject.keys();

        while (it.hasNext()) {
            String key = String.valueOf(it.next());
            Object value = jsonObject.get(key);
            data.put(key, value);
        }

        return data;
    }

    /**
     * 将对象转换为List
     * @param object
     * @return
     */
    public static List<Map<String, Object>> toList(Object object) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        JSONArray jsonArray = JSONArray.fromObject(object);

        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            Map<String, Object> map = new HashMap<String, Object>();
            Iterator it = jsonObject.keys();

            while (it.hasNext()) {
                String key = (String) it.next();
                Object value = jsonObject.get(key);
                map.put((String) key, value);
            }
            list.add(map);
        }
        return list;
    }

    /**
     * 将JSON对象转换为传入类型的对象
     * @param jsonObject
     * @param beanClass
     * @return
     */
    public static <T> T toBean(JSONObject jsonObject, Class<T> beanClass) {
        return (T) JSONObject.toBean(jsonObject, beanClass);
    }

    /**
     * 将对象转换为传入类型的对象
     * @param object
     * @param beanClass
     * @return
     */
    public static <T> T toBean(Object object, Class<T> beanClass) {
        JSONObject jsonObject = JSONObject.fromObject(object);
        return (T) JSONObject.toBean(jsonObject, beanClass);
    }

    /**
     * 将JSON文本反序列化为主从关系的实体
     * 泛型T 代表主实体类型
     * 泛型D 代表从实体类型
     * @param jsonString JSON文本
     * @param mainClass 主实体类型
     * @param detailName 从实体类在主实体类中的属性名称
     * @param detailClass 从实体类型
     * @return
     */
    public static <T, D> T toBean(String jsonString, Class<T> mainClass,
                                  String detailName, Class<D> detailClass) {
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        JSONArray jsonArray = (JSONArray) jsonObject.get(detailName);

        T mainEntity = JsonUtils.toBean(jsonObject, mainClass);
        List<D> detailList = JSONArray.toList(jsonArray, detailClass);

        try {
            BeanUtils.setProperty(mainEntity, detailName, detailList);
        } catch (Exception ex) {
            throw new RuntimeException("主从关系JSON反序列化实体失败！");
        }

        return mainEntity;
    }

    /***
     * 将JSON文本反序列化为主从关系的实体
     * 泛型T 代表主实体类型
     * 泛型D1 代表从实体类型
     * 泛型D2 代表从实体类型
     * @param jsonString JSON文本
     * @param mainClass 主实体类型
     * @param detailName1 从实体类在主实体类中的属性
     * @param detailClass1 从实体类型
     * @param detailName2 从实体类在主实体类中的属性
     * @param detailClass2 从实体类型
     * @return
     */
    public static <T, D1, D2> T toBean(String jsonString, Class<T> mainClass,
                                       String detailName1, Class<D1> detailClass1, String detailName2,
                                       Class<D2> detailClass2) {
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        JSONArray jsonArray1 = (JSONArray) jsonObject.get(detailName1);
        JSONArray jsonArray2 = (JSONArray) jsonObject.get(detailName2);

        T mainEntity = JsonUtils.toBean(jsonObject, mainClass);
        List<D1> detailList1 = JSONArray.toList(jsonArray1, detailClass1);
        List<D2> detailList2 = JSONArray.toList(jsonArray2, detailClass2);

        try {
            BeanUtils.setProperty(mainEntity, detailName1, detailList1);
            BeanUtils.setProperty(mainEntity, detailName2, detailList2);
        } catch (Exception ex) {
            throw new RuntimeException("主从关系JSON反序列化实体失败！");
        }

        return mainEntity;
    }

    /***
     * 将JSON文本反序列化为主从关系的实体
     * 泛型T 代表主实体类型
     * 泛型D1 代表从实体类型
     * 泛型D2 代表从实体类型
     * @param jsonString JSON文本
     * @param mainClass 主实体类型
     * @param detailName1 从实体类在主实体类中的属性
     * @param detailClass1 从实体类型
     * @param detailName2 从实体类在主实体类中的属性
     * @param detailClass2 从实体类型
     * @param detailName3 从实体类在主实体类中的属性
     * @param detailClass3 从实体类型
     * @return
     */
    public static <T, D1, D2, D3> T toBean(String jsonString,
                                           Class<T> mainClass, String detailName1, Class<D1> detailClass1,
                                           String detailName2, Class<D2> detailClass2, String detailName3,
                                           Class<D3> detailClass3) {
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        JSONArray jsonArray1 = (JSONArray) jsonObject.get(detailName1);
        JSONArray jsonArray2 = (JSONArray) jsonObject.get(detailName2);
        JSONArray jsonArray3 = (JSONArray) jsonObject.get(detailName3);

        T mainEntity = JsonUtils.toBean(jsonObject, mainClass);
        List<D1> detailList1 = JSONArray.toList(jsonArray1, detailClass1);
        List<D2> detailList2 = JSONArray.toList(jsonArray2, detailClass2);
        List<D3> detailList3 = JSONArray.toList(jsonArray3, detailClass3);

        try {
            BeanUtils.setProperty(mainEntity, detailName1, detailList1);
            BeanUtils.setProperty(mainEntity, detailName2, detailList2);
            BeanUtils.setProperty(mainEntity, detailName3, detailList3);
        } catch (Exception ex) {
            throw new RuntimeException("主从关系JSON反序列化实体失败！");
        }

        return mainEntity;
    }

    /***
     * 将JSON文本反序列化为主从关系的实体
     * 主实体类型
     * @param jsonString JSON文本
     * @param mainClass 主实体类型
     * @param detailClass 存放了多个从实体在主实体中属性名称和类型
     * @return
     */
    public static <T> T toBean(String jsonString, Class<T> mainClass,
                               HashMap<String, Class> detailClass) {

        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        T mainEntity = JsonUtils.toBean(jsonObject, mainClass);

        for (Object key : detailClass.keySet()) {
            try {
                Class value = (Class) detailClass.get(key);
                BeanUtils.setProperty(mainEntity, key.toString(), value);
            } catch (Exception ex) {
                throw new RuntimeException("主从关系JSON反序列化实体失败！");
            }
        }
        return mainEntity;
    }
}
