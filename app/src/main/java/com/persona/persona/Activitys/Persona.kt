package com.persona.persona.Activitys

import android.app.Application
import com.kakao.auth.IApplicationConfig
import com.kakao.auth.KakaoAdapter
import com.kakao.auth.KakaoSDK


class Persona : Application() {
    override fun onCreate() {
        super.onCreate()
        // Kakao SDK 초기화
        KakaoSDK.init(object : KakaoAdapter() {
            override fun getApplicationConfig(): IApplicationConfig {
                return IApplicationConfig { this@Persona }
            }
        })
    }
}