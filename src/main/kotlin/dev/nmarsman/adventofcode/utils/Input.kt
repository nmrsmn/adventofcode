package dev.nmarsman.adventofcode.utils

import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import java.nio.file.Files
import java.nio.file.Paths

interface Input
{
    @Headers("Cookie: session={{INSERT COOKIE HERE}}")
    @GET("{year}/day/{day}/input")
    fun fetch(@Path("year") year: Int, @Path("day") day: Int): Call<String>

    companion object
    {
        private val cache = Files.createDirectories(
            Paths.get(System.getProperty("java.io.tmpDir"), "adventofcode"))

        private val client = OkHttpClient.Builder()
            .cache(Cache(cache.toFile(), 100 * 1024 * 1024))
            .build()

        val fetcher = Retrofit.Builder()
            .client(client)
            .baseUrl("https://adventofcode.com")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build().create(Input::class.java)
    }
}