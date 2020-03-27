package com.loyo.koinapplication.model

import com.loyo.koinapplication.model.HelloRepository

class HelloRepositoryImpl() : HelloRepository {
    override fun giveHello() = "$this"
}