package br.org.venturus.mvpkotlin.mvp.presenter

import br.org.venturus.mvpkotlin.mvp.view.View

abstract class BasePresenter<V> : Presenter<V> where V : View {

  private var view: V? = null

  override fun getView(): V {
    return view!!
  }

  override fun onAttach(view: V) {
    this.view = view
  }

  override fun onDetach() {
    view = null
  }

  override fun checkViewAttached() {
    if(view == null) throw  ViewNotAttachedException()
  }

  override fun beforeRequest() {
    getView().showProgress(true)
  }

  override fun afterRequest() {
    getView().showProgress(false)
  }

  override fun onConnectError() {
    getView().onConnectError()
  }

  override fun onTimeoutError() {
    getView().onTimeoutError()
  }

  override fun onUnauthorizedError() {
    getView().onUnauthorizedError()
  }

  override fun onInternalServerError() {
    getView().onInternalServerError()
  }

  override fun onUnexpectedError(error: Throwable) {
    getView().onUnexpectedError(error)
  }

  class ViewNotAttachedException : RuntimeException("View requested when its not attached to presenter")
}