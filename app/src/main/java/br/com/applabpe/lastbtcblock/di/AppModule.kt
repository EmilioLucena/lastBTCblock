package br.com.applabpe.lastbtcblock.di

import br.com.applabpe.lastbtcblock.network.BlockCypherApiService
import br.com.applabpe.lastbtcblock.network.BlockchainInfoApiService
import br.com.applabpe.lastbtcblock.repository.BlockchainInfoRepository
import br.com.applabpe.lastbtcblock.repository.BlockcypherRepository
import br.com.applabpe.lastbtcblock.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideBitcoinApi(): BlockchainInfoApiService {

        val httpLogging = HttpLoggingInterceptor()
        httpLogging.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(httpLogging)
            .build()

        return Retrofit
            .Builder()
            .baseUrl(Constants.BLOCKCHAIN_INFO_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BlockchainInfoApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideBlockcypherApi(): BlockCypherApiService {

        val httpLogging = HttpLoggingInterceptor()
        httpLogging.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(httpLogging)
            .build()

        return Retrofit
            .Builder()
            .baseUrl(Constants.BLOCK_CYPHER_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BlockCypherApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideBlockchainInfoRepository(api: BlockchainInfoApiService): BlockchainInfoRepository =
        BlockchainInfoRepository(api)

    @Singleton
    @Provides
    fun provideBlockcypherRepository(api: BlockCypherApiService): BlockcypherRepository =
        BlockcypherRepository(api)
}