package br.org.venturus.mvpkotlin.mvp.model

import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException

abstract class BaseModel<T, C : BaseModelCallback> : Model<T> {

  private var callback: C? = null

  protected fun getCallback() = callback

  fun clear() {
    this.callback = null
  }

  protected fun request(request: Single<T>, callback: C?) {
    this.callback = callback
    getCallback()?.beforeRequest()

    request
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ response -> requestSuccess(response)}, {error -> requestError(error)})
  }

  protected fun request(request: Completable, callback: C?) {
    this.callback = callback
    getCallback()?.beforeRequest()

    request
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ requestSuccess(null) }, { error -> requestError(error)})
  }

  private fun requestSuccess(response: T?) {
    onSuccess(response)
    getCallback()?.afterRequest()
  }

  private fun requestError(error: Throwable) {
    when (error) {
      is ConnectException -> getCallback()?.onConnectError()
      is SocketTimeoutException -> getCallback()?.onTimeoutError()
      is HttpException -> when(error.code()) {
        401 -> getCallback()?.onUnauthorizedError()
        500 -> getCallback()?.onInternalServerError()
        else -> onHttpError(error)
      }
      else -> getCallback()?.onUnexpectedError(error)
    }
  }

  override fun onHttpError(error: HttpException) {
    getCallback()?.onUnexpectedError(error)
  }
}