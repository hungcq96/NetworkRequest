package com.hung.network.paser

import android.util.Xml
import com.hung.network.model.News
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.net.HttpURLConnection
import java.net.URL

//singleton pattern
object NewsParser {

   suspend fun parserNews(link: String): List<News> {
        val listNews = arrayListOf<News>()


        val url = URL(link)
        val connection = url.openConnection() as HttpURLConnection
        val inputStream = connection.inputStream

        val xmlPullParserFactory = XmlPullParserFactory.newInstance()
        val xmlPullParser = xmlPullParserFactory.newPullParser()
        xmlPullParser.setInput(inputStream, "utf-8")

        var type = xmlPullParser.eventType

        var news = News()
        var text = ""
        while (type != XmlPullParser.END_DOCUMENT) {

            when (type) {

                XmlPullParser.START_TAG -> {
                    val tag = xmlPullParser.name
                    if (tag == "item") {
                        news = News()
                    } else if (tag == "img") {
                        val img = xmlPullParser.getAttributeValue(null, "src")
                        news.image = img
                    }
                }
                XmlPullParser.TEXT -> {
                    text = xmlPullParser.text
                }
                XmlPullParser.END_TAG -> {
                    val tag = xmlPullParser.name
                    when (tag) {
                        "title" -> {
                            news.title = text
                        }
                        "description" -> {
                            news.description = text
                        }
                        "link" -> {
                            news.link = text
                        }
                        "item" -> {
                            listNews.add(news)
                        }
                        "pubDate" -> {
                            news.pubDate = text
                        }
                    }
                }
            }
            type = xmlPullParser.next()
        }
        return listNews
    }
}