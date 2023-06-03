package com.example.domain.interceptors

interface BaseUseCase<in Parameter,out Result> {

     suspend  operator  fun  invoke(params:Parameter) : Result
}