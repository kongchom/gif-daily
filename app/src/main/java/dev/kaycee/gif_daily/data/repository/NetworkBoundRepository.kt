package dev.kaycee.gif_daily.data.repository

import androidx.annotation.WorkerThread

/**
 * [RESULT] type for the resource data
 * [REQUEST] type for the API response
 */
abstract class NetworkBoundRepository<RESULT, REQUEST> {

    /**
     * Called to save the result of the API response into the database
     */
    @WorkerThread
    protected abstract suspend fun saveRemoteData(response: REQUEST)

    /**
     *
     */
}