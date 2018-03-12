package br.org.venturus.mvpkotlin.dagger

import br.org.venturus.mvpkotlin.App
import br.org.venturus.mvpkotlin.dagger.model.RetrofitModule
import br.org.venturus.mvpkotlin.dagger.presentation.PresentationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
    (AndroidSupportInjectionModule::class),
    (RetrofitModule::class),
    (PresentationModule::class)
    ]
)
interface AppComponent : AndroidInjector<App> {

  override fun inject(instance: App)

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun application(app: App): Builder

    fun build(): AppComponent
  }
}