package com.example.schmerzfreiapp.data.model

import com.example.schmerzfreiapp.R

class Datasource {

    fun getUebungsbilder(): List<Uebungen> {
        return listOf(
            Uebungen(R.drawable.group_35555, "WARM UP / COOL DOWN"),
            Uebungen(R.drawable.group_35555, "BASISÜBUNGEN"),
            Uebungen(R.drawable.group_35555, "BECKEN UNTERER RÜCKEN"),
            Uebungen(R.drawable.group_35555, "SCHULTERN"),
            Uebungen(R.drawable.group_35555, "ARME, HÄNDE"),
            Uebungen(R.drawable.group_35555, "NACKEN, HWS"),
            Uebungen(R.drawable.group_35555, "AUGEN, KIEFER"),
            Uebungen(R.drawable.group_35555, "FÜSSE, KNIE")
        )
    }
}
