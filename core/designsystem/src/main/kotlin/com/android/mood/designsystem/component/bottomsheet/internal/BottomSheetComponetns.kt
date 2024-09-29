package com.android.mood.designsystem.component.bottomsheet.internal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.android.mood.designsystem.component.bottomsheet.BottomSheetOption
import com.android.mood.designsystem.component.bottomsheet.SingleSelectOption
import com.android.mood.designsystem.component.button.BtnSolidLarge
import com.android.mood.designsystem.component.datepicker.DatePicker
import com.android.mood.designsystem.component.datepicker.defaultMaximumDate
import com.android.mood.designsystem.component.datepicker.defaultMinimumDate
import com.android.mood.designsystem.component.datepicker.internal.DefaultPickerDecoration
import com.android.mood.designsystem.component.datepicker.internal.DefaultPickerItemContent
import com.android.mood.designsystem.component.datepicker.rememberDatePickerState
import com.android.mood.designsystem.foundation.MoodTheme
import java.util.Date


@Composable
internal fun SingleSelectOptionList(
    modifier: Modifier = Modifier,
    list: List<SingleSelectOption>,
    onSelectOption: (index: Int) -> Unit,
    onDismiss: () -> Unit,
) {
    val state = rememberLazyListState()

    LazyColumn(
        modifier = modifier,
        state = state,
    ) {
        itemsIndexed(list) { index, option ->
            BottomSheetOption(
                text = option.text,
                isSelected = option.isSelected,
                onClick = {
                    onSelectOption(index)
                    onDismiss()
                }
            )
        }
    }
}

@Composable
internal fun BottomSheetDatePicker(
    modifier: Modifier = Modifier,
    initialYear: Int? = null,
    initialMonth: Int? = null,
    initialDate: Int? = null,
    yearEnabled: Boolean = true,
    monthEnabled: Boolean = true,
    dateEnabled: Boolean = true,
    minimumDate: Date = remember { defaultMinimumDate },
    maximumDate: Date = remember { defaultMaximumDate },
    itemHeight: Dp = 48.dp,
    pickerSpacing: Dp = 0.dp,
    contentPadding: PaddingValues = PaddingValues(all = 0.dp),
    decorationBox: @Composable BoxScope.(innerPickers: @Composable () -> Unit) -> Unit =
        @Composable { innerPickers ->
            DefaultPickerDecoration()
            innerPickers()
        },
    yearItemContent: @Composable BoxScope.(year: Int) -> Unit = { year ->
        DefaultPickerItemContent(text = year.toString())
    },
    monthItemContent: @Composable BoxScope.(month: Int) -> Unit = { month ->
        DefaultPickerItemContent(text = if (month >= 10) month.toString() else "0${month}")
    },
    dateItemContent: @Composable BoxScope.(date: Int) -> Unit = { date ->
        DefaultPickerItemContent(text = if (date >= 10) date.toString() else "0${date}")
    },
    onClick: (String, String, String) -> Unit = { _, _, _ -> },
) {
    val datePickerState = if (initialYear != null && initialMonth != null && initialDate != null) {
        rememberDatePickerState(initialYear, initialMonth, initialDate)
    } else {
        rememberDatePickerState()
    }
    Column {
        DatePicker(
            modifier = modifier,
            state = datePickerState,
            yearEnabled = yearEnabled,
            monthEnabled = monthEnabled,
            dateEnabled = dateEnabled,
            minimumDate = minimumDate,
            maximumDate = maximumDate,
            itemHeight = itemHeight,
            pickerSpacing = pickerSpacing,
            contentPadding = contentPadding,
            decorationBox = decorationBox,
            yearItemContent = yearItemContent,
            monthItemContent = monthItemContent,
            dateItemContent = dateItemContent,
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MoodTheme.color.white)
                .height(74.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center,
        ) {
            BtnSolidLarge(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "확인",
                onClick = {
                    onClick(
                        datePickerState.currentYear.toString(),
                        datePickerState.currentMonth.toString(),
                        datePickerState.currentDate.toString()
                    )
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSingleSelectOptionList() {
    SingleSelectOptionList(
        list = listOf(
            SingleSelectOption("옵션1", true),
            SingleSelectOption("옵션2", false),
            SingleSelectOption("옵션3", false),
            SingleSelectOption("옵션4", false),
        ),
        onSelectOption = {},
        onDismiss = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewBottomSheetDatePicker() {
    BottomSheetDatePicker()
}
