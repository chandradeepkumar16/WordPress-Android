package org.wordpress.android.ui.prefs.language

import org.wordpress.android.ui.prefs.language.LocalePickerListItem.LocalePickerListViewType.LOCALE
import org.wordpress.android.ui.prefs.language.LocalePickerListItem.LocalePickerListViewType.SUB_HEADER

sealed class LocalePickerListItem(val type: LocalePickerListViewType) {
    data class SubHeader(val label: String) : LocalePickerListItem(SUB_HEADER)

    data class LocaleRow(
        val label: String,
        val localizedLabel: String,
        val localeCode: String,
        val clickAction: ClickAction
    ) : LocalePickerListItem(LOCALE)

    enum class LocalePickerListViewType {
        SUB_HEADER,
        LOCALE;
    }

    data class ClickAction(
        val localeCode: String,
        private val clickItem: (localeCode: String) -> Unit
    ) {
        fun onClick() = clickItem(localeCode)
    }
}