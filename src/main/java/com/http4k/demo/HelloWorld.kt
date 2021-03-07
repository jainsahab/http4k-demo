package com.http4k.demo

import org.http4k.core.HttpHandler
import org.http4k.core.Method.GET
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.core.then
import org.http4k.filter.DebuggingFilters
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.Netty
import org.http4k.server.asServer

fun HelloWorld(): HttpHandler {
  return routes("/" bind GET to { Response(OK).body("Hello, ${it.query("name")}!") })
}

fun main() {
  val port = 9000
  DebuggingFilters.PrintRequestAndResponse()
    .then(HelloWorld())
    .asServer(Netty(port)).start()
  println("Server started at port: $port")
}
