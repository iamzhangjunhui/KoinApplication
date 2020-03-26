package com.loyo.koinapplication

class HelloRepositoryImpl() : HelloRepository {
    override fun giveHello() = "$this"
}