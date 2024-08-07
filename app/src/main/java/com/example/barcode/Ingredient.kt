package com.example.barcode

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

data class Ingredient(
    val name: String,
    val expiryDate: String // 유통기한을 "yyyy-MM-dd" 형식의 문자열로 저장
) {
    fun getDDay(): Long {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val expiry = dateFormat.parse(expiryDate) ?: return 0
        val today = Date()

        val diff = expiry.time - today.time
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) //현재 날짜와 유통기한 비교하여 d-day 계산
    }
}