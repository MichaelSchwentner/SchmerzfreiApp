package com.example.schmerzfreiapp.data.model

import com.example.schmerzfreiapp.R

class Datasource {

    fun getUebungsbilder(): List<Uebungen> {
        return listOf(
            Uebungen(R.drawable.group_35555, "WARMUP"),
            Uebungen(R.drawable.group_35555, "BASISUEBUNGEN"),
            Uebungen(R.drawable.group_35555, "BECKEN UNTERER RÜCKEN"),
            Uebungen(R.drawable.group_35555, "SCHULTERN"),
            Uebungen(R.drawable.group_35555, "ARME, HÄNDE"),
            Uebungen(R.drawable.group_35555, "NACKEN, HWS"),
            Uebungen(R.drawable.group_35555, "AUGEN, KIEFER"),
            Uebungen(R.drawable.group_35555, "FÜSSE, KNIE")
        )
    }
    fun getUebungsbilder2(): List<Uebungen> {
        return listOf(
            Uebungen(R.drawable.group_35554, "BEINÜBUNG"),
            Uebungen(R.drawable.group_35558, "SCHULTERÜBUNG"),
            Uebungen(R.drawable.group_35554, "BEINÜBUNGEN")

        )
    }
    fun getUebungsbilder3(): List<Uebungen> {
        return listOf(
            Uebungen(R.drawable.group_35561, "WARMUP"),
            Uebungen(R.drawable.group_35561, "COOLDOWN")

        )
    }
}



