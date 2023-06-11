package com.pzz.utils;

import com.pzz.pojo.User;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Objects;

public class JsoupUtil {
    /**
     * 从国家统计局官网中获取指定页面的区域信息，返回包含下级区域信息的列表
     *
     * @param index 页面编号，用于构造请求URL，如"11"代表北京市
     * @return ArrayList<String> 包含下级区域信息的列表
     * @throws IOException 如果连接或获取页面数据失败，将抛出IOException异常
     */
    public static ArrayList<String> select(String index) throws IOException {
        // 创建一个空列表以存储获得的区域信息
        ArrayList<String> nexts = new ArrayList<>();
        // 构造请求URL
        String url = "http://www.stats.gov.cn/sj/tjbz/tjyqhdmhcxhfdm/2022/" + index + ".html";
        // 使用Jsoup连接到URL，并且获取页面Document对象
        Document doc = Jsoup.connect(url).get();
        // 获取Document中body标签下的所有元素, 返回值是一个Elements集合
        Elements elements = doc.getElementsByTag("body");
        // 获取Elements集合中第一个元素下的所有a标签元素, 返回值也是一个Elements集合
        Elements contents = Objects.requireNonNull(elements.first()).getElementsByTag("a");
        // 遍历这个Elements集合
        int i = 1;
        for (Element content : contents) {
            // 获取a标签元素内部的文本，并进行筛选
            String linkText = content.text();
            if (i % 2 == 0)
                // 如果满足条件，则将其加入我们之前创建的列表中
                nexts.add(linkText);
            i++;
        }
        // 返回包含下级区域信息的列表
        return nexts;
    }
}
