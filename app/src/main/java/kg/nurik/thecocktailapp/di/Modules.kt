package kg.nurik.thecocktailapp.di

import kg.nurik.thecocktailapp.data.interactor.Interactor
import kg.nurik.thecocktailapp.data.interactor.InteractorImpl
import kg.nurik.thecocktailapp.data.local.CasheAppDatabase
import kg.nurik.thecocktailapp.data.remote.CocktailService
import kg.nurik.thecocktailapp.data.remote.RetrofitBuilder
import kg.nurik.thecocktailapp.data.repository.Repository
import kg.nurik.thecocktailapp.data.repository.RepositoryImpl
import kg.nurik.thecocktailapp.ui.bottomNav.favourite.FavouriteCocktailViewModel
import kg.nurik.thecocktailapp.ui.bottomNav.random.RandomCocktailViewModel
import kg.nurik.thecocktailapp.ui.bottomNav.story.StoryViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

fun injectModules() = loadModules

val viewModelModule: Module = module {
    viewModel { RandomCocktailViewModel(get(), get()) }
    viewModel { FavouriteCocktailViewModel(get()) }
    viewModel { StoryViewModel(get()) }
}

val repositoryModule: Module = module {
    single<Repository> { RepositoryImpl(get(), get()) }
}

val apiModule: Module = module {
    single<CocktailService> { RetrofitBuilder.buildRetrofit() }
    single<Interactor> { InteractorImpl(get()) }
}

val dbModule: Module = module {
    single<CasheAppDatabase> { CasheAppDatabase.getInstanceDB(androidApplication()) }
}

private val loadModules by lazy {
    loadKoinModules(
        listOf(viewModelModule, repositoryModule, apiModule, dbModule)
    )
}
