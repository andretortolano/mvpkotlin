package br.org.venturus.mvpkotlin.mvp.presenter

import br.org.venturus.mvpkotlin.mvp.model.ModelClient
import br.org.venturus.mvpkotlin.mvp.view.View

interface Presenter<V> : ModelClient where V : View {
  fun getView(): V

  fun onAttach(view: V)
  fun onDetach()

  // TODO @Throws(BasePresenter.ViewNotAttachedException::class)
  fun checkViewAttached()
}