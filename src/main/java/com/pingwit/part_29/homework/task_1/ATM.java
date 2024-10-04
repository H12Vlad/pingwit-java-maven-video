package com.pingwit.part_29.homework.task_1;

import com.fasterxml.jackson.annotation.JsonProperty;

record ATM(
        Integer id,
        String area,
        @JsonProperty("city_type")
        String cityType,
        String city,
        @JsonProperty("address_type")
        String addressType,
        String address,
        String house,
        @JsonProperty("install_place")
        String installPlace,
        @JsonProperty("work_time")
        String workTime,
        @JsonProperty("gps_x")
        String gpsX,
        @JsonProperty("gps_y")
        String gpsY,
        @JsonProperty("install_place_full")
        String installPlaceFull,
        @JsonProperty("work_time_full")
        String workTimeFull,
        @JsonProperty("ATM_type")
        String atmType,
        @JsonProperty("ATM_error")
        String atmError,
        String currency,
        @JsonProperty("cash_in")
        String cashIn,
        @JsonProperty("ATM_printer")
        String atmPrinter
) {
}