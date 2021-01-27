package com.shopdata.parsing.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParsingController {

  @ResponseBody
  @GetMapping(value = "/parsing", produces = "application/json; charset=UTF-8")
  public Map<String, Object> parser(String url) throws IOException {
    Document document = Jsoup.connect(url).get();
    String shopName = document.getElementsByClass("top_summary_title__15yAr")
        .get(0).getElementsByTag("h2").get(0).text();
    String lowestPrice = document.getElementsByClass("lowestPrice_num__3AlQ-").get(0).text();
    return new HashMap<>();
  }
}
