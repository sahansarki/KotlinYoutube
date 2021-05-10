package com.example.kotlinyoutube.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.kotlinyoutube.R
import kotlinx.android.synthetic.main.activity_course_lesson.*

class CourseLessonActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_course_lesson)
        webview_course_lesson.setBackgroundColor(ContextCompat.getColor(this,R.color.yellow))

        val courseLink = intent.getStringExtra(CourseDetailActivity.CourseLessonViewHolder.COURSE_LESSON_LINK_KEY)


        if(courseLink != null) {
            webview_course_lesson.settings.javaScriptEnabled = true
            webview_course_lesson.settings.loadWithOverviewMode = true
            webview_course_lesson.settings.useWideViewPort = true


            webview_course_lesson.loadUrl(courseLink)
        }

    }
}