package ru.omelchuk.parser.service

import ru.omelchuk.parser.domain.Loto

interface ParserService {
    fun fillLoto() : Loto
}