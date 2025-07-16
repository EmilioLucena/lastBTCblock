package br.com.applabpe.lastbtcblock.di

import br.com.applabpe.lastbtcblock.network.BitcoinApiService
import br.com.applabpe.lastbtcblock.repository.BTCRepository
import br.com.applabpe.lastbtcblock.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideBitcoinApi(): BitcoinApiService {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BitcoinApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(api: BitcoinApiService): BTCRepository =
        BTCRepository(api)
}