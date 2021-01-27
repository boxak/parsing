package com.shopdata.parsing;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main {
  public static void main(String[] args) throws IOException {

    String url = "https://search.shopping.naver.com/catalog/24278707522?adId=nad-a001-02-000000107735707&channel=nshop.npla&query=%ED%82%A4%EB%B3%B4%EB%93%9C&NaPm=ct%3Dkkfe7re8%7Cci%3D0AK0002Akf5uHrIGpuX3%7Ctr%3Dpla%7Chk%3Db07e7695ce39b2ff4ae2fe8416bd2d9e60e062e5&cid=0AK0002Akf5uHrIGpuX3";

    Document document = Jsoup.connect(url).get();

    Element element = document.getElementsByClass("top_summary_title__15yAr").get(0);
    Element element1 = element.getElementsByTag("h2").get(0);
    System.out.println(element1.text());

    Element ogTitle = document.select("meta[property^=og:title]").get(0);
    Element star = document.getElementsByClass("top_grade__3jjdl").get(0);
    Element star2 = document.getElementsByClass("top_star__1Ca9x").get(0);

    String str1 = star.text();

    System.out.println(str1.replaceFirst("평점",""));
  }
}
