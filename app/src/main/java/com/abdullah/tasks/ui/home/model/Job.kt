package com.abdullah.tasks.ui.home.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Job(
    @PrimaryKey
    var id: Int,
    var __status: String? = "",
    var customer_name: String? = "",
    var distance: String? = "",
    var extras: String? = "",
    var job_city: String? = "",
    var job_date: String? = "",
    var job_latitude: String? = "",
    var job_longitude: String? = "",
    var job_postalcode: Int? = 0,
    var job_street: String? = "",
    var order_duration: Int? = 0,
    var order_id: String? = "",
    var order_time: String? = "",
    var payment_method: String? = "",
    var price: String? = "",
    var recurrency: Int? = 0,
    var status: String? = ""
)