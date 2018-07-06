package com.instructure.dataseeding.util

import java.net.InetSocketAddress

interface RunClient {
    fun runClient(address: InetSocketAddress = Config.exampleDotCom): String
}
