package com.ahmadhassan.testkmp.home_setting

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
/**
 * Created by Ahmad Hassan on 02/01/2023.
 */

class HomeSettingViewModel constructor(
    /*private val settingsDataSource: SettingsDataSource,
    private val savedStateHandle: SavedStateHandle*/
) : KMMViewModel() {

    val isDarkModeEnabled = MutableStateFlow(viewModelScope,false)
    val isArabicEnabled = MutableStateFlow(viewModelScope,false)

    val isTranslationEnabled = MutableStateFlow(viewModelScope,false)
    val isHashiyaEnabled = MutableStateFlow(viewModelScope,false)
    val selectedView = MutableStateFlow(viewModelScope,"")
/*
    val isArabicEnabled = settingsDataSource.getBoolean(Constants.Keys.IS_ARABIC_ENABLED_KEY, true)
    val isTranslationEnabled =
        settingsDataSource.getBoolean(Constants.Keys.IS_TRANSLATION_ENABLED_KEY, true)
    val isHashiyaEnabled = settingsDataSource.getBoolean(Constants.Keys.IS_HASHIYA_ENABLED_KEY, true)
    val selectedView = settingsDataSource.getString(Constants.Keys.SELECTED_VIEW_KEY, Constants.DefaultValues.SELECTED_VIEW_DEFAULT.name)
*/

    fun onTranslationChange(state: Boolean) {
        /*viewModelScope.launch {
            if (!state)
                if (!isArabicEnabled.stateIn(this).value && !isHashiyaEnabled.stateIn(this).value)
                    return@launch
            settingsDataSource.putBoolean(Constants.Keys.IS_TRANSLATION_ENABLED_KEY, state)
        }*/
        isTranslationEnabled.value = isTranslationEnabled.value.not()
    }

    /*fun onArabicChange(state: Boolean) {
        viewModelScope.launch {
            val isTranslationEnabled = isTranslationEnabled.stateIn(this)
            val isHashiyaEnabled = isHashiyaEnabled.stateIn(this)
            if (!state)
                if (!isTranslationEnabled.value && !isHashiyaEnabled.value)
                    return@launch
            settingsDataSource.putBoolean(Constants.Keys.IS_ARABIC_ENABLED_KEY, state)
        }
    }

    fun onHashiyaChange(state: Boolean) {
        viewModelScope.launch {
            if (!state)
                if (!isArabicEnabled.stateIn(this).value && !isTranslationEnabled.stateIn(this).value)
                    return@launch
            settingsDataSource.putBoolean(Constants.Keys.IS_HASHIYA_ENABLED_KEY, state)
        }
    }

    fun onViewChange(viewType: RecitationOptions) {
        viewModelScope.launch {
            settingsDataSource.putString(Constants.Keys.SELECTED_VIEW_KEY, viewType.name)
        }
    }

    fun onThemeChange(theme: Theme){
        viewModelScope.launch {
            settingsDataSource.putString(Constants.Keys.IS_DARK_ENABLED_KEY, theme.name)
        }
    }*/
}