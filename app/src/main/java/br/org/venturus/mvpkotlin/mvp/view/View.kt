package br.org.venturus.mvpkotlin.mvp.view

interface View {
  fun attachView()
  fun detachView()
  fun getLayoutId(): Int
  fun onViewReady()
  fun showProgress(show: Boolean)

  fun onNetworkConnected()
  fun onNetworkDisconnected()

  fun onConnectError()
  fun onTimeoutError()
  fun onUnauthorizedError()
  fun onInternalServerError()
  fun onUnexpectedError(error: Throwable)
}