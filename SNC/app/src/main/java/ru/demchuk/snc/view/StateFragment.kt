package ru.demchuk.snc.view

sealed class StateFragment {
    data object Empty : StateFragment()

    data object BottomSheetFragment : StateFragment()

}
