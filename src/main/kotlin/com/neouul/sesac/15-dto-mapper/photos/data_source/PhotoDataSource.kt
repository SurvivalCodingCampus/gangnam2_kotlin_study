package com.neouul.sesac.`15-dto-mapper`.photos.data_source

import com.neouul.sesac.`15-dto-mapper`.photos.dto.PhotoDTO
import com.neouul.sesac.core.Response

interface PhotoDataSource {
    suspend fun loadPhotos(): Response<List<PhotoDTO?>?>
}