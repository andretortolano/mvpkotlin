package br.org.venturus.mvpkotlin.mvp.model

import retrofit2.HttpException

interface Model<in T> {

  fun onSuccess(response: T?)
  fun onHttpError(error: HttpException)
}