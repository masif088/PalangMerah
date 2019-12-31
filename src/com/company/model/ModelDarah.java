package com.company.model

open class ModelDarah {
    open var jumlah: Int = 0
    open var golongan: String

    constructor(golongan: String) {
        this.jumlah = 0
        this.golongan = golongan
    }

    constructor() {}

    fun showDarah() {
        println("Golongan Darah $golongan Jumlah Darah $jumlah")
    }

    fun addingDarah(pendonor: ModelPendonor) {
        if (golongan == pendonor.getGolongan()) {
            jumlah += pendonor.getJumlah()
        }
    }

    fun removeDarah(pendonor: ModelPendonor) {
        if (golongan == pendonor.getGolongan()) {
            jumlah -= pendonor.getJumlah()
        }
    }
}
