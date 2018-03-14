package br.org.venturus.mvpkotlin.presentation.demo

import br.org.venturus.mvpkotlin.mvp.view.BaseActivity
import br.org.venturus.mvpkotlin.mvp.view.ChildView
import br.org.venturus.mvpkotlin.presentation.demo.Contract.DemoView
import javax.inject.Inject

class DemoActivity : BaseActivity(), DemoView {

  @Inject
  internal lateinit var presenter: DemoPresenter

  override fun attachView() {
    presenter.onAttach(this)
  }

  override fun detachView() {
    presenter.onDetach()
  }

  override fun onChildAttached(child: ChildView) {
    TODO()
  }

  override fun getLayoutId(): Int {
    TODO()
  }

  override fun onChildDetached(child: ChildView) {
    TODO()
  }

  override fun onViewReady() {
    TODO()
  }

  override fun onNetworkConnected() {
    TODO()
  }

  override fun onNetworkDisconnected() {
    TODO()
  }
}