package com.hung.network

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hung.network.adapter.NewsAdapter
import com.hung.network.databinding.ActivityMainBinding
import com.hung.network.model.News

class MainActivity : AppCompatActivity() {
    private val listNews = arrayListOf(
        News(
            "Lạng Sơn: Băng tuyết xuất hiện mỏng manh trên đỉnh Mẫu Sơn",
            "Nhiệt độ tại khu du lịch Mẫu Sơn, giảm xuống âm 1,2 độ C, có mưa nhỏ, băng đang đông kết trên nhà cửa, cỏ cây.",
            "https://www.24h.com.vn/tin-tuc-trong-ngay/lang-son-bang-tuyet-xuat-hien-mong-manh-tren-dinh-mau-son-c46a1334182.html",
            "https://image.24h.com.vn/upload/1-2022/images/2022-02-20//adt1645321328-tp-ms1-6115.jpg",
            "Sun, 20 Feb 2022 09:00:00 +0700"),
        News(
            "Test nhanh phát hiện 2.490 ca mắc Covid-19 mới, 7 bệnh nhân nặng tử vong",
            "Số ca mắc Covid-19 vẫn tiếp tục tăng nhanh ở Nghệ An, nhiều ca mắc diễn biến nặng dẫn đến tử vong.",
            "https://www.24h.com.vn/tin-tuc-trong-ngay/test-nhanh-phat-hien-2490-ca-mac-covid-19-moi-7-benh-nhan-nang-tu-vong-c46a1334199.html",
            "https://image.24h.com.vn/upload/1-2022/images/2022-02-20//adt1645326069-f23fc005fd73cc945919a7e7ceca1fdc.png",
            "Sun, 20 Feb 2022 10:04:11 +0700"),
        News(
            "Lạng Sơn: Băng tuyết xuất hiện mỏng manh trên đỉnh Mẫu Sơn",
            "Nhiệt độ tại khu du lịch Mẫu Sơn, giảm xuống âm 1,2 độ C, có mưa nhỏ, băng đang đông kết trên nhà cửa, cỏ cây.",
            "https://www.24h.com.vn/tin-tuc-trong-ngay/lang-son-bang-tuyet-xuat-hien-mong-manh-tren-dinh-mau-son-c46a1334182.html",
            "https://image.24h.com.vn/upload/1-2022/images/2022-02-20//adt1645321328-tp-ms1-6115.jpg",
            "Sun, 20 Feb 2022 09:00:00 +0700"),
        News(
            "Lạng Sơn: Băng tuyết xuất hiện mỏng manh trên đỉnh Mẫu Sơn",
            "Nhiệt độ tại khu du lịch Mẫu Sơn, giảm xuống âm 1,2 độ C, có mưa nhỏ, băng đang đông kết trên nhà cửa, cỏ cây.",
            "https://www.24h.com.vn/tin-tuc-trong-ngay/lang-son-bang-tuyet-xuat-hien-mong-manh-tren-dinh-mau-son-c46a1334182.html",
            "https://image.24h.com.vn/upload/1-2022/images/2022-02-20//adt1645321328-tp-ms1-6115.jpg",
            "Sun, 20 Feb 2022 09:00:00 +0700")
    )
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = NewsAdapter(listNews)
        binding.rvNews.adapter = adapter
        binding.rvNews.layoutManager =
            LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }
}