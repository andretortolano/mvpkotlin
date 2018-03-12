package br.org.venturus.mvpkotlin.mvp.model

interface ModelClient {
  fun beforeRequest()
  fun afterRequest()

  fun onConnectError()
  fun onTimeoutError()
  fun onUnauthorizedError()
  fun onInternalServerError()
  fun onUnexpectedError(error: Throwable)
}