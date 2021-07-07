package com.example.android.dagger.di

import android.content.Context
import com.example.android.dagger.login.LoginComponent
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.registration.RegistrationActivity
import com.example.android.dagger.registration.RegistrationComponent
import com.example.android.dagger.registration.enterdetails.EnterDetailsFragment
import com.example.android.dagger.registration.termsandconditions.TermsAndConditionsFragment
import com.example.android.dagger.settings.SettingsActivity
import com.example.android.dagger.user.UserComponent
import com.example.android.dagger.user.UserManager
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StorageModule::class, AppSubcomponents::class])
interface Appcomponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context) : Appcomponent
    }

    fun registrationComponent(): RegistrationComponent.Factory

    fun loginComponent(): LoginComponent.Factory

    // 2) Expose UserManager so that MainActivity and SettingsActivity
    // can access a particular instance of UserComponent
    fun userManager(): UserManager

}