package com.theolm.tvshowalert

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.captureToImage
import androidx.test.platform.app.InstrumentationRegistry
import java.io.File
import java.io.FileOutputStream
import kotlin.math.roundToInt

/**
 * Simple on-device screenshot comparator that uses golden images present in
 * `androidTest/assets`.
 *
 * Source: https://github.com/googlecodelabs/android-compose-codelabs/blob/main/TestingCodelab/app/src/androidTest/java/com/example/compose/rally/ScreenshotComparator.kt
 * Minimum SDK is O.
 *
 * Screenshots are saved on device in `/data/data/{package}/files`.
 *
 * Screenshot names will have the bitmap size included. This allows for different golden images
 * to be used for different screen densities. You will need to ensure that golden images with the
 * appropriate size in the name is included for all supported densities.
 */
@RequiresApi(Build.VERSION_CODES.O)
fun assertScreenshotMatchesGolden(
    folderName: String,
    goldenName: String,
    node: SemanticsNodeInteraction
) {
    val bitmap = node.captureToImage().asAndroidBitmap()

    // Save screenshot to file for debugging
    saveScreenshot(
        folderName,
        "$goldenName",
        bitmap
    )
    val golden = InstrumentationRegistry.getInstrumentation()
        .context.resources.assets.open("golden/$folderName/$goldenName.png")
        .use { BitmapFactory.decodeStream(it) }

    golden.compare(bitmap)
}

private fun saveScreenshot(folderName: String, filename: String, bmp: Bitmap) {
    val path = File(InstrumentationRegistry.getInstrumentation().targetContext.filesDir, folderName)
    if (!path.exists()) {
        path.mkdirs()
    }
    FileOutputStream("$path/$filename.png").use { out ->
        bmp.compress(Bitmap.CompressFormat.PNG, 100, out)
    }
    println("Saved screenshot to $path/$filename.png")
}

private fun Bitmap.compare(other: Bitmap) {
    if (this.width != other.width || this.height != other.height) {
        throw AssertionError("Size of screenshot does not match golden file (check device density). Golden: ${this.width}x${this.height} Screenshot: ${other.width}x${other.height}")
    }

    val pixelTolerance = getSnapTolerance(width, height)
    var outliers = 0

    // Compare row by row to save memory on device
    val row1 = IntArray(width)
    val row2 = IntArray(width)
    for (column in 0 until height) {
        // Read one row per bitmap and compare
        this.getRow(row1, column)
        other.getRow(row2, column)
        if (!row1.contentEquals(row2)) {
            // Each errors increments the outliers counter
            outliers++
        }
    }

    if (outliers > pixelTolerance) {
        throw AssertionError("Sizes match but bitmap content has differences")
    }
}

private fun getSnapTolerance(width: Int, height: Int): Int {
    val maximumTolerance = 500
    val minimumTolerance = 50

    // Tolerance of 0.05%
    val toleranceRatio = 0.0005
    // Calculate the maximum amount of outliers pixels
    val pixelTolerance = width * height * toleranceRatio

    return when {
        pixelTolerance > maximumTolerance -> maximumTolerance
        pixelTolerance < minimumTolerance -> minimumTolerance
        else -> pixelTolerance.roundToInt()
    }
}

private fun Bitmap.getRow(pixels: IntArray, column: Int) {
    this.getPixels(pixels, 0, width, 0, column, width, 1)
}
