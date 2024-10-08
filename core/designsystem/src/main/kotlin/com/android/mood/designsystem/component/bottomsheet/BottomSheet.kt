package com.android.mood.designsystem.component.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.mood.core.designsystem.R
import com.android.mood.designsystem.component.bottomsheet.internal.BottomSheetDatePicker
import com.android.mood.designsystem.component.bottomsheet.internal.SingleSelectOptionList
import com.android.mood.designsystem.component.button.BtnPrimaryOutlineLarge
import com.android.mood.designsystem.component.button.BtnSolidLarge
import com.android.mood.designsystem.component.icons.Icon16
import com.android.mood.designsystem.component.text.MoodText
import com.android.mood.designsystem.foundation.Icon
import com.android.mood.designsystem.foundation.Icon24
import com.android.mood.designsystem.foundation.MoodTheme

/**
 * 모든 content 직접 구성하는 BottomSheet
 */
@Composable
fun BottomSheet(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier,
        content = content,
    )
}

/**
 * 텍스트 컨텐트가 있고 버튼이 없는 BottomSheet
 */
@Composable
fun BottomSheet(
    modifier: Modifier = Modifier.background(MoodTheme.color.white),
    title: String? = null,
    text: String,
    onDismiss: () -> Unit = {},
    hideXButton: Boolean = false,
) {
    Column(modifier = modifier) {
        if (title != null) {
            BottomSheetHeader(
                title = title,
                hideXButton = hideXButton,
                onDismiss = onDismiss,
            )
        } else {
            Spacer(modifier = Modifier.height(16.dp))
        }

        MoodText(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 24.dp),
            text = text,
            style = MoodTheme.typography.body.body1.bold,
            color = MoodTheme.color.black
        )
    }
}

/**
 * 텍스트 컨텐트가 있고 버튼이 하나인 BottomSheet
 */
@Composable
fun BottomSheet(
    modifier: Modifier = Modifier.background(MoodTheme.color.white),
    title: String? = null,
    text: String,
    buttonText: String,
    isButtonEnabled: Boolean = true,
    isButtonLoading: Boolean = false,
    hideXButton: Boolean = false,
    onButtonClick: () -> Unit,
    onDismiss: () -> Unit = {},
) {
    Column(modifier = modifier) {
        if (title != null) {
            BottomSheetHeader(
                title = title,
                hideXButton = hideXButton,
                onDismiss = onDismiss,
            )
        } else {
            Spacer(modifier = Modifier.height(16.dp))
        }

        MoodText(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 12.dp),
            text = text,
            style = MoodTheme.typography.body.body1.bold,
            color = MoodTheme.color.black
        )
        BottomSheetFooterOneButton(
            buttonText = buttonText,
            isButtonEnabled = isButtonEnabled,
            isButtonLoading = isButtonLoading,
            onButtonClick = onButtonClick,
        )
    }
}


/**
 * 텍스트 컨텐트가 있고 버튼이 두개인 BottomSheet
 */
@Composable
fun BottomSheet(
    modifier: Modifier = Modifier.background(MoodTheme.color.white),
    title: String? = null,
    text: String,
    primaryButtonText: String,
    secondaryButtonText: String,
    isPrimaryButtonEnabled: Boolean = true,
    isSecondaryButtonEnabled: Boolean = true,
    isPrimaryButtonLoading: Boolean = false,
    isSecondaryButtonLoading: Boolean = false,
    hideXButton: Boolean = false,
    onPrimaryButtonClick: () -> Unit,
    onSecondaryButtonClick: () -> Unit,
    onDismiss: () -> Unit = {},
) {
    Column(modifier = modifier) {
        if (title != null) {
            BottomSheetHeader(
                title = title,
                hideXButton = hideXButton,
                onDismiss = onDismiss,
            )
        } else {
            Spacer(modifier = Modifier.height(16.dp))
        }

        MoodText(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 12.dp),
            text = text,
            style = MoodTheme.typography.body.body1.bold,
            color = MoodTheme.color.black
        )

        BottomSheetFooterTwoButtons(
            primaryButtonText = primaryButtonText,
            secondaryButtonText = secondaryButtonText,
            isPrimaryButtonEnabled = isPrimaryButtonEnabled,
            isSecondaryButtonEnabled = isSecondaryButtonEnabled,
            isPrimaryButtonLoading = isPrimaryButtonLoading,
            isSecondaryButtonLoading = isSecondaryButtonLoading,
            onPrimaryButtonClick = onPrimaryButtonClick,
            onSecondaryButtonClick = onSecondaryButtonClick,
        )
    }
}

/**
 * 자유 형식의 버튼이 없는 BottomSheet
 */
@Composable
fun BottomSheet(
    modifier: Modifier = Modifier.background(MoodTheme.color.white),
    title: String? = null,
    hideXButton: Boolean = false,
    onDismiss: () -> Unit = {},
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(modifier = modifier) {
        if (title != null) {
            BottomSheetHeader(
                title = title,
                hideXButton = hideXButton,
                onDismiss = onDismiss,
            )
        } else {
            Spacer(modifier = Modifier.height(16.dp))
        }
        content()
    }
}

/**
 * 자유 형식의 버튼 1개 있는 BottomSheet
 */
@Composable
fun BottomSheet(
    modifier: Modifier = Modifier.background(MoodTheme.color.white),
    title: String? = null,
    buttonText: String,
    isButtonEnabled: Boolean = true,
    isButtonLoading: Boolean = false,
    hideXButton: Boolean = false,
    onButtonClick: () -> Unit,
    onDismiss: () -> Unit = {},
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(modifier = modifier) {
        if (title != null) {
            BottomSheetHeader(
                title = title,
                hideXButton = hideXButton,
                onDismiss = onDismiss,
            )
        } else {
            Spacer(modifier = Modifier.height(16.dp))
        }
        content()
        BottomSheetFooterOneButton(
            buttonText = buttonText,
            isButtonEnabled = isButtonEnabled,
            isButtonLoading = isButtonLoading,
            onButtonClick = onButtonClick,
        )
    }
}

/**
 * 자유 형식의 버튼 2개 있는 BottomSheet
 */
@Composable
fun BottomSheet(
    modifier: Modifier = Modifier.background(MoodTheme.color.white),
    title: String? = null,
    primaryButtonText: String,
    secondaryButtonText: String,
    isPrimaryButtonEnabled: Boolean = true,
    isSecondaryButtonEnabled: Boolean = true,
    isPrimaryButtonLoading: Boolean = false,
    isSecondaryButtonLoading: Boolean = false,
    hideXButton: Boolean = false,
    onPrimaryButtonClick: () -> Unit,
    onSecondaryButtonClick: () -> Unit,
    onDismiss: () -> Unit = {},
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(modifier = modifier) {
        if (title != null) {
            BottomSheetHeader(
                title = title,
                hideXButton = hideXButton,
                onDismiss = onDismiss,
            )
        } else {
            Spacer(modifier = Modifier.height(16.dp))
        }

        content()

        BottomSheetFooterTwoButtons(
            primaryButtonText = primaryButtonText,
            secondaryButtonText = secondaryButtonText,
            isPrimaryButtonEnabled = isPrimaryButtonEnabled,
            isSecondaryButtonEnabled = isSecondaryButtonEnabled,
            isPrimaryButtonLoading = isPrimaryButtonLoading,
            isSecondaryButtonLoading = isSecondaryButtonLoading,
            onPrimaryButtonClick = onPrimaryButtonClick,
            onSecondaryButtonClick = onSecondaryButtonClick,
        )
    }
}

/**
 * 연/월/일, 연/월 Date Picker를 사용하는 BottomSheet
 */
@Composable
@Preview
fun DatePickerBottomSheet(
    modifier: Modifier = Modifier
        .background(MoodTheme.color.white),
    title: String? = null,
    hideXButton: Boolean = false,
    onDismiss: () -> Unit = {},
    onClick: (String, String, String) -> Unit = { _, _, _ -> },
) {
    Column {
        if (title != null) {
            BottomSheetHeader(
                title = title,
                hideXButton = hideXButton,
                onDismiss = onDismiss,
            )
        }

        BottomSheetDatePicker(
            modifier = modifier,
            onClick = onClick,
        )
    }
}

/**
 * 하나의 옵션을 선택하는 BottomSheet
 */
@Composable
fun BottomSheetSingleSelectOption(
    title: String,
    modifier: Modifier = Modifier.background(MoodTheme.color.white),
    singleSelectOptionList: List<SingleSelectOption>,
    onSelectOption: (index: Int) -> Unit,
    hideXButton: Boolean = false,
    onDismiss: () -> Unit = {},
) {
    Column(modifier = modifier) {
        BottomSheetHeader(
            title = title,
            hideXButton = hideXButton,
            onDismiss = onDismiss,
        )

        SingleSelectOptionList(
            list = singleSelectOptionList,
            onSelectOption = onSelectOption,
            onDismiss = onDismiss,
        )
    }
}


@Composable
fun BottomSheetHeader(
    modifier: Modifier = Modifier.background(MoodTheme.color.white),
    title: String,
    hideXButton: Boolean = false,
    onDismiss: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(top = 24.dp)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        MoodText(
            modifier = Modifier.weight(1f),
            text = title,
            style = MoodTheme.typography.body.body1.bold,
            color = MoodTheme.color.black,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
        Spacer(modifier = Modifier.width(16.dp))

        if (hideXButton.not()) {
            Icon24(
                iconRes = R.drawable.ic_bracket_right_thickness_1_5,
                onClick = onDismiss,
            )
        }
    }
}

@Composable
fun BottomSheetHeaderArrowClose(
    modifier: Modifier = Modifier.background(MoodTheme.color.white),
    onDismiss: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(32.dp),
    ) {
        Icon(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 4.dp)
                .clickable(
                    onClick = onDismiss,
                    role = Role.Image,
                    enabled = true,
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ),
            iconRes = R.drawable.ic_arrow_right_thickness_1_5,
            width = 30.dp,
            height = 12.dp,
            color = MoodTheme.color.gray600
        )
    }
}

@Composable
fun BottomSheetFooterOneButton(
    buttonText: String,
    modifier: Modifier = Modifier,
    isButtonEnabled: Boolean = true,
    isButtonLoading: Boolean = false,
    onButtonClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MoodTheme.color.white),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(74.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center,
        ) {
            BtnSolidLarge(
                modifier = Modifier.fillMaxWidth(),
                text = buttonText,
                enabled = isButtonEnabled,
                loading = isButtonLoading,
                onClick = onButtonClick,
            )
        }
    }
}

@Composable
fun BottomSheetFooterTwoButtons(
    primaryButtonText: String,
    secondaryButtonText: String,
    modifier: Modifier = Modifier,
    isPrimaryButtonEnabled: Boolean = true,
    isSecondaryButtonEnabled: Boolean = true,
    isPrimaryButtonLoading: Boolean = false,
    isSecondaryButtonLoading: Boolean = false,
    onPrimaryButtonClick: () -> Unit,
    onSecondaryButtonClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(74.dp)
            .background(MoodTheme.color.white)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BtnPrimaryOutlineLarge(
            modifier = Modifier.weight(1f),
            text = secondaryButtonText,
            enabled = isSecondaryButtonEnabled,
            loading = isSecondaryButtonLoading,
            onClick = onSecondaryButtonClick,
        )
        Spacer(modifier = Modifier.width(8.dp))
        BtnSolidLarge(
            modifier = Modifier.weight(1f),
            text = primaryButtonText,
            enabled = isPrimaryButtonEnabled,
            loading = isPrimaryButtonLoading,
            onClick = onPrimaryButtonClick,
        )
    }
}

/** 텍스트 + 우측 체크 아이콘을 갖고 있는 바텀시트 옵션 */
@Composable
fun BottomSheetOption(
    text: String,
    isSelected: Boolean = false,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .background(MoodTheme.color.white)
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp)
    ) {
        MoodText(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            text = text,
            style = MoodTheme.typography.body.body1.bold,
            color = if (isSelected) MoodTheme.color.primary500 else MoodTheme.color.gray200,
        )

        if (isSelected) {
            Icon24(
                modifier = Modifier.align(Alignment.CenterVertically),
                iconRes = R.drawable.ic_check_thickness_2_0,
                color = MoodTheme.color.primary500,
            )
        }
    }
}

/** 좌측 24dp 아이콘 + 텍스트 + 우측 체크 아이콘을 갖고 있는 바텀시트 옵션 */
@Composable
fun BottomSheetOption(
    text: String,
    isSelected: Boolean = false,
    iconRes: Int,
    iconColor: Color = MoodTheme.color.gray200,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .background(MoodTheme.color.white)
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp)
    ) {
        Icon24(
            modifier = Modifier
                .padding(end = 8.dp)
                .align(Alignment.CenterVertically),
            iconRes = iconRes,
            color = iconColor,
        )

        MoodText(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            text = text,
            style = MoodTheme.typography.body.body1.bold,
            color = if (isSelected) MoodTheme.color.primary500 else MoodTheme.color.gray200,
        )

        if (isSelected) {
            Icon24(
                modifier = Modifier.align(Alignment.CenterVertically),
                iconRes = R.drawable.ic_check_thickness_2_0,
                color = MoodTheme.color.primary500,
            )
        }
    }
}

/** 좌측 24dp content + 텍스트 + 우측 24dp 커스텀 아이콘을 갖고 있는 바텀시트 옵션 */
@Composable
fun BottomSheetOption24(
    text: String,
    isSelected: Boolean = false,
    isEnabled: Boolean = true,
    leftContent: @Composable () -> Unit,
    rightIconRes: Int = 0,
    rightIconColor: Color = MoodTheme.color.gray300,
    isShowRightIcon: Boolean = true,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(MoodTheme.color.white)
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(end = 8.dp)
                .size(24.dp)
                .align(Alignment.CenterVertically)

        ) {
            leftContent()
        }

        MoodText(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            text = text,
            style = MoodTheme.typography.body.body1.bold,
            color = when {
                !isEnabled -> MoodTheme.color.gray50
                isSelected -> MoodTheme.color.primary500
                else -> MoodTheme.color.gray100
            },
        )

        if (isShowRightIcon && rightIconRes > 0) {
            Icon24(
                modifier = Modifier.align(Alignment.CenterVertically),
                iconRes = rightIconRes,
                color = rightIconColor,
            )
        }
    }
}

/** 좌측 32dp content + 텍스트 + 우측 24dp 커스텀 아이콘을 갖고 있는 바텀시트 옵션 */
@Composable
fun BottomSheetOption32(
    text: String,
    isSelected: Boolean = false,
    isEnabled: Boolean = true,
    leftContent: @Composable () -> Unit,
    rightIconRes: Int,
    rightIconColor: Color = MoodTheme.color.gray200,
    isShowRightIcon: Boolean = true,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MoodTheme.color.white)
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(end = 8.dp)
                .size(32.dp)
                .align(Alignment.CenterVertically)
        ) {
            leftContent()
        }

        MoodText(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            text = text,
            style = MoodTheme.typography.body.body1.bold,
            color = when {
                !isEnabled -> MoodTheme.color.gray50
                isSelected -> MoodTheme.color.primary500
                else -> MoodTheme.color.gray100
            }
        )

        if (isShowRightIcon && rightIconRes > 0) {
            Icon24(
                modifier = Modifier.align(Alignment.CenterVertically),
                iconRes = rightIconRes,
                color = rightIconColor,
            )
        }
    }
}


/** 좌측 40dp content + 텍스트 + 우측 24dp 커스텀 아이콘을 갖고 있는 바텀시트 옵션 */
@Composable
fun BottomSheetOption40(
    text: String,
    isSelected: Boolean = false,
    isEnabled: Boolean = true,
    leftContent: @Composable () -> Unit,
    rightIconRes: Int,
    rightIconColor: Color = MoodTheme.color.gray75,
    isShowRightIcon: Boolean = true,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(MoodTheme.color.white)
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(end = 8.dp)
                .size(40.dp)
                .align(Alignment.CenterVertically)
        ) {
            leftContent()
        }

        MoodText(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            text = text,
            style = MoodTheme.typography.body.body1.bold,
            color = when {
                !isEnabled -> MoodTheme.color.gray50
                isSelected -> MoodTheme.color.primary500
                else -> MoodTheme.color.gray100
            }
        )

        if (isShowRightIcon && rightIconRes > 0) {
            Icon24(
                modifier = Modifier.align(Alignment.CenterVertically),
                iconRes = rightIconRes,
                color = rightIconColor,
            )
        }
    }
}

/**
 * 단일 옵션 선택할 때 사용.
 * 좌측에 아이콘이 붙는 경우 icon composable 작성.
 */
data class SingleSelectOption(
    val text: String,
    val isSelected: Boolean,
    val icon: @Composable () -> Unit = {},
)

@Preview(showBackground = true)
@Composable
fun PreviewTextBottomSheetNoButton() {
    BottomSheet(
        title = "타이틀",
        text = "텍스트가 이렇게 깁니다 텍스트가 이렇게 깁니다 텍스트가 이렇게 깁니다 텍스트가 이렇게 깁니다 텍스트가 이렇게 깁니다 텍스트가 이렇게 깁니다 텍스트가 이렇게 깁니다 텍스트가 이렇게 깁니다 텍스트가 이렇게 깁니다 텍스트가 이렇게 깁니다 ",
        onDismiss = {},
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTextBottomSheetOneButton() {
    BottomSheet(
        title = "타이틀",
        text = "버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 ",
        buttonText = "버튼명",
        onButtonClick = {},
        onDismiss = {},
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTextBottomSheetOneButtonNoTitle() {
    BottomSheet(
        text = "버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 ",
        buttonText = "버튼명",
        onButtonClick = {},
        onDismiss = {},
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTextBottomSheetTwoButtons() {
    BottomSheet(
        title = "타이틀",
        text = "버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 버튼1개 텍스트 ",
        primaryButtonText = "확인",
        secondaryButtonText = "취소",
        onPrimaryButtonClick = {},
        onSecondaryButtonClick = {},
        onDismiss = {},
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewBottomSheetNoButton() {
    BottomSheet(
        title = "타이틀",
        onDismiss = {},
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(MoodTheme.color.white)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewBottomSheetOneButton() {
    BottomSheet(
        title = "타이틀",
        buttonText = "확인",
        onButtonClick = {},
        onDismiss = {},
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(MoodTheme.color.white)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewBottomSheetTwoButtons() {
    BottomSheet(
        title = "타이틀",
        primaryButtonText = "확인",
        secondaryButtonText = "취소",
        onPrimaryButtonClick = {},
        onSecondaryButtonClick = {},
        onDismiss = {}
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(MoodTheme.color.white)
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewBottomSheetSingleSelectOption() {
    BottomSheetSingleSelectOption(
        title = "단일 선택 바텀시트",
        singleSelectOptionList = listOf(
            SingleSelectOption(
                text = "옵션명1",
                isSelected = true,
            ),
            SingleSelectOption(
                text = "옵션명2",
                isSelected = false,
            ),
            SingleSelectOption(
                text = "옵션명3",
                isSelected = false,
                icon = {
                    Icon16(iconRes = R.drawable.ic_minus_thickness_2_0)
                }
            )
        ),
        onDismiss = {},
        onSelectOption = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewBottomSheetHeader() {
    BottomSheetHeader(
        title = "헤더"
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewBottomSheetHeaderSheetClose() {
    BottomSheetHeaderArrowClose()
}

@Preview(showBackground = true)
@Composable
private fun PreviewBottomSheetOption24() {
    BottomSheetOption24(
        text = "24 옵션입니다",
        isEnabled = true,
        isSelected = false,
        leftContent = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MoodTheme.color.white)
            )
        },
        rightIconRes = 0,
        onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewBottomSheetOption32() {
    BottomSheetOption32(
        text = "32 옵션입니다 & 비활성",
        isEnabled = false,
        isSelected = false,
        leftContent = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MoodTheme.color.white)
            )
        },
        rightIconRes = 0,
        onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewBottomSheetOption40() {
    BottomSheetOption40(
        text = "40 옵션입니다 & 선택됨",
        isEnabled = true,
        isSelected = true,
        leftContent = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MoodTheme.color.white)
            )
        },
        rightIconRes = R.drawable.ic_plus,
        onClick = {},
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewBottomSheetFooter1() {
    BottomSheetFooterOneButton(
        buttonText = "버튼",
        onButtonClick = {}
    )
}


@Preview(showBackground = true)
@Composable
private fun PreviewBottomSheetFooter2() {
    BottomSheetFooterTwoButtons(
        primaryButtonText = "확인",
        secondaryButtonText = "취소",
        onPrimaryButtonClick = {},
        onSecondaryButtonClick = {},
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewBottomSheetOption() {
    BottomSheetOption(
        text = "옵션이 여기 있습니다",
        isSelected = true,
        iconRes = R.drawable.ic_minus_thickness_2_0,
        onClick = {}
    )
}