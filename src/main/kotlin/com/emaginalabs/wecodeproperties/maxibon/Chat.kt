package com.emaginalabs.wecodeproperties.maxibon

interface Chat {
    fun sendMessage(message: String)
}

class ConsoleChat : Chat {
    override fun sendMessage(message: String) {
        println(message)
    }
}