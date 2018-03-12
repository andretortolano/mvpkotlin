package br.org.venturus.mvpkotlin.mvp.view

import android.os.Bundle
import android.support.v4.app.Fragment
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity(), ParentView {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(getLayoutId())
    attachView()
    onViewReady()
  }

  override fun onDestroy() {
    detachView()
    super.onDestroy()
  }

  override fun showProgress(show: Boolean) {
    TODO()
  }

  override fun onConnectError() {
    TODO()
  }

  override fun onTimeoutError() {
    TODO()
  }

  override fun onUnauthorizedError() {
    TODO()
  }

  override fun onInternalServerError() {
    TODO()
  }

  override fun onUnexpectedError(error: Throwable) {
    TODO()
  }

  protected fun attachFragment(
    containerId: Int,
    fragment: Fragment
  ) {
    supportFragmentManager
        .beginTransaction()
        .replace(containerId, fragment)
        .commit()
  }
}