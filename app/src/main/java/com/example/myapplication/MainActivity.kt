package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.reflect.full.memberProperties

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testInstance = TestClass()
        testInstance.testProperty // prevent optimizing out
        testInstance::class.memberProperties // CRASH
    }

    enum class TestEnum { TEST_ENTRY }
}

class TestClass {
    val testProperty = MainActivity.TestEnum.TEST_ENTRY
}