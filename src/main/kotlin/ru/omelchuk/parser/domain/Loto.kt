package ru.omelchuk.parser.domain

class Loto {
    var item: List<Item> = emptyList()

    constructor(item: List<Item>) {
        this.item = item
    }

    override fun toString(): String {
        return "Loto(item=$item)"
    }

}