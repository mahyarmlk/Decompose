package com.arkivanov.sample.dynamicfeatures.shared.root.featureinstaller

import com.badoo.reaktive.single.Single

interface FeatureInstaller {

    fun install(name: String): Single<Result>

    sealed interface Result {
        object Installed : Result
        object Cancelled : Result
        object Error : Result
    }
}
