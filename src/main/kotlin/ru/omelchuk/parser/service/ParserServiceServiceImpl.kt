package ru.omelchuk.parser.service

import org.jsoup.Jsoup
import org.springframework.stereotype.Service
import ru.omelchuk.parser.domain.Item
import ru.omelchuk.parser.domain.Loto
import java.net.URL



@Service
class ParserServiceServiceImpl : ParserService {
    private var map = mutableMapOf<String, Int?>()
    override fun fillLoto(): Loto {
        val itemList = arrayListOf<Item>()
        for (item in 1297..1346) {
            buildMap(item.toString(), map)
        }
        map.forEach { (k, v) -> itemList.add(Item(k, v)) }
        map.clear()
        return Loto(itemList)
    }
}

private fun buildMap(circulation: String, map : MutableMap<String, Int?>) {
    val document = Jsoup.parse(URL("https://www.stoloto.ru/ruslotto/archive/${circulation}"), 3000)
    val elements = document.select("div[class=results_table]").select("td[class=word-wrap]").text().split(" ")
    if (map.isEmpty()) {
        for (element in elements) {
            map[element] = 1
        }
    } else {
        for (element in elements) {
            if (map.containsKey(element)) {
                val v = map[element]
                map[element] = v?.plus(1)
            }
        }
    }
}