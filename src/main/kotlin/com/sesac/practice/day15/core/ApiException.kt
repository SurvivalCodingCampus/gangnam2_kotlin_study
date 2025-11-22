package com.sesac.practice.day15.core

class ApiException(
    message: String = "API 에러가 발생했습니다",
) : Exception(message)
