package ru.omelchuk.parser.domain

class Item {
    var number : String = ""
    var count : Int? = 0

    constructor(number: String, count: Int?) {
        this.number = number
        this.count = count
    }

    override fun toString(): String {
        return "Item(number='$number', count=$count)"
    }

}