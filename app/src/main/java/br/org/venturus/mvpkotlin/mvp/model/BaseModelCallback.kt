package br.org.venturus.mvpkotlin.mvp.model

abstract class BaseModelCallback(private val presenter: ModelClient) {

  open fun beforeRequest() {
    presenter.beforeRequest()
  }

  open fun afterRequest() {
    presenter.afterRequest()
  }

  open fun onConnectError() {
    presenter.onConnectError()
  }

  open fun onTimeoutError() {
    presenter.onTimeoutError()
  }

  open fun onUnauthorizedError() {
    presenter.onUnauthorizedError()
  }

  open fun onInternalServerError() {
    presenter.onInternalServerError()
  }

  open fun onUnexpectedError(error: Throwable) {
    presenter.onUnexpectedError(error)
  }
}