package dev.kaycee.gif_daily.data.repository

import android.util.Log
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.*
import retrofit2.Response

/**
 * [RESULT] type for the resource data
 * [REQUEST] type for the API response
 */
abstract class NetworkBoundResource<RESULT, REQUEST> {

    fun asFlow() = flow<Resource<RESULT>> {

        //Emit database content first
        emit(Resource.Success(fetchLocalDb().first()))

        //Fetch latest gif from remote
        val apiResponse = fetchFromRemote()
        Log.d("congnm",apiResponse.body().toString())
        //Parse body
        val remoteGif = apiResponse.body()
        //Check for response validation
        if (apiResponse.isSuccessful && remoteGif != null) {
            //Save gif into the db
            saveRemoteData(remoteGif)
        } else {
            //Emit error when something went wrong
            emit(Resource.Error(apiResponse.message()))
        }

        //Get gif from persistence storage and emit
        emitAll(
            fetchLocalDb().map {
                Resource.Success(it)
            }
        )
    }.catch { e ->
        e.printStackTrace()
        emit(Resource.Error("Network error! ${e.message}"))
    }

    /**
     * Called to save the result of the API response into the database
     */
    @WorkerThread
    protected abstract suspend fun saveRemoteData(response: REQUEST)

    /**
     *Fetch all data from persistent storage
     */
    @MainThread
    protected abstract fun fetchLocalDb(): Flow<RESULT>

    /**
     * Logic to check whether we need to fetch data from db
     */
    @MainThread
    protected abstract fun shouldFetch(data: RESULT): Boolean

    /**
     * Fetch data from remote
     */
    protected abstract suspend fun fetchFromRemote(): Response<REQUEST>

}