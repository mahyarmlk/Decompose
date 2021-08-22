package com.arkivanov.sample.dynamicfeatures.shared.root

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.animation.child.crossfadeScale
import com.arkivanov.sample.dynamicfeatures.shared.main.MainContent
import com.arkivanov.sample.dynamicfeatures.shared.root.dynamicfeature.DynamicFeatureContent

@Composable
fun RootContent(root: Root, modifier: Modifier = Modifier) {
    Children(routerState = root.routerState, animation = crossfadeScale()) {
        when (val child = it.instance) {
            is Root.Child.MainChild -> MainContent(main = child.main, modifier = modifier)

            is Root.Child.Feature1Child ->
                DynamicFeatureContent(
                    dynamicFeature = child.feature1,
                    modifier = modifier
                ) { feature ->
                    val feature1Content = remember(::Feature1Content)
                    feature1Content.Content(feature1 = feature, modifier = modifier)
                }

            is Root.Child.Feature2Child ->
                DynamicFeatureContent(
                    dynamicFeature = child.feature2,
                    modifier = modifier
                ) { feature ->
                    val feature2Content = remember(::Feature2Content)
                    feature2Content.Content(feature2 = feature, modifier = modifier)
                }
        }.let {}
    }
}
