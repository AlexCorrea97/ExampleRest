package com.example.examplerest.ui.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

class StatusIndicator(
    val status: Int,
    val title1: String = "Pedido confirmado",
    val title2: String = "Preparando tu pedido",
    val title3: String = "Pedido en camino",
    val title4: String = "Pedido entegado"
) {


    @Composable
    fun StatusIndicatorView() {
        val grayColor = Color(0xFFD0D0D0)
        val greenColor = Color(0xFFAEF359)
        ConstraintLayout {
            val (circle1, circle2, circle3, circle4, line1, line2, line3) = createRefs()
            val (title1, title2, title3, title4) = createRefs()
            val (date1, date2, date3, date4) = createRefs()
            Box(
                modifier = Modifier
                    .constrainAs(circle1) {
                        top.linkTo(parent.top)
                    }
                    .size(24.dp)
                    .clip(CircleShape)
                    .background(greenColor)
            )

            Text(
                this@StatusIndicator.title1,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .constrainAs(title1) {
                        top.linkTo(circle1.top)
                        bottom.linkTo(circle1.bottom)
                        start.linkTo(circle1.end)
                    },
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            Text(
                "02 de agosto",
                modifier = Modifier
                    .padding(vertical = 2.dp, horizontal = 8.dp)
                    .constrainAs(date1) {
                        top.linkTo(title1.bottom)
                        start.linkTo(title1.start)
                    },
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )


            Box(
                modifier = Modifier
                    .padding(vertical = 2.dp)
                    .constrainAs(line1) {
                        top.linkTo(circle1.bottom)
                        start.linkTo(circle1.start)
                        end.linkTo(circle1.end)
                    }
                    .size(height = 80.dp, width = 5.dp)
                    .clip(CircleShape)
                    .background(grayColor)

            )

            Box(
                modifier = Modifier
                    .constrainAs(circle2) {
                        top.linkTo(line1.bottom)
                    }
                    .size(24.dp)
                    .clip(CircleShape)
                    .background(grayColor)
            )

            Text(
                this@StatusIndicator.title2,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .constrainAs(title2) {
                        top.linkTo(circle2.top)
                        bottom.linkTo(circle2.bottom)
                        start.linkTo(circle2.end)
                    },
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            Text(
                "",
                modifier = Modifier
                    .padding(vertical = 2.dp, horizontal = 8.dp)
                    .constrainAs(date2) {
                        top.linkTo(title2.bottom)
                        start.linkTo(title2.start)
                    },
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )

            Box(
                modifier = Modifier
                    .padding(vertical = 2.dp)
                    .constrainAs(line2) {
                        top.linkTo(circle2.bottom)
                        start.linkTo(circle2.start)
                        end.linkTo(circle2.end)
                    }
                    .size(height = 80.dp, width = 5.dp)
                    .clip(CircleShape)
                    .background(grayColor)

            )

            Box(
                modifier = Modifier
                    .constrainAs(circle3) {
                        top.linkTo(line2.bottom)
                    }
                    .size(24.dp)
                    .clip(CircleShape)
                    .background(grayColor)
            )

            Text(
                this@StatusIndicator.title3,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .constrainAs(title3) {
                        top.linkTo(circle3.top)
                        bottom.linkTo(circle3.bottom)
                        start.linkTo(circle3.end)
                    },
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            Text(
                "",
                modifier = Modifier
                    .padding(vertical = 2.dp, horizontal = 8.dp)
                    .constrainAs(date3) {
                        top.linkTo(title3.bottom)
                        start.linkTo(title3.start)
                    },
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )

            Box(
                modifier = Modifier
                    .padding(vertical = 2.dp)
                    .constrainAs(line3) {
                        top.linkTo(circle3.bottom)
                        start.linkTo(circle3.start)
                        end.linkTo(circle3.end)
                    }
                    .size(height = 80.dp, width = 5.dp)
                    .clip(CircleShape)
                    .background(grayColor)

            )

            Box(
                modifier = Modifier
                    .constrainAs(circle4) {
                        top.linkTo(line3.bottom)
                    }
                    .size(24.dp)
                    .clip(CircleShape)
                    .background(grayColor)
            )

            Text(
                this@StatusIndicator.title4,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .constrainAs(title4) {
                        top.linkTo(circle4.top)
                        bottom.linkTo(circle4.bottom)
                        start.linkTo(circle4.end)
                    },
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            Text(
                "",
                modifier = Modifier
                    .padding(vertical = 2.dp, horizontal = 8.dp)
                    .constrainAs(date4) {
                        top.linkTo(title4.bottom)
                        start.linkTo(title4.start)
                    },
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )

        }
    }


}