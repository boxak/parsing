package com.shopdata.parsing;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main {
  public static void main(String[] args) throws IOException {

    String url = "https://search.shopping.naver.com/catalog/14797788871?adId=nad-a001-02-000000100388288&channel=nshop.npla&query=%ED%82%A4%EB%B3%B4%EB%93%9C&NaPm=ct%3Dkkercng8%7Cci%3D0AG0002xKL1ulSOB%2DeYE%7Ctr%3Dpla%7Chk%3D948d4b2e2330ed89983a4f7ba4878409c137d077&cid=0AG0002xKL1ulSOB-eYE";

    Document document = Jsoup.connect(url).get();

    Element element = document.getElementsByClass("top_summary_title__15yAr").get(0);
    Element element1 = element.getElementsByTag("h2").get(0);
    System.out.println(element1.text());

    Element ogTitle = document.select("meta[property^=og:title]").get(0);
    System.out.println(ogTitle.attr("content"));
  }
}
