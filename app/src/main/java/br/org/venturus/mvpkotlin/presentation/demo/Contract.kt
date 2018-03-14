package br.org.venturus.mvpkotlin.presentation.demo

import br.org.venturus.mvpkotlin.mvp.presenter.Presenter
import br.org.venturus.mvpkotlin.mvp.view.ParentView

interface Contract {
  interface DemoView : ParentView {

  }

  interface DemoPresenter : Presenter<DemoView> {

  }
}