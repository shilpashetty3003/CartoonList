package com.example.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.interceptors.GetCharacterBookmarkUseCase
import com.example.domain.interceptors.GetCharacterListUseCase
import com.example.presentation.utils.CoroutineContextProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject


sealed class CharacterUIModel{
    object Loading:CharacterUIModel()
    data class Success(val data:List<Character>) : CharacterUIModel()
    data class Failure(val error:String):CharacterUIModel()
}

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val contentProvider:CoroutineContextProvider,
    private val characterUseCase:GetCharacterListUseCase,
    private val bookmarkCharacterUseCase:GetCharacterBookmarkUseCase
)  :BaseViewModel(contentProvider) {

    private val _characterList = MutableLiveData<CharacterUIModel>()
    private var characterList:LiveData<CharacterUIModel> = _characterList

    override val coroutineExceptionHandler: CoroutineExceptionHandler
        get() = TODO("Not yet implemented")


    fun getCharacters(isFavourite:Boolean){

    }



}