package com.example.dyslexiascanner.retrofit

import com.google.gson.annotations.SerializedName

data class PostResponse(

	@field:SerializedName("confidence")
	val confidence: Any? = null,

	@field:SerializedName("diagnosis")
	val diagnosis: String? = null,

) {
}


