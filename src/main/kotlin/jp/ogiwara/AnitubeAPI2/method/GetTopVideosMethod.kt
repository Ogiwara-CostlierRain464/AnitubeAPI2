package jp.ogiwara.AnitubeAPI2.method

import jp.ogiwara.AnitubeAPI2.Anitube
import jp.ogiwara.AnitubeAPI2.http.getBody
import jp.ogiwara.AnitubeAPI2.makeVideo
import jp.ogiwara.AnitubeAPI2.model.Video

internal class GetTopVideosMethod(val fragment: String) {

    companion object{
        val HIGHLIGHT = "fragment-1"
        val TOP_RATED = "fragment-2"
        val MOST_SEEN = "fragment-3"
    }

    fun execute(): List<Video>{
        val result = ArrayList<Video>()
        val document = getBody(Anitube.URL.TOP)
        val fragments = document.getElementById(fragment)
        val targetFragment = fragments.getElementById(fragment).getElementsByClass("mainList")
        targetFragment.forEach {
            result.add(makeVideo(it))
        }

        return result
    }
}