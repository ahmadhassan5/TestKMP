package com.ahmadhassan.testkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform