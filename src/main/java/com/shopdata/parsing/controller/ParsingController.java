package com.shopdata.parsing.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParsingController {

  @CrossOrigin("*")
  @ResponseBody
  @GetMapping(value = "/parsing", produces = "application/json; charset=UTF-8")
  public Map<String, Object> parser(String url) throws IOException {
    Document document = Jsoup.connect(url).get();
    String shopName = document.getElementsByClass("top_summary_title__15yAr")
        .get(0).getElementsByTag("h2").get(0).text();
    String lowestPrice = document.getElementsByClass("lowestPrice_num__3AlQ-").get(0).text();
    String strOfRateHtml = document.getElementsByClass("top_grade__3jjdl").get(0).text();
    double starRate = Double.parseDouble(strOfRateHtml.replaceFirst("평점",""));
    String imgUrl = document.select("meta[property^=og:image]").get(0).attr("content");

    Map<String, Object> shopData = new HashMap<>();
    shopData.put("shopName",shopName);
    shopData.put("lowestPrice", lowestPrice);
    shopData.put("starRate", starRate);
    shopData.put("imgUrl", imgUrl);

    return shopData;
  }
}
