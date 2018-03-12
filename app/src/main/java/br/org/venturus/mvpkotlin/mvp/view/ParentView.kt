package br.org.venturus.mvpkotlin.mvp.view

interface ParentView : View {
  fun onChildAttached(child: ChildView)
  fun onChildDetached(child: ChildView)
}