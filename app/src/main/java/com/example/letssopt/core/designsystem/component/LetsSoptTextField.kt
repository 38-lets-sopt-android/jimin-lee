package com.example.letssopt.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme

@Composable
fun LetsSoptTextField(
    title: String,
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    inputTextColor: Color = LETSSOPTTheme.colors.txtPrimary,
    textStyle: TextStyle = LETSSOPTTheme.typography.caption.regular14,
    keyboardOptions: KeyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
    keyboardActions: KeyboardActions = KeyboardActions(),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {

    Column(
        modifier = modifier,
    ) {
        Text(
            text = title,
            color = LETSSOPTTheme.colors.txtSecondary,
            style = textStyle,
        )

        Spacer(modifier = Modifier.height(3.dp))

        Box(
            modifier = Modifier
                .background(
                    color = LETSSOPTTheme.colors.surface,
                    shape = RoundedCornerShape(8.dp),
                ),
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier,
                textStyle = textStyle.copy(
                    color = inputTextColor,
                ),
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                singleLine = true,
                visualTransformation = visualTransformation,
                interactionSource = interactionSource,
                cursorBrush = SolidColor(inputTextColor),
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Top,
                    ) {

                        Box(
                            modifier = Modifier
                                .padding(start = 16.dp, top = 18.dp, bottom = 17.dp),
                            contentAlignment = Alignment.TopStart,
                        ) {
                            if (value.isEmpty()) {
                                Text(
                                    text = placeholder,
                                    style = textStyle,
                                    color = LETSSOPTTheme.colors.placeholder,
                                )
                            }
                            innerTextField()
                        }
                    }
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LetsSoptTextFieldPreview() {
    LETSSOPTTheme {
        var value by remember { mutableStateOf("") }

        Box(
            modifier = Modifier
                .padding(20.dp),
        ) {
            LetsSoptTextField(
                title = "이메일",
                value = value,
                placeholder = "이메일 주소를 입력하세요",
                onValueChange = { value = it },
            )
        }
    }
}
