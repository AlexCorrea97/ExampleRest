package com.example.examplerest.ui.presentation.home_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examplerest.domain.GetUserUseCase
import com.example.examplerest.domain.Resource
import com.example.examplerest.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val useCase: GetUserUseCase
): ViewModel() {
    private var _userState = MutableLiveData<UserViewState>()
    val userState: LiveData<UserViewState> = _userState
    private var _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun getUser(){
        viewModelScope.launch{
            _isLoading.value = true
            val user = useCase()
            setUser(user)
            _isLoading.value = false
        }
    }
    private fun setUser(resource: Resource<User>){
        when(resource){
            is Resource.Error -> {

                println(resource.message)
            }
            is Resource.Success -> {
                resource.data?.let {
                    _userState.value = UserViewState(
                        imageProfile = it.imageProfile,
                        name = it.name,
                        email = it.email,
                        birthday = it.birthday,
                        address = it.address,
                        phone = it.phone,
                        password = it.password
                    )
                }
            }
        }
    }
}